package team.core.agent.schedule;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * Created by wusq on 2015/4/13.
 */
public class ConfigHelper {
    public static String ReadConfig(String key) {
        Properties configFile = new Properties();
        try {
            configFile.load(new InputStreamReader(ConfigHelper.class.getClassLoader().getResourceAsStream("config.properties"), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = configFile.getProperty(key);
        System.out.println(value);
        return value;
    }
}
