/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parameter.shared.constraints;

import java.util.Calendar;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang.time.DateUtils;

/**
 *
 * @author Usuario
 */
public class EsMenorIgualFechaActualValid implements ConstraintValidator<EsMenorIgualFechaActual, Date> {


    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {          
        return date.getTime()<=DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH).getTime();
    }

}
