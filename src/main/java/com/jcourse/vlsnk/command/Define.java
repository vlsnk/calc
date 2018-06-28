package com.jcourse.vlsnk.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Define extends Command {
    String var;
    Double value;


    public Define(Stack<Double> stack, Map<String, Double> definitions) {
        super(stack, definitions);
    }

    public void addArgument(String[] args) {
        this.var = args[1];
        this.value = Double.valueOf(args[2]);
    }

    public void execute() {
        vars.put(var, value);
    }
}
