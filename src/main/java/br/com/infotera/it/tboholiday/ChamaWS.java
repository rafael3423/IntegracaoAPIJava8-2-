/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infotera.it.tboholiday;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSIntegrador;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSIntegradorLogTipoEnum;
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import br.com.infotera.common.util.Utils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import javax.xml.ws.BindingProvider;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.transport.http.HTTPConduit;
import static org.glassfish.hk2.utilities.reflection.Pretty.method;
import static org.glassfish.jersey.internal.util.Pretty.method;
import org.tempuri.HotelService;
import tektravel.hotelbookingapi.AuthenticationData;
import tektravel.hotelbookingapi.AvailabilityAndPricingRequest;
import tektravel.hotelbookingapi.AvailabilityAndPricingResponse;
import tektravel.hotelbookingapi.GiataHotelCodesRequest;
import tektravel.hotelbookingapi.GiataHotelCodesResponse;
import tektravel.hotelbookingapi.HotelBookRequest;
import tektravel.hotelbookingapi.HotelBookResponse;
import tektravel.hotelbookingapi.HotelBookingDetailBasedOnDateRequest;
import tektravel.hotelbookingapi.HotelBookingDetailBasedOnDateResponse;
import tektravel.hotelbookingapi.HotelBookingDetailRequest;
import tektravel.hotelbookingapi.HotelBookingDetailResponse;
import tektravel.hotelbookingapi.HotelCancelRequest;
import tektravel.hotelbookingapi.HotelCancelResponse;
import tektravel.hotelbookingapi.HotelCancellationPolicyRequest;
import tektravel.hotelbookingapi.HotelCancellationPolicyResponse;
import tektravel.hotelbookingapi.HotelDetailsRequest;
import tektravel.hotelbookingapi.HotelDetailsResponse;
import tektravel.hotelbookingapi.HotelRoomAvailabilityRequest;
import tektravel.hotelbookingapi.HotelRoomAvailabilityResponse;
import tektravel.hotelbookingapi.HotelSearchRequest;
import tektravel.hotelbookingapi.HotelSearchResponse;

/**
 *
 * @author Bruno
 */
public class ChamaWS {

    private HotelService service;

    public <T> T chamadaPadrao(WSIntegrador integrador, Object envio, Class<T> retorno) throws ErrorException {

        Long tempoInicio = System.currentTimeMillis();
        Class cls = null;
        Object port = null;
        String metodo = null;
        Object objResponse = new Object();

        try {
            if (service == null) {
                service = new HotelService(ConfigWsdl.buscaWsdl(integrador, metodo));

            }
        } catch (Exception ex) {
            throw new ErrorException(integrador, ChamaWS.class, metodo, WSMensagemErroEnum.GENWSDL, "Erro ao localizar wsdl", WSIntegracaoStatusEnum.NEGADO, ex);
        }
        try {
            cls = Class.forName("org.tempuri.IHotelService");
        } catch (Exception ex) {
            throw new ErrorException(integrador, ChamaWS.class, metodo, WSMensagemErroEnum.GENWSDL, "Erro ao localizar wsdl", WSIntegracaoStatusEnum.NEGADO, ex);
        }
        port = service.getBasicHttpBindingIHotelService();

        Writer xmlRequest = new StringWriter();
        Writer xmlResponse = new StringWriter();
        org.apache.cxf.endpoint.Client client = ClientProxy.getClient(port);

        HTTPConduit httpConduit = (HTTPConduit) ClientProxy.getClient(port).getConduit();
        TLSClientParameters tlsCP = new TLSClientParameters();
        tlsCP.setDisableCNCheck(true);
        httpConduit.setTlsClientParameters(tlsCP);

        client.getOutInterceptors().add(new LoggingOutInterceptor(new PrintWriter(xmlRequest)));
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ConfigWsdl.buscaEndPoint(integrador.getAmbiente()));

        LoggingInInterceptor in = new LoggingInInterceptor();
        in.setLimit(-1);
        in.setPrintWriter(new PrintWriter(xmlResponse));
        client.getInInterceptors().add(in);
        java.util.Map<String, Object> requestContext = ((javax.xml.ws.BindingProvider) port).getRequestContext();
        requestContext.put("set-jaxb-validation-event-handler", "false");

        AuthenticationData authenticationData = new AuthenticationData();
        authenticationData.setUserName(integrador.getDsCredencialList().get(0));
        authenticationData.setPassword(integrador.getDsCredencialList().get(1));

        try {
            if (envio instanceof HotelSearchRequest) {
                metodo = "hotelSearch";

            } else if (envio instanceof HotelRoomAvailabilityRequest) {
                metodo = "availableHotelRooms";

            } else if (envio instanceof AvailabilityAndPricingRequest) {
                metodo = "availabilityAndPricing";

            } else if (envio instanceof HotelBookRequest) {
                metodo = "hotelBook";

            } else if (envio instanceof HotelBookingDetailRequest) {
                metodo = "hotelBookingDetail";

            } else if (envio instanceof HotelDetailsRequest) {
                metodo = "hotelDetails";

            } else if (envio instanceof HotelBookingDetailBasedOnDateRequest) {
                metodo = "hotelBookingDetailBasedOnDate";

            } else if (envio instanceof HotelCancelRequest) {
                metodo = "hotelCancel";

            }  else if (envio instanceof GiataHotelCodesRequest) {
                metodo = "giataHotelCodeList";
            }

            try {

                Method method = cls.getDeclaredMethod(metodo, envio.getClass(), AuthenticationData.class);
                objResponse = method.invoke(port, envio, authenticationData);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } finally {

            String[] aa = xmlRequest.toString().split("Payload: ");
            String[] ab = aa[1].split("-------");
            String request = ab[0];
            String[] ba = xmlResponse.toString().split("Payload: ");
            String[] bb = ba[1].split("-------");
            String response = bb[0];

            System.out.println("RQ - > " + metodo + request);
            System.out.println("RS - > " + metodo + response);
            
            integrador.setIntegradorLogList(Utils.adicionaIntegradorLog(integrador,
                    WSIntegradorLogTipoEnum.XML,
                    metodo,
                    "",//request,
                    "",//response,
                    Utils.tempoExecucaoSeg(tempoInicio)));

        }

        verificaErro(integrador, objResponse);
        return retorno.cast(objResponse);
    }

