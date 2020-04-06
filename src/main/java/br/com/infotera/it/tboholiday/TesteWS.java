package br.com.infotera.it.tboholiday;

//
import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSIntegrador;
import br.com.infotera.common.WSPreReservarRQ;
import br.com.infotera.common.WSReserva;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.WSReservaRelatorioRQ;
import br.com.infotera.common.enumerator.WSAmbienteEnum;
import br.com.infotera.common.enumerator.WSIntegradorEnum;
import br.com.infotera.common.enumerator.WSPaxTipoEnum;
import br.com.infotera.common.enumerator.WSRelatorioPeriodoEnum;
import br.com.infotera.common.enumerator.WSSexoEnum;
import br.com.infotera.common.hotel.WSConfigUh;
import br.com.infotera.common.hotel.WSConfigUhIdade;
import br.com.infotera.common.hotel.WSHotel;
import br.com.infotera.common.hotel.rqrs.WSDetalheHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSDisponibilidadeHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRQ;
import br.com.infotera.common.reserva.rqrs.WSReservaRQ;
import br.com.infotera.common.reserva.rqrs.WSReservarRQ;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.monta.ConsultarReservaWS;
import br.com.infotera.it.tboholiday.monta.DetalharHotelWS;
import br.com.infotera.it.tboholiday.monta.ReservaRelatorioWS;
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
        integrador.setTimeoutSegundos(1500);

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
                WSPaxTipoEnum.ADT,
                20,
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

        WSDisponibilidadeHotelRQ disponibilidadeHotelRQ = new WSDisponibilidadeHotelRQ(integrador,
                dtEntrada,
                dtSaida,
                "115936",
                configUhList,
                null);

                
        MontaWS montaWS = new MontaWS();
        
        
//        DISPONIBILIDADE
//        montaWS.disponibilidade(disponibilidadeHotelRQ);                      
        
//        PRE-RESERVAR
//        montaWS.preReservar(preReservarRQ)

//        RESERVAR
//        montaWS.reservar(new WSReservarRQ(integrador, new WSReserva()));

//        CONSULTAR
//        montaWS.consultar(new WSReservaRQ(integrador, new WSReserva(new WSReservaHotel("126614"))));
        
//        DETALHE HOTEL
//        montaWS.detalharHotel(new WSDetalheHotelRQ(integrador, new WSHotel(null, "1136544", null)));
        
//        RELATORIO DE RESERVAS
        montaWS.relatorio(new WSReservaRelatorioRQ(integrador, WSRelatorioPeriodoEnum.ENTRADA, Utils.toDate("2020-03-01","yyyy-MM-dd"), Utils.toDate("2020-04-05","yyyy-MM-dd")));
      
//        PRE-CANCELAR
//        montaWS.preCancelar(new WSReservaRQ(integrador, new WSReserva(new WSReservaHotel("1136544"))));

//        CANCELAR
//        montaWS.cancelar(new WSReservaRQ(integrador, new WSReserva(new WSReservaHotel(""))));

//        TARIFAR
//        montaWS.tarifar(new WSTarifarHotelRQ(integrador, new WSReservaHotel("")));

    }
}
