/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtel.logger;

import java.io.File;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.apache.log4j.xml.DOMConfigurator;

/**
 *
 * @author Administrator
 */
public class LoggerClass {
    static Logger logger = LogManager.getLogger(LoggerClass.class);

    public LoggerClass() {
        
        String path = new File("./config/log4j.properties").getAbsolutePath();
        PropertyConfigurator.configure(path);
        logger = LogManager.getLogger(LoggerClass.class);
    }

    public  Logger getLogger() {
        return logger;
    }
}
