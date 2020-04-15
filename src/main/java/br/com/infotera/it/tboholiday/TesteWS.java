package br.com.infotera.it.tboholiday;

//
import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSIntegrador;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.WSReservaRelatorioRQ;
import br.com.infotera.common.enumerator.WSAmbienteEnum;
import br.com.infotera.common.enumerator.WSPaxTipoEnum;
import br.com.infotera.common.enumerator.WSRelatorioPeriodoEnum;
import br.com.infotera.common.hotel.WSConfigUh;
import br.com.infotera.common.hotel.rqrs.WSDisponibilidadeHotelRQ;
import br.com.infotera.common.util.Utils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

///**
// *
// * @author Bruno
// */
public class TesteWS {

    public static void main(String[] args) throws ErrorException {

        WSIntegrador integrador = new WSIntegrador();
        List<String> dsCredencialList = new ArrayList();
        dsCredencialList.add("InfoteraTest");
        dsCredencialList.add("Inf@64890970");
        integrador.setDsCredencialList(dsCredencialList);
        integrador.setAmbiente(WSAmbienteEnum.HOMOLOGACAO);
        integrador.setTimeoutSegundos(30000);

        Date dtEntrada = Utils.toDate("2020-05-12", "yyyy-MM-dd");
        Date dtSaida = Utils.toDate("2020-05-15", "yyyy-MM-dd");

        List<WSConfigUh> configUhList = new ArrayList();
        List<WSReservaNome> reservaNomeList = new ArrayList();

        reservaNomeList.add(new WSReservaNome(null,
                "nome",
                "sobrenome",
                null,
                null,
                null,
                WSPaxTipoEnum.CHD,
                2,
                "BR",
                null,
                null));

        reservaNomeList.add(new WSReservaNome(null,
                "nome2",
                "sobrenome2",
                null,
                null,
                null,
                WSPaxTipoEnum.ADT,
                20,
                "BR",
                null,
                null));

        configUhList.add(new WSConfigUh(reservaNomeList));
        configUhList.add(new WSConfigUh(reservaNomeList));
        configUhList.add(new WSConfigUh(reservaNomeList));

        WSDisponibilidadeHotelRQ disponibilidadeHotelRQ = new WSDisponibilidadeHotelRQ(integrador,
                dtEntrada,
                dtSaida,
                "115936",
                configUhList,
                null);

        MontaWS montaWS = new MontaWS();
//
//        DISPONIBILIDADE
//        WSDisponibilidadeHotelRS disponibilidadeHotelRS = montaWS.disponibilidade(disponibilidadeHotelRQ);
//
//        PRE-RESERVAR
//        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();
//
//        WSReservaHotelUh reservaHotelUh = new WSReservaHotelUh(1,
//                disponibilidadeHotelRS.getHotelPesquisaList().get(0).getQuartoList().get(0).getQuartoUhList().get(0).getUh(),
//                disponibilidadeHotelRS.getHotelPesquisaList().get(0).getQuartoList().get(0).getQuartoUhList().get(0).getRegime(),
//                disponibilidadeHotelRS.getHotelPesquisaList().get(0).getQuartoList().get(0).getQuartoUhList().get(0).getTarifa(),
//                disponibilidadeHotelRS.getHotelPesquisaList().get(0).getDtEntrada(),
//                disponibilidadeHotelRS.getHotelPesquisaList().get(0).getDtSaida(),
//                disponibilidadeHotelRS.getHotelPesquisaList().get(0).getQuartoList().get(0).getConfigUh().getReservaNomeList(),
//                WSReservaStatusEnum.SOLICITACAO);
//
//        reservaHotelUhList.add(reservaHotelUh);
//
//        WSReservaHotel reservaHotel = new WSReservaHotel();
//
//        reservaHotel = new WSReservaHotel(WSReservaStatusEnum.SOLICITACAO,
//                disponibilidadeHotelRS.getHotelPesquisaList().get(0).getHotel(),
//                reservaHotelUhList);
//
//        reservaHotel.setDsParametro(disponibilidadeHotelRS.getHotelPesquisaList().get(0).getDsParametro());
//
//        WSPreReservarRQ preReserva = new WSPreReservarRQ(integrador, new WSReserva(reservaHotel));
//
//        WSPreReservarRS preReservaRS = montaWS.preReservar(preReserva);
//
//        RESERVAR
//        montaWS.reservar(new WSReservarRQ(integrador, preReservaRS.getReserva()));

//        CONSULTA
//        montaWS.consultar(new WSReservaRQ(integrador, new WSReserva(new WSReservaHotel("127707"))));
//        DETALHE HOTEL
//        montaWS.detalharHotel(new WSDetalheHotelRQ(integrador, new WSHotel(null, "1136544", null)));
//        RELATORIO DE RESERVAS
        montaWS.relatorio(new WSReservaRelatorioRQ(integrador, WSRelatorioPeriodoEnum.ENTRADA, Utils.toDate("2020-04-01","yyyy-MM-dd"), Utils.toDate("2020-04-05","yyyy-MM-dd")));
//        PRE-CANCELAR
//        montaWS.preCancelar(new WSReservaRQ(integrador, new WSReserva(new WSReservaHotel("126614"))));
//        CANCELAR
//        montaWS.cancelar(new WSReservaRQ(integrador, new WSReserva(new WSReservaHotel("127707"))));
//        TARIFAR
//        montaWS.tarifar(new WSTarifarHotelRQ(integrador, new WSReservaHotel("")));
//        PESQUISAR
//        WSPesquisaHotelRQ pesquisaHotelRQ = new WSPesquisaHotelRQ();
//
//        pesquisaHotelRQ.setIntegrador(integrador);
//        pesquisaHotelRQ.setCdDestino("136873");
//
//        montaWS.pesquisarHotel(pesquisaHotelRQ);

    }
}
