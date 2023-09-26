/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Algorithm;
import common.IOExecute;
import model.Paragraph;

/**
 *
 * @author GoldCandy
 */
public class Program {
    Algorithm algorithm;
    IOExecute inputOutput;
    Paragraph paragraph;
    
    public Program(){
        algorithm = new Algorithm();
        inputOutput = new IOExecute();
        paragraph = new Paragraph();
    }
    
    public void execute(){
        paragraph.setStr(inputOutput.readFromFile("input.txt"));
        algorithm.normalizePara(paragraph.getStr());
        inputOutput.writeToFile("output.txt", paragraph.getStr());
        System.out.println("Complete");
    }
}
