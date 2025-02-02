package br.com.model.entities;

import java.time.LocalDateTime;

public class Installment {

    private LocalDateTime dueDate;
    private Integer amount;

    public Installment(LocalDateTime dueDate, Integer amount) {
        this.amount = amount;
        this.dueDate = dueDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    
}
