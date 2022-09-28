/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author jona
 */
@Log4j2
@Data
@MappedSuperclass
public abstract class GlobalEntityPkString implements Serializable{
    @Id    
    @Column(length=3,columnDefinition = "char",name = "ID_ADUANA")  
    private String id;
    /*@Column(name = "version")
    private Long version;    
    @Column(name = "is_persistente")
    private Boolean isPersistente;*/
    /*@Transient          
    private String operacion;*/
}
