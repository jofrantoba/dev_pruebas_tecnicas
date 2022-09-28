//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.08.24 a las 09:45:37 AM COT 
//


package com.parameter.apisoap.ws;

import com.parameter.entity.Empleado;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public EmpleadoRequest createEmpleadoRequest() {
        return new EmpleadoRequest();
    }

    public Empleado createEmpleado() {
        return new Empleado();
    }

    public EmpleadoResponse createEmpleadoResponse() {
        return new EmpleadoResponse();
    }

}
