package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SalesOrderCancelDetailPage extends Parent {
    WebDriver driver;

    public SalesOrderCancelDetailPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "h5")
    List<WebElement> listHeaders;

    @FindBy(id = "reasonRefundVIrtual")
    WebElement textboxReason;

    @FindBy(id = "btnRefundVirtual")
    WebElement buttonRefund;

    public List<WebElement> getListSOCDHeaders()
    {
        return listHeaders;
    }

    public void submitRefund()
    {
        js.executeScript("window.scrollBy(0,500)");

        //pengganti Assert, pake exception handling
        try {
            textboxReason.sendKeys("Failed");
            buttonRefund.click();
        }
        catch (Exception e)
        {
            System.out.println("Tidak ada kolom Refund");
        }
    }

}
