/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.dao.impl;

import com.jofrantoba.model.jpa.daoentity.AbstractJpaDao;
import com.jofrantoba.model.jpa.psf.PSF;
import com.parameter.dao.inter.InterDaoEmpleado;
import com.parameter.entity.Empleado;
import org.springframework.stereotype.Repository;



/**
 *
 * @author jona
 */
@Repository
public class DaoEmpleado extends AbstractJpaDao<Empleado>
        implements InterDaoEmpleado {

    public DaoEmpleado() {
        super();
        setClazz(Empleado.class);
        this.setSessionFactory(PSF.getClassPSF().getPSFStatic());
    }

}
