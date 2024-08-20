package br.com.application;

import br.com.entities.ImportedProduct;
import br.com.entities.Product;
import br.com.entities.UsedProduct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    static ArrayList<Product> productList = new ArrayList();
 
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        info();
    }

    public static void info() throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        int quantity = sc.nextInt();

        for (int i = 1; i <= quantity; i++) {
            System.out.println("\nProduct #" + i + " Data:");
            System.out.print("\nCommon, used or imported? [C] [U] [I]: ");
            Character selection;
            Character.toLowerCase(selection = sc.next().charAt(0));
            sc.nextLine();

            if (selection == 'c') {
                System.out.print("\nName: ");
                String name = sc.nextLine();
                System.out.print("\nPrice ($): ");
                Double price = sc.nextDouble();
                productList.add(new Product(name, price));
            } else if (selection == 'u') {
                System.out.print("\nName: ");
                String name = sc.nextLine();
                System.out.print("\nPrice ($): ");
                Double price = sc.nextDouble();
                System.out.println("\nManufacture date: ");
                Date manufactureDate = formatter.parse(sc.next());
                productList.add(new UsedProduct(name, price, manufactureDate));
            } else if (selection == 'i') {
                System.out.print("\nName: ");
                String name = sc.nextLine();
                System.out.print("\nPrice ($): ");
                Double price = sc.nextDouble();
                System.out.println("\nCustom fee: ");
                Double customFee = sc.nextDouble();
                productList.add(new ImportedProduct(name, price, customFee));
            } else {
                sc.close();
            }

        }
        System.out.println("\n---- PRICE TAGS ----");
        for (Product p : productList) {
            System.out.println(p);
        }
    }
}
