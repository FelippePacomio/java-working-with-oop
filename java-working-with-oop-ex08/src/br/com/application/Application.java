package br.com.application;

import br.com.entities.Student;
import java.util.Scanner;

public class Application {

    static Scanner sc;
    static String[] room = new String[10];
    static Student[] student;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        sc = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.print("\n|===========    RENT A ROOM    ===========|");
        System.out.print("\n|Option 01 - Rent a room                  |");
        System.out.print("\n|Option 02 - View busy rooms              |");
        System.out.print("\n|Option 03 - View all rooms               |");
        System.out.print("\n\nPlease, choose an option: ");
        int selection = sc.nextInt();
        rentRooms(selection);
    }

    public static void rentRooms(int selection) {
        switch (selection) {

            case 1 -> {
                System.out.println("\nHow many rooms will be rented? ");
                int quantity = sc.nextInt();
                student = new Student[quantity];
                for (int i = 0; i < student.length; i++) {
                    System.out.printf("\nRent #%d:", i + 1);
                    System.out.print("\nName: ");
                    String name = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    System.out.print("Room: ");
                    int roomNumber = sc.nextInt();

                    if (room[roomNumber] == null) {
                        student[i] = new Student(name, email, roomNumber);
                        room[student[i].getRoom()] = "Room: " + student[i].getRoom() + ", " + student[i].getName() + ", " + student[i].getEmail();
                        System.out.println("\nSuccess!");
                    } else {
                        System.out.println("Sorry, this room has already been rented!");
                        returnTo();
                    }

                }
                returnTo();
            }

            case 2 -> {
                System.out.println("Busy Rooms:");
                for (int i = 0; i < room.length; i++) {
                    if (room[i] != null) {
                        System.out.println(room[i]);
                    }
                }
                returnTo();
            }

            case 3 -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(room[i]);
                }
                returnTo();

            }
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
