package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.bouncycastle.oer.its.etsi102941.Url;

public class ConfigReader {

    private Properties prop;

    public ConfigReader(){
        Properties prop = new Properties();
        try{
            FileInputStream fis = new FileInputStream("C:\\Users\\ratsatsi\\Documents\\OddRhymes-Automation-Framework\\selenium-framework\\src\\test\\java\\com\\automation\\Resources\\Configurations\\config.properties");
            prop.load(fis);

        }catch(IOException io){
            io.printStackTrace();
        }

    }
    public String getUrl(){
        return prop.getProperty("URL");
    }
    public  String getBrowser(){
        return prop.getProperty("BROWSER");

    }
    public Long getGlobalWait(){
        return Long.parseLong(prop.getProperty("GLOBALWAIT"));
}
    
}   
