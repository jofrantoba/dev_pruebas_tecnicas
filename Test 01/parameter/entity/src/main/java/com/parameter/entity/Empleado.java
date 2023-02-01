/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.entity;

import com.parameter.shared.Constantes;
import com.parameter.shared.constraints.EsMayorEdad;
import com.parameter.shared.constraints.EsMenorIgualFechaActual;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author jona
 */
@XmlRootElement(name = "empleado")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Component
@Scope("prototype")
@Log4j2
@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(catalog="demotiktok",schema="demotiktok",name = "empleado")
public class Empleado extends GlobalEntityPkNumeric implements Serializable{    
    @NotEmpty    
    @Column(name = "nombres")
    private String nombres;    
    @NotEmpty    
    @Column(name = "apellidos")
    private String apellidos;    
    @NotEmpty    
    @Column(name = "tipo_documento")
    private String tipoDocumento;      
    @NotEmpty
    @Column(name = "numero_documento")        
    private String numeroDocumento;    
    @NotNull    
    @EsMenorIgualFechaActual(message="{fecha.menorIgualFechaActual}")
    @EsMayorEdad(valueEdad=Constantes.MAYOREDAD,message="{fechaNac.mayoredad}")
    @Column(name = "fecha_nacimiento")    
    private Date fechaNacimiento;   
    @NotNull
    @EsMenorIgualFechaActual(message="{fecha.menorIgualFechaActual}")
    @Column(name = "fecha_vinculacion")
    private Date fechaVinculacion; 
    @NotEmpty    
    @Column(name = "cargo")
    private String cargo;    
    @NotNull
    @Column(name = "salario")
    private BigDecimal salario;
    @Transient
    private int[] anioMesDiaNac;   
    @Transient
    private int[] anioMesDiaVinc;   
}
