package com.jcourse.vlsnk.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Sqrt extends Command {

    public Sqrt(Stack<Double> stack, Map<String,Double> definitions) {
        super(stack, definitions);
    }


    public void execute() {
        if (!stack.isEmpty()) {
            Double d1 = stack.pop();
            Double result = Math.sqrt(d1);
            stack.push(result);
        }
    }
}
