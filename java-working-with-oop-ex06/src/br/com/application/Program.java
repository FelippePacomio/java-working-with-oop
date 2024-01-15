package br.com.application;

import br.com.entities.Client;
import java.util.Scanner;

public class Program {

    static Client client;
    static Scanner sc;

    public static void main(String[] args) {
        createAccount(client);
    }

    public static void createAccount(Client client) {
        sc = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("\nEnter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("\nEnter account holder: ");
        String ownerName = sc.nextLine();
        System.out.println("\nIs there a initial deposit (y/n)? ");
        String choice = sc.nextLine();
        IsDeposit(accountNumber, ownerName, choice, client);
    }

    public static void updateAccount(Client client) {
        System.out.println("\nAccount data: ");
        System.out.println(client);
        System.out.println("\n\nEnter a deposit value U$: ");
        client.deposit(sc.nextDouble());
        System.out.println("\n - Updated account data - : ");
        System.out.println(client);
        System.out.println("\n\nEnter a withdraw value U$: ");
        client.withdraw(sc.nextDouble());
        System.out.println("\n - Updated account data - : ");
        System.out.println(client);
    }

    public static void IsDeposit(int accountNumber, String ownerName, String choice, Client client) {
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("\nEnter initial deposit value U$: ");
            double amount = sc.nextDouble();
            client = new Client(accountNumber, ownerName, amount);
            client.setAccountNumber(accountNumber);
            client.setOwnerName(ownerName);
            client.deposit(amount);
            updateAccount(client);
        } else {
            client = new Client(accountNumber, ownerName);
            client.setAccountNumber(accountNumber);
            client.setOwnerName(ownerName);
            updateAccount(client);
        }
    }
}
