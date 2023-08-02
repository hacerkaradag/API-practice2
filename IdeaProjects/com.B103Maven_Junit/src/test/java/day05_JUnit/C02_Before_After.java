package day05_JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C02_Before_After {
    @Before
    public void setup(){
        System.out.println("her Test Metodundan Once Calisir");
    }
    @After
    public void tearDown(){
        System.out.println("Her Test Metodundan Sonra Calisir");
    }
    @Test
    public void test01(){
        System.out.println("Ilk Test");
    }
    @Test
    public void test02(){
        System.out.println("Ikinci Test");
    }





    }


