package com.boratron.frontdeskapp.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    private Reader() {}

    private static BufferedReader getReader() {
        return new BufferedReader(
                new InputStreamReader(System.in));
    }

    public static String readString(String message) {
        String input = "";

        System.out.print(message + ": ");

        try {
            input = getReader().readLine();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return input;
    }

    public static int readInt(String message) {
        int input;

        System.out.print(message + ": ");

        while (true) {
            try {
                // converts String data type to int primitive data type
                input = Integer.parseInt(getReader().readLine());
                break;
            } catch (IOException ioe) {
                System.err.println(ioe.getMessage());
            } catch (NumberFormatException nfe) {
                //System.err.println("Invalid input: " + nfe.getMessage());
                System.err.print("\nInvalid input! Please enter a number: ");
            }
        }

        return input;
    }
}
