package br.com.model.entities;

import br.com.model.exceptions.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.balance = balance;
        this.holder = holder;
        this.number = number;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public Double deposit(Double deposit) {
        balance += deposit;
        return balance;
    }

    public Double withdraw(Double withdraw) throws DomainException {
        if (withdrawLimit < withdraw) {
            throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
        }
        if (balance < withdraw) {
            throw new DomainException("Withdraw error: Not enough balance");
        }
        balance -= withdraw;
        return balance;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

}