    private void verificaErro(WSIntegrador integrador, Object objResponse) throws ErrorException {

        String dsErro = "";

        if (objResponse instanceof HotelSearchResponse) {
            HotelSearchResponse erro = (HotelSearchResponse) objResponse;

            if (erro.getStatus().getStatusCode().equals("01")) {
            } else {
                if (erro.getStatus().getDescription() != null && !erro.getStatus().getDescription().equals("")) {
                    dsErro = erro.getStatus().getDescription();
                } else {
                    dsErro = "Erro não retornado pelo conector.";
                }
            }

        } else if (objResponse instanceof HotelRoomAvailabilityResponse) {
            HotelRoomAvailabilityResponse erro = (HotelRoomAvailabilityResponse) objResponse;

            if (erro.getStatus().getStatusCode().equals("01")) {
            } else {
                if (erro.getStatus().getDescription() != null && !erro.getStatus().getDescription().equals("")) {
                    dsErro = erro.getStatus().getDescription();
                } else {
                    dsErro = "Erro não retornado pelo conector.";
                }
            }

        }else if (objResponse instanceof AvailabilityAndPricingResponse) {
            AvailabilityAndPricingResponse erro = (AvailabilityAndPricingResponse) objResponse;

            if (erro.getStatus().getStatusCode().equals("01")) {
            } else {
                if (erro.getStatus().getDescription() != null && !erro.getStatus().getDescription().equals("")) {
                    dsErro = erro.getStatus().getDescription();
                } else {
                    dsErro = "Erro não retornado pelo conector.";
                }
            }

        }else if (objResponse instanceof HotelBookResponse) {
            HotelBookResponse erro = (HotelBookResponse) objResponse;

            if (erro.getStatus().getStatusCode().equals("01")) {
            } else {
                if (erro.getStatus().getDescription() != null && !erro.getStatus().getDescription().equals("")) {
                    dsErro = erro.getStatus().getDescription();
                } else {
                    dsErro = "Erro não retornado pelo conector.";
                }
            }

        } else if (objResponse instanceof HotelBookingDetailResponse) {
            HotelBookingDetailResponse erro = (HotelBookingDetailResponse) objResponse;

            if (erro.getStatus().getStatusCode().equals("01")) {
            } else {
                if (erro.getStatus().getDescription() != null && !erro.getStatus().getDescription().equals("")) {
                    dsErro = erro.getStatus().getDescription();
                } else {
                    dsErro = "Erro não retornado pelo conector.";
                }
            }

        } else if (objResponse instanceof HotelDetailsResponse) {
            HotelDetailsResponse erro = (HotelDetailsResponse) objResponse;

            if (erro.getStatus().getStatusCode().equals("01")) {
            } else {
                if (erro.getStatus().getDescription() != null && !erro.getStatus().getDescription().equals("")) {
                    dsErro = erro.getStatus().getDescription();
                } else {
                    dsErro = "Erro não retornado pelo conector.";
                }
            }
        } else if (objResponse instanceof HotelBookingDetailBasedOnDateResponse) {
            HotelBookingDetailBasedOnDateResponse erro = (HotelBookingDetailBasedOnDateResponse) objResponse;

            if (erro.getStatus().getStatusCode().equals("01")) {
            } else {
                if (erro.getStatus().getDescription() != null && !erro.getStatus().getDescription().equals("")) {
                    dsErro = erro.getStatus().getDescription();
                } else {
                    dsErro = "Erro não retornado pelo conector.";
                }
            }

        } else if (objResponse instanceof HotelCancelResponse) {
            HotelCancelResponse erro = (HotelCancelResponse) objResponse;

            if (erro.getStatus().getStatusCode().equals("01")) {
            } else {
                if (erro.getStatus().getDescription() != null && !erro.getStatus().getDescription().equals("")) {
                    dsErro = erro.getStatus().getDescription();
                } else {
                    dsErro = "Erro não retornado pelo conector.";
                }
            }

        } else if (objResponse instanceof HotelCancellationPolicyResponse) {
            HotelCancellationPolicyResponse erro = (HotelCancellationPolicyResponse) objResponse;

            if (erro.getStatus().getStatusCode().equals("01")) {
            } else {
                if (erro.getStatus().getDescription() != null && !erro.getStatus().getDescription().equals("")) {
                    dsErro = erro.getStatus().getDescription();
                } else {
                    dsErro = "Erro não retornado pelo conector.";
                }
            }
        } else if (objResponse instanceof GiataHotelCodesResponse) {
            GiataHotelCodesResponse erro = (GiataHotelCodesResponse) objResponse;

            if (erro.getStatus().getStatusCode().equals("01")) {
            } else {
                if (erro.getStatus().getDescription() != null && !erro.getStatus().getDescription().equals("")) {
                    dsErro = erro.getStatus().getDescription();
                } else {
                    dsErro = "Erro não retornado pelo conector.";
                }
            }
        }

        if (!dsErro.equals("")) {
            throw new ErrorException(integrador, ChamaWS.class, "verificaErro", WSMensagemErroEnum.GENCONEC, dsErro, WSIntegracaoStatusEnum.INCONSISTENTE, null);
        }
    }
}
