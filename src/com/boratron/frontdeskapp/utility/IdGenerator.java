package com.boratron.frontdeskapp.utility;

public class IdGenerator {
    private static int id = 1;

    private IdGenerator() {}

    public static int generateId() {
        return ++id;
    }
}
