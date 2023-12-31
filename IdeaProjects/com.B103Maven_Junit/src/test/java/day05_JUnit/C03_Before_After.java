package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Before_After {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.close();

    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");
      Thread.sleep(3000);
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://techproeducation.com");
        Thread.sleep(3000);
    }

}