import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class AmazonShopping {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void setUp() throws Exception {
        String sDirpath=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", sDirpath+ "/driver/chromedriver.exe");
        driver = (WebDriver) new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void AmazonShoppingTest() throws Exception {
        driver.get("https://www.google.co.in/search?q=amazon&rlz=1C1GCEU_enIN820&oq=ama&aqs=chrome.1.69i57j0l5.2151j0j7&sourceid=chrome&ie=UTF-8");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Web result with site links'])[1]/following::h3[1]")).click();
        driver.findElement(By.linkText("Today's Deals")).click();
//        driver.findElement(By.id("nextButton")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All Available'])[1]/following::span[2]")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Upcoming'])[1]/following::span[2]")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Try'])[1]/following::span[1]")).click();
//        driver.findElement(By.id("a-autoid-0-announce")).click();
//        driver.findElement(By.linkText("Privacy Notice")).click();
          }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
