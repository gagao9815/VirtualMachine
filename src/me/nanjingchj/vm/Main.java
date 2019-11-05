/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.nanjingchj.vm;

import java.io.*;
import java.util.Arrays;

/**
 * @author njche
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if (args.length != 1) {
            System.out.println("Please provide the input file");
            System.exit(0);
        }
        // read file name
        String fileName = args[0];

        // execute
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            long fileSize = new File(fileName).length();
            byte[] bytes = new byte[(int) fileSize];
            inputStream.read(bytes);
            System.out.println(Arrays.toString(bytes));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static byte nextByte() {

    }

}
