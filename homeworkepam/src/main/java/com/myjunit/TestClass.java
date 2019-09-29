package com.myjunit;

import org.junit.After;
import org.junit.AfterClass;

public class TestClass {

    @BeforeClass
    public static void init(){
        System.out.println("static");
    }

    @Test
    public void shouldreturnResult1(){
        System.out.println("result1");
    }

    @Test
    public void shouldreturnResult2(){
        System.out.println("result2");
    }

    @AfterClass
    public void after(){
        System.out.println("after");
    }

}
