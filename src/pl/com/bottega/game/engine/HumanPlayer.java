package pl.com.bottega.game.engine;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private String name;
    private Scanner scanner = new Scanner(System.in);
    private int globalErrorsCounter;

    public HumanPlayer(String name) {
        this.name = name;
    }

    public String giveHand() {
        System.out.println("Wpisz: kamien, nozyce, papier");
        int counter = 0;
        String hand = scanner.nextLine();
        while (!(hand.equals("kamien") || hand.equals("nozyce") || hand.equals("papier")) && counter < 3) {
            System.out.println("Spróbuj jeszcze raz!");
            hand = scanner.nextLine();
            counter++;
            addToGlobalErrorsCounter(counter);
        }
        if (hand.equals("kamien") || hand.equals("nozyce") || hand.equals("papier"))
            return hand;
        else
            return null;
    }
    private void addToGlobalErrorsCounter(int fails) {
        globalErrorsCounter = globalErrorsCounter + fails;
    }

    public String getName() {
        return name;
    }
}
