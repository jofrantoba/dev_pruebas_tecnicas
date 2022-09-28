/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.service.impl;

import com.jofrantoba.model.jpa.shared.UnknownException;
import com.parameter.dao.inter.InterDaoEmpleado;
import com.parameter.entity.Empleado;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parameter.service.inter.InterServiceEmpleado;
import javax.transaction.Transactional;
import org.hibernate.Transaction;

/**
 *
 * @author jona
 */
@Log4j2
@Service
public class ServiceEmpleadoImpl implements InterServiceEmpleado{
    
    @Autowired    
    private InterDaoEmpleado daoEmpleado;
    
    //@Transactional
    @Override
    public Empleado saveEmpleado(Empleado entidad) throws UnknownException {        
            Transaction tx=daoEmpleado.getSession().beginTransaction();
            daoEmpleado.save(entidad);
            tx.commit();                        
            return entidad;
    }
    
    
}
