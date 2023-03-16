package com.ivarsexample.calendardemo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/* This was an example of a CommandLineRunner. He said we could use it to insert data into our db at startup.
* But then we moved on to another way of doing things, that's why we commented out @Component.*/
//@Component
public class DataLoader implements CommandLineRunner {
    // A CommandLineRunner has a run method which will be executed after the CommandLineRunner instance
    // is dependency injected.

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello!");
    }
}
