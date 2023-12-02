package HW08;

import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat;

public class Main {

    static double purshaseAmount;
    static double discount;
    static double amountPay;
    static double amountDiscount;
    final static double STANDARDDISCOUNT = 5;
    final static double AVERAGEDISCOUNT = 10;
    final static double HIGHDISCOUNT = 15;
    final static double MINPURSHASEAMOUNT = 5000;
    final static double MAXPURSHASEAMOUNT = 10000;
    final static String CURRENCY = "USD";

    public static void main(String[] args) {

        purshaseAmount = getData();
        discount = getDiscount(purshaseAmount);
        amountPay = calculatePay(purshaseAmount, discount);
        amountDiscount = calculateDiscount(purshaseAmount, discount);
        getOutput();
    }

    public static double getData() {

        System.out.print("Please, enter the purchase amount: ");
        Scanner salesScanner = new Scanner(System.in);
        salesScanner.useLocale(Locale.ENGLISH);
        return salesScanner.nextDouble();
    }

    public static double getDiscount(double amount) {

        if (amount <= MINPURSHASEAMOUNT) {
            return STANDARDDISCOUNT;
        } else if (amount > MINPURSHASEAMOUNT && purshaseAmount <= MAXPURSHASEAMOUNT) {
            return AVERAGEDISCOUNT;
        } else {
            return HIGHDISCOUNT;
        }
    }

    public static double calculatePay(double amount, double discount) {

        return amount - (amount * discount / 100);
    }

    public static double calculateDiscount(double amount, double discount) {

        return amount * discount / 100;
    }

    public static void getOutput() {

        String roundPurshaseAmount = roundValue(purshaseAmount);
        String roundDiscount = roundValue(discount);
        String roundAmountDiscount = roundValue(amountDiscount);
        String roundAmountPay = roundValue(amountPay);

        System.out.println("Total purchase amount: " + CURRENCY + " " + roundPurshaseAmount +
                "\nYour discount: " + roundDiscount + " %" +
                "\nAmount of discount: " + CURRENCY + " " + roundAmountDiscount +
                "\nThe amount to be paid: " + CURRENCY + " " + roundAmountPay);
    }

    public static String roundValue(double value) {

        return new DecimalFormat("#.00").format(value);
    }
}