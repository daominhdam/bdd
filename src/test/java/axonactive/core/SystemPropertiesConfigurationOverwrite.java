package axonactive.core;

import axonactive.webapp.until.TestUtils;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.SupportedWebDriver;

import java.io.IOException;
import java.util.Properties;

public class SystemPropertiesConfigurationOverwrite extends net.thucydides.core.webdriver.SystemPropertiesConfiguration {

    public  static Properties env = null;

    public SystemPropertiesConfigurationOverwrite(EnvironmentVariables environmentVariables) {
        super(environmentVariables);
    }

    public SupportedWebDriver getDriverType() {
        SupportedWebDriver custom_driver = super.getDriverType();

        return custom_driver;
    }

    public static void loadFile() throws IOException {
        if(SystemPropertiesConfigurationOverwrite.env == null){
            env= new Properties();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            env= TestUtils.readUserConfigs(classLoader.getResourceAsStream("config.properties"));
        }
    }



}
