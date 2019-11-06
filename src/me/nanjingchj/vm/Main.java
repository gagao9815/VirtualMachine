/*
 * List of opcodes
 * stp: stop the execution, no args
 * def: define a new int variable (4 bytes long)
 *      syntax:
 *          defint,x,10;
 * ;: separate the current statement from the next one
 * ,: argument separator
 * mov: move the value stored in the 2nd var into the 1st var
 *      syntax:
 *          movx,y;
 *          mov x, y
 */
package me.nanjingchj.vm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    private static FileInputStream inputStream;
    private static int index = 0;
    private static byte[] bytes;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide the input file");
            System.exit(0);
        }
        // read file name
        String fileName = args[0];

        // execute
        try {
            inputStream = new FileInputStream(fileName);
            long fileSize = new File(fileName).length();
            bytes = new byte[(int) fileSize];
            inputStream.read(bytes);

            // start the execution
            new Thread(new VM()).start();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }

    public static byte nextByte() {
        index++;
        return bytes[index - 1];
    }

}
