/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.dao.impl;

import com.jofrantoba.model.jpa.shared.UnknownException;
import com.parameter.dao.inter.InterDaoEmpleado;
import com.parameter.entity.Empleado;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jona
 */
public class TestDaoEmpleadoInsert extends TestBaseDao{ 
    
    @Test
    void createEntity1() throws UnknownException {                
        Empleado emp = contextEntity.getBean(Empleado.class);        
        InterDaoEmpleado daoSequence = contextDao.getBean(DaoEmpleado.class);          
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
        InterDaoEmpleado dao = contextDao.getBean(DaoEmpleado.class);   
        Transaction tx=dao.getSession().beginTransaction();
        dao.save(emp);
        tx.commit();
    }
    
}
