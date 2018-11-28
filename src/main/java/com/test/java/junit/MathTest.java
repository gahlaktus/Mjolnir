package com.test.java.junit;

import static org.junit.Assert.*;
import com.dragon.junit.Math;
import org.junit.Test;

/**
 * Created by huangzhibo on 19/05/2017.
 */
public class MathTest {
    @Test
    public void factorial() throws Exception {
    }

    @Test
    public void fibonacci() throws Exception {
    }

    @Test
    public void testFactorial() throws Exception {
        assertEquals(120, new Math().factorial(5));
    }
}
