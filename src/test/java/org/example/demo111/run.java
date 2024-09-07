package org.example.demo111;

import org.testng.TestNG;

import static org.testng.TestNG.privateMain;

public class run {

    public static void main(String[] argv) {
        TestNG testng = privateMain(argv, null);
        System.exit(testng.getStatus());
    }

    }
