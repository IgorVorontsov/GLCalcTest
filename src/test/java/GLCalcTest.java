import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class GLCalcTest {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void start() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", "GLCalcTest/src/test/resources/Calculator.exe");
        driver = new RemoteWebDriver(new URL("http://localhost:9999"), cap);
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("1")));

    }

    @Test
    public void calculatorAddTest() {

        driver.findElement(By.name("7")).click();
        driver.findElement(By.name("6")).click();
        driver.findElement(By.name("+")).click();
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("=")).click();

        Assert.assertEquals("117", driver.findElement(By.id("1000")).getText());

    }
    @Test
    public void calculatorSubtractTest() {

        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("-")).click();
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("=")).click();

        Assert.assertEquals("21", driver.findElement(By.id("1000")).getText());

    }
    @Test
    public void calculatorMultiplicationTest() {

        driver.findElement(By.name("3")).click();
        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("*")).click();
        driver.findElement(By.name("3")).click();
        driver.findElement(By.name("=")).click();

        Assert.assertEquals("93", driver.findElement(By.id("1000")).getText());

    }
    @Test
    public void calculatorDivisionTest() {

        driver.findElement(By.name("8")).click();
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("/")).click();
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("=")).click();

        Assert.assertEquals("42", driver.findElement(By.id("1000")).getText());

    }

    @AfterClass
    public static void stop() {

        driver.quit();
    }
}


