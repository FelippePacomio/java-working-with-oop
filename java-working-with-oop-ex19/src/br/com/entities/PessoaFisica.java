package br.com.entities;

public class PessoaFisica extends Pessoa {

    private double medicalExpenditure;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String name, double anualIncome, double medicalExpenditure) {
        super(name, anualIncome);
        this.medicalExpenditure = medicalExpenditure;
    }

    public double getMedicalExpenditure() {
        return medicalExpenditure;
    }

    public void setMedicalExpenditure(double medicalExpenditure) {
        this.medicalExpenditure = medicalExpenditure;
    }

    public double taxAmount() {
        double tax = 0.0;
        if (super.getAnualIncome() < 20000.00 && medicalExpenditure > 0.0) {
            tax = super.getAnualIncome() * 0.15 - (medicalExpenditure * 0.5);
        } else if (super.getAnualIncome() < 20000.00 && medicalExpenditure <= 0.0) {
            tax = super.getAnualIncome() * 0.15;
        } else if (super.getAnualIncome() >= 20000.00 && medicalExpenditure > 0.0) {
            tax = super.getAnualIncome() * 0.25 - (medicalExpenditure * 0.5);
        } else if (super.getAnualIncome() >= 20000.00 && medicalExpenditure <= 0.0) {
            tax = super.getAnualIncome() * 0.25;
        }
        return tax;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(super.getName());
        sb.append(":  $");
        sb.append(taxAmount());
        return sb.toString();
    }
}
