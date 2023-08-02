package day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {

    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
    // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Tüm option'ları yazdırın
    // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin//test varsa Assert de vardir

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//implicitly wait selenyumdan gelir
        //tread.sleep javadan gelir
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown ");
        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        //dropdown 3 adimile handle edilir
        //1.adim dropdown locate edilir
        WebElement ddm=driver.findElement(By.xpath("//select[@id='dropdown']"));
        //2.adim, selcet objesi olusturulur
        Select select= new Select(ddm);
        //3. adim, option secilir
        select.selectByIndex(1);

        String sectigimOptionIndex=select.getFirstSelectedOption().getText();
        System.out.println("Sectigimin option index: " + sectigimOptionIndex);
        Thread.sleep(3000);

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
       String sectigimOPtionValue= select.getFirstSelectedOption().getText();//get text bize string verir
        System.out.println("sectigimOPtionValue="+sectigimOPtionValue);
        Thread.sleep(3000);

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
        String sectiginOptionVisible=select.getFirstSelectedOption().getText();
        System.out.println("sectigimOptionVisible="+sectiginOptionVisible);
        Thread.sleep(3000);

        // Tüm option'ları yazdırın

        List<WebElement> tumOption=select.getOptions();

        int sayac=1;
        for(WebElement each:tumOption){
            System.out.println(sayac +".Option"+each.getText());
            sayac++;
        }
        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin//test varsa Assert de vardir

        int expected=3;
        int actual=tumOption.size();
        Assert.assertEquals(expected, actual);



    }

}

