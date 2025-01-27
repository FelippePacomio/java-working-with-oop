package br.com.application;

import br.com.entities.CarRental;
import br.com.entities.Vehicle;
import br.com.services.BrazilTaxService;
import br.com.services.RentalService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Enter rent data");
        System.out.print("Car model: ");
        String model = sc.nextLine();
        System.out.println("Rent start date: ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.println("Rent finish date: ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental cr = new CarRental(start, finish, new Vehicle(model));

        System.out.println("Enter the price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.println("Enter the price per day: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("INVOICE: ");
        System.out.println("Basic Payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total Payment " + String.format("%.2f", cr.getInvoice().getTotalPayment()));

        sc.close();
    }

}
