/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parameter.response;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class ServiceResult<T> {
    private T resultado;
    private Boolean esCorrecto;
    private String mensajeError;
    private Integer httpStatus;
    private ArrayList<String> advertencias;
    
}
