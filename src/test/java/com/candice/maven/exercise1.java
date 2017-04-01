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

    public String getName() {
        return name;
    }

    public String getPlatform() {
        return platform;
    }

    public String getCompany() {
        return company;
    }

    public void showConsole() {

        System.out.println("My name is " + getName());
        System.out.println("My favorite platform is " + getPlatform());
        System.out.println("It is created by " + getCompany());
        System.out.println("  ");
    }
}