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

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public String getHomeScreenOption()
    {
        System.out.println("                What would you like to do?");
        System.out.println();

        System.out.println("                   (" + ANSI_CYAN + "D" + ANSI_RESET + ") Display Items");
        System.out.println("                     (" + ANSI_CYAN + "P" + ANSI_RESET + ") Purchase");
        System.out.println("                     (" + ANSI_CYAN + "E" + ANSI_RESET + ") Exit App");

        System.out.println();
        System.out.print("                Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        System.out.println("Option Selected = " + option);
        if (option.equals("d"))
        {
            return "display";
        } else if (option.equals("p"))
        {
            return "purchase";
        } else if (option.equals("e"))
        {
            return "exit";
        } else
        {
            return "";
        }

    }
}

