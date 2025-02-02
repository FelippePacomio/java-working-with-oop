package br.com.application;

import br.com.model.entities.Contract;
import br.com.model.entities.Installment;
import br.com.model.services.ContractService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Date;

public class Program {

    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        try {
            System.out.print("\n|-------------    WELCOME      ------------|");
            System.out.print("\n|Enter contract data                       |");
            System.out.print("\n|Contract number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("|Date (dd/MM/yyyy): ");
            LocalDateTime date = LocalDate.parse(sc.next(), fmt).atStartOfDay();
            System.out.print("|Contract value $: ");
            double totalValue = sc.nextDouble();
            System.out.print("|Total installments: ");
            int amount = sc.nextInt();
            System.out.println("\n|--ALL INSTALLMENTS--|");
            Contract contract = new Contract(number, date, totalValue, new Installment(date, amount));
            ContractService service = new ContractService();
            service.processContract(contract, amount);
            sc.close();

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

}
