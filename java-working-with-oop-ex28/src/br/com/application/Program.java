package br.com.application;

import br.com.entities.CarRental;
import br.com.entities.Vehicle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        menu();

    }

    public static void menu() {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Enter rent data");
        System.out.print("Car model: ");
        String model = sc.nextLine();
        System.out.println("Rent start date: ");
        LocalDateTime start = LocalDateTime.parse(sc.next(), fmt);
        System.out.println("Rent finish date: ");
        LocalDateTime finish = LocalDateTime.parse(sc.next(), fmt);
        
        CarRental cr = new CarRental(start, finish, new Vehicle(model));
    }

}
