package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BeritaAcaraPage extends Parent{
    WebDriver driver;
    public BeritaAcaraPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "SearchBtn")
    WebElement searchButton;

    @FindBy(xpath = "//td[@data-name='FPPBNo']/a")
    WebElement listSO;

    @FindBy(css = ".btn-group.more-criteria")
    WebElement moreCriteriaFilter;

    @FindBy(xpath = "//ul[@id='ul-more-list']//li//label[@class='item-label']")
    List<WebElement> listFilterFromMoreCriteriaText;

    @FindBy(xpath = "//ul[@id='ul-more-list']//li//label[@class='item-label']//input[@type='checkbox']")
    List<WebElement> listFilterFromMoreCriteriaCheckbox;

    @FindBy(css = ".btn-group.sub-criteria.retur-status")
    WebElement statusFilter;

    @FindBy(xpath = "//ul[@id='ul-retur-status']/li")
    List<WebElement> listStatusText;

    @FindBy(xpath = "//ul[@id='ul-retur-status']/li/label/input")
    List<WebElement> listStatusRadioButton;

    @FindBy(xpath = "//tbody/tr/td[@data-name='StatusString']")
    WebElement statusText;

    public void clickTheFilterButton()
    {
        searchButton.click();
    }

    public BeritaAcaraDetailPage gotoBADetailPage()
    {
        waitWebElement(listSO);
        listSO.click();
        BeritaAcaraDetailPage beritaAcaraDetailPage = new BeritaAcaraDetailPage(driver);
        return beritaAcaraDetailPage;
    }

    public void clickMoreCriteriaFilter()
    {
        moreCriteriaFilter.click();
    }

    public void checkFilterFromMoreCriteria(String filter)
    {
        List<WebElement> listFilter = listFilterFromMoreCriteriaText;
        List<WebElement> listCheckBoxFilter = listFilterFromMoreCriteriaCheckbox;
        for(int i = 0 ; i < listFilter.size() ; i++)
        {
            if(listFilter.get(i).getText().equalsIgnoreCase(filter))
            {
                listCheckBoxFilter.get(i).click();
            }
        }
    }

    public void clickStatusFilter()
    {
        statusFilter.click();
    }

    public void chooseParticularStatusFromStatusFilter(String status)
    {
        List<WebElement> listStatus = listStatusText;
        List<WebElement> listRadioButtonStatus = listStatusRadioButton;
        for(int i = 0 ; i < listStatus.size() ; i++)
        {
            if(listStatus.get(i).getText().equalsIgnoreCase(status))
            {
                listRadioButtonStatus.get(i).click();
            }
        }
    }

    public String getFinishStatusSO(){
        return statusText.getText();
    }
}
