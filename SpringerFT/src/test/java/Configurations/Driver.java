package Configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by rneves on 1/21/16.
 */

public class Driver {

    private static WebDriver _instance = null;

    private static String _browser = "";



    public static void clearInstance(){
        _instance = null;
    }

    public static WebDriver getInstance() {

        // Only read the properties file if the browser is null
        if (_browser == "") {
            try {
                // Read properties file
                getPropValues();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Select correct browser
        switch (_browser) {
            case "firefox":
                _instance = getFirefoxInstance();
                break;
            case "chrome":
                _instance = getChromeInstance();
                break;
            default:
                _instance = getFirefoxInstance();
                break;
        }

        return _instance;
    }

    private static void getPropValues() throws IOException {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            // Get the file
            File file = new File("src/test/resources/config.properties");
            input = new FileInputStream(file);

            // Load a properties file
            prop.load(input);

            // Get the property value
            _browser = prop.getProperty("browser");

        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static WebDriver getFirefoxInstance() {

        if (_instance == null) {

            FirefoxProfile firefoxProfile = new FirefoxProfile();

            _instance = new FirefoxDriver(firefoxProfile);
        }

        return _instance;
    }

    // Set Google Chrome browser instance
    private static WebDriver getChromeInstance() {

        if (_instance == null) {
             _instance = new ChromeDriver();
        }
        System.out.print("About to use Chrome");
        return _instance;
    }
}
