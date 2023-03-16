package com.example.test.demo.test.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Util {

    public static List<String>  getInputString(){
        InputStream inputStream = Util.class.getResourceAsStream("/input.txt");
        List<String> lines = new BufferedReader(new InputStreamReader(inputStream))
                .lines().toList();

        return lines;
    }
}
