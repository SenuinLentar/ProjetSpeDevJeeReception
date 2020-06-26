/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appjee.receptionfacade.facade;

import com.appjee.receptionfacade.domain.SoapMessage;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author myal6
 */
@WebService(name = "FacadeEndpoint")
public interface FacadeServiceEndpointInterface {
    //TODO add WebParam(name = "") on parameters
    @WebMethod(operationName = "receiveDecipherOrder")
    @WebResult(name = "receivedOrder")
    SoapMessage receiveDecipherOrder(@WebParam(name = "soapMessage") SoapMessage message);
}
