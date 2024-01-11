package br.com.aplication;

import br.com.entities.Student;
import java.util.Scanner;

public class Startup {

    public static void main(String[] args) {
        info();
    }

    public static void info() {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();

        System.out.println("Please enter the student data: ");
        System.out.println("Name: ");
        student.setName(sc.nextLine());
        System.out.println("First trimester grade: ");
        student.setTrimesterGrade1(sc.nextDouble());
        System.out.println("Second trimester grade: ");
        student.setTrimesterGrade2(sc.nextDouble());
        System.out.println("Last trimester grade: ");
        student.setTrimesterGrade3(sc.nextDouble());
        System.out.println(student);
        sc.close();
    }
}
