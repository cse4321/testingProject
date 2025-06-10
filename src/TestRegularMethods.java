import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class TestRegularMethods {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    
    PureNameCheck nameCheck=new PureNameCheck();
    
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
		
		
		// Call your method that prints to System.out
		nameCheck.checkPureName("name123");
		String result=outContent.toString().replaceAll("\\r?\\n", "");
        assertEquals("not pure name", result);
	}	
	
	
	@Test
	public void testCheckPureName2() {		
		// input: "name"
	    // expected output: "pure name"	
		
		// Call your method that prints to System.out
		nameCheck.checkPureName("name");
		String result=outContent.toString().replaceAll("\\r?\\n", "");
		assertEquals("pure name", result);
		
	}
	
	

	
	@Test
	public void testGetNameFromSystemIn() {
		// input:"nameFromSystemIn123" (provided through system.in)
		// output: "nameFromSystemIn123"		

		String input = "nameFromSystemIn123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
       
        // Call your method that use System.in
        String name=nameCheck.getNameFromSystemIn();

        assertEquals("nameFromSystemIn123", name);
	}
	
		

}
