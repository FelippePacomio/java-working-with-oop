package br.com.entities;

import br.com.entities.enums.OrderStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> orderList = new ArrayList<>();

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem orderItem) {
        orderList.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        orderList.remove(orderItem);
    }

    public double total() {
        double sum = 0.0;
        for (OrderItem i : orderList) {
            sum += i.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
       
        sb.append("|----- ORDER SUMMARY -----|\n\n");
        sb.append("Order Moment: ");
        sb.append(sdf2.format(moment));
        sb.append("\nOrder Status: ");
        sb.append(status);
        sb.append("\nClient: ");
        sb.append(client.getName());
        sb.append(" (");
        sb.append(sdf.format(client.getBirthDate()));
        sb.append(")");
        sb.append(" - ");
        sb.append(client.getEmail());
        sb.append("\nOrder Items: ");
        for (OrderItem i : orderList) {
            sb.append(i.getProduct().getName());
            sb.append(", ");
            sb.append(String.format("%.2f", i.getPrice()));
            sb.append(", ");
            sb.append("Quantity: ");
            sb.append(i.getQuantity());
            sb.append(", ");
            sb.append("Subtotal: $");
            sb.append(String.format("%.2f", i.subTotal()));
            sb.append("\n");
        }

        sb.append("\nTotal price: $");
        sb.append(String.format("%.2f", total()));

        return sb.toString();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
