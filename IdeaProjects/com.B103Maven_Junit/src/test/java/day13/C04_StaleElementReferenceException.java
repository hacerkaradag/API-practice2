package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {


    @Test
    public void staleElementReferenceExceptionTest1() {
        driver.get("https://www.techproeducation.com");
        waitFor(5);
//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        lmsLoginLink.click();//LMS e git
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URl in lms kelimesini icerdigini test et
        waitFor(5);
//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
        driver.navigate().back();//tekrar ana sayfaya gittik
        waitFor(5);
        lmsLoginLink.click();//LMS e git    //org.openqa.selenium.StaleElementReferenceException
      /*
        lmsLoginLink linkini sayfa yenilendikden(back()) sonra kullandigim icin StaleElementReferenceException aldim
         */
    }

    @Test
    public void staleElementReferenceExceptionTest2() {
        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        lmsLoginLink.click();// SAYFA YENILENMEDEN ONCE BULDUGUM ELEMENTI, SAYFA YENILENDIKDEN SONRA KULLANMAK ISTEDIM


//        COZUM ESKI(SLATE ELEMENT) ELEMENTI TEKRAR LOCATE ET
//        driver.findElement(By.linkText("LMS LOGIN")).click();

    }
}
//    Stale Element means the element is no longer fresh. It is old and no longer available
//        When the element is no longer fresh on the page and you try to use it
//        When the element is detached from the DOM
//        When the element is removed after session started
//        Solution:
//        Relocate the same element again. You can use a new variable name as well.
//        Example:
//
//        Stale Element = eski, kullanılamaz durumda, kullanım artık elverişli degil
//        -Sayfayi yenilediğinizde (refresh())
//        -Sayfada ileri geri gittimizde
//        COZUM:
//        Elementi tekrar bulmak