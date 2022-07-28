package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

public class VendingMachine
{
    Logger logger;


    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();

    public VendingMachine()
    {
        this.logger = new Logger();
    }

    public void run()
    {
        //Print header for log
        this.logger.write("=== STARTING LOG ===");


        while (true)
        {
            userOutput.displayIntro();

            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            System.out.println(choice);
            if (choice.equals("display"))
            {
                // display the items
            } else if (choice.equals("purchase"))
            {
                // make a purchase
            } else if (choice.equals("exit"))
            {
                // EXIT
                break;
            }
        }
    }
}
