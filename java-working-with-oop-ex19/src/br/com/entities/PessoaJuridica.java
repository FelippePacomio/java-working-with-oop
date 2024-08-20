package br.com.entities;

public class PessoaJuridica extends Pessoa {

    private int numberOfEmployees;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String name, double anualIncome, int numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public double taxAmount() {
        double tax = 0.0;
        if (numberOfEmployees <= 10) {
            tax = super.getAnualIncome() * 0.16;
        } else if (numberOfEmployees > 10) {
            {
                tax = tax = super.getAnualIncome() * 0.14;
            }

        }
        return tax;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(super.getName());
        sb.append(":  $");
        sb.append(taxAmount());
        return sb.toString();
    }
}
