import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalculatorTest {

    private static WebDriver driver;

    @BeforeClass
    public static void start()
    {
        driver = new ChromeDriver();
        driver.get("file:///C:/Automation/calc.html");
    }

    @Before
    public void cleanup ()
    {
        driver.findElement(By.xpath("//input[@value='C']")).click();
    }

    @Test
    public void add() {
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.xpath("//input[@value='3']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("43", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }
    @Test
    public void subtraction() {


        driver.findElement(By.xpath("//input[@value='7']")).click();
        driver.findElement(By.xpath("//input[@value='8']")).click();
        driver.findElement(By.xpath("//input[@value='-']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("54", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }
    @Test
    public void multiplication() {

        driver.findElement(By.xpath("//input[@value='3']")).click();
        driver.findElement(By.xpath("//input[@value='4']")).click();
        driver.findElement(By.xpath("//input[@value='x']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("68", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }
    @Test
    public void division() {

        driver.findElement(By.xpath("//input[@value='9']")).click();
        driver.findElement(By.xpath("//input[@value='6']")).click();
        driver.findElement(By.xpath("//input[@value='/']")).click();
        driver.findElement(By.xpath("//input[@value='3']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("3", driver.findElement(By.id("resultsbox")).getAttribute("value"));

    }



    @AfterClass
    public static void stop ()
    {

        driver.quit();

    }

}
