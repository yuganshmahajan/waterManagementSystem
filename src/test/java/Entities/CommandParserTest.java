package Entities;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.JUnitException;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandParserTest {

    private CommandParser commandParserUnderTest;

    @BeforeEach
    void setUp() {
        commandParserUnderTest = new CommandParser("/Users/b0223014/Downloads/java-maven-starter-kit-master/sample_input/input1.txt");
    }

    @Test
    void testGenerateApartmentBill_Success() throws Exception {

        // Run the test
        commandParserUnderTest.generateApartmentBill();

        // Verify the results
        Assert.assertEquals(commandParserUnderTest.getApt().getM_bill(), 5215);
    }

    @Test
    void testGenerateApartmentBill_Failure_MISSED_ALLOTMENT() throws Exception {
        // Setup
        commandParserUnderTest.setFilePath("/Users/b0223014/Downloads/java-maven-starter-kit-master/sample_input/input2.txt");
        // Run the test
        commandParserUnderTest.generateApartmentBill();

        // Verify the results
        Assert.assertEquals(commandParserUnderTest.getApt(), null);
    }

    @Test
    void testGenerateApartmentBill_Failure_ADD_GUEST_BEFORE_ALLOTMENT() throws Exception {
        // Setup
        commandParserUnderTest.setFilePath("/Users/b0223014/Downloads/java-maven-starter-kit-master/sample_input/input3.txt");
        // Run the test
        commandParserUnderTest.generateApartmentBill();

        // Verify the results
        Assert.assertEquals(commandParserUnderTest.getApt(), null);
    }

    @Test
    void testGenerateApartmentBill_ThrowsFileNotFoundException() {
        // Setup

        // Run the test
        assertThrows(FileNotFoundException.class, () -> commandParserUnderTest.generateApartmentBill());
    }
}
