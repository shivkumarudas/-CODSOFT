import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minrange = 1;
        int maxrange = 100;
        int maxAttempts = 10;
        int rounds = 1;
        int score = 0;

        while (true) {
            int secretNumber = random.nextInt(maxrange - minrange + 1) + minrange;
            int attempts = 0;
            System.out.println("\nRound " + rounds + ":");
            System.out.println("Guess the number between " + minrange + " and " + maxrange  + ". You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                if (guess < minrange || guess > maxrange ) {
                    System.out.println("Please enter a number within the range " + minrange + " to " + maxrange  + ".");
                } else if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else if (guess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + secretNumber + ".");
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // Consume newline
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
            rounds++;
        }

        System.out.println("Game over! Your final score is " + score + ".");
        scanner.close();
    }
}
