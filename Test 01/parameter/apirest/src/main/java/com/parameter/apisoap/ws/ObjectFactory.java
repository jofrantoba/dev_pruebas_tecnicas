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
