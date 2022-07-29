package com.techelevator.application;

import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class FeedMoney {
    private Scanner scanner = new Scanner(System.in);
    private Balance balance;
    private Logger logger;

    public FeedMoney () {
        this.balance = new Balance();
        this.logger = new Logger();
    }


    public void feedMoney(){
        double currentBalance = balance.getBalance();
        BigDecimal currentBalanceBd = new BigDecimal(Double.toString(currentBalance));
        BigDecimal currentBalanceBdRound = currentBalanceBd.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Current Money Provided: " + "$" + currentBalanceBdRound);
        System.out.println("Please input how much money you would like add to your balance");
        System.out.println("$1, $5, $10, or $20. Only enter the numerical value");
        System.out.println("Input menu to go back to the main menu");

        String moneyChoice = scanner.nextLine();
        while(!moneyChoice.equalsIgnoreCase("menu") && !moneyChoice.equals("1")
                && !moneyChoice.equals("5") && !moneyChoice.equals("10")
                && !moneyChoice.equals("20")) {
            System.out.println("Please input 1, 5, 10, 20, or menu");
            moneyChoice = scanner.nextLine();
        }
        if (moneyChoice.equalsIgnoreCase("menu")) {
            UserOutput.displayHomeScreen();
        } else {
            double choiceDouble = (Integer.parseInt(moneyChoice));
            balance.setBalance(currentBalance + choiceDouble);
            BigDecimal balanceBd = new BigDecimal(Double.toString(balance.getBalance()));
            BigDecimal balanceBdRound = balanceBd.setScale(2, RoundingMode.HALF_UP);
            String moneyFedStr = String.format("%-15s", "MONEY FED: ");
            BigDecimal choiceDoubleBd = new BigDecimal((Double.toString(choiceDouble)));
            BigDecimal choiceDoubleBdRound = choiceDoubleBd.setScale(2, RoundingMode.HALF_UP);
            String balanceBdRoundStr = String.format("%5s", balanceBdRound);
            String loggerWrite = moneyFedStr + choiceDoubleBdRound + balanceBdRoundStr;
            this.logger.write(loggerWrite);
            feedMoney();
        }
    }
}
