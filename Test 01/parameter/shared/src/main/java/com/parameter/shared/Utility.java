/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parameter.shared;

import java.util.Calendar;
import java.util.Date;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import java.time.YearMonth;
import static org.joda.time.DateTimeFieldType.year;
import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class Utility {
    
    public boolean esMayorEdad(Date fechaNacimiento){
        Calendar calNacimiento= Calendar.getInstance();        
        calNacimiento.setTime(fechaNacimiento);
        Calendar calActual= Calendar.getInstance();        
        calActual.setTime(new Date());
        int edad=calcularEdad(calNacimiento,calActual);        
        return edad>=Constantes.MAYOREDAD;            
    }
    
    public int calcularEdad(Calendar calNacimiento,Calendar calActual){
        int edad=calActual.get(Calendar.YEAR)-calNacimiento.get(Calendar.YEAR); 
        if(calNacimiento.get(Calendar.MONTH)>calActual.get(Calendar.MONTH) ||
                (calNacimiento.get(Calendar.MONTH)==calActual.get(Calendar.MONTH)
                && calActual.get(Calendar.DAY_OF_MONTH)<calNacimiento.get(Calendar.DAY_OF_MONTH)
                )){
            edad=edad-1;
        }
        return edad;
    }
    
    public int[] anioMesDiaEntreFechas(Date fechaIni,Date fechaFin){
        Calendar calIni= Calendar.getInstance();                
        calIni.setTime(fechaIni);        
        Calendar calFin= Calendar.getInstance();        
        calFin.setTime(fechaFin);
        Calendar calIniAux= Calendar.getInstance();                
        calIniAux.set(calFin.get(Calendar.YEAR), calIni.get(Calendar.MONTH), calIni.get(Calendar.DAY_OF_MONTH));        
        int anios=calFin.get(Calendar.YEAR)-calIni.get(Calendar.YEAR);
        int meses=calFin.get(Calendar.MONTH)-calIni.get(Calendar.MONTH);
        int dias=calFin.get(Calendar.DAY_OF_YEAR)-calIniAux.get(Calendar.DAY_OF_YEAR);              
        int calcMeses=0;
        if(meses<0 ||
                (meses==0
                && dias<0
                )){
            anios=anios-1;              
            calcMeses=(12-calIni.get(Calendar.MONTH))+calFin.get(Calendar.MONTH)-1;                        
            Calendar calFinAux= Calendar.getInstance();                
            calFinAux.set(calFin.get(Calendar.YEAR), calIni.get(Calendar.MONTH)-1, calIni.get(Calendar.DAY_OF_MONTH));
            dias=calFin.get(Calendar.DAY_OF_YEAR)-calFinAux.get(Calendar.DAY_OF_YEAR);;
        }
        int[] anioMesDia=new int[3];
        anioMesDia[0]=anios;
        anioMesDia[1]=calcMeses;
        anioMesDia[2]=dias;
        return anioMesDia;
    }
    
    public int[] periodo(Date startDate,Date endDate){
        Period periodo = new Period(startDate.getTime(), endDate.getTime(), PeriodType.yearMonthDay());
        int[] anioMesDia=new int[3];
        anioMesDia[0]=periodo.getYears();
        anioMesDia[1]=periodo.getMonths();
        anioMesDia[2]=periodo.getDays();
        return anioMesDia;
    }
        
}
