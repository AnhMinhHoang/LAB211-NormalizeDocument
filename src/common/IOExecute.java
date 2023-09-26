/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author GoldCandy
 */
public class IOExecute {
    public StringBuilder readFromFile(String filename) {
        StringBuilder str = new StringBuilder();
        try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (line.isBlank()) {
                    continue;
                }
                str.append(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return str;
    }

    public void writeToFile(String filename, StringBuilder s) {
        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            pw.append(s);
            pw.close();
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }
}
