package br.com.entities;

public class ImportedProduct extends Product {

    private Double customFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, Double price, Double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    public Double getCustomFee() {
        return customFee;
    }

    public void setCustomFee(Double customFee) {
        this.customFee = customFee;
    }

    public Double totalPrice() {
        return price += customFee;
    }

    @Override
    public String priceTag() {
        return "(Custom fee: $" + customFee + ")";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("  $");
        sb.append(totalPrice());
        sb.append(" ");
        sb.append(priceTag());
        return sb.toString();
    }

}
