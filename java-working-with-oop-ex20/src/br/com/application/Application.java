package br.com.application;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import br.com.model.entities.Reservation;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {

    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static List<Reservation> reservationList = new ArrayList<>();

    public static void main(String[] args) throws ParseException {
        menu();
    }

    public static void menu() throws ParseException {
        System.out.print("\n|-------------    WELCOME      ------------|");
        System.out.print("\n|Option 01: New reservation                |");
        System.out.print("\n|Option 02: View reservation               |");
        System.out.print("\n|Option 03: Update reservation             |");
        System.out.print("\n|Option 04: Exit                           |");
        System.out.print("\n|------------------------------------------|");

        System.out.print("\n|Enter an option: ");
        int selection = sc.nextInt();
        runApplication(selection);
    }

    public static void runApplication(int selection) throws ParseException {
        switch (selection) {
            case 1 -> {
                System.out.print("\n|Enter room number: ");
                int roomNumber = sc.nextInt();
                System.out.print("\n|Enter Check-in date: ");
                Date checkIn = sdf.parse(sc.next());
                System.out.print("\n|Enter Check-out date: ");
                Date checkOut = sdf.parse(sc.next());
                if (Reservation.reservationCheck(checkIn, checkOut)) {
                    reservationList.add(new Reservation(roomNumber, checkIn, checkOut));
                } else {
                    System.out.println("ERROR!");
                }
                returnTo();
                break;
            }

            case 2 -> {
                Reservation r = new Reservation();
                System.out.println(r.listReservation(reservationList));
                returnTo();
                break;
            }

            case 3 -> {

                System.out.print("\n|Enter the room number to update: ");
                int roomNumber = sc.nextInt();

                System.out.print("\n|Enter new Check-in date (dd/MM/yyyy): ");
                Date newCheckIn = sdf.parse(sc.next());
                System.out.print("\n|Enter new Check-out date (dd/MM/yyyy): ");
                Date newCheckOut = sdf.parse(sc.next());
                
                Reservation r = new Reservation();
                String error = r.updateDates(reservationList, roomNumber, newCheckIn, newCheckOut);

                if (error != null) {
                    System.out.println(error);
                    System.out.println("reservation" + r.listReservation(reservationList));
                } else {
                    System.out.println("Reservation updated successfully");
                }
                returnTo();
                break;
            }

            case 4 -> {
                System.out.println("Thank you!");
            }

        }

    }

    public static void returnTo() throws ParseException {
        System.out.println("\n\nReturn to menu? [Y]Yes [N]No");
        char choice = sc.next().charAt(0);
        Character.toLowerCase(choice);
        if (choice == 'y') {
            menu();
        } else {
            System.out.println("Thank you!");
            sc.close();
        }
    }
}
