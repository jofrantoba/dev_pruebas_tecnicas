/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.apirest.ws;

import com.jofrantoba.model.jpa.shared.UnknownException;
import com.parameter.apisoap.ws.EmpleadoRequest;
import com.parameter.entity.Empleado;
import com.parameter.service.inter.InterServiceEmpleado;
import com.parameter.soapclient.SoapClientEmpleado;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jona
 */
@Slf4j
@RestController
@RequestMapping("parameta")
public class RestEmpleado {
    
    /*@Autowired    
    private InterServiceEmpleado serviceEmpleado;*/
    
    @Autowired    
    private SoapClientEmpleado soapClientEmpleado;

    @PostMapping(
            value = "/saveEmpleado",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Empleado saveEmpleado(@RequestBody Empleado entidad) throws UnknownException {
        entidad.setIsPersistente(Boolean.TRUE);
        entidad.setVersion((new Date()).getTime());
        EmpleadoRequest request=new EmpleadoRequest();
        request.setEmpleado(entidad);
        Empleado entity=soapClientEmpleado.saveEmpleado(request);
        Date fechaActual=new Date();
        Date fechaVinculacion=entity.getFechaVinculacion();
        Date fechaNacimiento=entity.getFechaNacimiento();
        long diffVinculacion=fechaActual.getTime()-fechaVinculacion.getTime();
        return entity;
    }
}
