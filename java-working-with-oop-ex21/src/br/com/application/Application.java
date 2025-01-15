package br.com.application;

import br.com.model.entities.Account;
import br.com.model.exceptions.DomainException;
import java.util.Scanner;

public class Application {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws DomainException {
        try{
        System.out.print("Enter account data: ");
        System.out.print("\nNumber: ");
        Integer number = sc.nextInt();
        System.out.print("Holder: ");
        sc.next();
        String holder = sc.next();
        System.out.print("Initial balance: ");
        Double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        Double withdrawLimit = sc.nextDouble();
        Account acc = new Account(number, holder, balance, withdrawLimit);
        
        System.out.println("Enter amount for withdraw: ");
        Double amount = sc.nextDouble();
        System.out.println("New balance: " + acc.withdraw(amount));
        } catch (DomainException e){
            System.out.println(e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
    }
}
