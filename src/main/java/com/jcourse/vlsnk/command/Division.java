package com.jcourse.vlsnk.command;

import java.util.Map;
import java.util.Stack;

public class Division extends Command {

    public Division(Stack<Double> stack, Map<String, Double> definitions) {
        super(stack, definitions);
    }

    public void execute(Stack<Double> stack, Map<String, Double> vars) {
        if (hasTwoNumber()) {
            Double d1 = stack.pop();
            Double d2 = stack.pop();
            Double result = d1 / d2;
            stack.push(result);
        }
    }
}
