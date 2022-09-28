//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.6 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.08.21 a las 03:17:51 AM COT 
//


package com.parameter.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.parameter.apirest.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Empleado_QNAME = new QName("http://jofrantoba.pe/soap/ws", "empleado");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.parameter.apirest.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Empleado }
     * 
     */
    public Empleado createEmpleado() {
        return new Empleado();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Empleado }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Empleado }{@code >}
     */
    @XmlElementDecl(namespace = "http://jofrantoba.pe/soap/ws", name = "empleado")
    public JAXBElement<Empleado> createEmpleado(Empleado value) {
        return new JAXBElement<Empleado>(_Empleado_QNAME, Empleado.class, null, value);
    }

}
