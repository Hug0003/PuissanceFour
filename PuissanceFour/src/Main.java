import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Player p1 = new Player("Player 1", 'X');
        Player p2 = new Player("Player 2", 'O');
        Player currentPlayer = p1;


        System.out.println("Welcome to Puissance 4!");
        Instant start = Instant.now();

        Player winner = null;

        game.showBoard();
        while (true) {
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + "), choose a column (1-7): ");
            int col;
            try {
                String input = scanner.nextLine();
                col = Integer.parseInt(input) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (game.playMove(col, currentPlayer)) {
                game.nbTokenPlay(currentPlayer);
                game.showBoard();
                if (game.checkWin()) {
                    System.out.println("Congratulations " + currentPlayer.getName() + "! You win!");
                    winner = currentPlayer;
                    break;
                }
                if (game.isFull()) {
                    System.out.println("It's a draw!");
                    break;
                }
                currentPlayer = (currentPlayer == p1) ? p2 : p1;
            }
        }
        Instant end = Instant.now();
        scanner.close();
        game.saveGameStats(p1, p2, winner);
        System.out.println(Duration.between(start,
                end));
    }


}