package com.candice.maven;

/**
 * Created by candice on 4/1/17.
 */
public class exercise2 {
    private String student;
    private String subject;
    private String grade;

    exercise2(String student, String subject, String grade) {
        this.student = student;
        this.subject = subject;
        this.grade = grade;

    }

    void showDetail(){
        System.out.println("Student: " + this.student);
        System.out.println("Student subject: " + this.subject);
        System.out.println("Student grade: " + this.grade);

    }
}
