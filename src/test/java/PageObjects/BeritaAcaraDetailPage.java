package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BeritaAcaraDetailPage extends Parent {
    WebDriver driver;
    public BeritaAcaraDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "h5")
    List<WebElement> listHeaders;

    public List<WebElement> getListRefundHeaders()
    {
        return listHeaders;
    }
}
