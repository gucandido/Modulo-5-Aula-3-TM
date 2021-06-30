package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MyFactory {

    public static Object getInstance(String objName) throws IOException {

        Properties properties = new Properties();
        String propertiesPath = System.getProperty("user.dir") + "/src/com/company/MyFactory.properties";

        try {

            InputStream inputStream = new FileInputStream(propertiesPath);
            properties.load(inputStream);

            String sorterType = properties.getProperty("sorter");

            Class className = Class.forName(sorterType);

            return className.getDeclaredConstructor().newInstance();

        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException | ClassNotFoundException e) {
            System.out.println("Quebrou");
            e.printStackTrace();
        }

        return null;
    }

}
