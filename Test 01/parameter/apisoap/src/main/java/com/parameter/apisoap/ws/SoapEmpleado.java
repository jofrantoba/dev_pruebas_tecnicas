/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.apisoap.ws;

import com.jofrantoba.model.jpa.shared.UnknownException;
import com.parameter.service.inter.InterServiceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author jona
 */
@Endpoint
public class SoapEmpleado {

    private static final String NAMESPACE_URI = "http://parameter.com/apisoap/ws";

    @Autowired
    private InterServiceEmpleado serviceEmpleado;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmpleadoRequest")
    @ResponsePayload
    public EmpleadoResponse saveEmpelado(@RequestPayload EmpleadoRequest request) throws UnknownException {                
        EmpleadoResponse response=new EmpleadoResponse();
        response.setEmpleado(serviceEmpleado.saveEmpleado(request.getEmpleado()));
        return response;
    }
}
