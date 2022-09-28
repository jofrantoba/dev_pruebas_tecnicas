/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.service.impl;

import com.parameter.config.ConfigDao;
import com.parameter.dao.impl.DaoEmpleado;
import com.parameter.dao.inter.InterDaoEmpleado;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jona
 */
@Log4j2
@Configuration
public class ServiceInterfaceDaoImpl {
    protected AnnotationConfigApplicationContext contextDao = new AnnotationConfigApplicationContext(ConfigDao.class);
    
    @Bean   
    public InterDaoEmpleado setUpDaoEmpleado(){
        return contextDao.getBean(DaoEmpleado.class);
    }
}
