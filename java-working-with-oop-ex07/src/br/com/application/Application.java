package br.com.application;

import java.util.Scanner;
import br.com.entities.Person;

public class Application {

    static Scanner sc;

    public static void main(String[] args) {
        //  negativeArrayNumberFinder();
        //  arraySum();
        personArray();
    }

    public static void negativeArrayNumberFinder() {
        sc = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.println("\nWhich numbers do you will enter? ");
        int number = sc.nextInt();

        if (number <= 10) {
            int[] vet = new int[number];

            for (int i = 0; i < vet.length; i++) {
                System.out.printf("\nEnter the %dº number: ", i + 1);
                vet[i] = sc.nextInt();
            }

            System.out.println("\nNegative numbers: ");
            for (int i = 0; i < vet.length; i++) {
                if (vet[i] < 0) {
                    System.out.println(vet[i]);
                } else {
                }

            }

        } else {
            System.out.println("No number greater than 10 is allowed!\n\n");
            negativeArrayNumberFinder();
        }

    }

    public static void arraySum() {
        sc = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.println("\nWhich numbers do you will enter? ");
        int number = sc.nextInt();

        double[] vet = new double[number];
        double sum = 0.0;
        double avg = 0.0;

        for (int i = 0; i < vet.length; i++) {
            System.out.printf("\nEnter the %dº number: ", i + 1);
            vet[i] = sc.nextDouble();
        }

        for (int i = 0; i < vet.length; i++) {
            sum += vet[i];
        }

        avg = sum / vet.length;

        System.out.print("\nValues: ");

        for (int i = 0; i < vet.length; i++) {
            System.out.print("[ " + vet[i] + " ], ");
        }

        System.out.println("\nSum: " + sum);
        System.out.printf("Average: " + String.format("%.2f", avg));
        sc.close();

    }

    public static void personArray() {

        sc = new Scanner(System.in);

        double avg = 0.0;
        double heightAvg = 0.0;
        int number = 0;
        int temp = 0;
        String youngPeople = "";

        System.out.println("Welcome!");
        System.out.println("\nHow many people do you will enter? ");
        number = sc.nextInt();
        Person[] person = new Person[number];

        for (int i = 0; i < person.length; i++) {
            System.out.printf("\n - %dº Person Data - ", i + 1);
            System.out.printf("\n\nEnter the %dº person name: ", i + 1);
            String name = sc.next();
            System.out.printf("\nEnter the %dº person age: ", i + 1);
            int age = sc.nextInt();
            sc.nextLine();
            System.out.printf("\nEnter the %dº person height: ", i + 1);
            double height = sc.nextDouble();
            person[i] = new Person(name, age, height);
            System.out.println("\nSuccess!");
        }

        for (int i = 0; i < person.length; i++) {
            heightAvg += person[i].getHeight() / person.length;
        }

        for (int i = 0; i < person.length; i++) {
            if (person[i].getAge() < 16) {
                temp = i;
                youngPeople += ", " + person[i].getName();
            } else {
            }

            avg = (temp * 100) / person.length;
        }

        for (int i = 0; i < person.length; i++) {
            System.out.print("\nName: " + person[i].getName());
            System.out.print("\nAge: " + person[i].getAge());
            System.out.print("\nHeight: " + person[i].getHeight() + "\n");
        }

        System.out.printf("\nAverage height: " + String.format("%.2f", heightAvg));
        System.out.println("\nLess than 16 years old: " + avg + "%");
        System.out.println(youngPeople);
        sc.close();

    }

}
