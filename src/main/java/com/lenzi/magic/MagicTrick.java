package main.java.com.lenzi.magic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author rlenzi
 */
public class MagicTrick {
    CardArranging arrangeA;
    CardArranging arrangeB;
    int answerA;
    int answerB;

    public String solve() {
        Set<String> cardsA = new HashSet<String>();
        Collections.addAll(cardsA, arrangeA.getRowOfCards(answerA));
        Set<String> cardsB = new HashSet<String>();
        Collections.addAll(cardsB, arrangeB.getRowOfCards(answerB));
        Set<String> intersection = new HashSet<String>(cardsA);
        intersection.retainAll(cardsB);

        if (intersection.size() == 1) {
            return intersection.iterator().next();
        } else if (intersection.size() > 1) {
            return "Bad magician!";

        } else
            return "Volunteer cheated!";

    }

    public void setAnswerA(int answerA) {
        this.answerA = answerA;
    }

    public void setAnswerB(int answerB) {
        this.answerB = answerB;
    }

    public void setArrangeA(CardArranging cardArranging) {
        arrangeA = cardArranging;
    }

    public void setArrangeB(CardArranging cardArranging) {
        arrangeB = cardArranging;
    }

}
