package me.nanjingchj.vm.codon;

public class Stop extends Codon {
    public Stop(byte... b) {
        super(b);
    }

    public Stop(byte b0, byte b1, byte b2) {
        super(b0, b1, b2);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
