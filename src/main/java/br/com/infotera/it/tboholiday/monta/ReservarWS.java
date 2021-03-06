package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSReserva;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.WSReservaHotelUh;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import br.com.infotera.common.reserva.rqrs.WSReservaRQ;
import br.com.infotera.common.reserva.rqrs.WSReservaRS;
import br.com.infotera.common.reserva.rqrs.WSReservarRQ;
import br.com.infotera.common.reserva.rqrs.WSReservarRS;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.ChamaWS;
import br.com.infotera.it.tboholiday.ParDisp;
import br.com.infotera.it.tboholiday.UtilsWS;
import java.math.BigDecimal;
import java.util.Date;
import tektravel.hotelbookingapi.ArrayOfGuest;
import tektravel.hotelbookingapi.ArrayOfRequestedRooms;
import tektravel.hotelbookingapi.ArrayOfSuppInfo;
import tektravel.hotelbookingapi.Guest;
import tektravel.hotelbookingapi.GuestType;
import tektravel.hotelbookingapi.HotelBookRequest;
import tektravel.hotelbookingapi.HotelBookResponse;
import tektravel.hotelbookingapi.PaymentInfo;
import tektravel.hotelbookingapi.PaymentModeType;
import tektravel.hotelbookingapi.Rate;
import tektravel.hotelbookingapi.RequestedRooms;
import tektravel.hotelbookingapi.SuppChargeType;
import tektravel.hotelbookingapi.SuppInfo;
import tektravel.hotelbookingapi.Supplement;

public class ReservarWS {
    
    ChamaWS chamaWS = new ChamaWS();
    
