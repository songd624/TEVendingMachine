package com.techelevator.ui;

public class UserOutput {

    private final String filePath = "workspace/module-1-capstone-group-0/catering.csv";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_LIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BOLD = "\u001B[1m";


    public void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayIntro() {
        System.out.println("\n" + ANSI_PURPLE + ANSI_BOLD +
                "\n" +
                "   __  __                     __                          \n" +
                "  /\\ \\/\\ \\                   /\\ \\  __                     \n" + ANSI_LIGHT_YELLOW +
                "  \\ \\ \\ \\ \\     __    ___    \\_\\ \\/\\_\\    ___      __     \n" +
                "   \\ \\ \\ \\ \\  /'__`\\/' _ `\\  /'_` \\/\\ \\ /' _ `\\  /'_ `\\   \n" + ANSI_BLUE +
                "    \\ \\ \\_/ \\/\\  __//\\ \\/\\ \\/\\ \\L\\ \\ \\ \\/\\ \\/\\ \\/\\ \\L\\ \\  \n" +
                "     \\ `\\___/\\ \\____\\ \\_\\ \\_\\ \\___,_\\ \\_\\ \\_\\ \\_\\ \\____ \\ \n" + ANSI_GREEN +
                "      `\\/__/  \\/____/\\/_/\\/_/\\/__,_ /\\/_/\\/_/\\/_/\\/___L\\ \\ \n" +
                "                                                   /\\____/ \n" +
                "                                                   \\_/__/ \n" + ANSI_PURPLE +
                "                            __                            \n" +
                "   /'\\_/`\\                 /\\ \\      __                  \n" + ANSI_LIGHT_YELLOW +
                "  /\\      \\     __      ___\\ \\ \\___ /\\_\\    ___      __   \n" +
                "  \\ \\ \\__\\ \\  /'__`\\   /'___\\ \\  _ `\\/\\ \\ /' _ `\\  /'__`\\ \n" + ANSI_BLUE +
                "   \\ \\ \\_/\\ \\/\\ \\L\\.\\_/\\ \\__/\\ \\ \\ \\ \\ \\ \\/\\ \\/\\ \\/\\  __/ \n" +
                "    \\ \\_\\\\ \\_\\ \\__/.\\_\\ \\____\\\\ \\_\\ \\_\\ \\_\\ \\_\\ \\_\\ \\____\\ \n" + ANSI_GREEN +
                "     \\/_/ \\/_/\\/__/\\/_/\\/____/ \\/_/\\/_/\\/_/\\/_/\\/_/\\/____/ \n" +
                "                                                                  \n"
                + ANSI_RESET);
    }

    public static void displayHomeScreen() {
        System.out.println(ANSI_CYAN + "                A Taste Elevator© Product" + ANSI_RESET);
        System.out.println("**********************************************************");
        System.out.println(ANSI_CYAN + ANSI_BOLD + "                        Main Menu" + ANSI_RESET);
        System.out.println("**********************************************************");
        System.out.println();
    }


    public void exitDisplay()
    {
        System.out.println();
        System.out.println("                 **********************************************************");
        System.out.println(ANSI_CYAN + "                     Thank You for using the Taste Elevator© Vending App" + ANSI_RESET);
        System.out.println("                 **********************************************************");
        System.out.println("\n" + ANSI_PURPLE + ANSI_BOLD +
                "\n" +
                "      __  __                                ______      ____                          __      \n" +
                "     /\\ \\/\\ \\                              /\\  _  \\    /\\  _`\\                       /\\ \\__   \n" + ANSI_LIGHT_YELLOW +
                "     \\ \\ \\_\\ \\     __     __  __     __    \\ \\ \\L\\ \\   \\ \\ \\L\\_\\  _ __    __     __  \\ \\ ,_\\  \n" +
                "      \\ \\  _  \\  /'__`\\  /\\ \\/\\ \\  /'__`\\   \\ \\  __ \\   \\ \\ \\L_L /\\`'__\\/'__`\\ /'__`\\ \\ \\ \\/  \n" + ANSI_BLUE +
                "       \\ \\ \\ \\ \\/\\ \\L\\.\\_\\ \\ \\_/ |/\\  __/    \\ \\ \\/\\ \\   \\ \\ \\/, \\ \\ \\//\\  __//\\ \\L\\.\\_\\ \\ \\_ \n" +
                "        \\ \\_\\ \\_\\ \\__/.\\_\\\\ \\___/ \\ \\____\\    \\ \\_\\ \\_\\   \\ \\____/\\ \\_\\\\ \\____\\ \\__/.\\_\\\\ \\__\\\n" + ANSI_GREEN +
                "         \\/_/\\/_/\\/__/\\/_/ \\/__/   \\/____/     \\/_/\\/_/    \\/___/  \\/_/ \\/____/\\/__/\\/_/ \\/__/\n" +
                "                                                                                              \n" +
                "                                                                                              \n" +
                "                                 ____                       __     \n" +ANSI_PURPLE +
                "                                /\\  _`\\                    /\\ \\    \n" +
                "                                \\ \\ \\/\\ \\     __     __  __\\ \\ \\   \n" + ANSI_LIGHT_YELLOW +
                "                                 \\ \\ \\ \\ \\  /'__`\\  /\\ \\/\\ \\\\ \\ \\  \n" +
                "                                  \\ \\ \\_\\ \\/\\ \\L\\.\\_\\ \\ \\_\\ \\\\ \\_\\ \n" +  ANSI_BLUE +
                "                                   \\ \\____/\\ \\__/.\\_\\\\/`____ \\\\/\\_\\\n" +
                "                                    \\/___/  \\/__/\\/_/ `/___/> \\\\/_/\n" + ANSI_GREEN +
                "                                                         /\\___/    \n" +
                "                                                         \\/__/     \n"
                + ANSI_RESET);
        System.out.println();
        System.exit(0);
    }

//    public void displayPurchaseOptions(double currentBalance) {
//        System.out.println("Here are the options: ");
//        System.out.println("(M) Feed Money");
//        System.out.println("(S) Select Option");
//        System.out.println("(F) Finish Transaction");
//        System.out.println("Current Money Provided: " + "$" + currentBalance);
//        System.out.println();
//    }

//    public static void displayFeedMoney(double currentBalance) {
//        System.out.println("Current Money Provided: " + "$" + currentBalance);
//        System.out.println("Please input how much money you would like add to your balance");
//        System.out.println("$1, $5, $10, or $20. Only enter the numerical value");
//        System.out.println("Input menu to go back to the main menu");
//    }


}
