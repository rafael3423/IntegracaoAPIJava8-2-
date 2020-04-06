///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.infotera.it.tboholiday.ms;
//
//import br.com.infotera.common.ErrorException;
//import br.com.infotera.common.WSPreReservarRQ;
//import br.com.infotera.common.WSPreReservarRS;
//import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
//import br.com.infotera.common.enumerator.WSMensagemErroEnum;
//import br.com.infotera.common.reserva.rqrs.WSReservaRQ;
//import br.com.infotera.common.reserva.rqrs.WSReservaRS;
//import br.com.infotera.common.reserva.rqrs.WSReservarRQ;
//import br.com.infotera.common.reserva.rqrs.WSReservarRS;
//import br.com.infotera.common.servico.rqrs.WSDisponibilidadeSeguroRQ;
//import br.com.infotera.common.servico.rqrs.WSDisponibilidadeSeguroRS;
//import br.com.infotera.common.servico.rqrs.WSTarifarServicoRQ;
//import br.com.infotera.common.servico.rqrs.WSTarifarServicoRS;
//import br.com.infotera.common.util.Utils;
//import br.com.infotera.it.travelace.TravelaceWS;
//import com.google.gson.Gson;
//import java.util.logging.Logger;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
///**
// *
// * @author arquimedes
// */
//@Path("/")
//public class WS {
//
//    Gson gson = Utils.getGson();
//    TravelaceWS travelaceWS = new TravelaceWS();
//    private static Logger logger;
//
//    static {
//        try {
//            logger = Logger.getLogger(WS.class.getName());
//        } catch (Exception e) {
//            e.printStackTrace(System.err);
//        }
//    }
//
//    @Path("ola")
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response helloWorld() {
//        return Response.ok("Hello World TRAVELACE!!!!").build();
//    }
//
//    @Path("disponibilidadeSeguro")
//    @POST
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response disponibilidade(String jsonRQ) {
//        WSDisponibilidadeSeguroRS wsRS = null;
//        WSDisponibilidadeSeguroRQ wsRQ = gson.fromJson(jsonRQ, WSDisponibilidadeSeguroRQ.class);
//        try {
//            wsRS = travelaceWS.disponibilidade(wsRQ);
//        } catch (ErrorException ex) {
//            wsRS = new WSDisponibilidadeSeguroRS(null, ex.getIntegrador());
//        } catch (Exception ex) {
//            wsRS = new WSDisponibilidadeSeguroRS(null, new ErrorException(wsRQ.getIntegrador(), WS.class, "disponibilidade", WSMensagemErroEnum.GENNULO, "", WSIntegracaoStatusEnum.NEGADO, ex).getIntegrador());
//        }
//        Utils.gerarLog(wsRS.getIntegrador(), "disponibilidade", false);
//        Response result = Response.ok(gson.toJson(wsRS)).build();
//        return result;
//    }
//
//    @Path("tarifar")
//    @POST
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response tarifar(String jsonRQ) {
//        WSTarifarServicoRS wsRS = null;
//        WSTarifarServicoRQ wsRQ = gson.fromJson(jsonRQ, WSTarifarServicoRQ.class);
//        try {
//            wsRS = travelaceWS.tarifar(wsRQ);
//        } catch (ErrorException ex) {
//            wsRS = new WSTarifarServicoRS(null, ex.getIntegrador());
//        } catch (Exception ex) {
//            wsRS = new WSTarifarServicoRS(null, new ErrorException(wsRQ.getIntegrador(), WS.class, "tarifar", WSMensagemErroEnum.GENNULO, "", WSIntegracaoStatusEnum.NEGADO, ex).getIntegrador());
//        }
//        Utils.gerarLog(wsRS.getIntegrador(), "tarifar", false);
//        Response result = Response.ok(gson.toJson(wsRS)).build();
//        return result;
//    }
//
//    @Path("preReservar")
//    @POST
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response preReservar(String jsonRQ) {
//        WSPreReservarRS wsRS = null;
//        WSPreReservarRQ wsRQ = gson.fromJson(jsonRQ, WSPreReservarRQ.class);
//        try {
//            wsRS = travelaceWS.preReservar(wsRQ);
//        } catch (ErrorException ex) {
//            wsRS = new WSPreReservarRS(null, ex.getIntegrador());
//        } catch (Exception ex) {
//            wsRS = new WSPreReservarRS(null, new ErrorException(wsRQ.getIntegrador(), WS.class, "preReservar", WSMensagemErroEnum.GENNULO, "", WSIntegracaoStatusEnum.NEGADO, ex).getIntegrador());
//        }
//        Utils.gerarLog(wsRS.getIntegrador(), "preReservar", true);
//        Response result = Response.ok(gson.toJson(wsRS)).build();
//        return result;
//    }
//
//    @Path("reservar")
//    @POST
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response reservar(String jsonRQ) {
//        WSReservarRS wsRS = null;
//        WSReservarRQ wsRQ = gson.fromJson(jsonRQ, WSReservarRQ.class);
//        try {
//            wsRS = travelaceWS.reservar(wsRQ);
//        } catch (ErrorException ex) {
//            wsRS = new WSReservarRS(null, ex.getIntegrador());
//        } catch (Exception ex) {
//            wsRS = new WSReservarRS(null, new ErrorException(wsRQ.getIntegrador(), WS.class, "reservar", WSMensagemErroEnum.GENNULO, "", WSIntegracaoStatusEnum.INCONSISTENTE, ex).getIntegrador());
//        }
//        Utils.gerarLog(wsRS.getIntegrador(), "reservar", true);
//        Response result = Response.ok(gson.toJson(wsRS)).build();
//        return result;
//    }
//
//    @Path("confirmar")
//    @POST
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response confirmar(String jsonRQ) {
//        WSReservaRS wsRS = null;
//        WSReservaRQ wsRQ = gson.fromJson(jsonRQ, WSReservaRQ.class);
//        try {
//            wsRS = travelaceWS.confirmar(wsRQ);
//        } catch (ErrorException ex) {
//            wsRS = new WSReservaRS(null, ex.getIntegrador());
//        } catch (Exception ex) {
//            wsRS = new WSReservaRS(null, new ErrorException(wsRQ.getIntegrador(), WS.class, "confirmar", WSMensagemErroEnum.GENNULO, "", WSIntegracaoStatusEnum.INCONSISTENTE, ex).getIntegrador());
//        }
//        Utils.gerarLog(wsRS.getIntegrador(), "confirmar", true);
//        Response result = Response.ok(gson.toJson(wsRS)).build();
//        return result;
//    }
//
//    @Path("consultar")
//    @POST
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response consulta(String jsonRQ) {
//        WSReservaRS wsRS = null;
//        WSReservaRQ wsRQ = gson.fromJson(jsonRQ, WSReservaRQ.class);
//        try {
//            wsRS = travelaceWS.consulta(wsRQ);
//        } catch (ErrorException ex) {
//            wsRS = new WSReservaRS(null, ex.getIntegrador());
//        } catch (Exception ex) {
//            wsRS = new WSReservaRS(null, new ErrorException(wsRQ.getIntegrador(), WS.class, "consulta", WSMensagemErroEnum.GENNULO, "", WSIntegracaoStatusEnum.INCONSISTENTE, ex).getIntegrador());
//        }
//        Utils.gerarLog(wsRS.getIntegrador(), "consulta", true);
//        Response result = Response.ok(gson.toJson(wsRS)).build();
//        return result;
//    }
//
//    @Path("preCancelar")
//    @POST
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response preCancelar(String jsonRQ) {
//        WSReservaRS wsRS = null;
//        WSReservaRQ wsRQ = gson.fromJson(jsonRQ, WSReservaRQ.class);
//        try {
//            wsRS = travelaceWS.preCancelar(wsRQ);
//        } catch (ErrorException ex) {
//            wsRS = new WSReservaRS(null, ex.getIntegrador());
//        } catch (Exception ex) {
//            wsRS = new WSReservaRS(null, new ErrorException(wsRQ.getIntegrador(), WS.class, "preCancelar", WSMensagemErroEnum.GENNULO, "", WSIntegracaoStatusEnum.NEGADO, ex).getIntegrador());
//        }
//        Utils.gerarLog(wsRS.getIntegrador(), "preCancelar", true);
//        Response result = Response.ok(gson.toJson(wsRS)).build();
//        return result;
//    }
//
//    @Path("cancelar")
//    @POST
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response cancelar(String jsonRQ) {
//        WSReservaRS wsRS = null;
//        WSReservaRQ wsRQ = gson.fromJson(jsonRQ, WSReservaRQ.class);
//        try {
//            wsRS = travelaceWS.cancelar(wsRQ);
//        } catch (ErrorException ex) {
//            wsRS = new WSReservaRS(null, ex.getIntegrador());
//        } catch (Exception ex) {
//            wsRS = new WSReservaRS(null, new ErrorException(wsRQ.getIntegrador(), WS.class, "cancelar", WSMensagemErroEnum.GENNULO, "", WSIntegracaoStatusEnum.NEGADO, ex).getIntegrador());
//        }
//        Utils.gerarLog(wsRS.getIntegrador(), "cancelar", true);
//        Response result = Response.ok(gson.toJson(wsRS)).build();
//        return result;
//    }
//}
