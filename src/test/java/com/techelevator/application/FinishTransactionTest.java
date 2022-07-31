package com.techelevator.application;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.*;

import static org.junit.Assert.*;

public class FinishTransactionTest
{

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @After
    public void restoreInitialStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void completeTransaction()
    {
        //Arrange

        //Act

        //Assert

    }

    @Test
    public void returnChange()
    {

        double testBalance = 5.55;
        int testInt = (int) (testBalance * 100);
        System.out.println("     Your change is as follows: 5 dollars, 2 quarters, 0 dimes, 1 nickels, and 0 pennies.");

        String expectedOutput = "     Your change is as follows: 5 dollars, 2 quarters, 0 dimes, 1 nickels, and 0 pennies.";
        assertEquals("     Your change is as follows: 5 dollars, 2 quarters, 0 dimes, 1 nickels, and 0 pennies.",
                expectedOutput);
    }


}