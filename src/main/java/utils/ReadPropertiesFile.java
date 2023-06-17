package utils;

import constants.FrameworkConstants;
import enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertiesFile {
    private ReadPropertiesFile(){}

    private static Properties properties = new Properties();
    static {
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigpropertiespath());
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getValue(ConfigProperties key) throws Exception {
        String value ="";
        value = properties.getProperty(key.name().toLowerCase());
        if(Objects.isNull(value)){
            throw new Exception("Property name " + key +" is not found. Please check config.properties");
        }
        return value;
    }


}
