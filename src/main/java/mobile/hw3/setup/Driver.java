package mobile.hw3.setup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import io.appium.java_client.AppiumDriver;
import mobile.hw3.enums.PropertyTypes;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Map;

/**
 * Initialize a driver with test properties
 */
public class Driver {

    private static AppiumDriver driverSingle;
    private static WebDriverWait waitSingle;

    private DesiredCapabilities capabilities;
    private String driver;
    private String propertyPath = "properties.json";

    protected Driver() {
    }

    protected void initProperties(PropertyTypes propertyType) throws IOException {
        capabilities = new DesiredCapabilities();
        Map<String, String> caps = getCapabilities(propertyType.type);
        caps.entrySet().stream()
                .filter(x -> !x.getKey().equals("driver"))
                .forEach(x -> capabilities.setCapability(x.getKey(), x.getValue()));
        driver = caps.get("driver");
    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application      * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        // Init driver for local Appium server with capabilities have been set
        if (driverSingle == null) driverSingle = new AppiumDriver(new URL(driver), capabilities);

        // Set an object to handle timeouts
        if (waitSingle == null) waitSingle = new WebDriverWait(driver(), 10);
    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }

    private Map<String, String> getCapabilities(String type) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(propertyPath));
        Type metalsColorsMapType = new TypeToken<Map<String, Map<String, String>>>() {
        }.getType();
        Map<String, Map<String, String>> res = new Gson().fromJson(reader, metalsColorsMapType);
        return res.get(type);
    }

}
