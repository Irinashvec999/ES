package homework1;/*Написать рекрсивный и не рекурсивный метод нахождения числа фибоначчи по его порядковому номеру*/

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(getRecursFibonacci(6));
        System.out.println(getUnrecursFibonacci(6));
    }

    public static long getRecursFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return getRecursFibonacci(n - 1) + getRecursFibonacci(n - 2);
        }
    }

    public static long getUnrecursFibonacci(int n) {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}

