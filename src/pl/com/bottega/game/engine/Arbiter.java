package pl.com.bottega.game.engine;

public class Arbiter {
    private Player player1;
    private Player player2;

    private short currentRound;
    private  short maxRound; //TODO wstrzyknąć przez konstruktor

    public Arbiter(short maxRound, Player player1, Player player2) {
        this.maxRound = maxRound;
        this.player1 = player1;
        this.player2 = player2;
    }
    public Arbiter(Player player1, Player player2) {
        this((short)10, player1, player2);
    }

    public byte playRound() {
        if (currentRound == maxRound)
            return -1;
        currentRound++;
        String hand1 = player1.giveHand();
        String hand2 = player2.giveHand();

        return calculateResult(hand1, hand2);
    }
    private byte calculateResult(String hand1, String hand2) {
        if (hand1==null || hand2==null)
            return 0;
        if (hand1.equals(hand2))
            return 0;
        if ((hand1.equals("papier") && hand2.equals("kamien"))
                ||
                (hand1.equals("kamien") && hand2.equals("nozyce"))
                ||
                (hand1.equals("nozyce") && hand2.equals("papier"))) {
            return 1;
        } else {
            return 2;
        }
    }
}
