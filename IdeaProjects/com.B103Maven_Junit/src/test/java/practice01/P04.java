package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P04 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get(" https://the-internet.herokuapp.com/add_remove_elements");

         // Add Element butonuna 100 defa basınız
       driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();
        for(int i=0 ; i<100; i++) {

        }
//            int i= 0;
//            while(i<100){
//                addElement.click();
//                i++;

        // 100 defa basıldığını test ediniz
      List<WebElement>addButtonList=driver.findElements(By.xpath("//*[@onclick='addElement()']"));
        Assert.assertEquals(100, addButtonList.size());

        // 90 defa delete butonuna basınız
        for(int i=0; i<90; i++) {

        }
      driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();

        // 90 defa basıldığını doğrulayınız
        List<WebElement> deleteButtonList = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int kalanDeleteButton = deleteButtonList.size()-90;
        Assert.assertEquals(kalanDeleteButton,deleteButtonList.size());

        // Sayfayı kapatınız
        driver.close();


    }
        }




