package com.techelevator.ui;

import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * <p>
 * Dependencies: None
 */
public class UserInput
{
    private Scanner scanner = new Scanner(System.in);

   // private Purchase purchase;
//    private Balance balance;


    //public UserInput()
   // {
    //    this.purchase = new Purchase();
   // }

    public String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        System.out.println("option = " + option);
        if (option.equals("d"))
        {
            return "Displaying available items...";
        } else if (option.equals("p"))
        {
            return "Entering Purchase Menu...";
        } else if (option.equals("e"))
        {
            return "Thank You for using the Taste Elevator© Vending Machine App \n Have a Great Day!";
        } else
        {
            return "";
        }

    }
}

