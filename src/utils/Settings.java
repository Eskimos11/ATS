package utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {


    private static final String FILENAME = "resources/config.properties";

    private static Properties properties = new Properties();
    private static InputStream input;

    private static Settings setting;

    public static Settings getInstance() {
        if (setting == null) {
            setting = new Settings();
        }
        return setting;
    }

    public Settings() {
        initialize();
    }

    private void initialize() {
        try {
            input = new FileInputStream(FILENAME);
            properties.load(input);

        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
