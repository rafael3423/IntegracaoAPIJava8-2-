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
import tektravel.hotelbookingapi.HotelCancellationPolicyResponse;
import tektravel.hotelbookingapi.HotelDetailsRequest;
import tektravel.hotelbookingapi.HotelDetailsResponse;
import tektravel.hotelbookingapi.HotelRoomAvailabilityRequest;
import tektravel.hotelbookingapi.HotelRoomAvailabilityResponse;
import tektravel.hotelbookingapi.HotelSearchRequest;
import tektravel.hotelbookingapi.HotelSearchResponse;


public class ChamaWS {

    private HotelService service;

    public <T> T chamadaPadrao(WSIntegrador integrador, Object envio, Class<T> retorno) throws ErrorException {

        Long tempoInicio = System.currentTimeMillis();
        Class cls = null;
        Object port = null;
        String metodo = "";
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
            throw new ErrorException(integrador, ChamaWS.class, metodo, WSMensagemErroEnum.GENMETHOD, "Erro ao localizar wsdl", WSIntegracaoStatusEnum.NEGADO, ex);
        }
        try {
            port = service.getBasicHttpBindingIHotelService();
        } catch (Exception ex) {
            throw new ErrorException(integrador, ChamaWS.class, metodo, WSMensagemErroEnum.GENPORT, "Erro ao gerar port", WSIntegracaoStatusEnum.NEGADO, ex);

        }

        Writer xmlRequest = new StringWriter();
        Writer xmlResponse = new StringWriter();
        org.apache.cxf.endpoint.Client client = ClientProxy.getClient(port);

        HTTPConduit httpConduit = (HTTPConduit) ClientProxy.getClient(port).getConduit();
        TLSClientParameters tlsCP = new TLSClientParameters();
        tlsCP.setDisableCNCheck(true);
        httpConduit.setTlsClientParameters(tlsCP);

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

            } else if (envio instanceof GiataHotelCodesRequest) {
                metodo = "giataHotelCodeList";
            }

            if (Utils.geraArquivoXml || (!metodo.equals("hotelSearch") && !metodo.equals("availableHotelRooms"))) {
                client.getOutInterceptors().add(new LoggingOutInterceptor(new PrintWriter(xmlRequest)));
                LoggingInInterceptor in = new LoggingInInterceptor();
                in.setLimit(-1);
                in.setPrintWriter(new PrintWriter(xmlResponse));
                client.getInInterceptors().add(in);
            }

            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ConfigWsdl.buscaEndPoint(integrador.getAmbiente()));

            java.util.Map<String, Object> requestContext = ((javax.xml.ws.BindingProvider) port).getRequestContext();
            requestContext.put("set-jaxb-validation-event-handler", "false");

            AuthenticationData authenticationData = new AuthenticationData();
            authenticationData.setUserName(integrador.getDsCredencialList().get(0));
            authenticationData.setPassword(integrador.getDsCredencialList().get(1));

            try {
                Method method = cls.getDeclaredMethod(metodo, envio.getClass(), AuthenticationData.class);
                objResponse = method.invoke(port, envio, authenticationData);
            } catch (Exception ex) {
                throw new ErrorException(integrador, ChamaWS.class, metodo, WSMensagemErroEnum.GENMETHOD, "Erro ao gerar o method", WSIntegracaoStatusEnum.INCONSISTENTE, ex);
            }

        } finally {
//            if (Utils.geraArquivoXml) {
//                System.out.println("RQ - > " + xmlRequest.toString());
//                System.out.println("RS - > " + xmlResponse.toString());
//            }

            integrador.setIntegradorLogList(Utils.adicionaIntegradorLog(integrador,
                    WSIntegradorLogTipoEnum.XML,
                    metodo,
                    xmlRequest.toString(),//request,
                    xmlResponse.toString(),//response,
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

        } else if (objResponse instanceof AvailabilityAndPricingResponse) {
            AvailabilityAndPricingResponse erro = (AvailabilityAndPricingResponse) objResponse;

            if (erro.getStatus().getStatusCode().equals("01")) {
            } else {
                if (erro.getStatus().getDescription() != null && !erro.getStatus().getDescription().equals("")) {
                    dsErro = erro.getStatus().getDescription();
                } else {
                    dsErro = "Erro não retornado pelo conector.";
                }
            }

        } else if (objResponse instanceof HotelBookResponse) {
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
