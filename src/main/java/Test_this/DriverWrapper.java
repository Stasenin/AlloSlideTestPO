package Test_this;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DriverWrapper {

    private static WebDriver driver;

    public static WebDriver getDriver() throws IOException {

// to run this public public:
// 1. All classes and methods who call this method(getDriver()) need to have "throws IOException".
// 2. you need to set JDK and JVM version to 1.6 or upper. You can do it by setting the POM file
// with "maven-compiler-plugin".  ( if dosent work try set File->ProjectStructure->Modules->Source->Language level
// to lvl that you need.)
// 3. you CANT compare like this if(x == "sasda") -   ONLY like  if(x==y)
        try {
            Properties properties = new Properties();
            InputStream input = null;
            input = new FileInputStream("src\\webDriver.properties");
            properties.load(input);
            properties.getProperty("driverWEBs");
            String x = properties.getProperty("driverWEBs");
            String y = "ChromeDriver";
            String z = "FirefoxDriver";

            if (driver == null) {
                if (x.equals(y)) {
                    System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
                    driver = new ChromeDriver();
                    System.out.println("Starting Chrome Driver ");
                }
                if (x.equals(z)) {
                    System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    System.out.println("Starting FirefoxDriver ");
                } else {
                    System.out.println("None of the drivers was initialized");
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return driver;
    }
}


