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
//        System.out.printf("%s%n %32s%n %s%n",
//                "***********************************",
//                "WELCOME To Vending Machine App",
//                "*********************************");

        System.out.println("\n" + ANSI_PURPLE + ANSI_BOLD +
                "\n" +
                "     __  __                     __                          \n" +
                "    /\\ \\/\\ \\                   /\\ \\  __                     \n" + ANSI_LIGHT_YELLOW +
                "    \\ \\ \\ \\ \\     __    ___    \\_\\ \\/\\_\\    ___      __     \n" +
                "     \\ \\ \\ \\ \\  /'__`\\/' _ `\\  /'_` \\/\\ \\ /' _ `\\  /'_ `\\   \n" + ANSI_BLUE +
                "      \\ \\ \\_/ \\/\\  __//\\ \\/\\ \\/\\ \\L\\ \\ \\ \\/\\ \\/\\ \\/\\ \\L\\ \\  \n" +
                "       \\ `\\___/\\ \\____\\ \\_\\ \\_\\ \\___,_\\ \\_\\ \\_\\ \\_\\ \\____ \\ \n" + ANSI_GREEN +
                "        `\\/__/  \\/____/\\/_/\\/_/\\/__,_ /\\/_/\\/_/\\/_/\\/___L\\ \\ \n" +
                "                                                     /\\____/ \n" +
                "                                                     \\_/__/ \n" + ANSI_PURPLE +
                "                              __                            \n" +
                "     /'\\_/`\\                 /\\ \\      __                  \n" + ANSI_LIGHT_YELLOW +
                "    /\\      \\     __      ___\\ \\ \\___ /\\_\\    ___      __   \n" +
                "    \\ \\ \\__\\ \\  /'__`\\   /'___\\ \\  _ `\\/\\ \\ /' _ `\\  /'__`\\ \n" + ANSI_BLUE +
                "     \\ \\ \\_/\\ \\/\\ \\L\\.\\_/\\ \\__/\\ \\ \\ \\ \\ \\ \\/\\ \\/\\ \\/\\  __/ \n" +
                "      \\ \\_\\\\ \\_\\ \\__/.\\_\\ \\____\\\\ \\_\\ \\_\\ \\_\\ \\_\\ \\_\\ \\____\\ \n" + ANSI_GREEN +
                "       \\/_/ \\/_/\\/__/\\/_/\\/____/ \\/_/\\/_/\\/_/\\/_/\\/_/\\/____/ \n" +
                "                                                                    \n"
                + ANSI_RESET);
    }

    public static void displayHomeScreen() {
        System.out.println("**********************************************************");
        System.out.println(ANSI_CYAN + "                        Main Menu" + ANSI_RESET);
        System.out.println("**********************************************************");
        System.out.println();
    }


    public void displayPurchaseOptions(double currentBalance) {
        System.out.println("Here are the options: ");
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Option");
        System.out.println("(F) Finish Transaction");
        System.out.println("Current Money Provided: " + "$" + currentBalance);
        System.out.println();
    }

//    public static void displayFeedMoney(double currentBalance) {
//        System.out.println("Current Money Provided: " + "$" + currentBalance);
//        System.out.println("Please input how much money you would like add to your balance");
//        System.out.println("$1, $5, $10, or $20. Only enter the numerical value");
//        System.out.println("Input menu to go back to the main menu");
//    }


}
