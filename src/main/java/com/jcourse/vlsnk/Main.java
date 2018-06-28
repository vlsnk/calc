package com.jcourse.vlsnk;

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
            if (getFile(s)) {
                calculator.addFile(s);
            } else {
                calculator.addCommand(s);
                if (s.startsWith("PRINT")) {
                    calculator.clear();
                }
            }
        }
    }

    static boolean getFile(String name){
        Path path = Paths.get(name);
        return Files.exists(path) ? true : false;
    }

}

