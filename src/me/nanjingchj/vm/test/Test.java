package me.nanjingchj.vm.test;

import me.nanjingchj.vm.operation.*;

public class Test {
    public static void main(String[] args) {
        String n = "me.nanjingchj.vm.operation.STP";
        try {
            Class c = Class.forName(n);
            Operation o = (Operation) c.newInstance();
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
