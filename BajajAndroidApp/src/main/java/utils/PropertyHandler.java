package utils;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public final class PropertyHandler {
    private static PropertyHandler propertyHandler;
    private static Properties properties;

    private PropertyHandler() {
        properties = new Properties();
    }

    public void load(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        properties.load(fileInputStream);
    }

    public void load(InputStream fileInputStream) throws IOException {
        properties.load(fileInputStream);
    }

    public void load(File file) throws IOException {
        properties.load(new FileInputStream(file));
    }

    public String getValue(String key) {
        return properties.getProperty(key, (String) null);
    }

    public static synchronized PropertyHandler getInstance() {
        if (propertyHandler == null) {
            propertyHandler = new PropertyHandler();
        }

        return propertyHandler;
    }
}
