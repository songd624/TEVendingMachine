package com.techelevator.application;

import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class FeedMoney {
    private Scanner scanner = new Scanner(System.in);
    private Balance balance;
    private Logger logger;

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";


    public FeedMoney () {
        this.balance = new Balance();
        this.logger = new Logger();

    }


    public void feedMoney(){
        BigDecimal currentBalanceBd = new BigDecimal(Double.toString(balance.getCurrentBalance()));
        BigDecimal currentBalanceBdRound = currentBalanceBd.setScale(2, RoundingMode.HALF_UP);

        if(currentBalanceBdRound.equals(new BigDecimal("0.00")))
        {
            System.out.println("        Current Money Provided: " + "$" +
                    ANSI_RED + currentBalanceBdRound + ANSI_RESET);
        }
        else
        {
            System.out.println("            Current Money Provided: " + "$" +
                    ANSI_GREEN + currentBalanceBdRound + ANSI_RESET);
        }

        System.out.println("   How much money you would like add to your balance...");
        System.out.println("                  " + ANSI_GREEN + "$1" + ANSI_RESET
                                            + ", " + ANSI_GREEN + "$5" + ANSI_RESET
                                            + ", " + ANSI_GREEN + "$10" + ANSI_RESET
                                            + ", or "  + ANSI_GREEN + "$20" + ANSI_RESET );
        System.out.println( "Enter the numerical value (" + ANSI_GREEN + "1" + ANSI_RESET + "), ("
                + ANSI_GREEN + "5" + ANSI_RESET + "), ("
                + ANSI_GREEN + "10" + ANSI_RESET + "), or ("
                + ANSI_GREEN + "20" + ANSI_RESET + ")");
        System.out.println("        Enter '" + ANSI_CYAN + "menu" + ANSI_RESET +
                "' to return to the " + ANSI_CYAN + "Main Menu" + ANSI_RESET);



        String moneyChoice = scanner.nextLine();
        while(!moneyChoice.equalsIgnoreCase("menu") && !moneyChoice.equals("1")
                && !moneyChoice.equals("5") && !moneyChoice.equals("10")
                && !moneyChoice.equals("20")) {
            System.out.println("Please input (" + ANSI_GREEN + "1" + ANSI_RESET
                    + "), (" + ANSI_GREEN + "5" + ANSI_RESET
                    + "), (" + ANSI_GREEN + "10" + ANSI_RESET + "), ("
                    + ANSI_GREEN + "20" + ANSI_RESET + ")), or '"
                    + ANSI_CYAN + "menu" + ANSI_RESET +"'");
            moneyChoice = scanner.nextLine();
        }
        if (moneyChoice.equalsIgnoreCase("menu")) {
            balance.setCurrentBalance(balance.getCurrentBalance());
            UserOutput.displayHomeScreen();
        } else {
            double choiceDouble = (Integer.parseInt(moneyChoice));
            double addToBalance = balance.getCurrentBalance() + choiceDouble;

            balance.setCurrentBalance(addToBalance);
            BigDecimal balanceBd = new BigDecimal(Double.toString(balance.getCurrentBalance()));
            BigDecimal balanceBdRound = balanceBd.setScale(2, RoundingMode.HALF_UP);
            String moneyFedStr = String.format("%-15s", "MONEY FED: ");
            BigDecimal choiceDoubleBd = new BigDecimal((Double.toString(choiceDouble)));
            BigDecimal choiceDoubleBdRound = choiceDoubleBd.setScale(2, RoundingMode.HALF_UP);
            String balanceBdRoundStr = String.format("%8s", balanceBdRound);
            String loggerWrite = moneyFedStr + choiceDoubleBdRound + balanceBdRoundStr;
            this.logger.write(loggerWrite);

            feedMoney();
        }
    }
}
