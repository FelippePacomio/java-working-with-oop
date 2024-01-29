package br.com.application;

import br.com.entities.Department;
import br.com.entities.HourContract;
import br.com.entities.Worker;
import br.com.entities.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    static Scanner sc;
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        worker();
    }


    public static void worker() throws ParseException {
        sc = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.print("|------------------------------------|\n");
        System.out.print("|Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.print("|--------- Enter worker data ---------|\n");
        System.out.print("|Name: ");
        String workerName = sc.nextLine();
        System.out.print("|Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("|Base Salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
        System.out.print("|How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("|Enter contract #" + i + " data: ");
            System.out.print("|Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("|Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("|Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
            System.out.print("|--------- Contract #" + i + " added! ---------|\n\n");
        }
        
        System.out.print("\n\n|Enter month and year to calculte income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("|Name: " + worker.getName());
        System.out.println("|Department: " + worker.getDepartment().getName());
        System.out.println("|Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
