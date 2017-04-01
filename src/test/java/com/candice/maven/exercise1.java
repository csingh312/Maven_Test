package com.candice.maven;

/**
 * Created by candice on 4/1/17.
 */
public class exercise1 {
    private String name;
    private String platform;
    private String company;

    exercise1(String myName, String myPlatform, String myCompany) {
        name = myName;
        platform = myPlatform;
        company = myCompany;
    }

    public void showConsole() {

        System.out.println("My name is " + name);
        System.out.println("My favorite platform is " + platform);
        System.out.println("It is created by " + company);
        System.out.println("  ");
    }
}