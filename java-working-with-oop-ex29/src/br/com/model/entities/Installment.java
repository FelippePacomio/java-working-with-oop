package br.com.model.entities;

import java.util.Date;

public class Installment {

    private Date dueDate;
    private Double amount;

    public Installment(Date dueDate, Double amount) {
        this.amount = amount;
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    
}
