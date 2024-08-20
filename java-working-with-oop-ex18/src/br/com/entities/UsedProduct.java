package br.com.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

    private Date manufactureDate;

    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "(Manufacture date: " + formatter.format(manufactureDate) + ")";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" (used)");
        sb.append("  $");
        sb.append(price);
        sb.append(" ");
        sb.append(priceTag());
        return sb.toString();
    }

}
