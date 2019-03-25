import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class TuitionCalculatorTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpSelenium() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\aaley\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void inStateTest() {
        driver.get("https://www.ggc.edu/admissions/tuition-and-financial-aid-calculators/index.html#");
        WebElement resident = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/article/div/div[2]/form/div[1]/div/div/div[1]/fieldset/div/label[1]"));
        resident.click();
        WebElement hours = driver.findElement(By.xpath("//*[@id=\"creditHOURS\"]"));
        hours.click();
        WebElement cost = driver.findElement(By.id("totalcost"));
        int estimateInt = (int) Integer.parseInt(cost.getAttribute("value").substring(1, 5));
        int givenValue = 5634 / 2;
        Assert.assertEquals(estimateInt, givenValue, 10.00);
    }
    @Test
    public  void outStateTest(){
        driver.get("https://www.ggc.edu/admissions/tuition-and-financial-aid-calculators/index.html#");
        WebElement resident = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/article/div/div[2]/form/div[1]/div/div/div[1]/fieldset/div/label[2]"));
        resident.click();
        WebElement hours = driver.findElement(By.xpath("//*[@id=\"creditHOURS\"]"));
        hours.click();
        WebElement housing= driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/article/div/div[2]/form/div[1]/div/div/div[3]/fieldset/div/label[2]"));
        housing.click();
        WebElement cost = driver.findElement(By.id("totalcost"));
        int estimateInt = (int) Integer.parseInt(cost.getAttribute("value").substring(1, 5));
        int givenValue = 16348;
        Assert.assertEquals((estimateInt * 2), givenValue, 10.00);







    }
    @Test
    public void myTest(){
        driver.get("https://www.ggc.edu/admissions/tuition-and-financial-aid-calculators/index.html#");
        Actions builder = new Actions(driver);
        WebElement resident =driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/article/div/div[2]/form/div[1]/div/div/div[1]/fieldset/div/label[2]"));
        resident.click();
        WebElement hours = driver.findElement(By.xpath("//*[@id=\"creditHOURS\"]"));
        hours.click();
        WebElement housing= driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/article/div/div[2]/form/div[1]/div/div/div[3]/fieldset/div/label[1]"));
        housing.click();
        WebElement size = driver.findElement(By.xpath("//*[@id=\"suite\"]"));
        size.click();
        builder.moveToElement(size).sendKeys("12 Bedroom, 6 Bath Suite").perform();
        size.click();
        WebElement cost = driver.findElement(By.id("totalcost"));
        int estimateInt = (int) Integer.parseInt(cost.getAttribute("value").substring(1, 6));
        int givenValue = 27506/2;
        Assert.assertEquals((estimateInt ), givenValue, 10.00);
        // My bill is the exact amount #Expensive
    }
}