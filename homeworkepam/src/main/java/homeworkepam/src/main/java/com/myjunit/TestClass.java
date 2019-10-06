package com.myjunit;

public class TestClass {

    @BeforeClass
    public static void init(){
        System.out.println("before");
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
    public static void after(){
        System.out.println("after");
    }

}
