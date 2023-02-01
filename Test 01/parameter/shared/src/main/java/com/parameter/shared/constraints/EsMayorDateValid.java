/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parameter.shared.constraints;

import com.parameter.shared.Utility;
import java.util.Calendar;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Usuario
 */
public class EsMayorDateValid implements ConstraintValidator<EsMayorEdad, Date> {

    int valueEdadMayor;

    @Override
    public void initialize(EsMayorEdad constraintAnnotation) {
        valueEdadMayor = constraintAnnotation.valueEdad();
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        Utility util=new Utility();
        Calendar calNacimiento= Calendar.getInstance();        
        calNacimiento.setTime(date);
        Calendar calActual= Calendar.getInstance();        
        calActual.setTime(new Date());
        return util.calcularEdad(calNacimiento, calActual)>=valueEdadMayor;
    }

}
