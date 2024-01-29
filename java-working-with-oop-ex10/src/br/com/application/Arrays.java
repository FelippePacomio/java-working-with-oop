package br.com.application;

import java.util.Scanner;

public class Arrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.print("\n\nEnter the quantity of row of the array: ");
        int row = sc.nextInt();
        System.out.print("\n\nEnter the quantity of columns of the array: ");
        int column = sc.nextInt();

        int[][] mat = new int[row][column];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print("\nEnter a integer number at position " + i + ", " + j + ": ");
                mat[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (j == 0) {
                    System.out.print("\n" + mat[i][j] + " ");
                } else {
                    System.out.print(mat[i][j] + " ");
                }
            }
        }
        System.out.print("\nEnter a number to discover the position: ");
        int num = sc.nextInt();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == num) {
                    System.out.print("\nNumber position: " + i + ", " + j);

                    if (j > 0) {
                        System.out.printf("Left: %d%n", mat[i][j - 1]);
                    }
                    if (j < column - 1) {
                        System.out.printf("\nRight: %d%n", mat[i][j + 1]);
                    }
                    if (i > 0) {
                        System.out.printf("Up: %d%n", mat[i - 1][j]);
                    }
                    if (i < row - 1) {
                        System.out.printf("Down: %d%n", mat[i + 1][j]);
                    }

                }

            }

        }
    }

}
