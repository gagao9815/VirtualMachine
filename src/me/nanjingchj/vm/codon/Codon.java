package me.nanjingchj.vm.codon;

/*
 * List of codons
 * stp: stop
 */

public abstract class Codon {
    private static Class<Codon>[] codons = new Class[]{Stop.class};
    protected byte[] codes;

    public Codon(byte... b) {
        if (b.length == 3) {
            codes = b;
        } else {
            throw new java.lang.RuntimeException("Codon length must be 3");
        }
    }

    public Codon(byte b0, byte b1, byte b2) {
        this(new byte[]{b0, b1, b2});
    }

    public abstract void execute();
}
