package br.com.application;

import java.io.File;
import java.util.Scanner;
import br.com.entities.Item;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {

    static Scanner sc = new Scanner(System.in);
    static List<Item> itemList = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        System.out.print("\n|-------------    WELCOME      ------------|");
        System.out.print("\n|Option 01: New item                       |");
        System.out.print("\n|Option 02: List all items                 |");
        System.out.print("\n|Option 03: Generate .csv file             |");
        System.out.print("\n|Option 04: Exit                           |");
        System.out.print("\n|------------------------------------------|");

        System.out.print("\n|Enter an option: ");
        int selection = sc.nextInt();
        runApplication(selection);
    }

    public static void runApplication(int selection) {
        try {
            switch (selection) {
                case 1 -> {
                    System.out.println("Enter item name: ");
                    String name = sc.next();
                    sc.nextLine();
                    System.out.println("Enter the price of " + name + " $: ");
                    Double price = sc.nextDouble();
                    System.out.println("Enter the quantity of " + name + ": ");
                    Integer quantity = sc.nextInt();
                    itemList.add(new Item(name, price, quantity));

                    returnTo();
                    break;
                }

                case 2 -> {
                    Item i = new Item();
                    System.out.println(i.listItem(itemList));
                    returnTo();
                    break;
                }

                case 3 -> {
                    String outPath = "B:\\out\\summary.csv";

                    boolean success = new File("B:\\out").mkdir();
                    System.out.println("Directory created sucessfully: " + success);

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(outPath))) {

                        bw.write(Item.listItemForCsv(itemList));

                        System.out.println(".csv file created sucessfully!");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                        sc.close();
                    }
                }

                case 4 -> {
                    System.out.println("Thank you!");
                    sc.close();
                    break;
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
            sc.close();
        }

    }

    public static void returnTo() {
        System.out.println("\n\nReturn to menu? [Y]Yes [N]No");
        char choice = sc.next().charAt(0);
        Character.toLowerCase(choice);
        if (choice == 'y') {
            menu();
        } else {
            System.out.println("Thank you!");
            sc.close();
        }
    }
}
