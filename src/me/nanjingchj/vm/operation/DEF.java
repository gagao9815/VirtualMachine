package me.nanjingchj.vm.operation;

import java.nio.ByteBuffer;

public class DEF extends Operation {
    @Override
    public void execute() {
        // take the arguments and turn them into a string
        String[] argsS = new String(this.args).split(",");
        // 3 parts
        // type, variable name, initial value
        String type = argsS[0];
        String varName = argsS[1];
        // for ints
        if (type.toLowerCase().equals("int")) {
            int val = Integer.parseInt(argsS[2]);
            System.out.println(val);
        }
    }
}
