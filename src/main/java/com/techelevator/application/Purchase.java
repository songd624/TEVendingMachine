package com.techelevator.application;

import com.techelevator.ui.UserOutput;

import java.util.Scanner;

public class Purchase
{

    private Logger logger;

    private Balance balance;

    private UserOutput output = new UserOutput();
    private Scanner scanner = new Scanner(System.in);

    private double currentBalance;

    public Purchase()
    {
    }


    public double getCurrentBalance()
    {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance)
    {
        this.currentBalance = currentBalance;
    }

    public Purchase(Logger logger, Balance balance)
    {
        this.logger = logger;
        this.balance = balance;
    }


    public void purchaseOptions(String choice)
    {
        if (choice.equalsIgnoreCase("m"))
        {
            feedMoney();
        } else if (choice.equalsIgnoreCase("S"))
        {
            selectionItem();
        } else if (choice.equalsIgnoreCase("F"))
        {
            finishTransaction();
        }
    }

    public void feedMoney()
    {
        output.displayFeedMoney(balance.getBalance());

        String moneyChoice = scanner.nextLine();

        while (!moneyChoice.equalsIgnoreCase("menu") && !moneyChoice.equals("1")
                && !moneyChoice.equals("5") && !moneyChoice.equals("10")
                && !moneyChoice.equals("20"))
        {
            System.out.println("Please input money in whole dollars: '1', '5', '10', '20', or input 'menu'");
            // TODO expand menu
            moneyChoice = scanner.nextLine();
        }
        if (moneyChoice.equalsIgnoreCase("menu"))
        {
            UserOutput.displayHomeScreen();
        } else
        {
            double choiceDouble = Integer.parseInt(moneyChoice);
            currentBalance = balance.getBalance();
            balance.setBalance(currentBalance + choiceDouble);
            this.logger.write("MONEY FED:     " + choiceDouble + "   " + balance.getBalance());
            feedMoney();
        }
    }

//    public void selectionOption() {
//        Display showOptions = new Display();
//        showOptions.display();
//        System.out.println("Option 3: Charge Card.");
//        System.out.println("Your current balance is: " + balance.getBalance());
//        System.out.println("Please choose an option to purchase");
//        System.out.println("Or input menu to go to the main menu.");
//        Scanner ticketOption = new Scanner(System.in);
//        String ticketOptions = ticketOption.nextLine();
//        while (!ticketOptions.equalsIgnoreCase("menu") && !ticketOptions.equals("1")
//                && !ticketOptions.equals("2") && !ticketOptions.equals("3")) {
//            System.out.println("Please input 1, 2, 3, or menu");
//            ticketOptions = scanner.nextLine();
//        }
//        if (ticketOptions.equalsIgnoreCase("1")) {
//            currentBalance = balance.getBalance() - ONE_STOP;
//            balance.setBalance(currentBalance);
//            System.out.println("Ticket: 1 - stop. Cost: " + ONE_STOP +
//                    ". Remaining balance: " + currentBalance);
//            System.out.println("Enjoy your ride");
//            this.logger.write("1 - stop:      " + ONE_STOP + "   " + balance.getBalance());
//            UserOutput.displayHomeScreen();
//        } else if (ticketOptions.equalsIgnoreCase("2")) {
//            currentBalance = balance.getBalance() - DAILY;
//            balance.setBalance(currentBalance);
//            System.out.println("Ticket: Daily. Cost: " + DAILY +
//                    ". Remaining balance: " + currentBalance);
//            this.logger.write("Daily:         " + DAILY + "   " + balance.getBalance());
//            System.out.println("Enjoy your day");
//
//            UserOutput.displayHomeScreen();
//        } else if (ticketOptions.equalsIgnoreCase("3")) {
//            currentBalance = balance.getBalance();
//            balance.setBalance(0.00);
//            System.out.println("Charge Card. Cost: " + currentBalance +
//                    ". Remaining balance: " + balance.getBalance());
//            System.out.println("Life is an adventure");
//            this.logger.write("Check Card:    " + currentBalance + "   " + balance.getBalance());
//            UserOutput.displayHomeScreen();
//        } else {
//            UserOutput.displayHomeScreen();
//        }
//    }

    public void finishTransaction()
    {
        System.out.println("Thank you for using the Vending Machine App!");
        System.out.println("Here is your change: ");
        int currentChange = (int) (balance.getBalance() * 100);
        returnChange(currentChange);
    }

    public void returnChange(int change)
    {
        int dollarsInTwenties = 0;
        int dollarsInOnes = 0;
        int quarters = 0;
        int nickels = 0;
        int dimes = 0;
        int remainingDollars = 0;
        int remainingQtrs = 0;
        int remainingDimes = 0;
        int remainingNickels = 0;

        if (change > 2000)
        {
            dollarsInTwenties = change / 2000;
            remainingDollars = change % 2000;
            dollarsInOnes = remainingDollars / 100;
            remainingQtrs = change % 100;
            quarters = remainingQtrs / 25;
        } else
        {
            quarters = change / 25;
        }
        remainingDimes = remainingQtrs % 25;
        dimes = remainingDimes / 10;
        remainingNickels = remainingDimes % 10;
        nickels = remainingNickels / 5;
        System.out.println("Your change is as follows: " +
                        dollarsInTwenties + " twenty dollar bills" +
                 dollarsInOnes + " one dollar bills, " + quarters + " quarters, "
                + dimes + " dimes, " + nickels + " nickels.");
    }
}
