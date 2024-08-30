package Project01;

import java.util.Random;

public class GuessTheNumberGame {
    private int targetNumber;
    private Player humanPlayer;
    private Player computerPlayer;

    public GuessTheNumberGame() {
        Random random = new Random();
        this.targetNumber = random.nextInt(100) + 1;
        this.humanPlayer = new HumanPlayer("Humano");
        this.computerPlayer = new ComputerPlayer("Computadora");
    }

    public void play() {
        boolean guessed = false;

        while (!guessed) {
            int humanGuess = humanPlayer.makeGuess();
            guessed = checkGuess(humanGuess, humanPlayer);

            if (guessed) break;

            int computerGuess = computerPlayer.makeGuess();
            guessed = checkGuess(computerGuess, computerPlayer);
        }

        // Mostrar el historial de suposiciones de cada jugador
        displayGuesses(humanPlayer);
        displayGuesses(computerPlayer);
    }

    private boolean checkGuess(int guess, Player player) {
        if (guess == targetNumber) {
            System.out.println("¡" + player.getName() + " ha adivinado correctamente el número!");
            return true;
        } else if (guess < targetNumber) {
            System.out.println(player.getName() + ", el número es mayor.");
        } else {
            System.out.println(player.getName() + ", el número es menor.");
        }
        return false;
    }

    private void displayGuesses(Player player) {
        System.out.println(player.getName() + " hizo " + player.getGuesses().size() + " intentos.");
        System.out.println("Intentos: " + player.getGuesses());
    }

    public static void main(String[] args) {
        GuessTheNumberGame game = new GuessTheNumberGame();
        game.play();
    }
}