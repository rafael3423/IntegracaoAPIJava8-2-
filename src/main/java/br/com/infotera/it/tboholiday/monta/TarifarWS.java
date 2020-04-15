package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSIntegrador;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.WSReservaHotelUh;
import br.com.infotera.common.WSTarifa;
import br.com.infotera.common.WSTarifaAdicional;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import br.com.infotera.common.enumerator.WSReservaStatusEnum;
import br.com.infotera.common.enumerator.WSTarifaAdicionalTipoEnum;
import br.com.infotera.common.hotel.WSConfigUh;
import br.com.infotera.common.hotel.WSHotel;
import br.com.infotera.common.hotel.WSHotelPesquisa;
import br.com.infotera.common.hotel.WSQuartoUh;
import br.com.infotera.common.hotel.WSRegime;
import br.com.infotera.common.hotel.WSUh;
import br.com.infotera.common.hotel.rqrs.WSDisponibilidadeHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSDisponibilidadeHotelRS;
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRS;
import br.com.infotera.common.politica.WSPolitica;
import br.com.infotera.common.politica.WSPoliticaCancelamento;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.ChamaWS;
import br.com.infotera.it.tboholiday.ParDisp;
import br.com.infotera.it.tboholiday.UtilsWS;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tektravel.hotelbookingapi.BookingOptions;
import tektravel.hotelbookingapi.CancelPolicy;
import tektravel.hotelbookingapi.HotelCancellationPolicyRequest;
import tektravel.hotelbookingapi.HotelCancellationPolicyResponse;
import tektravel.hotelbookingapi.RoomCombination;

public class TarifarWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSTarifarHotelRS tarifarHotel(WSTarifarHotelRQ tarifarHotelRQ) throws ErrorException {

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();

        if (tarifarHotelRQ.getReservaHotel().getReservaStatus().equals(WSReservaStatusEnum.ORCAMENTO)) {
            DisponibilidadeWS disponibilidadeWS = new DisponibilidadeWS();

            List<WSHotel> hotelList = new ArrayList();

            hotelList.add(tarifarHotelRQ.getReservaHotel().getHotel());

            ParDisp[] parDisp = (ParDisp[]) UtilsWS.fromJson(tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getUh().getDsParametro(), ParDisp[].class);

            List<WSConfigUh> configUhList = new ArrayList();
            try {
                for (ParDisp pd : parDisp) {
                    configUhList.add(new WSConfigUh(Utils.gerarWSReservaNome(pd.getA3())));
                }
            } catch (Exception ex) {
                throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifarHotel", WSMensagemErroEnum.HTA, "Ocorreu uma falha ao gerar tarifas", WSIntegracaoStatusEnum.NEGADO, ex);
            }

            WSDisponibilidadeHotelRS disponibilidadeHotelRS = disponibilidadeWS.disponibilidade(new WSDisponibilidadeHotelRQ(tarifarHotelRQ.getIntegrador(),
                    tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtEntrada(),
                    tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtSaida(),
                    tarifarHotelRQ.getReservaHotel().getHotel().getIdExterno2(),
                    configUhList,
                    hotelList));

            WSQuartoUh quartoUh = null;
            String chvSessao = null;

            try {
                for (WSHotelPesquisa hp : disponibilidadeHotelRS.getHotelPesquisaList()) {
                    for (WSQuartoUh quh : hp.getQuartoList().get(0).getQuartoUhList()) {
                        if (tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getUh().getDsParametro().equals(quh.getUh().getDsParametro())) {
                            quartoUh = quh;
                            chvSessao = hp.getDsParametro();
                        }
                    }
                }
            } catch (Exception ex) {
                throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifarHotel", WSMensagemErroEnum.HTA, "Ocorreu uma falha ao gerar tarifas", WSIntegracaoStatusEnum.NEGADO, ex);
            }

            if (quartoUh == null) {
                throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifar", WSMensagemErroEnum.HTA, "Quarto não disponivel", WSIntegracaoStatusEnum.NEGADO, null);
            } else {

                ParDisp[] parDispRetono = (ParDisp[]) UtilsWS.fromJson(quartoUh.getUh().getDsParametro(), ParDisp[].class);
                int count = 0;
                try {
                    for (ParDisp pd : parDispRetono) {

                        String dsParametro = UtilsWS.toJson(pd);
                        String chvVlTarifa[] = pd.getA5().split("#");

                        List<WSTarifaAdicional> tarifaAdicionalList = new ArrayList();

                        tarifaAdicionalList.add(new WSTarifaAdicional(WSTarifaAdicionalTipoEnum.TAXA_SERVICO,
                                "Taxa de serviço.",
                                quartoUh.getTarifa().getSgMoedaNeto(),
                                Double.parseDouble(chvVlTarifa[1])));

                        reservaHotelUhList.add(new WSReservaHotelUh(count,
                                new WSUh(null, pd.getA1(), pd.getA6(), pd.getA6(), dsParametro),
                                new WSRegime(quartoUh.getRegime().getCdRegime(), quartoUh.getRegime().getIdExterno(), quartoUh.getRegime().getDsRegime()),
                                new WSTarifa(quartoUh.getTarifa().getSgMoedaNeto(), Double.parseDouble(chvVlTarifa[0]), null, pd.getA2(), null, null, tarifaAdicionalList),
                                tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtEntrada(),
                                tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtSaida(),
                                Utils.gerarWSReservaNome(pd.getA3()),
                                WSReservaStatusEnum.SOLICITACAO));

                        List<WSPolitica> politicaList = listaPolitica(tarifarHotelRQ.getIntegrador(), reservaHotelUhList.get(count), chvSessao);
                        reservaHotelUhList.get(count).getTarifa().setPoliticaList(politicaList);
                        count++;

                    }
                } catch (Exception ex) {
                    throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifarHotel", WSMensagemErroEnum.HTA, "Ocorreu uma falha ao gerar tarifas", WSIntegracaoStatusEnum.NEGADO, ex);
                }
            }
        }

