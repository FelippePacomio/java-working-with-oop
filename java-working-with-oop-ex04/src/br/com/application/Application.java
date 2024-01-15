package br.com.application;

import br.com.util.CurrencyConverter;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total amount that you want to convert R$: ");
        double real = sc.nextDouble();

        System.out.printf("\n\nOriginal value R$: %.2f%n", real);
        System.out.printf("\nTax R$: %.2f%n", CurrencyConverter.TAX * real);
        System.out.printf("\nTotal in Dolar U$: %.2f%n", CurrencyConverter.exchangeTax(real));
        sc.close();
    }

}
