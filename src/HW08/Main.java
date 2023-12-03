package HW08;

import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat;

public class Main {

    static double purchaseAmount;
    static double discount;
    static double amountPay;
    static double amountDiscount;
    final static double STANDARD_DISCOUNT = 5;
    final static double AVERAGE_DISCOUNT = 10;
    final static double HIGH_DISCOUNT = 15;
    final static double MIN_PURCHASE_AMOUNT = 5000;
    final static double MAX_PURCHASE_AMOUNT = 10000;
    final static String CURRENCY = "USD";

    public static void main(String[] args) {

        purchaseAmount = getData();
        discount = getDiscount(purchaseAmount);
        amountPay = calculatePay(purchaseAmount, discount);
        amountDiscount = calculateDiscount(purchaseAmount, discount);
        getOutput();
    }

    public static double getData() {

        System.out.print("Please, enter the purchase amount: ");
        Scanner salesScanner = new Scanner(System.in);
        salesScanner.useLocale(Locale.ENGLISH);
        return salesScanner.nextDouble();
    }

    public static double getDiscount(double amount) {

        if (amount <= MIN_PURCHASE_AMOUNT) {
            return STANDARD_DISCOUNT;
        } else if (amount > MIN_PURCHASE_AMOUNT && purchaseAmount <= MAX_PURCHASE_AMOUNT) {
            return AVERAGE_DISCOUNT;
        } else {
            return HIGH_DISCOUNT;
        }
    }

    public static double calculatePay(double amount, double discount) {

        return amount - (amount * discount / 100);
    }

    public static double calculateDiscount(double amount, double discount) {

        return amount * discount / 100;
    }

    public static void getOutput() {

        String roundPurchaseAmount = roundValue(purchaseAmount);
        String roundDiscount = roundValue(discount);
        String roundAmountDiscount = roundValue(amountDiscount);
        String roundAmountPay = roundValue(amountPay);

        System.out.println("Total purchase amount: " + CURRENCY + " " + roundPurchaseAmount +
                "\nYour discount: " + roundDiscount + " %" +
                "\nAmount of discount: " + CURRENCY + " " + roundAmountDiscount +
                "\nThe amount to be paid: " + CURRENCY + " " + roundAmountPay);
    }

    public static String roundValue(double value) {

        return new DecimalFormat("#.00").format(value);
    }
}