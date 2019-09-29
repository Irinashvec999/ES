package homework1;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FactorialTest {

    @Test
    public void mustReturnFactorial() {
        assertEquals(120L, Factorial.factorialRec(5));
    }

    @Test
    public void mustReturnFactorialUnrecurseWay() {
        assertEquals(BigInteger.valueOf(120), Factorial.factorialUnrec(5));
    }
}