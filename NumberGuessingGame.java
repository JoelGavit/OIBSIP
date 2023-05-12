import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int randomNumber, guess, attempts = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        randomNumber = random.nextInt(100) + 1;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("Try to guess the number.");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        } while (true);

        scanner.close();
    }
}