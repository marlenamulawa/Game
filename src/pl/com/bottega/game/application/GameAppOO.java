package pl.com.bottega.game.application;

import pl.com.bottega.game.engine.*;
import java.util.Scanner;

public class GameAppOO {
    private static Scanner scanner = new Scanner(System.in);
    private static Player player1;
    private static Player player2;

    public static void main (String[] args) {

        short gamesCount = readGamesCount();
        initializePlayers();
        SoundDevice selectedDevice = selectSoundDevice();

        //Player human = new HumanPlayer("Andrzej");
        //human.giveHand();
        Arbiter arbiter = new Arbiter(gamesCount, player1, player2); //dependency injection
        ScoreBoard primaryScoreBoard = new ScoreBoard(player1.getName(), player2.getName(), gamesCount, selectedDevice);

        byte result = 0;
        do {
            result = arbiter.playRound();
            primaryScoreBoard.refresh(result);
        } while (result != -1);
    }
    private static Player initializePlayers() {
        System.out.println("Wybierz jedną z opcji zaznaczając numer: \n" +
          "1. computer vs computer\n" +
          "2. human vs human\n" +
          "3. human vs computer ");
        int playerOption = scanner.nextInt();
        scanner.nextLine();
        switch (playerOption) {
        case 1:
            player1 = new ComputerPlayer("Computer1");
            player2 = new ComputerPlayer("Computer2");
            break;
        case 2:
            System.out.println("Podaj imię pierwszego gracza: ");
            String playerName1 = scanner.nextLine();
            System.out.println("Podaj imię drugiego gracza: ");
            String playerName2 = scanner.nextLine();
            player1 = new HumanPlayer(playerName1);
            player2 = new HumanPlayer(playerName2);
            break;
        case 3:
            System.out.println("Podaj imię gracza: ");
            String playerName = scanner.nextLine();
            player1 = new HumanPlayer(playerName);
            player2 = new ComputerPlayer("Computer");
            break;
    }
        return null;
}
    private static short readGamesCount() {
        System.out.println("Podaj ilosc gier: ");
        short count = scanner.nextShort();
        scanner.nextLine();
        return count;
    }
    private static SoundDevice selectSoundDevice () {
        System.out.println("Wpisz: SONY, MANTA, BOSSE");
        DeviceSelector device = DeviceSelector.valueOf(scanner.nextLine());
        if (device.equals(DeviceSelector.SONY)) {
            return new SonyDevice();
        }
        if (device.equals(DeviceSelector.MANTA)) {
            return new MantaDevice();
        }
        if (device.equals(DeviceSelector.BOSSE)) {
            return new BosseDevice();
        } else
            return null;
    }
}

