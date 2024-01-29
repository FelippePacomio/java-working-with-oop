package br.com.application;

import br.com.entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    static Employee e;
    static Scanner sc;
    static List<Employee> list = new ArrayList<>();

    public static void main(String[] args) {
        welcome();
    }

    public static void welcome() {
        sc = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("|---------- Employee Registration ----------|");
        System.out.println("|Option 01 - Add an employee                |");
        System.out.println("|Option 02 - View all employees             |");
        System.out.println("|Option 03 - Increase employee salary       |");
        System.out.println("|Option 09 - Exit                           |");
        System.out.println("|-------------------------------------------|");
        System.out.println("\n\nPlease, enter an option: ");
        int selection = sc.nextInt();
        promotion(selection);
    }

    public static void promotion(int selection) {

        switch (selection) {
            case 1 -> {
                System.out.print("How many employees will be registered? ");
                int quantity = sc.nextInt();

                for (int i = 0; i < quantity; i++) {

                    System.out.printf("\nEmployee #%d", i + 1);
                    System.out.print("\nId: ");
                    int id = sc.nextInt();
                    int index = idPosition(list, id);
                    if (index == -1) {
                        System.out.print("Name: ");
                        String name = sc.next();
                        System.out.print("Salary (U$): ");
                        double salary = sc.nextDouble();
                        e = new Employee(id, salary, name);

                        list.add(e);

                        System.out.println("\nEmployee added!");
                    } else {
                        System.out.println("\nThis Id already exists!");
                        returnTo();
                    }
                }
                returnTo();
                break;
            }

            case 2 -> {
                System.out.println("\nList of Employees: ");
                for (Employee e : list) {
                    System.out.println(e);
                }
                returnTo();
                break;
            }

            case 3 -> {
                System.out.println("Enter the employee id that will have salary increase: ");
                int id = sc.nextInt();
                int index = idPosition(list, id);
                if (index == -1) {
                    System.out.println("This Id does not exist!");
                    returnTo();
                } else {
                    System.out.println("Enter the percentage: ");
                    double percentage = sc.nextDouble();
                    list.get(index).salaryIncrease(percentage);
                }
                returnTo();
                break;
            }

            case 9 -> {
                System.out.println("Thank you!");
                sc.close();
                break;
            }
        }

    }

    public static void returnTo() {
        System.out.println("\n\nReturn to menu? [Y]Yes [N]No");
        char choice = sc.next().charAt(0);
        Character.toLowerCase(choice);
        if (choice == 'y') {
            welcome();
        } else {
            System.out.println("Thank you!");
            sc.close();
        }
    }

    public static int idPosition(List<Employee> list1, int id) {
        for (int i = 0; i < list1.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
