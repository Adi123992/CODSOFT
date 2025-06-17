import java.util.*;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to Simple Currency Converter");

        System.out.println("Available Currencies: INR, USD, EUR, GBP, JPY");

        System.out.print("Enter base currency: ");
        String baseCurrency = s.next().toUpperCase();

        System.out.print("Enter target currency: ");
        String targetCurrency = s.next().toUpperCase();

        double inrRate = 83.2;
        double usdRate = 1.0;
        double eurRate = 0.92;
        double gbpRate = 0.79;
        double jpyRate = 156.95;

        double baseToUsd = 1;
        double usdToTarget = 1;

        if (baseCurrency.equals("INR")) {
            baseToUsd = 1 / inrRate;
        } else if (baseCurrency.equals("USD")) {
            baseToUsd = 1;
        } else if (baseCurrency.equals("EUR")) {
            baseToUsd = 1 / eurRate;
        } else if (baseCurrency.equals("GBP")) {
            baseToUsd = 1 / gbpRate;
        } else if (baseCurrency.equals("JPY")) {
            baseToUsd = 1 / jpyRate;
        } else {
            System.out.println("Invalid base currency.");
            return;
        }

        if (targetCurrency.equals("INR")) {
            usdToTarget = inrRate;
        } else if (targetCurrency.equals("USD")) {
            usdToTarget = 1;
        } else if (targetCurrency.equals("EUR")) {
            usdToTarget = eurRate;
        } else if (targetCurrency.equals("GBP")) {
            usdToTarget = gbpRate;
        } else if (targetCurrency.equals("JPY")) {
            usdToTarget = jpyRate;
        } else {
            System.out.println("Invalid target currency.");
            return;
        }

        System.out.print("Enter amount in " + baseCurrency + ": ");
        double amount = s.nextDouble();

        double result = amount * baseToUsd * usdToTarget;

        System.out.printf("Converted amount: %.2f %s\n", result, targetCurrency);

        s.close();
    }
}

