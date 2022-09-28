/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parameter.config;

import com.parameter.soapclient.SoapClientEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 *
 * @author Usuario
 */
@Configuration
public class SoapEmpleado {
    @Autowired
    private SoapClientEmpleado soapClientEmpleado;
    
    @Bean(name="marshallerSoapEmpleado")
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        String[] packagesToScan= {"com.parameter.apisoap.ws","com.parameter.entity"};
        marshaller.setPackagesToScan(packagesToScan);
        return marshaller;
    }

    @Bean(name="soapClientEmpleadoImpl")
    public SoapClientEmpleado soapClient(@Qualifier("marshallerSoapEmpleado")Jaxb2Marshaller marshaller) {
        soapClientEmpleado.setDefaultUri("http://localhost:7000/ws/soapserviceempleado.wsdl");
        soapClientEmpleado.setMarshaller(marshaller);
        soapClientEmpleado.setUnmarshaller(marshaller);
        return soapClientEmpleado;
    }
    
}
