package com.techelevator.application;

import java.util.Scanner;

public class FinishTransaction
{
    private Scanner scanner = new Scanner(System.in);
    private Balance balance;
    private Logger logger;
    private double currentBalance;

    public FinishTransaction(Scanner scanner, Balance balance, Logger logger, double currentBalance)
    {
        this.scanner = scanner;
        this.balance = balance;
        this.logger = logger;
        this.currentBalance = currentBalance;
    }


}
