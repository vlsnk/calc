package com.jcourse.vlsnk;

import com.jcourse.vlsnk.command.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Calculator {
    private static final String DEFINE = "DEFINE";
    private static final String DIVISION = "/";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String POP = "POP";
    private static final String PUSH = "PUSH";
    private static final String PRINT = "PRINT";
    private static final String SQRT = "SQRT";
    private static final String SUM = "+";

    protected Stack<Double> stack = new Stack<Double>();
    protected Map<String, Double> definitions = new HashMap<String, Double>();
    protected String[] args;
    protected List<Command> commandList = new LinkedList<Command>();

    public void addCommand(String s) {
        args = s.split(" ");
        Command c = null;

        if (args.length==0) return;

        String type = args[0];
        switch (type) {
            case DEFINE: {
                c = new Define(stack,definitions);
                ((Define) c).addArgument(args);
                break;
            }
            case DIVISION: {
                c = new Division(this.stack, definitions);
                break;
            }
            case MINUS: {
                c = new Minus(stack, definitions);
                break;
            }
            case MULTIPLY: {
                c = new Multiply(stack, definitions);
                break;
            }
            case POP: {
                c = new Pop(stack, definitions);
                break;
            }
            case PRINT: {
                c = new Print(stack, definitions);

                break;
            }
            case PUSH: {
                c = new Push(stack, definitions);
                ((Push) c).setPush(args[1]);
                break;
            }
            case SQRT: {
                c = new Sqrt(stack, definitions);
                break;
            }
            case SUM: {
                c = new Sum(stack, definitions);
                break;
            }
        }
        if (c != null) commandList.add(c);
        if (c != null) c.execute();
    }

    public void addFile(String s) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(s), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String line: lines){
            addCommand(line);
        }
    }

    void clear(){

        commandList.clear();
        stack.clear();
        definitions.clear();

    }
}
