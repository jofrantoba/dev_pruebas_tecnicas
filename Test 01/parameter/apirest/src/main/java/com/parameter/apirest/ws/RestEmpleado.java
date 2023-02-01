/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.apirest.ws;

import com.jofrantoba.model.jpa.shared.UnknownException;
import com.parameter.apisoap.ws.EmpleadoRequest;
import com.parameter.entity.Empleado;
import com.parameter.response.ServiceResult;
import com.parameter.shared.Utility;
import com.parameter.soapclient.SoapClientEmpleado;
import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        
    @Autowired
    private Utility util;
    
    @Autowired
    private SoapClientEmpleado soapClientEmpleado;

    @PostMapping(
            value = "/saveEmpleado",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> saveEmpleado(@RequestBody Empleado entidad) throws UnknownException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validador = factory.getValidator();
        Set<ConstraintViolation<Empleado>> constraintsViolations = validador.validate(entidad);
        if (constraintsViolations.isEmpty()) {            
            EmpleadoRequest request = new EmpleadoRequest();
            request.setEmpleado(entidad);
            Empleado entity = soapClientEmpleado.saveEmpleado(request);    
            Date fechaActual=new Date();
            entity.setAnioMesDiaNac(util.periodo(entity.getFechaNacimiento(), fechaActual));
            entity.setAnioMesDiaVinc(util.periodo(entity.getFechaVinculacion(), fechaActual));
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            ServiceResult<Integer> respuesta = new ServiceResult<Integer>();
            respuesta.setMensajeError(constraintsViolations.toString());
            respuesta.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            respuesta.setEsCorrecto(false);
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
