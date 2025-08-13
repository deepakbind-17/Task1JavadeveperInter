import java.util.Scanner;
import java.util.Random;

public class NumberGame_task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 7;
        int round = 0;
        int score = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            round++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n🔢 Round " + round + ": Guess a number between 1 and 100.");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Enter your guess: ");

                int guess;
                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                } else {
                    System.out.println("❌ Invalid input. Please enter a number.");
                    scanner.next(); // consume invalid input
                    continue;
                }

                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("✅ Correct! You guessed it in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("🔻 Too low!");
                } else {
                    System.out.println("🔺 Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The correct number was: " + numberToGuess);
            }

            System.out.print("\n🔁 Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\n🏁 Game Over! You won " + score + " out of " + round + " rounds.");
        scanner.close();
    }
}
 