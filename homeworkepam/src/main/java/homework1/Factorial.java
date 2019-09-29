package homework1;

import java.math.BigInteger;

/*Написать реализация метода, который вычисляет факториал, используя "длинную арифметику"*/
public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorialRec(16));
        System.out.println(factorialUnrec(16));
    }

    static long factorialRec(long n) {
        if (n == 0)
            return 1;
        else
            return (n * factorialRec(n - 1));
    }

    static BigInteger factorialUnrec(long n) {
        BigInteger res = BigInteger.valueOf(1);
        for (long i = 2; i <= n; ++i) {
            res = BigInteger.valueOf(i).multiply(res);
        }
        return res;
    }

}
