import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Project2 {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpSelenium() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\aaley\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void atltoCancun(){
        driver.get("https://www.hotwire.com/");
        WebElement flight = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/farefinder/div/farefinder-options/div/div[3]/div[1]"));
        flight.click();
        WebElement from = driver.findElement(By.xpath("//*[@id=\"farefinder-flight-origin-input\"]"));
        from.clear();
        from.sendKeys("Atlanta, GA, United States (ATL-All Airports)");
        from.click();
        WebElement select1 = driver.findElement(By.xpath("//*[@id=\"typeahead-262-5119-option-0\"]/a"));
        select1.click();


    }
    @Test
    public void atlCancun(){
        driver.get("https://www.kayak.com/");
        WebElement from = driver.findElement(By.xpath("//*[@id=\"J_h--origin-airport\"]"));
        from.clear();
        from.sendKeys("Atlanta");
        from.click();
        WebElement drop1 =driver.findElement(By.xpath("//*[@id=\"ap-ATL/11123\"]/div[2]/div[1]"));
        drop1.click();
        WebElement to = driver.findElement(By.xpath(""));
        to.sendKeys("Cancun");
        WebElement drop2 = driver.findElement(By.xpath("//*[@id=\"ap-CUN/34713\"]/div[2]/div[1]"));
        drop2.click();

    }
    @Test
    public void sample (){
        driver.get("https://www.priceline.com/?tab=flights");
        WebElement from =
                driver.findElement(By.xpath("//*[@id=\"flight-departure-airport0\"]"));
        from.clear();
        from.sendKeys("Atlanta, GA (ATL)");
        from.click();
        WebElement drop1 = driver.findElement(By.xpath("//*[@id=\"flight-departure-airport0-dropdown-item-0\"]"));
        drop1.click();
    }
}
