package com.techelevator.ui;

public class UserOutput {

    private final String filePath = "workspace/module-1-capstone-group-0/catering.csv";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

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

        System.out.println("\n" + ANSI_CYAN +
                "        ___           ___           ___           ___                       ___           ___     \n" +
                "       /\\__\\         /\\  \\         /\\__\\         /\\  \\          ___        /\\__\\         /\\  \\    \n" +
                "      /:/  /        /::\\  \\       /::|  |       /::\\  \\        /\\  \\      /::|  |       /::\\  \\   \n" +
                "     /:/  /        /:/\\:\\  \\     /:|:|  |      /:/\\:\\  \\       \\:\\  \\    /:|:|  |      /:/\\:\\  \\  \n" +
                "    /:/__/  ___   /::\\~\\:\\  \\   /:/|:|  |__   /:/  \\:\\__\\      /::\\__\\  /:/|:|  |__   /:/  \\:\\  \\ \n" +
                "    |:|  | /\\__\\ /:/\\:\\ \\:\\__\\ /:/ |:| /\\__\\ /:/__/ \\:|__|  __/:/\\/__/ /:/ |:| /\\__\\ /:/__/_\\:\\__\\\n" +
                "    |:|  |/:/  / \\:\\~\\:\\ \\/__/ \\/__|:|/:/  / \\:\\  \\ /:/  / /\\/:/  /    \\/__|:|/:/  / \\:\\  /\\ \\/__/\n" +
                "    |:|__/:/  /   \\:\\ \\:\\__\\       |:/:/  /   \\:\\  /:/  /  \\::/__/         |:/:/  /   \\:\\ \\:\\__\\  \n" +
                "     \\::::/__/     \\:\\ \\/__/       |::/  /     \\:\\/:/  /    \\:\\__\\         |::/  /     \\:\\/:/  /  \n" +
                "      ~~~~          \\:\\__\\         /:/  /       \\::/__/      \\/__/         /:/  /       \\::/  /   \n" +
                "                     \\/__/         \\/__/         ~~                        \\/__/         \\/__/    \n" +
                "        ___           ___           ___           ___                       ___           ___     \n" +
                "       /\\__\\         /\\  \\         /\\  \\         /\\__\\          ___        /\\__\\         /\\  \\    \n" +
                "      /::|  |       /::\\  \\       /::\\  \\       /:/  /         /\\  \\      /::|  |       /::\\  \\   \n" +
                "     /:|:|  |      /:/\\:\\  \\     /:/\\:\\  \\     /:/__/          \\:\\  \\    /:|:|  |      /:/\\:\\  \\  \n" +
                "    /:/|:|__|__   /::\\~\\:\\  \\   /:/  \\:\\  \\   /::\\  \\ ___      /::\\__\\  /:/|:|  |__   /::\\~\\:\\  \\ \n" +
                "   /:/ |::::\\__\\ /:/\\:\\ \\:\\__\\ /:/__/ \\:\\__\\ /:/\\:\\  /\\__\\  __/:/\\/__/ /:/ |:| /\\__\\ /:/\\:\\ \\:\\__\\\n" +
                "   \\/__/~~/:/  / \\/__\\:\\/:/  / \\:\\  \\  \\/__/ \\/__\\:\\/:/  / /\\/:/  /    \\/__|:|/:/  / \\:\\~\\:\\ \\/__/\n" +
                "         /:/  /       \\::/  /   \\:\\  \\            \\::/  /  \\::/__/         |:/:/  /   \\:\\ \\:\\__\\  \n" +
                "        /:/  /        /:/  /     \\:\\  \\           /:/  /    \\:\\__\\         |::/  /     \\:\\ \\/__/  \n" +
                "       /:/  /        /:/  /       \\:\\__\\         /:/  /      \\/__/         /:/  /       \\:\\__\\    \n" +
                "       \\/__/         \\/__/         \\/__/         \\/__/                     \\/__/         \\/__/    "
                + ANSI_RESET);
    }

    public static void displayHomeScreen() {
        System.out.println();
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
