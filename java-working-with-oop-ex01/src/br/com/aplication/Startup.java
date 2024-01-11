package br.com.aplication;

import br.com.entities.Rectangle;
import java.util.Scanner;

public class Startup {

    public static void main(String[] args) {
        info();
    }

    public static void info() {
        Scanner sc = new Scanner(System.in);
        Rectangle rectangle = new Rectangle();

        System.out.println("Please enter the rectangle width: ");
        rectangle.setWidth(sc.nextDouble());
        System.out.println("Please enter the rectangle height: ");
        rectangle.setHeight(sc.nextDouble());
        System.out.println(rectangle);
        sc.close();
    }
}
