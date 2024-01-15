package br.com.util;

public class CurrencyConverter {

    public static final double DOLAR = 4.86;
    public static final double TAX = 0.06;

    public static double exchangeTax(double real) {
        return (real - real * TAX) / DOLAR;
    }
}
