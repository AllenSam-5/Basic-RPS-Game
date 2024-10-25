import java.util.Scanner;

public class RockPaperScissors {

    public static void main (String[] args) {

        String strName = "";
        int []intScore;

        System.out.print("Hello there! What is your name? ");
        strName = new Scanner(System.in).next();

        startGame(strName);
        intScore = playGame(strName);
        endGame(strName, intScore);

    }

    public static void startGame(String strName) {

        String strStart = "";
        boolean blnStart = false;

        do {
            System.out.print("\nHi " + strName + "! Do you want to play a game of Rock-Paper-Scissors? (Yes/No) ");
            strStart = new Scanner(System.in).next();

            if (strStart.equalsIgnoreCase("Yes")) {
                blnStart = true;
            } else if (strStart.equalsIgnoreCase("No")) {
                System.out.println("\nWe hope to see you again! Bye!");
                System.exit(0);
            } else
                System.out.println("That is an invalid entry! Please try again!");
        } while(!blnStart);

    }

    public static int [] playGame (String strName) {

        String strUserChoice = "";
        String strComputerChoice = "";
        String strRematch = "";
        int intUserScore = 0;
        int intComputerScore = 0;
        int[] intPassScore = new int[2];
        byte bytMax = 3;
        byte bytMin = 1;
        byte bytRandomNum;
        boolean blnCheck;
        boolean blnRematch = true;

        do {
            do {
                blnCheck = false;
                System.out.print("\nThe computer has its move ready. What will you choose? ");
                strUserChoice = new Scanner(System.in).next();

                if (strUserChoice.equalsIgnoreCase("Rock"))
                    blnCheck = true;
                else if (strUserChoice.equalsIgnoreCase("Paper"))
                    blnCheck = true;
                else if (strUserChoice.equalsIgnoreCase("Scissors"))
                    blnCheck = true;
                else
                    System.out.println("That is not a valid choice. Please try again!");
            } while(!blnCheck);

            bytRandomNum = (byte)Math.floor(Math.random()*(bytMax-bytMin+1)+bytMin);

            if (bytRandomNum == 1)
                strComputerChoice = "Rock";
            else if (bytRandomNum == 2)
                strComputerChoice = "Paper";
            else if (bytRandomNum == 3)
                strComputerChoice = "Scissors";

            System.out.println("\nYou have chosen " + strUserChoice + "!");
            System.out.println("The computer chose " + strComputerChoice + "!\n");

            if (strUserChoice.equalsIgnoreCase("Rock") && strComputerChoice.equalsIgnoreCase("Paper")) {
                System.out.println("Paper beats Rock!");
                intComputerScore = intComputerScore + 1;
            } else if (strUserChoice.equalsIgnoreCase("Rock") && strComputerChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Rock beats Scissors!");
                intUserScore = intUserScore + 1;
            } else if (strUserChoice.equalsIgnoreCase("Paper") && strComputerChoice.equalsIgnoreCase("Rock")){
                System.out.println("Paper beats Rock!");
                intUserScore = intUserScore + 1;
            } else if (strUserChoice.equalsIgnoreCase("Paper") && strComputerChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Scissors beats Paper!");
                intComputerScore = intComputerScore + 1;
            } else if (strUserChoice.equalsIgnoreCase("Scissors") && strComputerChoice.equalsIgnoreCase("Rock")) {
                System.out.println("Rock beats Scissors!");
                intComputerScore = intComputerScore + 1;
            } else if (strUserChoice.equalsIgnoreCase("Scissors") && strComputerChoice.equalsIgnoreCase("Paper")) {
                System.out.println("Scissors beats Paper!");
                intUserScore = intUserScore + 1;
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println(strName + ": " + intUserScore + "   Computer: " + intComputerScore + "\n");

            do {
                System.out.print("Do you want to keep playing? (Yes/No) ");
                strRematch = new Scanner(System.in).next();

                if (strRematch.equalsIgnoreCase("Yes")) {
                    break;
                } else if (strRematch.equalsIgnoreCase("No")) {
                    blnRematch = false;
                    break;
                } else {
                    System.out.println("That is an invalid entry! Please try again!");
                    System.out.println();
                }
            } while(!"Yes".equalsIgnoreCase(strRematch) || !"No".equalsIgnoreCase(strRematch));
        } while(blnRematch);

        intPassScore[0] = intUserScore;
        intPassScore[1] = intComputerScore;

        return intPassScore;

    }

    public static void endGame (String strName, int []intScore) {

        System.out.println("\nThe final score is " + intScore[0] + "-" + intScore[1] + "!\n");

        if (intScore[0] > intScore[1]) {
            System.out.println(strName + " wins!");
        } else if (intScore[0] == intScore[1]) {
            System.out.println("It's a tie! Everyone wins!");
        } else {
            System.out.println("The Computer wins!");
        }

    }

}