package br.com.application;

import br.com.entities.Employee;
import br.com.entities.OutsourcedEmployee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    static Scanner sc;
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        menu();
    }

    public static void menu() {

        System.out.print("\n|-------------      MENU       ------------|");
        System.out.print("\n|Option 01: Insert an employee             |");
        System.out.print("\n|Option 02: View employee list             |");
        System.out.print("\n|Option 03: Exit                           |");
        System.out.print("\n|------------------------------------------|");

        System.out.print("\n|Enter an option: ");
        int selection = sc.nextInt();
        processData(selection);
    }

    public static void processData(int selection) {
        switch (selection) {
            case 1 -> {
                System.out.print("\nEnter the number of employees: ");
                int quantity = sc.nextInt();

                for (int i = 1; i <= quantity; i++) {
                    System.out.println("Employee #" + i + " data:");
                    System.out.print("\nOutsourced? (Y/N): ");
                    char outsourced = sc.next().charAt(0);
                    System.out.print("\nName: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("\nHours: ");
                    Integer hours = sc.nextInt();
                    System.out.print("\nValue per hour: ");
                    Double valuePerHours = sc.nextDouble();
                    if (outsourced == 'y') {
                        System.out.print("\nAdditional charge: ");
                        Double additionalCharge = sc.nextDouble();
                        employeeList.add(new OutsourcedEmployee(name, hours, valuePerHours, additionalCharge));

                    } else {
                        employeeList.add(new Employee(name, hours, valuePerHours));
                    }
                    System.out.println("Employee added!");
                }
                returnTo();
                break;
            }
            case 2 -> {
                Employee e = new Employee();
                e.readList(employeeList);
                returnTo();
                break;
            }
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
