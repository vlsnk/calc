package com.jcourse.vlsnk;

import com.jcourse.vlsnk.exception.*;
import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import jdk.nashorn.internal.runtime.Context;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner in = new Scanner(System.in);

        for (;;) {
            String s = in.nextLine();
            if (s.equalsIgnoreCase("EXIT")) break;
            try {
                if (getFile(s)) {
                    calculator.addFile(s);
                } else {
                    calculator.addCommand(s);
                    if (s.startsWith("PRINT")) {
                        calculator.clear();
                    }
                }
            } catch (NoDefinitionExcetpion | StackCalcException | WrongArguments noDefinitionExcetpion) {
                System.out.println(noDefinitionExcetpion.getMessage());
            } catch (CalculatorException c) {
                c.printStackTrace();
            }
        }
    }

    static boolean getFile(String name){
        try {
//            File file = new File(Context.getContext().toString(), name);
//            if (file != null) {
//                return true;
//            }
            Path path = Paths.get("D:\\Idea Projects\\calc\\src\\main\\resources\\" + name);
            return Files.exists(path) ? true : false;

        } catch (Exception e) {
            return false;
        }
//        return false;
    }

}

