package br.com.entities;

public abstract class Pessoa {

    private String name;
    private double anualIncome;

    public Pessoa() {
    }

    public Pessoa(String name, double anualIncome) {
        this.name = name;
        this.anualIncome = anualIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAnualIncome() {
        return anualIncome;
    }

    public void setAnualIncome(double anualIncome) {
        this.anualIncome = anualIncome;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(name);
        sb.append(":  $");
        sb.append(" ");
        return sb.toString();
    }

    public abstract double taxAmount(); 

}
