package br.com.aplication;

import br.com.entities.Employee;
import java.util.Scanner;

public class Startup {

    public static void main(String[] args) {
info();
    }

    public static void info() {
        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.println("Please enter the employee data: ");
        System.out.println("Name: ");
        employee.setName(sc.nextLine());
        System.out.println("Gross salary (U$): ");
        employee.setGrossSalary(sc.nextDouble());
        System.out.println("Tax (U$): ");
        employee.setTax(sc.nextDouble());
        System.out.println(employee);
        System.out.println("\n\nWhich percentage to increase salary? ");
        employee.increaseSalary(sc.nextDouble());
        System.out.println("Updated!");
        System.out.println(employee);
        sc.close();
    }
}
