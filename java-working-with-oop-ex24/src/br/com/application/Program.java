package br.com.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        String[] lines = new String[]{"Good morning", "Good afternoon", "Good night"};

        String path = "B:\\out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

            for (String i : lines) {
                bw.write(i);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
