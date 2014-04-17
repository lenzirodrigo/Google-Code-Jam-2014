package main.java.com.lenzi.magic;

/**
 * @author rlenzi
 */
public class CardArranging {
    private String[][] cards;

    public CardArranging() {
        cards = new String[4][4];
    }

    public void addRow(int r, String[] cards) {
        for (int c = 0; c < cards.length; c++) {
            this.cards[r][c] = cards[c];
        }
    }

    public String[] getRowOfCards(int row) {
        return cards[row-1];

    }
}
