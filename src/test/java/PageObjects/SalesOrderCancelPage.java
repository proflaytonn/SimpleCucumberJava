package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SalesOrderCancelPage extends Parent {
    WebDriver driver;
    String successText;
    public SalesOrderCancelPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "transactionTypeValue")
    WebElement textboxSalesOrder;

    @FindBy(id = "SearchBtn")
    WebElement searchButton;

    @FindBy(css = "b")
    WebElement firstSalesOrderDetail;

    @FindBy(css = ".alert.alert-success")
    WebElement alertSuccessText;

    public SalesOrderCancelDetailPage searchSalesOrder(String salesOrderNo)
    {
        textboxSalesOrder.sendKeys(salesOrderNo);
        searchButton.click();
        firstSalesOrderDetail.click();

        SalesOrderCancelDetailPage salesOrderCancelDetailPage = new SalesOrderCancelDetailPage(driver);
        return salesOrderCancelDetailPage;
    }

    public String getSuccessRefundText()
    {
        successText = alertSuccessText.getText();
        System.out.println(successText);
        return successText;
    }
}
