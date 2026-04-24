package Week_1;

import java.time.LocalDate;

public class HelloMediTrack {
    public static void main(String[] args) {// Sprint 0 verification - confirms environment is working
        System.out.println("MediTrack Patient System - v0.1");
        System.out.println("Developer: hypoxi");
        System.out.println("Student ID: 12345");
        System.out.println("Status: Environment configured successfully.");
        LocalDate date = LocalDate.now();
        System.out.println("Welcome to MediTrack, hypoxi. Today is " + date + ".");
    }
}
