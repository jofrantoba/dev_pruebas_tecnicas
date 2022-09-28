/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.entity;

import com.parameter.config.ConfigEntity;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author jona
 */
@Log4j2
public class TestEmpleado {
     private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    
    @Test
    void callContextSpring(){   
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigEntity.class);
        Empleado bean = context.getBean(Empleado.class);        
        bean.setId(Long.MIN_VALUE);
        Empleado bean1 = context.getBean(Empleado.class);
        bean.setId(8L);
        System.out.println(bean.getId());
        System.out.println(bean1.getId());
        bean1.setId(90L);
        System.out.println(bean1.getId());
        context.close();
    }
}
