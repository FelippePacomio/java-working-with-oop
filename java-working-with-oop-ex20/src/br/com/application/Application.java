package br.com.application;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import br.com.model.entities.Reservation;
import br.com.model.exceptions.DomainExceptions;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {

    static Scanner sc = new Scanner(System.in);
    
    static List<Reservation> reservationList = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
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

    public static void runApplication(int selection) {
        try {
            switch (selection) {
                case 1 -> {
                    System.out.print("\n|Enter room number: ");
                    int roomNumber = sc.nextInt();
                    System.out.print("\n|Enter Check-in date: ");
                    Date checkIn = sdf.parse(sc.next());
                    System.out.print("\n|Enter Check-out date: ");
                    Date checkOut = sdf.parse(sc.next());

                    reservationList.add(new Reservation(roomNumber, checkIn, checkOut));

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
                    r.updateDates(reservationList, roomNumber, newCheckIn, newCheckOut);
                    System.out.println("Reservation updated successfully");

                    returnTo();
                    break;
                }

                case 4 -> {
                    System.out.println("Thank you!");
                }

            }
        } catch (ParseException e) {
            System.out.println("Invalid date format!");
        } catch (DomainExceptions e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

    }

    public static void returnTo() {
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
