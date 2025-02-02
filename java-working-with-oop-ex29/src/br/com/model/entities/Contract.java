package br.com.model.entities;

import java.time.LocalDateTime;

public class Contract {

    private Integer number;
    private LocalDateTime date;
    private Double totalValue;
    private Installment installment;

    public Contract(Integer number, LocalDateTime date, Double totalValue, Installment installment) {
        this.date = date;
        this.installment = installment;
        this.number = number;
        this.totalValue = totalValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Installment getInstallment() {
        return installment;
    }

    public void setInstallment(Installment installment) {
        this.installment = installment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(date);
        sb.append(" - ");
        return sb.toString();
    }

}
