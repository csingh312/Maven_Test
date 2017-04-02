package com.candice.maven;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by candice on 4/1/17.
 */
public class exercise4 {
    public static void main(String[] args) {
        try {
            File file = new File("/home/candice/Desktop/test.txt");

            PrintWriter output = new PrintWriter(file);
            output.println("Krogan");
            output.println(50);
            output.close();
            }
        catch (Exception e){
            System.out.println("Error: " + e);
        }


        try {
            Scanner input = new Scanner(new File("/home/candice/Desktop/test.txt"));
            String name = input.nextLine();
            int age = input.nextInt();
            System.out.printf("Name: %s Age: %d", name, age);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}