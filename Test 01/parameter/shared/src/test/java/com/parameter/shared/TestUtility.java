/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parameter.shared;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Usuario
 */
@Log4j2
public class TestUtility extends TestBaseShared{
    
    @Test
    public void calcularEdad() throws ParseException {
        Utility util=contextShared.getBean(Utility.class);
        Calendar calNacimiento= Calendar.getInstance(); 
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNac = df.parse("22/01/2022");
        calNacimiento.setTime(fechaNac);
        Calendar calActual= Calendar.getInstance();        
        calActual.setTime(new Date());
        int edad=util.calcularEdad(calNacimiento, calActual);
        log.info("La edad es:{}",edad);
        System.out.println(String.format("La edad es:%d", edad));
    }
    
    @Test
    public void calcularAnioMesDia() throws ParseException{
        Utility util=contextShared.getBean(Utility.class);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNac = df.parse("22/01/2022");        
        log.info("AnioMesDia:{}",Arrays.toString(util.anioMesDiaEntreFechas(fechaNac, new Date())));
    }
    
    
    @Test
    public void periodo() throws ParseException{
        Utility util=contextShared.getBean(Utility.class);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNac = df.parse("22/01/2022"); 
        Date fechaActual=new Date();
        log.info("Periodo:{}",Arrays.toString(util.periodo(fechaNac, fechaActual)));        
    }
    
    
    
}
