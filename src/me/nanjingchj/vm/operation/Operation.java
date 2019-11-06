package me.nanjingchj.vm.operation;

public abstract class Operation implements Operable {
    public static Class<Operation>[] operations = new Class[]{STP.class};
    protected byte[] args;

    public Operation() {
    }

    public byte[] getArgs() {
        return args;
    }

    public void setArgs(byte[] args) {
        this.args = args;
    }

    public abstract void execute();
}
