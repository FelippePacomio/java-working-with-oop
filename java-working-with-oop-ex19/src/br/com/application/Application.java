package br.com.application;

import br.com.entities.Pessoa;
import br.com.entities.PessoaFisica;
import br.com.entities.PessoaJuridica;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    static List<Pessoa> pessoaList = new ArrayList();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        run();
    }

    public static void run() {

        System.out.print("Enter the number of tax payers: ");
        int quantity = sc.nextInt();

        for (int i = 1; i <= quantity; i++) {
            System.out.println("\nTax payer #" + i + " data:");
            System.out.print("\nIndividual or company? [I] [C]: ");
            Character selection;
            Character.toLowerCase(selection = sc.next().charAt(0));
            sc.nextLine();

            if (selection == 'i') {
                System.out.print("\nName: ");
                String name = sc.nextLine();
                System.out.print("\nAnual income: ");
                double anualIncome = sc.nextDouble();
                System.out.print("\nHealth expenditure: ");
                double medicalExpenditure = sc.nextDouble();
                pessoaList.add(new PessoaFisica(name, anualIncome, medicalExpenditure));
                System.out.println("\nTax payer #" + i + " added!");
            } else if (selection == 'c') {
                System.out.print("\nName: ");
                String name = sc.nextLine();
                System.out.print("\nAnual income: ");
                double anualIncome = sc.nextDouble();
                System.out.print("\nTotal employees: ");
                int numberOfEmployees = sc.nextInt();
                pessoaList.add(new PessoaJuridica(name, anualIncome, numberOfEmployees));
                System.out.println("\nTax payer #" + i + " added!");
            } else {
                sc.close();
            }
        }
        System.out.println("\n\n|---- Taxes Paid ----|");
        for (Pessoa p : pessoaList) {
            System.out.println(p);
        }

    }

    public static void returnTo() {
        System.out.println("\n\nReturn to menu? [Y]Yes [N]No");
        char choice = sc.next().charAt(0);
        Character.toLowerCase(choice);
        if (choice == 'y') {
            run();
        } else {
            System.out.println("Thank you!");
            sc.close();
        }
    }

}
