import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class RegistrationTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpSelenium() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\aaley\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void registrationTest(){
        driver.get("https://ihgrewardsclubdining.rewardsnetwork.com/join.htm");
        WebElement fname = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        fname.clear();
        fname.sendKeys("Aaleyah");
        fname.click();
        WebElement lname = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lname.sendKeys("Joseph");
        lname.click();
        WebElement zipcode = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
        zipcode.sendKeys("30043");
        zipcode.click();
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        email.sendKeys("abc@gmail.com");
        email.click();
        WebElement verify = driver.findElement(By.xpath("//*[@id=\"emailConfirm\"]"));
        verify.sendKeys("abc@gmail.com");
        verify.click();
        WebElement next = driver.findElement(By.xpath("//*[@id=\"enrollment\"]/div/div[3]/input"));
        next.click();

        Assert.assertTrue(driver.findElement(By.name("address1"))!=null);
    }
}
