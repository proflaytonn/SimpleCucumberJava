package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Parent{
    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle']/span[text()='Sales Order']")
    WebElement salesOrderMenuHeader;

    @FindBy(xpath = "//a[text()='Sales Order Cancel']")
    WebElement salesOrderCancelSubMenu;

    @FindBy(xpath = "//a[@class='dropdown-toggle']/span[text()='Retur & Refund']")
    WebElement returAndRefundMenuHeader;

    @FindBy(xpath = "//a[text()='Berita Acara Refund']")
    WebElement beritaAcaraRefundSubMenu;

    public SalesOrderCancelPage gotoSalesOrderCancel()
    {
        a.moveToElement(salesOrderMenuHeader)
                .moveToElement(salesOrderCancelSubMenu)
                .click()
                .build()
                .perform();

        SalesOrderCancelPage salesOrderCancelPage = new SalesOrderCancelPage(driver);
        return salesOrderCancelPage;
    }

    public BeritaAcaraPage gotoBeritaAcaraPage()
    {
        a.moveToElement(returAndRefundMenuHeader)
                .moveToElement(beritaAcaraRefundSubMenu)
                .click()
                .build()
                .perform();

        BeritaAcaraPage beritaAcaraPage = new BeritaAcaraPage(driver);
        return beritaAcaraPage;
    }
}
