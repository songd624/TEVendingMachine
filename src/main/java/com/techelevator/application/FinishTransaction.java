package com.techelevator.application;


import com.techelevator.ui.UserOutput;

import java.util.Scanner;

public class FinishTransaction
{
    private Scanner scanner = new Scanner(System.in);
    private Balance balance;
    private Logger logger;
    private double currentBalance;

    public FinishTransaction()
    {
        this.balance = new Balance();
        this.logger = new Logger();

    }

    public void completeTransaction() {
        currentBalance = balance.getCurrentBalance();
        System.out.println("Your total remaining balance is: " + currentBalance);
        System.out.println("Are you sure you would like to finish this transaction? [Y/N]");
        String userInput = scanner.nextLine();
        if(userInput.equalsIgnoreCase("Y"))
        {
            //give the user their change
            System.out.println("Here is your change: ");
            int currentChange = (int)(balance.getCurrentBalance() * 100);
            returnChange(currentChange);
            //log onto audit
            String changeGiven = "CHANGE GIVEN :";
            String changeGivenFormatted = String.format("%-15s", changeGiven);
            String balanceString = Double.toString(currentBalance);
            String loggerWrite = changeGivenFormatted + "$" + balanceString + "   $0.00";

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
        } else {
            quarters = change / 25;

        }
        remainingDimes = remainingQtrs % 25;
        dimes = remainingDimes / 10;
        remainingNickels = remainingDimes % 10;
        nickels = remainingNickels / 5;
        remainingPennies = remainingNickels % 5;
        pennies = remainingPennies;
        System.out.println("Your change is as follows: " +
                dollars + " dollars, " + quarters + " quarters, "
                + dimes + " dimes, " + nickels + " nickels, and  " + pennies
                + " pennies.");


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