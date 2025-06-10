

package com;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testMain1() {
        String[] simulatedArgs = {"abcx"};
        PureNameCheck.main(simulatedArgs);
        String result = outContent.toString().replaceAll("\\r?\\n", "");
        assertEquals("pure name", result);
    }

    @Test
    public void testMain2() {
        String[] simulatedArgs = {};
        String input = "nameFromSystemIn123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        PureNameCheck.main(simulatedArgs);
        String result = outContent.toString().replaceAll("\\r?\\n", "");
        assertEquals("not pure name", result);
    }
}
