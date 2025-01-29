package br.com.model.entities;

import java.util.Date;

public class Contract {

    private Integer number;
    private Date date;
    private Double totalValue;
    private Installment installment;

    public Contract(Integer number, Date date, Double totalValue, Installment installment) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
    
    
}
