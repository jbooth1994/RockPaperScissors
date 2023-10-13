import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Player A, please choose Rock (R), Paper (P), or Scissors (S):");
            String playerAChoice = getValidMove(scanner);

            System.out.println("Player B, please choose Rock (R), Paper (P), or Scissors (S):");
            String playerBChoice = getValidMove(scanner);

            System.out.println("Player A chose " + playerAChoice);
            System.out.println("Player B chose " + playerBChoice);

            String result = determineWinner(playerAChoice, playerBChoice);
            System.out.println(result);

            System.out.println("Do you want to play again? [Y/N]:");
            String playAgainChoice = scanner.next();
            if (!playAgainChoice.equalsIgnoreCase("Y")) {
                playAgain = false;
            }

        }
        scanner.close();
    }

    private static String getValidMove(Scanner scanner) {
        String choice = scanner.next().toUpperCase();
        while (!(choice.equals("R") || choice.equals("P") || choice.equals("S"))){
            System.out.println("Invalid choice. Please choose Rock (R), Paper (P), or Scissors (S):");
            choice = scanner.next().toUpperCase();
        }
        return choice;
    }

    private static String determineWinner(String playerAChoice, String playerBChoice) {
        if (playerAChoice.equals(playerBChoice)) {
            return "It's a Tie!";
        } else if ((playerAChoice.equals("R") && playerBChoice.equals("S")) ||
                (playerAChoice.equals("P") && playerBChoice.equals("R")) ||
                (playerAChoice.equals("S") && playerBChoice.equals("P"))) {
            return "Player A wins!";
        } else {
            return "Player B wins!";
        }
    }
}