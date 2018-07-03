package com.jcourse.vlsnk.command;

import com.jcourse.vlsnk.exception.StackCalcException;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Print extends Command {

//    protected static Stack<Double> stack = new Stack<Double>();
//    protected static Map<String, Double> vars = new HashMap<String, Double>();
    public Print(Stack<Double> stack, Map<String, Double> definitions) {
        super(stack, definitions);
    }

    public void execute() throws StackCalcException {
        if (!stack.empty()) {
            System.out.println(stack.peek());
//            vars.clear();
//            stack.clear();
        } else throw new StackCalcException("Not enough arguments");
    }
}
