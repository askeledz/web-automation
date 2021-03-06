package com.askeledz.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Author: askeledzija It's a generic WebDriver manager, it works with local and remote instances of WebDriver
 */
public class LocalDriverFactoryWEB {

    static Logger log = Logger.getLogger(LocalDriverFactoryWEB.class);

    static WebDriver createInstance(String browserName) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("firefox")) {
            // selenium-server-standalone-2.53.1 --> FireFox 46.0
            System.setProperty("webdriver.gecko.driver", "/Users/askeledzija/Documents/Private/Development/workspace/web-automation/geckodriver2");
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            capability.setVersion("57.03");
            capability.setPlatform(Platform.ANY);
            driver = new FirefoxDriver(capability);
            log.info("LocalDriverFactory created aa instance of WebDriver for: " + browserName);
            return driver;
        }
        if (browserName.equalsIgnoreCase("chrome")) {
System.setProperty("webdriver.gecko.driver", "/Users/askeledzija/Documents/Private/Development/workspace/web-automation/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--kiosk");
            driver = new ChromeDriver(options);
            log.info("LocalDriverFactory created aa instance of WebDriver for: " + browserName);
            return driver;

        }
        if (browserName.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
            log.info("LocalDriverFactory created aa instance of WebDriver for: " + browserName);
            return driver;
        }
        if (browserName.toLowerCase().contains("safari")) {
            // System.setProperty("webdriver.safari.driver", "/Applications/Safari.app/Contents/MacOS/Safari");
            driver = new SafariDriver();
            log.info("LocalDriverFactory created aa instance of WebDriver for: " + browserName);
            return driver;
        }

        log.info("LocalDriverFactory created aa instance of WebDriver for: " + browserName);
        return driver;
    }
}
