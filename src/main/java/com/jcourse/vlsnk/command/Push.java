package com.jcourse.vlsnk.command;

import java.util.Map;
import java.util.Stack;

public class Push extends Command {

    String var;

    public Push(Stack<Double> stack, Map<String, Double> definitions) {
        super(stack, definitions);
    }

    public void setPush(String s) {
        this.var = s;
    }

    public void execute() {
        if (vars.containsKey(var)) {
            Double d = super.vars.get(var);
            stack.push(d);
        }
    }
}
