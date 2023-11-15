import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Usuario\\Documents\\Ingenieria_de_Sotfware_II\\Laboratorio_05\\geckodriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPositive() {
        driver.navigate().to("http://www.calculator.net/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"homelistwrap\"]/div[3]/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();
        driver.findElement(By.id("cpar1")).sendKeys("10");
        driver.findElement(By.id("cpar2")).sendKeys("50");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals(result, "5");
    }

    @Test
    public void testNegative() {
        driver.navigate().to("http://www.calculator.net/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"homelistwrap\"]/div[3]/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();
        driver.findElement(By.id("cpar1")).sendKeys("10");
        driver.findElement(By.id("cpar2")).sendKeys("-50");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals(result, "-5");
    }

    @Test
    public void testA() {
        driver.navigate().to("http://www.calculator.net/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"homelistwrap\"]/div[4]/div[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/table[3]/tbody/tr/td/div[1]/a[2]")).click();
        driver.findElement(By.id("cpar1")).sendKeys("15");
        driver.findElement(By.id("cpar2")).sendKeys("3");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals(result, "5");
    }

    @Test
    public void testB() {
        driver.navigate().to("http://www.calculator.net/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"homelistwrap\"]/div[4]/div[1]/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();
        driver.findElement(By.id("cpar1")).sendKeys("25");
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        assertEquals(result, "5");
    }
}