    public WSReservarRS reservar(WSReservarRQ reservarRQ) throws ErrorException {
        
        HotelBookRequest hotelBookRequest = new HotelBookRequest();
        
        ArrayOfRequestedRooms arrayOfRequestedRooms = new ArrayOfRequestedRooms();
        ArrayOfGuest arrayOfGuest = new ArrayOfGuest();
        PaymentInfo paymentInfo = new PaymentInfo();
        Boolean leadGuest = true;
        int sqQuato = 0;
        String sessionDisp = null;
        
        try {
            for (WSReservaHotelUh rhuh : reservarRQ.getReserva().getReservaHotel().getReservaHotelUhList()) {
                
                RequestedRooms requestedRooms = new RequestedRooms();
                
                SuppInfo suppInfo = new SuppInfo();
                
                ParDisp parDisp = (ParDisp) UtilsWS.fromJson(rhuh.getUh().getDsParametro(), ParDisp.class);
                
                sessionDisp = parDisp.getA7();
                
                String chvTarifas[] = parDisp.getA5().split("#");
                
                BigDecimal bigFare = new BigDecimal(chvTarifas[0]);
                BigDecimal bigTax = new BigDecimal(chvTarifas[1]);
                BigDecimal bigTotalFare = new BigDecimal(chvTarifas[2]);
                
                Rate rate = new Rate();
                rate.setRoomFare(bigFare);
                rate.setRoomTax(bigTax);
                rate.setTotalFare(bigTotalFare);
                
                Supplement[] supplement = (Supplement[]) UtilsWS.fromJson(parDisp.getA4(), Supplement[].class);
          
                sqQuato++;
                
                if (supplement != null && supplement.length != 0) {
                    
                    ArrayOfSuppInfo arrayOfSuppInfo = new ArrayOfSuppInfo();
                    try {
                        for (Supplement s : supplement) {
                            suppInfo.setPrice(s.getPrice());
                            suppInfo.setSuppID(s.getSuppID());
                            suppInfo.setSuppIsSelected(false);
                            suppInfo.setSuppChargeType(SuppChargeType.AT_PROPERTY);
                            
                            arrayOfSuppInfo.getSuppInfo().add(suppInfo);
                        }
                    } catch (Exception ex) {
                        throw new ErrorException(reservarRQ.getIntegrador(), ReservarWS.class, "Reservar", WSMensagemErroEnum.HRE, "Ocorreu uma falha ao efetuar a reserva do quarto", WSIntegracaoStatusEnum.INCONSISTENTE, ex);
                    }
                    
                    requestedRooms.setSupplements(arrayOfSuppInfo);
                    
                }
                try {
                    for (WSReservaNome rn : rhuh.getReservaNomeList()) {
                        
                        Guest guest = new Guest();
                        GuestType guestType = null;
                        
                        if (rn.getPaxTipo().isAdt() || rn.getPaxTipo().isSrn()) {
                            guestType = GuestType.ADULT;
                        } else if (rn.getPaxTipo().isChd() || rn.getPaxTipo().isInf()) {
                            guestType = GuestType.CHILD;
                        }
                        
                        paymentInfo.setVoucherBooking(true);
                        paymentInfo.setPaymentModeType(PaymentModeType.LIMIT);
                        guest.setGuestType(guestType);
                        guest.setGuestInRoom(sqQuato);
                        guest.setTitle("MR");
                        guest.setFirstName(Utils.tiraAcento(rn.getNmNome()));
                        guest.setLastName(Utils.tiraAcento(rn.getNmSobrenome()));
                        guest.setAge(rn.getQtIdade());
                        guest.setLeadGuest(leadGuest);
                        leadGuest = false;
                        
                        arrayOfGuest.getGuest().add(guest);
                    }
                } catch (Exception ex) {
                    throw new ErrorException(reservarRQ.getIntegrador(), ReservarWS.class, "Reservar", WSMensagemErroEnum.HRE, "Ocorreu uma falha ao efetuar a reserva do quarto", WSIntegracaoStatusEnum.INCONSISTENTE, ex);
                }
                
                requestedRooms.setRoomIndex(Integer.parseInt(parDisp.getA0()));
                requestedRooms.setRoomTypeName(rhuh.getUh().getDsUh());
                requestedRooms.setRoomTypeCode(rhuh.getUh().getCdUh());
                requestedRooms.setRatePlanCode(rhuh.getTarifa().getCdTarifa());
                requestedRooms.setRoomRate(rate);
                
                arrayOfRequestedRooms.getHotelRoom().add(requestedRooms);
                
            }
        } catch (Exception ex) {
            throw new ErrorException(reservarRQ.getIntegrador(), ReservarWS.class, "Reservar", WSMensagemErroEnum.HRE, "Ocorreu uma falha ao efetuar a reserva do quarto", WSIntegracaoStatusEnum.INCONSISTENTE, ex);
        }
        
        String chvSplit[] = sessionDisp.split("#");
        
        String date = Utils.formatData(new Date(), "ddMMyyHHmmss000");
        
        hotelBookRequest.setGuestNationality("BR");
        hotelBookRequest.setClientReferenceNumber(date + "#TBOH");
        hotelBookRequest.setGuests(arrayOfGuest);
        hotelBookRequest.setPaymentInfo(paymentInfo);
        hotelBookRequest.setSessionId(chvSplit[0]);
        hotelBookRequest.setNoOfRooms(sqQuato);
        hotelBookRequest.setResultIndex(Integer.parseInt(chvSplit[1]));
        hotelBookRequest.setHotelCode(reservarRQ.getReserva().getReservaHotel().getHotel().getIdExterno());
        hotelBookRequest.setHotelName(reservarRQ.getReserva().getReservaHotel().getHotel().getNome());
        hotelBookRequest.setRestrictDuplicateBooking(true);
        hotelBookRequest.setHotelRooms(arrayOfRequestedRooms);
        
        HotelBookResponse hotelBookResponse = chamaWS.chamadaPadrao(reservarRQ.getIntegrador(), hotelBookRequest, HotelBookResponse.class);
        reservarRQ.getIntegrador().setCdLocalizador(hotelBookResponse.getBookingId()+"");
        ConsultarReservaWS consultarReservaWS = new ConsultarReservaWS();
        
        WSReserva reserva = new WSReserva(new WSReservaHotel(Integer.toString(hotelBookResponse.getBookingId())));
        
        WSReservaRS reservaRS = consultarReservaWS.consultar(new WSReservaRQ(reservarRQ.getIntegrador(), reserva), false);
        
        return new WSReservarRS(reservaRS.getReserva(), reservarRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);
        
    }
}
