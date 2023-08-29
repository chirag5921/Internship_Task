import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalScore = 0;
        boolean playAgain = true;
        
        System.out.println("Welcome to Guess the Number Game!");
        
        while (playAgain) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            
            System.out.printf("I'm thinking of a number between %d and %d.%n", minRange, maxRange);
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;
                
                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.printf("Congratulations! You guessed the number %d in %d attempts", numberToGuess, attempts);
                    totalScore++;
                    break;
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.printf("Sorry, you've used all your attempts. The number was %d", numberToGuess);
            }
            
            System.out.print(" Do you want to play again? (yes/no): ");
            String playAgainStr = sc.next();
            playAgain = playAgainStr.equalsIgnoreCase("yes");
        }
        
        System.out.printf("Thank you for playing! Your total score is %d.%n", totalScore);
    }
}
