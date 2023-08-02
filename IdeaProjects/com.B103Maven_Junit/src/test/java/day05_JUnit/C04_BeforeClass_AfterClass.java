package day05_JUnit;

import org.junit.*;

public class C04_BeforeClass_AfterClass {
    /*
       @BeforeClass ve @AfterClass notasyonları sadece static method'lar için çalışır.
   @BeforeClass ve @AfterClass kullanırsak oluşturduğumuz @Test methodlarının hepsini aynı anda çalıştırıp
   en son @AfterClass'ı çalıştırırız
       Ama sadece @Before ve @After kullanırsak her test için @before ve @after'i kullnır.
    */
    @BeforeClass
    public static void setup() {
        System.out.println("Bütün Testlerden önce çalıştı");
        System.out.println("------------------------------");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Bütün Testlerden sonra çalıştı");
        System.out.println("--------------------------");
    }

    @Before
    public void setup01() {
        System.out.println("Her Test'ten önce çalışır");
        System.out.println("--------------------------");
    }

    @After
    public void teardown01() {
        System.out.println("Her Test'ten sonra çalışır");
        System.out.println("---------------------------");
    }

    @Test
    public void test01() {
        System.out.println("Ilk Test");
        System.out.println("------------------------------");
    }

    @Test
    public void test02() {
        System.out.println("Ikinci Test");
        System.out.println("------------------------------");
    }
    @Test
    @Ignore // Eğer bir testi çalıştırmak istemezsek bu şekilde kullanabiliriz
    public void test03(){
        System.out.println("Üçüncü Test");
    }
}