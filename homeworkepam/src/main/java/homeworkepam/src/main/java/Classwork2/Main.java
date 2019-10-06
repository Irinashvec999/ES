package Classwork2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Singleton singleton1 = Singleton.SINGLETON;
        Singleton singleton2 = new Singleton();
        System.out.println(singleton1 == singleton2);

        Class<Singleton> singletonClass = Singleton.class;
        //not static method1 without parameters
        Method method = singletonClass.getDeclaredMethod("notStaticMethod");
        method.setAccessible(true);
        System.out.println(method.getName());
        Object invoke = method.invoke(singleton1);

        //not static method1 with parameters
        Method method1 = singletonClass.getDeclaredMethod("notStaticMethod", int.class);
        method1.setAccessible(true);
        System.out.println(method1.getName());
        Object invoke1 = method1.invoke(singleton1, 1);

        //static method2 with parameters
        Method method2 = singletonClass.getDeclaredMethod("staticMethod");
        method2.setAccessible(true);
        System.out.println(method2.getName());
        Object invoke2 = method2.invoke(null);

        Constructor<Singleton> declaredConstructor = singletonClass.getDeclaredConstructor();
        Singleton singleton = declaredConstructor.newInstance();
        System.out.println(singleton == singleton1);

    }
}

class Singleton {
    public static final Singleton SINGLETON = new Singleton();

    public Singleton() {
    }

    private void notStaticMethod(){
        System.out.println("Hello");
    }
    private void notStaticMethod(int code){
        System.out.println("Hello" + code);
    }
    static private void staticMethod(){
        System.out.println("Hello static");
    }
}
