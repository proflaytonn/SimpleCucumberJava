package StepDefinitions;

import PageObjects.*;
import Utils.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class StepDefinition extends BaseDriver {
    WebDriver driver;
    HomePage homePage;
    SalesOrderCancelPage salesOrderCancelPage;
    SalesOrderCancelDetailPage salesOrderCancelDetailPage;
    BeritaAcaraPage beritaAcaraPage;
    BeritaAcaraDetailPage beritaAcaraDetailPage;

    @Before
    public void initializeDriver() throws IOException {
        driver = getDriver();
    }

    @After
    public void closeWindows()
    {
        driver.quit();
    }
    @Given("Login to CMS Virtual {string} with email {string} and password {string}")
    public void login_to_cms_virtual_with_email_and_password(String url, String email, String password) {
//        driver.get(url);
//        driver.findElement(By.name("email")).sendKeys(email);
//        driver.findElement(By.name("password")).sendKeys(password);
//        driver.findElement(By.cssSelector(".btn-glow.primary.login")).click();
        LoginPage loginPage = new LoginPage(driver);
        homePage = loginPage.login(url, email, password);
    }
    @When("Go to Sales Order Cancel page")
    public void go_to_sales_order_cancel_page() {
//        a.moveToElement(driver.findElement(By.xpath("//a[@class='dropdown-toggle']/span[text()='Sales Order']")))
//                .moveToElement(driver.findElement(By.xpath("//a[text()='Sales Order Cancel']")))
//                .click()
//                .build()
//                .perform();
        salesOrderCancelPage = homePage.gotoSalesOrderCancel();
    }
    @When("Do the date filter")
    public void do_the_date_and_filter() {
//        driver.findElement(By.id("dp_from")).click();
//        Select select = new Select(driver.findElement(By.cssSelector(".ui-datepicker-month")));
//        select.selectByVisibleText("Jan");
//
//        Select selectYear = new Select(driver.findElement(By.cssSelector(".ui-datepicker-year")));
//        selectYear.selectByVisibleText("2022");
//
//        List<WebElement> dateCalendar = driver.findElements(By.cssSelector(".ui-state-default"));
//
//        for (int i = 0; i < dateCalendar.size(); i++) {
//            if (dateCalendar.get(i).getText().equalsIgnoreCase("1")) {
//                dateCalendar.get(i).click();
//                break;
//            }
//        }
        if(salesOrderCancelPage == null)
        {
            beritaAcaraPage.filterDate();
        }
        else {
            salesOrderCancelPage.filterDate();
        }
    }
    @When("Search {string} and Click the detail")
    public void click_the_detail(String salesOrderNo) {
//        driver.findElement(By.id("transactionTypeValue")).sendKeys(salesOrderNo);
//        driver.findElement(By.id("SearchBtn")).click();
//        //cancelStatus = driver.findElement(By.xpath("//tr/td[9]")).getText();
//        //validasi
//        //Assert.assertTrue(cancelStatus.equalsIgnoreCase("Refund belum diproses"));
//        driver.findElement(By.cssSelector("b")).click();
        salesOrderCancelDetailPage = salesOrderCancelPage.searchSalesOrder(salesOrderNo);
    }
    @When("Submit the refund")
    public void submit_the_refund() {
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.scrollBy(0,500)");
//
//        //pengganti Assert, pake exception handling
//        try {
//            driver.findElement(By.id("reasonRefundVIrtual")).sendKeys("Failed");
//            driver.findElement(By.id("btnRefundVirtual")).click();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Tidak ada kolom Refund");
//        }
        salesOrderCancelDetailPage.submitRefund();
    }
    @Then("Appear wording {string} that {string}")
    public void appear_wording_that(String salesOrderNo, String expectedWord) {
//        String successText = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
//        System.out.println(successText);
//        Assert.assertTrue(successText.contains(salesOrderNo + " " + expectedWord));
//        driver.quit();
        Assert.assertTrue(salesOrderCancelPage.getSuccessRefundText().contains(salesOrderNo + " " + expectedWord));
        driver.quit();
    }

    @Then("Check if SOC Detail opened successfuly")
    public void checkIfSOCDetailOpenedSuccessfuly() {
        List<WebElement> listSOCDetailText = salesOrderCancelDetailPage.getListSOCDHeaders();

        Assert.assertTrue(listSOCDetailText.get(0).getText().equalsIgnoreCase(getPropSOCHeader1()));
        Assert.assertTrue(listSOCDetailText.get(1).getText().equalsIgnoreCase(getPropSOCHeader2()));
        Assert.assertTrue(listSOCDetailText.get(2).getText().equalsIgnoreCase(getPropSOCHeader3()));
    }

    @When("Go to Berita Acara Refund Page")
    public void goToBeritaAcaraRefundPage() {
//        a.moveToElement(driver.findElement(By.xpath("//a[@class='dropdown-toggle']/span[text()='Retur & Refund']")))
//                .moveToElement(driver.findElement(By.xpath("//a[text()='Berita Acara Refund']")))
//                .click()
//                .build()
//                .perform();
        beritaAcaraPage = homePage.gotoBeritaAcaraPage();
    }

    @When("Click the BA filter button")
    public void click_the_ba_filter_button()
    {
//        driver.findElement(By.id("SearchBtn")).click(); //di date filter belom ada klik search
        beritaAcaraPage.clickTheFilterButton();
    }

    @When("Open the BA Refund Detail")
    public void openTheBARefundDetail(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@data-name='FPPBNo']/a")));
//        driver.findElement(By.xpath("//td[@data-name='FPPBNo']/a")).click();
        beritaAcaraDetailPage = beritaAcaraPage.gotoBADetailPage();
    }

    @Then("BA Refund Detail successfuly opened")
    public void baRefundDetailSuccessfulyOpened() {
        List<WebElement> listText = beritaAcaraDetailPage.getListRefundHeaders();
        Assert.assertTrue(listText.get(0).getText().equalsIgnoreCase(getPropBADHeader1()));
        Assert.assertTrue(listText.get(1).getText().equalsIgnoreCase(getPropBADHeader2()));
    }

    @When("Click the more criteria filter")
    public void click_the_more_criteria_filter()
    {
//        driver.findElement(By.cssSelector(".btn-group.more-criteria")).click();
        beritaAcaraPage.clickMoreCriteriaFilter();
    }
    @When("Check the {string} from Criteria Filter")
    public void check_the_status_filter_from_criteria_filter(String filter)
    {
//        List<WebElement> listFilter = driver.findElements(By.xpath("//ul[@id='ul-more-list']//li//label[@class='item-label']"));
//        List<WebElement> listCheckBoxFilter = driver.findElements(By.xpath("//ul[@id='ul-more-list']//li//label[@class='item-label']//input[@type='checkbox']"));
//        for(int i = 0 ; i < listFilter.size() ; i++)
//        {
//            if(listFilter.get(i).getText().equalsIgnoreCase(filter))
//            {
//                listCheckBoxFilter.get(i).click();
//            }
//        }
        beritaAcaraPage.checkFilterFromMoreCriteria(filter);
    }
    @When("Click the Status Filter")
    public void click_the_status_filter()
    {
//        driver.findElement(By.cssSelector(".btn-group.sub-criteria.retur-status")).click();
        beritaAcaraPage.clickStatusFilter();
    }
    @When("Choose status {string} filter from Status Filter")
    public void choose_status_finish_filter(String status)
    {
//        List<WebElement> listStatus = driver.findElements(By.xpath("//ul[@id='ul-retur-status']/li"));
//        List<WebElement> listRadioButtonStatus = driver.findElements(By.xpath("//ul[@id='ul-retur-status']/li/label/input"));
//        for(int i = 0 ; i < listStatus.size() ; i++)
//        {
//            if(listStatus.get(i).getText().equalsIgnoreCase(status))
//            {
//                listRadioButtonStatus.get(i).click();
//            }
//        }
        beritaAcaraPage.chooseParticularStatusFromStatusFilter(status);
    }

    @When("SalesOrder with finish status appear")
    public void salesorder_with_finish_status_appear(){
        String firstRowStatusText = beritaAcaraPage.getFinishStatusSO();
        Assert.assertTrue(firstRowStatusText.equalsIgnoreCase(getFinishWording()));
    }
}