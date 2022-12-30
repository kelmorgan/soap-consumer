package com.kelmorgan.consumesoapservice;

import com.kelmorgan.consumesoapservice.wsdl.GetCountryRequest;
import com.kelmorgan.consumesoapservice.wsdl.GetCountryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class CountryClient extends WebServiceGatewaySupport {

    public GetCountryResponse getCountry(String country) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        log.info("Requesting location for " + country);

        return (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
                        new SoapActionCallback(
                                "http://kelmorgan.com/firstsoapservice/countries/GetCountryRequest"));
    }
}
