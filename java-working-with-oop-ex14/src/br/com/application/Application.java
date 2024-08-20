package br.com.application;

import br.com.entities.Client;
import br.com.entities.Order;
import br.com.entities.OrderItem;
import br.com.entities.Product;
import br.com.entities.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static Scanner sc;
    static Instant d03 = Instant.now();

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        application();
    }

    public static void application() throws ParseException {
        sc = new Scanner(System.in);
        System.out.println("|------ Enter client data ------|\n");
        System.out.print("|Name: ");
        String name = sc.nextLine();
        System.out.print("|Email: ");
        String email = sc.next();
        System.out.print("|Birth Date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        System.out.println("\n|------ Enter order data ------|\n");
        Date moment = Date.from(d03);
        System.out.print("|Status: ");
        String status = sc.next();
        Order order = new Order(moment, OrderStatus.valueOf(status), new Client(name, email, birthDate));
        System.out.print("How many items to this order? ");
        int quantity = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= quantity; i++) {
            System.out.println("\n|------ Enter #" + i + " item data ------|\n");
            System.out.print("|Product name: ");
            String productName = sc.nextLine();
            System.out.print("|Product price: ");
            Double productPrice = sc.nextDouble();
            System.out.print("|Quantity: ");
            Integer quant = sc.nextInt();
            sc.nextLine();
            OrderItem orderItem = new OrderItem(quant, productPrice, new Product(productName, productPrice));
            order.addItem(orderItem);
            System.out.print("|--------- Order #" + i + " added! ---------|\n\n");
        }
        System.out.println(order);

    }

}
