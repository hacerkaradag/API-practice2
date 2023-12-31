package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {

    // ...Exercise 2...
    // 1- https://www.amazon.com sayfasina gidelim
    // 2- url'in 'amazon' icerdigini test edelim
    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    // 4- title'in 'Best Buy' icerdigini test edelim
    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    // 6- arama sonuclarının 'Java' icerdigini test edelim
    // 7- ikinci sayfaya(bestbuy) donelim
    // 8- logonun gorundugunu test edelim


    @Test
    public void test02() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com ");
        String sayfaAmazon=driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        String amazonUrl=driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        // 4- title'in 'Best Buy' icerdigini test edelim
        String bestBuytitle=driver.getTitle();
        Assert.assertTrue(bestBuytitle.contains("Best Buy"));

        String bestBuyhandle=driver.getWindowHandle();

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(sayfaAmazon);
        WebElement aramaSonuc=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaSonuc.sendKeys("Java", Keys.ENTER);

//        hocanin yazdigi
//        driver.switchTo().window(sayfa1Handle);
//        WebElement amazonAramaMot=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
//        amazonAramaMot.sendKeys("Java" + Keys.ENTER);


        // 6- arama sonuclarının 'Java' icerdigini test edelim'
        WebElement aramaSonuc1=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        Assert.assertTrue(aramaSonuc1.getText().contains("Java"));

//        hocanin yazdigi
//        WebElement aramaSonucu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
//        String aramaSonucuStr=aramaSonucu.getText();
//        Assert.assertTrue(aramaSonucuStr.contains("Java"));


        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestBuyhandle);

        // 8- logonun gorundugunu test edelim
        WebElement logo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
