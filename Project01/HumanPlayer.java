package Project01;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name) {
        super (name);
        this.scanner = new Scanner (System.in);
    }

    @Override
    public int makeGuess() {
        System.out.print(name + ", introduce un número entre 1 y 100: ");
        return scanner.nextInt();
    }
}
