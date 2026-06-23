package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public ConfigReader() {
        prop = new Properties();

        String path = System.getProperty("user.dir")
                + "\\src\\test\\java\\com\\automation\\Resources\\Configurations\\config.properties";

        try (FileInputStream fis = new FileInputStream(path)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }

    public String getUrl() {
        return prop.getProperty("URL");
    }

    public String getBrowser() {
        return prop.getProperty("BROWSER");
    }

    public Long getGlobalWaitValue() {
        return Long.parseLong(prop.getProperty("GLOBALWAIT"));
    }

    public String getFieldNamesFromExcel() {
        return prop.getProperty("FIELDS_VERIFICATION_EXCEL");
    }
}