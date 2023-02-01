/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.service.impl;

import com.jofrantoba.model.jpa.shared.UnknownException;
import com.parameter.entity.Empleado;
import com.parameter.service.inter.InterServiceEmpleado;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestServiceEmpleadoImpl extends TestBaseService {

    @Test
    void createEntity1() throws UnknownException {
        InterServiceEmpleado service = contextService.getBean(ServiceEmpleadoImpl.class);
        Empleado emp = contextEntity.getBean(Empleado.class);
        emp.setNombres("Jonathan");
        emp.setApellidos("Torres");
        emp.setCargo("Developer");
        emp.setFechaNacimiento(new Date());
        emp.setFechaVinculacion(new Date());
        emp.setIsPersistente(Boolean.TRUE);
        emp.setNumeroDocumento("45329234");
        emp.setSalario(BigDecimal.ZERO);
        emp.setTipoDocumento("DNI");
        emp.setVersion(Long.MIN_VALUE);        
        service.saveEmpleado(emp);
    }

}
