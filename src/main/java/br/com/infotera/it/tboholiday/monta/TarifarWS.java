package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.WSReservaHotelUh;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.WSTarifa;
import br.com.infotera.common.WSTarifaAdicional;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import br.com.infotera.common.enumerator.WSReservaStatusEnum;
import br.com.infotera.common.enumerator.WSTarifaAdicionalTipoEnum;
import br.com.infotera.common.hotel.WSConfigUh;
import br.com.infotera.common.hotel.WSConfigUhIdade;
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
import java.util.List;
import tektravel.hotelbookingapi.AvailabilityAndPricingRequest;
import tektravel.hotelbookingapi.AvailabilityAndPricingResponse;
import tektravel.hotelbookingapi.BookingOptions;
import tektravel.hotelbookingapi.RoomCombination;

public class TarifarWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSTarifarHotelRS tarifarHotel(WSTarifarHotelRQ tarifarHotelRQ) throws ErrorException {

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();
        String chvSessao = null;

        if (tarifarHotelRQ.getReservaHotel().getReservaStatus().equals(WSReservaStatusEnum.ORCAMENTO)) {
            reservaHotelUhList.addAll(tarifarOrcamento(tarifarHotelRQ));

        } else {
            if (tarifarHotelRQ.getReservaHotel().getReservaStatus().equals(WSReservaStatusEnum.SOLICITACAO)) {
                DisponibilidadeWS disponibilidadeWS = new DisponibilidadeWS();

                List<WSHotel> hotelList = new ArrayList();

                hotelList.add(tarifarHotelRQ.getReservaHotel().getHotel());

                List<WSConfigUh> configUhList = new ArrayList();
                try {
                    for (WSReservaHotelUh rhuh : tarifarHotelRQ.getReservaHotel().getReservaHotelUhList()) {
                        configUhList.add(new WSConfigUh(rhuh.getReservaNomeList()));
                    }
                } catch (Exception ex) {
                    throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifarHotel", WSMensagemErroEnum.HTA, "Ocorreu uma falha ao gerar tarifas", WSIntegracaoStatusEnum.NEGADO, ex);
                }

                WSDisponibilidadeHotelRS disponibilidadeHotelRS = disponibilidadeWS.disponibilidade(new WSDisponibilidadeHotelRQ(tarifarHotelRQ.getIntegrador(),
                        tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtEntrada(),
                        tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtSaida(),
                        null,
                        configUhList,
                        hotelList));

                WSQuartoUh quartoUh = null;

                try {
                    for (WSHotelPesquisa hp : disponibilidadeHotelRS.getHotelPesquisaList()) {
                        for (WSQuartoUh quh : hp.getQuartoList().get(0).getQuartoUhList()) {
                            if (tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getTarifa().getVlNeto().equals(quh.getTarifa().getVlNeto())) {
                                String dsUh = quh.getUh().getDsUh();//.substring(3, quh.getUh().getDsUh().length());
                                if (tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getUh().getDsUh().equals(dsUh)) {
                                    if (tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getRegime().getDsRegime().equals(quh.getRegime().getDsRegime())) {
                                        quartoUh = quh;
                                        chvSessao = hp.getDsParametro();

                                    }
                                }
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

                            reservaHotelUhList.add(new WSReservaHotelUh(count++,
                                    new WSUh(null, pd.getA1(), pd.getA6(), pd.getA6(), dsParametro),
                                    new WSRegime(quartoUh.getRegime().getCdRegime(), quartoUh.getRegime().getIdExterno(), quartoUh.getRegime().getDsRegime()),
                                    new WSTarifa(quartoUh.getTarifa().getSgMoedaNeto(), Double.parseDouble(chvVlTarifa[0]), null, pd.getA2(), null, null, tarifaAdicionalList),
                                    tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtEntrada(),
                                    tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtSaida(),
                                    Utils.gerarWSReservaNome(pd.getA3()),
                                    WSReservaStatusEnum.SOLICITACAO));

                        }
                    } catch (Exception ex) {
                        throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifarHotel", WSMensagemErroEnum.HTA, "Ocorreu uma falha ao gerar tarifas", WSIntegracaoStatusEnum.NEGADO, ex);
                    }
                }
                AvailabilityAndPricingRequest availabilityAndPricingRequest = new AvailabilityAndPricingRequest();

                BookingOptions bookingOptions = new BookingOptions();

                RoomCombination roomCombination = new RoomCombination();

                String resultIndex = null;
                String sessionId = null;

                for (WSReservaHotelUh rhuh : reservaHotelUhList) {

                    ParDisp parDispRetono = (ParDisp) UtilsWS.fromJson(rhuh.getUh().getDsParametro(), ParDisp.class);

                    String result[] = parDispRetono.getA7().split("#");
                    resultIndex = result[1];
                    sessionId = result[0];

                    roomCombination.getRoomIndex().add(Integer.parseInt(parDispRetono.getA0()));
                }

                bookingOptions.setFixedFormat(false);
                bookingOptions.getRoomCombination().add(roomCombination);

                availabilityAndPricingRequest.setResultIndex(Integer.parseInt(resultIndex));
                availabilityAndPricingRequest.setOptionsForBooking(bookingOptions);
                availabilityAndPricingRequest.setSessionId(sessionId);

                chamaWS.chamadaPadrao(tarifarHotelRQ.getIntegrador(), availabilityAndPricingRequest, AvailabilityAndPricingResponse.class);

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
                chvSessao);

        return new WSTarifarHotelRS(reservaHotel, tarifarHotelRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);
    }

    private List<WSReservaHotelUh> tarifarOrcamento(WSTarifarHotelRQ tarifarHotelRQ) throws ErrorException {

        DisponibilidadeWS disponibilidadeWS = new DisponibilidadeWS();
        List<WSHotel> hotelList = new ArrayList();
        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();

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
                null,
                configUhList,
                hotelList));

        WSQuartoUh quartoUh = null;

        try {
            for (WSHotelPesquisa hp : disponibilidadeHotelRS.getHotelPesquisaList()) {
                for (WSQuartoUh quh : hp.getQuartoList().get(0).getQuartoUhList()) {
                    if (tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getTarifa().getVlNeto().equals(quh.getTarifa().getVlNeto())) {
                        String dsUh = quh.getUh().getDsUh();//.substring(3, quh.getUh().getDsUh().length());
                        if (tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getUh().getDsUh().equals(dsUh)) {
                            if (tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getRegime().getDsRegime().equals(quh.getRegime().getDsRegime())) {
                                quartoUh = quh;
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifarHotel", WSMensagemErroEnum.HTA, "Ocorreu uma falha ao gerar tarifas", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        if (quartoUh == null) {
            throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifar", WSMensagemErroEnum.HTA, "Quarto não disponivel", WSIntegracaoStatusEnum.NEGADO, null);
        } else {

            reservaHotelUhList.add(new WSReservaHotelUh(0,
                    quartoUh.getUh(),
                    quartoUh.getRegime(),
                    quartoUh.getTarifa(),
                    tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtEntrada(),
                    tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtSaida(),
                    null,
                    WSReservaStatusEnum.SOLICITACAO));
        }

        return reservaHotelUhList;
    }

    private void tarifarSolicitacao(WSTarifarHotelRQ tarifarHotelRQ) {

    }

}
