package com.techelevator.application;


import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class FinishTransaction
{
    private Scanner scanner = new Scanner(System.in);
    private Balance balance;
    private Logger logger;
    private double currentBalance;
    private UserOutput userOutput = new UserOutput();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_LIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public FinishTransaction()
    {
        this.balance = new Balance();
        this.logger = new Logger();

    }

    public void completeTransaction() {
        currentBalance = balance.getCurrentBalance();
        BigDecimal currentBalanceBd = new BigDecimal(Double.toString(currentBalance));
        currentBalanceBd = currentBalanceBd.setScale(2, RoundingMode.HALF_UP);

        if(currentBalanceBd.equals(new BigDecimal("0.00")))
        {
            System.out.println("        Your total remaining balance is: " + "$" +
                    ANSI_RED + currentBalanceBd + ANSI_RESET);
        }
        else
        {
            System.out.println("        Your total remaining balance is: " + "$" +
                    ANSI_GREEN + currentBalanceBd + ANSI_RESET);
        }

        System.out.println("Are you sure you would like to finish this transaction? [Y/N]");
        String userInput = scanner.nextLine();
        if(userInput.equalsIgnoreCase("Y"))
        {
            //log onto audit
            String changeGiven = "CHANGE GIVEN :";
            String changeGivenFormatted = String.format("%-15s", changeGiven);
            String balanceString = Double.toString(currentBalance);
            BigDecimal balanceStringBd = new BigDecimal(balanceString);
            balanceStringBd = balanceStringBd.setScale(2, RoundingMode.HALF_UP);
            String loggerWrite = changeGivenFormatted + "$" + balanceStringBd + "   $0.00";
            Logger.write(loggerWrite);

            //give the user their change
            System.out.println("                                   Here is your change: ");
            String balanceStringBd1 = balanceStringBd.toString();
            double currentChange = Double.parseDouble(balanceStringBd1);
            int currentChange100 = (int)(currentChange * 100);
            returnChange(currentChange100);
            userOutput.exitDisplay();
        }
        else if(userInput.equalsIgnoreCase("N"))
        {
            UserOutput.displayHomeScreen();
        }
    }

    public void returnChange(int change) {
        int dollars = 0;
        int quarters = 0;
        int nickels = 0;
        int dimes = 0;
        int pennies = 0;
        int remainingQtrs = 0;
        int remainingDimes = 0;
        int remainingNickels = 0;
        int remainingPennies = 0;

        if (change >= 100) {
            dollars = change / 100;
            remainingQtrs = change % 100;
            quarters = remainingQtrs / 25;
            remainingDimes = remainingQtrs % 25;
            dimes = remainingDimes / 10;
            remainingNickels = remainingDimes % 10;
            nickels = remainingNickels / 5;
            remainingPennies = remainingNickels % 5;
            pennies = remainingPennies;
        } else {
            quarters = change / 25;
            remainingDimes = change % 25;
            dimes = remainingDimes / 10;
            remainingNickels = remainingDimes % 10;
            nickels = remainingNickels / 5;
            remainingPennies = remainingNickels % 5;
            pennies = remainingPennies;

        }
        System.out.println("     Your change is as follows: " +
                ANSI_PURPLE + dollars + ANSI_RESET + " dollars, " +
                ANSI_LIGHT_YELLOW + quarters + ANSI_RESET + " quarters, " +
                ANSI_BLUE + dimes + ANSI_RESET + " dimes, " +
                ANSI_GREEN + nickels + ANSI_RESET + " nickels, and  " +
                ANSI_CYAN + pennies + ANSI_RESET + " pennies.");
    }


//    while(true)
//    {
//        System.out.println("Your total remaining balance is: " + currentBalance);
//        System.out.println("Are you sure you would like to finish this transaction? [Y/N]");
//        String userInput = scanner.nextLine();
//        if(userInput.equalsIgnoreCase("Y"))
//        {
////        UserOutput.displayFinishTransaction(currentBalance);
//        }
//        else if(userInput.equalsIgnoreCase("N"))
//        {
//
//        }
//
//    }

}