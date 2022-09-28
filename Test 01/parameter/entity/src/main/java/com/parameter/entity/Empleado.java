/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(catalog="parameta",schema="parameta",name = "empleado")
public class Empleado extends GlobalEntityPkNumeric implements Serializable{    
    @Column(name = "nombres")
    private String nombres;    
    @Column(name = "apellidos")
    private String apellidos;    
    @Column(name = "tipo_documento")
    private String tipoDocumento;    
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;   
    @Column(name = "fecha_vinculacion")
    private Date fechaVinculacion; 
    @Column(name = "cargo")
    private String cargo;    
    @Column(name = "salario")
    private BigDecimal salario;
}
