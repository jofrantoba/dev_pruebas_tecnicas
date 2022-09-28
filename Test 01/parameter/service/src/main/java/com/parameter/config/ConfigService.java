/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parameter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jona
 */
@Configuration
@ComponentScan(basePackages = { "com.parameter.service","com.parameter.dao","com.paramter.entity"})
public class ConfigService {
    
}
