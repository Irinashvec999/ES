package homework1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void getFibonacciNumberByRecursMethod() {
        long expected = 832040;
        long actual = Fibonacci.getRecursFibonacci(30);
        assertEquals(expected, actual);
    }

    @Test
    public void getFibonacciNumberByUnrecursMethod() {
        long expected = 832040;
        long actual = Fibonacci.getUnrecursFibonacci(30);
        assertEquals(expected, actual);
    }
}