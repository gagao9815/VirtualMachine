package me.nanjingchj.vm.operation;

public class DEF extends Operation {
    @Override
    public void execute() {
        // take the arguments and turn them into a string
        String args = new String(this.args);
        System.out.println(args);
    }
}
