package com.candice.maven;

/**
 * Created by candice on 4/1/17.
 */
public class exercise2_main {
    public static void main(String[] args) {
        exercise2 theStudent = new exercise2("Larry", "Science", "Freshman");
        exercise2 theStudent3 = new exercise2("Michelle", "English", "Senior");
        theStudent.showDetail();
        theStudent3.showDetail();
    }
}
