package me.nanjingchj.vm;

import me.nanjingchj.vm.operation.*;

import java.util.ArrayList;

public class VM implements Runnable {

    @Override
    public void run() {
        for (; ; ) {
            // get the next opcode / 3 bytes
            byte[] code = new byte[]{Main.nextByte(), Main.nextByte(), Main.nextByte()};
            String opName = "";
            for (byte c : code) {
                opName += Character.toString(c);
            }
            String n = "me.nanjingchj.vm.operation." + opName.toUpperCase();
            try {
                Class c = Class.forName(n);
                Operation o = (Operation) c.newInstance();
                // read until the separator mark is reached
                ArrayList<Byte> argsAL = new ArrayList<>();
                boolean sepReached = false;

                do {
                    byte nextByte = Main.nextByte();
                    argsAL.add(nextByte);

                    if (Character.toString(nextByte).equals(";")) {
                        sepReached = true;
                    }
                } while (!sepReached);

                // get them into a byte array
                byte[] args = new byte[argsAL.size() - 1];
                for (int i = 0; i < args.length; i++) {
                    args[i] = argsAL.get(i);
                }
                o.setArgs(args);
                o.execute();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
