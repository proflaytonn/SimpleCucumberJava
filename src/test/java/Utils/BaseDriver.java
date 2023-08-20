package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseDriver {
    WebDriver driver;
    Properties properties;
    ChromeOptions options;
    public WebDriver getDriver() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//Utils//setting.properties");
        properties.load(fis);
        String settingBrowser = properties.getProperty("browser");

        if(settingBrowser.equalsIgnoreCase("chrome"))
        {
//            options = new ChromeOptions();
//            options.addArguments("--headless");
//            options.addArguments("--remote-allow-origins=*"); //stackoverflow solution for : "java.io.IOException: Invalid Status code=403 text=Forbidden"
            driver = new ChromeDriver();
//            driver = new ChromeDriver(options); //trying headless to make test faster
        }
        else if(settingBrowser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        return driver;
    }

    public String getPropSOCHeader1()
    {
        return properties.getProperty("SOCHeader1");
    }

    public String getPropSOCHeader2()
    {
        return properties.getProperty("SOCHeader2");
    }

    public String getPropSOCHeader3()
    {
        return properties.getProperty("SOCHeader3");
    }

    public String getPropBADHeader1()
    {
        return properties.getProperty("BADetailHeader1");
    }

    public String getPropBADHeader2()
    {
        return properties.getProperty("BADetailHeader2");
    }

    public String getFinishWording()
    {
        return properties.getProperty("StatusFinishWording");
    }
}
