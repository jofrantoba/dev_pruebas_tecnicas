/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.service.inter;

import com.jofrantoba.model.jpa.shared.UnknownException;
import com.parameter.entity.Empleado;

/**
 *
 * @author jona
 */
public interface InterServiceEmpleado {    
    Empleado saveEmpleado(Empleado entidad)throws UnknownException;
}
