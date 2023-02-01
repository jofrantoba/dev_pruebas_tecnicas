 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.config;

import com.jofrantoba.model.jpa.psf.PSF;
import com.jofrantoba.model.jpa.psf.connection.ConnectionPropertiesMysql;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *
 * @author jona
 */
@Configuration
@ComponentScan(basePackages = {"com.parameter.dao"})
public class ConfigDao {
    
    @Autowired
    @Primary
    @Bean(name = "sessionFactory")    
    public SessionFactory getSessionFactory(){        
        List<String> packages=new ArrayList();
        packages.add("com.parameter.entity");        
        PSF.getInstance().buildPSF("mysql", getCnx(), packages);
        SessionFactory sesionFactory=PSF.getInstance().getPSF("mysql");
        return  sesionFactory;
    }
    
    private ConnectionPropertiesMysql getCnx(){
        ConnectionPropertiesMysql cnx=new ConnectionPropertiesMysql("172.16.1.10",3306,"demotiktok","usertiktok","usertiktok");
        return cnx;
    }
}
