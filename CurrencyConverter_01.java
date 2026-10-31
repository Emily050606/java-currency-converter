/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package currencyconverter_01;

import java.util.Scanner;

public class CurrencyConverter_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amount = 0;
        double exchangeRate = 0;
        double finalExchange;
        double adminFee;
        double totalAmount;

        // Get Currency Type
        String currencyType = "";
        do {
            System.out.print("Please Enter Currency Type: ");
            currencyType = scanner.nextLine().toUpperCase();
        if (!currencyType.matches("[A-Z]{3}")) {
                System.out.println("Invalid input! Please enter a 3-letter alphabetic currency type!");
            }
        } while (!currencyType.matches("[A-Z]{3}"));

        // Get Exchange Amount
        do {
            System.out.print("Please Enter the exchange amount: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                if (amount <= 0) {
                    System.out.println("Invalid input. Please enter a positive number for the amount.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number for the amount.");
                scanner.nextLine(); // consume invalid input
            }
        } while (amount <= 0);

        // Get Exchange Rate
        do {
            System.out.print("Please enter exchange rate to MYR: ");
            if (scanner.hasNextDouble()) {
                exchangeRate = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                if (exchangeRate <= 0) {
                    System.out.println("Invalid input. Please enter a number greater than 0 for the exchange rate.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number for the exchange rate.");
                scanner.nextLine(); // consume invalid input
            }
        } while (exchangeRate <= 0);

        // Calculate Final Exchange and Admin Fee
        finalExchange = amount * exchangeRate;
        if (finalExchange <= 2000) {
            adminFee = finalExchange * 0.0025;
        } else if (finalExchange <= 5000) {
            adminFee = finalExchange * 0.0050;
        } else if (finalExchange <= 10000) {
            adminFee = finalExchange * 0.0075;
        } else {
            adminFee = finalExchange * 0.01;
        }

        // Display Final Result
        totalAmount = finalExchange - adminFee;
        System.out.println("=======================================");
        System.out.println("Currency Type: " + currencyType + " --> MYR");
        System.out.println("Exchange Amount: " + amount);
        System.out.println("Exchange Rate (MYR): " + exchangeRate);
        System.out.printf("Exchange Result (MYR): %.2f\n", finalExchange);
        System.out.printf("Admin Fee: %.2f\n", adminFee);
        System.out.printf("Total Amount (MYR): %.2f\n", totalAmount);
        System.out.println("=======================================");

        scanner.close();
    }
}
