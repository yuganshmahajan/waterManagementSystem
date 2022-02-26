package com.example.geektrust;

import Entities.CommandParser;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    @Test
    void testMain() throws Exception {

        // Run the test
        Main.main(new String[]{"/Users/b0223014/Downloads/java-maven-starter-kit-master/sample_input/input1.txt"});

    }

    @Test
    void testMain_ThrowsFileNotFoundException() {

        // Run the test
        assertThrows(FileNotFoundException.class, () -> Main.main(new String[]{"value"}));
    }
}
