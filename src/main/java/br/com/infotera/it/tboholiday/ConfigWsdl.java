/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infotera.it.tboholiday;

import br.com.infotera.it.tboholiday.wsdl.Wsdl;
import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSIntegrador;
import br.com.infotera.common.enumerator.WSAmbienteEnum;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import java.net.URL;

/**
 *
 * @author Bruno
 */
public class ConfigWsdl {

    public static URL buscaWsdl(WSIntegrador integrador, String wsdlFile) throws ErrorException {
        return Wsdl.class.getResource("HotelService.wsdl");
    }

    public static String buscaEndPoint(WSAmbienteEnum ambiente) throws ErrorException {
        String endPoint = null;
        if (WSAmbienteEnum.HOMOLOGACAO.equals(ambiente)) {
            endPoint = "http://api.tbotechnology.in/HotelAPI_V7/HotelService.svc/basic";
        } else if (WSAmbienteEnum.PRODUCAO.equals(ambiente)) {
            throw new ErrorException(null, ConfigWsdl.class, "buscaEndPoint", WSMensagemErroEnum.GENENDPOINT, "Ambiente nao configurado", WSIntegracaoStatusEnum.NEGADO, null);
        }
        return endPoint;
    }

}
