package day09;


import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Cookies extends TestBase {
    @Test
    public void handleCookiesTest() {
        //amazona git
        driver.get("htpps://www.amazon.com");
        waitFor(3);

        //toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies(); // toplam cerez sayisi
        int cookieSayisi= allCookies.size();
        System.out.println("Sayfada" + cookieSayisi + "adet cookie var");


        //bir cookie yi ismiyle bul
        //tum cookie leri yazdiriniz
        //lamda ile yazdiralim
        //allCookies.stream().forEach(t-> System.out.println(t.getName()));

        for(Cookie eachCookie : allCookies){
            System.out.println("COOKIE" + eachCookie); //COOKIE NIN TAMAMINI YAZDIK
            System.out.println("COOKIE ISIMLERI"+ eachCookie.getName());
        }

        System.out.println("COOKIEYI ISMIYLE CAGIRIYORUM" + driver.manage().getCookieNamed("i18n-prefs"));

        //yeni bir cookie ekle
        Cookie favoriCookiem= new Cookie("cikolatam","antem-fistikli-cikolata"); //cookie olusturduk
        driver.manage().addCookie(favoriCookiem); //sayfaya yeni cookie ekledik
        waitFor(3);
        System.out.println("yeni cookie sayisi" + driver.manage().getCookies().size()); //cooike sayisi artti

        //bir cookie yi ismiyle siliniz
        driver.manage().deleteCookieNamed("session-id");

        //tum cookileri sil
        driver.manage().deleteAllCookies();
        waitFor(5);
        System.out.println("tum cookileri sildim ,yeni cookie sayisi"+driver.manage().getCookies().size());
    }
}