        WSReservaHotel reservaHotel = new WSReservaHotel(tarifarHotelRQ.getReservaHotel().getDtReserva(),
                tarifarHotelRQ.getReservaHotel().getDtExpiracao(),
                null,
                tarifarHotelRQ.getReservaHotel().getHotel(),
                reservaHotelUhList,
                null,
                null,
                WSReservaStatusEnum.SOLICITACAO,
                null,
                tarifarHotelRQ.getReservaHotel().getDsParametro());

        return new WSTarifarHotelRS(reservaHotel, tarifarHotelRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);
    }

    public List<WSPolitica> listaPolitica(WSIntegrador integrador, WSReservaHotelUh reservaHotelUh, String sessao) throws ErrorException {

        HotelCancellationPolicyRequest hotelCancellationPolicyRequest = new HotelCancellationPolicyRequest();

        BookingOptions bookingOptions = new BookingOptions();

        bookingOptions.setFixedFormat(true);

        RoomCombination roomCombination = new RoomCombination();

        ParDisp parDispRetono = (ParDisp) UtilsWS.fromJson(reservaHotelUh.getUh().getDsParametro(), ParDisp.class);
        roomCombination.getRoomIndex().add(Integer.parseInt(parDispRetono.getA0()));

        bookingOptions.getRoomCombination().add(roomCombination);

        String chvSessao[] = sessao.split("#");

        hotelCancellationPolicyRequest.setResultIndex(Integer.parseInt(chvSessao[1]));
        hotelCancellationPolicyRequest.setSessionId(chvSessao[0]);
        hotelCancellationPolicyRequest.setOptionsForBooking(bookingOptions);

        HotelCancellationPolicyResponse hotelCancellationPolicyResponse = chamaWS.chamadaPadrao(integrador, hotelCancellationPolicyRequest, HotelCancellationPolicyResponse.class);

        List<WSPolitica> politicaCancelamentoList = new ArrayList();

        if (hotelCancellationPolicyResponse != null && !hotelCancellationPolicyResponse.equals("")) {
            if (hotelCancellationPolicyResponse.getCancelPolicies() != null && !hotelCancellationPolicyResponse.getCancelPolicies().equals("")) {
                try {
                    for (CancelPolicy cp : hotelCancellationPolicyResponse.getCancelPolicies().getCancelPolicy()) {

                        Date dtMaximaCancelamento = Utils.addDias(Utils.toDate(cp.getToDate(), "yyyy-MM-dd"), -3);

                        Boolean stImediata = false; //Inicia Multa em normalmente falso
                        Boolean stNaoRefundable = false;

                        if (new Date().compareTo(dtMaximaCancelamento) == 1) { //Compara se o dia de hoje passou a data máxima de ccanelmento
                            stImediata = true;  // entra em multa
                        }

                        politicaCancelamentoList.add(new WSPoliticaCancelamento(cp.getRoomTypeName(),
                                hotelCancellationPolicyResponse.getCancelPolicies().getDefaultPolicy(),
                                cp.getCurrency(),
                                null,
                                null,
                                null,
                                stImediata,
                                Utils.toDate(cp.getFromDate(), "yyyy-MM-dd"),
                                Utils.toDate(cp.getToDate(), "yyyy-MM-dd"),
                                stNaoRefundable));
                    }
                } catch (Exception ex) {
                    throw new ErrorException(integrador, TarifarWS.class, "listaPolitica", WSMensagemErroEnum.HPC, "Ocorreu uma falha ao gerar politicas de cancelamento", WSIntegracaoStatusEnum.NEGADO, ex);
                }
            }
        }
        return politicaCancelamentoList;
    }
}
