
package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import tektravel.hotelbookingapi.AmendmentRequest;
import tektravel.hotelbookingapi.AmendmentResponse;
import tektravel.hotelbookingapi.AuthenticationData;
import tektravel.hotelbookingapi.AvailabilityAndPricingRequest;
import tektravel.hotelbookingapi.AvailabilityAndPricingResponse;
import tektravel.hotelbookingapi.CityWiseNotificationRequest;
import tektravel.hotelbookingapi.CityWiseNotificationResponse;
import tektravel.hotelbookingapi.CountryListRequest;
import tektravel.hotelbookingapi.CountryListResponse;
import tektravel.hotelbookingapi.DestinationCityListRequest;
import tektravel.hotelbookingapi.DestinationCityListResponse;
import tektravel.hotelbookingapi.GenerateInvoiceRequest;
import tektravel.hotelbookingapi.GenerateInvoiceResponse;
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
import tektravel.hotelbookingapi.HotelCodesRequest;
import tektravel.hotelbookingapi.HotelCodesResponse;
import tektravel.hotelbookingapi.HotelDetailsRequest;
import tektravel.hotelbookingapi.HotelDetailsResponse;
import tektravel.hotelbookingapi.HotelRoomAvailabilityRequest;
import tektravel.hotelbookingapi.HotelRoomAvailabilityResponse;
import tektravel.hotelbookingapi.HotelSearchRequest;
import tektravel.hotelbookingapi.HotelSearchResponse;
import tektravel.hotelbookingapi.HotelSearchWithRoomsRequest;
import tektravel.hotelbookingapi.HotelSearchWithRoomsResponse;
import tektravel.hotelbookingapi.ObjectFactory;
import tektravel.hotelbookingapi.TBOHotelCodesRequest;
import tektravel.hotelbookingapi.TBOHotelCodesResponse;
import tektravel.hotelbookingapi.TagInfoRequest;
import tektravel.hotelbookingapi.TagInfoResponse;
import tektravel.hotelbookingapi.TopDestinationsRequest;
import tektravel.hotelbookingapi.TopDestinationsResponse;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6b21 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IHotelService", targetNamespace = "http://TekTravel/HotelBookingApi")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IHotelService {


    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.HotelSearchResponse
     */
    @WebMethod(operationName = "HotelSearch", action = "http://TekTravel/HotelBookingApi/HotelSearch")
    @WebResult(name = "HotelSearchResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public HotelSearchResponse hotelSearch(
        @WebParam(name = "HotelSearchRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        HotelSearchRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.HotelRoomAvailabilityResponse
     */
    @WebMethod(operationName = "AvailableHotelRooms", action = "http://TekTravel/HotelBookingApi/AvailableHotelRooms")
    @WebResult(name = "HotelRoomAvailabilityResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public HotelRoomAvailabilityResponse availableHotelRooms(
        @WebParam(name = "HotelRoomAvailabilityRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        HotelRoomAvailabilityRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.HotelCancellationPolicyResponse
     */
    @WebMethod(operationName = "HotelCancellationPolicy", action = "http://TekTravel/HotelBookingApi/HotelCancellationPolicy")
    @WebResult(name = "HotelCancellationPolicyResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public HotelCancellationPolicyResponse hotelCancellationPolicy(
        @WebParam(name = "HotelCancellationPolicyRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        HotelCancellationPolicyRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.HotelCancellationPolicyResponse
     */
    @WebMethod(operationName = "HotelCancellationPolicyForAllRooms", action = "http://TekTravel/HotelBookingApi/HotelCancellationPolicyForAllRooms")
    @WebResult(name = "HotelCancellationPolicyResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public HotelCancellationPolicyResponse hotelCancellationPolicyForAllRooms(
        @WebParam(name = "HotelCancellationPolicyRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        HotelCancellationPolicyRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.HotelBookResponse
     */
    @WebMethod(operationName = "HotelBook", action = "http://TekTravel/HotelBookingApi/HotelBook")
    @WebResult(name = "HotelBookResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public HotelBookResponse hotelBook(
        @WebParam(name = "HotelBookRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        HotelBookRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.AvailabilityAndPricingResponse
     */
    @WebMethod(operationName = "AvailabilityAndPricing", action = "http://TekTravel/HotelBookingApi/AvailabilityAndPricing")
    @WebResult(name = "AvailabilityAndPricingResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public AvailabilityAndPricingResponse availabilityAndPricing(
        @WebParam(name = "AvailabilityAndPricingRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        AvailabilityAndPricingRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.HotelBookingDetailResponse
     */
    @WebMethod(operationName = "HotelBookingDetail", action = "http://TekTravel/HotelBookingApi/HotelBookingDetail")
    @WebResult(name = "HotelBookingDetailResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public HotelBookingDetailResponse hotelBookingDetail(
        @WebParam(name = "HotelBookingDetailRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        HotelBookingDetailRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.GenerateInvoiceResponse
     */
    @WebMethod(operationName = "GenerateInvoice", action = "http://TekTravel/HotelBookingApi/GenerateInvoice")
    @WebResult(name = "GenerateInvoiceResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public GenerateInvoiceResponse generateInvoice(
        @WebParam(name = "GenerateInvoiceRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        GenerateInvoiceRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.AmendmentResponse
     */
    @WebMethod(operationName = "Amendment", action = "http://TekTravel/HotelBookingApi/Amendment")
    @WebResult(name = "AmendmentResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public AmendmentResponse amendment(
        @WebParam(name = "AmendmentRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        AmendmentRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.HotelCancelResponse
     */
    @WebMethod(operationName = "HotelCancel", action = "http://TekTravel/HotelBookingApi/HotelCancel")
    @WebResult(name = "HotelCancelResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public HotelCancelResponse hotelCancel(
        @WebParam(name = "HotelCancelRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        HotelCancelRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.CountryListResponse
     */
    @WebMethod(operationName = "CountryList", action = "http://TekTravel/HotelBookingApi/CountryList")
    @WebResult(name = "CountryListResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public CountryListResponse countryList(
        @WebParam(name = "CountryListRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        CountryListRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.DestinationCityListResponse
     */
    @WebMethod(operationName = "DestinationCityList", action = "http://TekTravel/HotelBookingApi/DestinationCityList")
    @WebResult(name = "DestinationCityListResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public DestinationCityListResponse destinationCityList(
        @WebParam(name = "DestinationCityListRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        DestinationCityListRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.TopDestinationsResponse
     */
    @WebMethod(operationName = "TopDestinations", action = "http://TekTravel/HotelBookingApi/TopDestinations")
    @WebResult(name = "TopDestinationsResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public TopDestinationsResponse topDestinations(
        @WebParam(name = "TopDestinationsRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        TopDestinationsRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.HotelDetailsResponse
     */
    @WebMethod(operationName = "HotelDetails", action = "http://TekTravel/HotelBookingApi/HotelDetails")
    @WebResult(name = "HotelDetailsResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public HotelDetailsResponse hotelDetails(
        @WebParam(name = "HotelDetailsRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        HotelDetailsRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.HotelCodesResponse
     */
    @WebMethod(operationName = "HotelCodeList", action = "http://TekTravel/HotelBookingApi/HotelCodes")
    @WebResult(name = "HotelCodesResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public HotelCodesResponse hotelCodeList(
        @WebParam(name = "HotelCodesRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        HotelCodesRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.HotelSearchWithRoomsResponse
     */
    @WebMethod(operationName = "HotelSearchWithRooms", action = "http://TekTravel/HotelBookingApi/HotelSearchWithRooms")
    @WebResult(name = "HotelSearchWithRoomsResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public HotelSearchWithRoomsResponse hotelSearchWithRooms(
        @WebParam(name = "HotelSearchWithRoomsRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        HotelSearchWithRoomsRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.HotelBookingDetailBasedOnDateResponse
     */
    @WebMethod(operationName = "HotelBookingDetailBasedOnDate", action = "http://TekTravel/HotelBookingApi/HotelBookingDetailBasedOnDate")
    @WebResult(name = "HotelBookingDetailBasedOnDateResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public HotelBookingDetailBasedOnDateResponse hotelBookingDetailBasedOnDate(
        @WebParam(name = "HotelBookingDetailBasedOnDateRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        HotelBookingDetailBasedOnDateRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.GiataHotelCodesResponse
     */
    @WebMethod(operationName = "GiataHotelCodeList", action = "http://TekTravel/HotelBookingApi/GiataHotelCodes")
    @WebResult(name = "GiataHotelCodesResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public GiataHotelCodesResponse giataHotelCodeList(
        @WebParam(name = "GiataHotelCodesRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        GiataHotelCodesRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.TBOHotelCodesResponse
     */
    @WebMethod(operationName = "TBOHotelCodeList", action = "http://TekTravel/HotelBookingApi/TBOHotelCodes")
    @WebResult(name = "TBOHotelCodesResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public TBOHotelCodesResponse tboHotelCodeList(
        @WebParam(name = "TBOHotelCodesRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        TBOHotelCodesRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.TagInfoResponse
     */
    @WebMethod(operationName = "TagInfo", action = "http://TekTravel/HotelBookingApi/TagInfos")
    @WebResult(name = "TagInfoResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public TagInfoResponse tagInfo(
        @WebParam(name = "TagInfoRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        TagInfoRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

    /**
     * 
     * @param credentials
     * @param parameters
     * @return
     *     returns tektravel.hotelbookingapi.CityWiseNotificationResponse
     */
    @WebMethod(operationName = "CityWiseNotification", action = "http://TekTravel/HotelBookingApi/CityWiseNotification")
    @WebResult(name = "CityWiseNotificationResponse", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
    public CityWiseNotificationResponse cityWiseNotification(
        @WebParam(name = "CityWiseNotificationRequest", targetNamespace = "http://TekTravel/HotelBookingApi", partName = "parameters")
        CityWiseNotificationRequest parameters,
        @WebParam(name = "Credentials", targetNamespace = "http://TekTravel/HotelBookingApi", header = true, partName = "Credentials")
        AuthenticationData credentials);

}
