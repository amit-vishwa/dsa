package module.one.exams.milestone;

import java.util.ArrayList;

/**
 * Refer _1The24Game.java file from package module.one.backtracking.assignment.
 */
public class _7Game24 {

    private final static double EPS = 0.000001;

    public static void main(String[] args) {
        play(new int[]{4, 1, 8, 7});
        play(new int[]{1, 2, 1, 2});
    }

    private static void play(int[] cards) {
        ArrayList<Double> cardList = new ArrayList<>();
        for (int card : cards) {
            cardList.add((double) card);
        }
        System.out.println("24 can be achieved? " + evaluate(cardList));
    }

    private static boolean evaluate(ArrayList<Double> cardList) {
        int n = cardList.size();
        if (n == 1) {
            return Math.abs(cardList.getFirst() - 24) <= EPS;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ArrayList<Double> cards = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    cards.add(cardList.get(k));
                }
                Double num1 = cardList.get(i);
                Double num2 = cardList.get(j);
                for (Double candidate : candidates(num1, num2)) {
                    cards.add(candidate);
                    if (evaluate(cards)) {
                        return true;
                    }
                    cards.removeLast();
                }
            }
        }
        return false;
    }

    private static ArrayList<Double> candidates(Double num1, Double num2) {
        ArrayList<Double> candidateList = new ArrayList<>();
        candidateList.add(num1 + num2);
        candidateList.add(num1 * num2);
        candidateList.add(num1 - num2);
        candidateList.add(num2 - num1);
        if (num2 > EPS) {
            candidateList.add(num1 / num2);
        }
        if (num1 > EPS) {
            candidateList.add(num2 / num1);
        }
        return candidateList;
    }

}
