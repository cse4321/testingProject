
package com;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestOtherMethods {
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
	public void testCheckPureName1() {
		// input: "name123"
		// expected output: "not pure name"	
		PureNameCheck nameCheck=new PureNameCheck();
		nameCheck.checkPureName("name123");
		String result = outContent.toString().replaceAll("\\r?\\n", "");			
		assertEquals("not pure name", result);	
	}	
	
	@Test
	public void testCheckPureName2() {		
		// input: "name"
	    // expected output: "pure name"
		PureNameCheck nameCheck=new PureNameCheck();
		nameCheck.checkPureName("name");	
		 String result = outContent.toString().replaceAll("\\r?\\n", "");	
		assertEquals("pure name", result);
	}
	
	
	@Test
	public void testGetNameFromSystemIn() {
		// input:"nameFromSystemIn123" (provided through system.in)
		// output: "not pure name"	
        String input = "nameFromSystemIn123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
		PureNameCheck nameCheck=new PureNameCheck();
		assertEquals("nameFromSystemIn123",nameCheck.getNameFromSystemIn() );		
	}
	

}
