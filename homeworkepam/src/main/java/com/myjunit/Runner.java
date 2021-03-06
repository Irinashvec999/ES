package com.myjunit;

import org.junit.AfterClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class Runner {

    private Runner() {
    }

    public static void run() throws InvocationTargetException, IllegalAccessException {
        TestClass testClass = new TestClass();
        Class<?> clazz = testClass.getClass();
        Method[] methods = clazz.getMethods();
        int counter = 0;

        List<Method> beforeClassMethods = getMethodByAnnotation(methods,BeforeClass.class);
        List<Method> afterClassMethods = getMethodByAnnotation(methods, AfterClass.class);
        List<Method> testMethods = getMethodByAnnotation(methods,Test.class);
        invokeMethods(beforeClassMethods,null);
        invokeMethods(afterClassMethods,null);
        invokeMethods(testMethods,testClass);

        /*for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                m.invoke(testClass);
                counter++;
            }
        }
        System.out.println(counter);*/
    }

    private static void invokeMethods(List<Method> beforeClassMethods, Object object) throws InvocationTargetException, IllegalAccessException {
        for (Method m:beforeClassMethods) {
            m.invoke(null);
        }
    }

    private static List<Method> getMethodByAnnotation(Method[] methods, Class<? extends Annotation>clazz) {
        List<Method> resultMethod = new ArrayList<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(clazz)){
                resultMethod.add(m);
            }
        }
        return resultMethod;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Runner.run();
    }
}
