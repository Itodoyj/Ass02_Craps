import java.util.Random; //Import random number generator
import java.util.Scanner; //Import Scanner for input by the user

public class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Initialize the Scanner (Create a variable for scanner)
        String playAgainChoice; //Initialize the choice to play the game

        do {
            int point = 0;
            boolean gameWon = false;

            System.out.println("Welcome to Craps!");

            // Roll the dice
            Random random = new Random();
            int dice1 = random.nextInt(6) + 1; //Generate the random numbers from 0-6 for dice 1
            int dice2 = random.nextInt(6) + 1; //Generate the random numbers from 0-6 for dice 1
            int sum = dice1 + dice2; //Sum the dice value rolled

            System.out.printf("You rolled %d + %d = %d%n", dice1, dice2, sum); //print the values rolled and the sum

            // Check initial roll
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose!");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
            } else {
                point = sum;
                System.out.printf("Point is set to %d%n", point);
                System.out.println("Trying for point...");

                // Continue rolling until point or 7 is rolled
                while (true) {
                    dice1 = random.nextInt(6) + 1;
                    dice2 = random.nextInt(6) + 1;
                    sum = dice1 + dice2;

                    System.out.printf("You rolled %d + %d = %d%n", dice1, dice2, sum);

                    if (sum == point) {
                        System.out.println("Made point! You win!");
                        gameWon = true;
                        break;
                    } else if (sum == 7) {
                        System.out.println("Got a seven! You lose!");
                        break;
                    }
                }
            }

            // Prompt to play again
            do {
                System.out.println("Do you want to play again? (Y/N): ");
                playAgainChoice = scanner.nextLine();
            }
            while (!playAgainChoice.equalsIgnoreCase("Y") && !playAgainChoice.equalsIgnoreCase("N"));
            System.out.println();

        } while (playAgainChoice.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing Craps!");
        scanner.close();
    }
}
