import java.util.Scanner;
import java.util.Random;

public class NumberGuessGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int roundsWon = 0;
        int totalRounds = 0;
        boolean playMore = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playMore) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 5;
            boolean isGuessed = false;

            totalRounds++;
            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess = input.nextInt();
                attemptsLeft--;

                if (guess == numberToGuess) {
                    System.out.println("You got it! Well done!");
                    isGuessed = true;
                    roundsWon++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                if (attemptsLeft > 0) {
                    System.out.println("Attempts remaining: " + attemptsLeft);
                }
            }

            if (!isGuessed) {
                System.out.println("Out of attempts! The correct number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String ans = input.next();
            if (!ans.equalsIgnoreCase("yes")) {
                playMore = false;
            }
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds You Won: " + roundsWon);

        input.close();
    }
}
