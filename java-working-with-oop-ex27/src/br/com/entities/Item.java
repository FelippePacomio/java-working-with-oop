package br.com.entities;

import java.util.List;

public class Item {

    private String name;
    private Double price;
    private Integer quantity;

    public Item() {
    }

    public Item(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String listItem(List<Item> itemList) {
        StringBuilder sb = new StringBuilder();
        for (Item i : itemList) {
            sb.append("\n");
            sb.append(i.getName());
            sb.append(",");
            sb.append(i.getPrice());
            sb.append(",");
            sb.append(i.getQuantity());
        }
        return sb.toString();
    }

    public static String listItemForCsv(List<Item> itemList) {
        StringBuilder sb = new StringBuilder();
        for (Item i : itemList) {
            sb.append("\n");
            sb.append(i.getName());
            sb.append(",");
            sb.append(calculateTotal(i.getQuantity(), i.getPrice()));
        }
        return sb.toString();
    }

    public static Double calculateTotal(Integer quantity, Double price) {
        return quantity * price;
    }

}
