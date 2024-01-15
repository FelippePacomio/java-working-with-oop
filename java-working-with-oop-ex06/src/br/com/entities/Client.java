package br.com.entities;

public class Client {

    private static final double TAX = 5.00;
    private int accountNumber;
    private String ownerName;
    private double accountBalance;
    private double amount;

    public Client() {
    }

    public Client(int accountNumber, String ownerName, double amount) {

        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public Client(int accountNumber, String ownerName) {

        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double accountTotal() {
        return accountBalance;
    }

    public void deposit(double amount) {
       accountBalance += amount;
    }

    public void withdraw(double amount) {
        accountBalance -= amount;
    }

    @Override
    public String toString() {

        String data = "";
        data += "\nAccount " + accountNumber
                + ", Holder: " + ownerName
                + ", Balance U$: " + String.format("%.2f", accountTotal());


        return data;
    }

}
