package UserInterfaceTask.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class GetProperties {
    private static final Properties PROPERTIES = new Properties();
    private static final String DATA = "src/test/resources/data.properties";

    public static String readFromDataConfig(String key) {
        try {
            InputStream input = new FileInputStream(DATA);
            PROPERTIES.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PROPERTIES.getProperty(key);
    }
}
