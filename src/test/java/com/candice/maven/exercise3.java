package com.candice.maven;

import java.util.Scanner;

/**
 * Created by candice on 4/1/17.
 */
public class exercise3 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter first number: ");
            int n1 = input.nextInt();
            System.out.println("Enter second number: ");
            int n2 = input.nextInt();
            int sum = n1 / n2;
            System.out.println(sum);
            }
        catch(Exception e){
            System.out.println("You can't do that!");

        }
    }
}
