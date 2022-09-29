/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parameter.soapclient;

import com.parameter.apisoap.ws.EmpleadoRequest;
import com.parameter.apisoap.ws.EmpleadoResponse;
import com.parameter.entity.Empleado;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 *
 * @author Usuario
 */
@Service
@Component("soapClientEmpleado")
public class SoapClientEmpleado extends WebServiceGatewaySupport{
    
    public Empleado saveEmpleado(EmpleadoRequest request){
        EmpleadoResponse response=(EmpleadoResponse)getWebServiceTemplate().marshalSendAndReceive("http://localhost:7000/ws/soapserviceempleado.wsdl", request);       
        return response.getEmpleado();
        
    }
}
