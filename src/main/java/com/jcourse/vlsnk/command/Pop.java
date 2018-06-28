package com.jcourse.vlsnk.command;

import java.util.Map;
import java.util.Stack;

public class Pop extends Command {

    public Pop(Stack<Double> stack, Map<String, Double> definitions) {
        super(stack, definitions);
    }

    public void execute() {
        if (!stack.empty()) {
            System.out.println(super.stack.pop());
        }
    }
}
