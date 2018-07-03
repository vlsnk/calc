package com.jcourse.vlsnk;

import com.jcourse.vlsnk.exception.CalculatorException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    protected Stack<Double> stackTest = new Stack<Double>();
    protected Map<String, Double> definitionsTest = new HashMap<String, Double>();
    private Scanner in = null;
    String a = "a", b = "b", c = "c";

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        definitionsTest.put("a",1d);
    }

    @AfterEach
    void tearDown() {
        if (in != null) in.close();
    }

    @Test
    void addCommand() {
        InputStream stream = Calculator.class.getClassLoader().getResourceAsStream("testDefine.txt");
        Scanner in = new Scanner(stream);

        while (in.hasNextLine()) {
            try {
                calculator.addCommand(in.nextLine());
            } catch (CalculatorException c) {

            }

        }
        assertEquals(definitionsTest.get("a"), calculator.definitions.get("a"));
    }

    @Test
    void testDefineCommand() {
        InputStream stream = Calculator.class.getClassLoader().getResourceAsStream("testDefine.txt");
        in = new Scanner(stream);
        while (in.hasNextLine()) {
            try {
                calculator.addCommand(in.nextLine());
            } catch (CalculatorException c) {

            }

        }
        assertEquals(definitionsTest.get("a"), calculator.definitions.get("a"));
    }

}