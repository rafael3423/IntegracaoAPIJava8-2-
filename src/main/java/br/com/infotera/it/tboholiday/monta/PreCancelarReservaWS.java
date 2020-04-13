/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.reserva.rqrs.WSReservaRQ;
import br.com.infotera.common.reserva.rqrs.WSReservaRS;

/**
 *
 * @author rafael
 */
public class PreCancelarReservaWS {

    public WSReservaRS preCancelarReserva(WSReservaRQ preCancelarReservaRQ) throws ErrorException {

        ConsultarReservaWS consultarWS = new ConsultarReservaWS();

        return consultarWS.consultar(preCancelarReservaRQ, true);
    }

}
