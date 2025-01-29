package br.com.application;

import br.com.model.entities.Contract;
import br.com.model.entities.Installment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Date;

public class Program {

    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {
        menu();
    }

    public static void menu() throws ParseException {
        try {
            System.out.print("\n|-------------    WELCOME      ------------|");
            System.out.print("\n|Enter contract data                       |");
            System.out.print("\n|Contract number: ");
            int number = sc.nextInt();
            System.out.print("\n|Date (dd/MM/yyyy): ");
            Date date = sdf.parse(sc.nextLine());
            System.out.print("\n|Contract value $: ");
            double totalValue = sc.nextDouble();
            System.out.print("\n|Total installments: ");
            double amount = sc.nextDouble();
            Contract contract = new Contract(number, date, totalValue, new Installment(date, amount));

        } catch (ParseException e) {
            System.out.println("Invalid date format!");
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
    }

    public static void runApplication(int selection) {
    }

}
