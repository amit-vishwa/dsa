package module.two.exams.mock;

import java.util.*;

/**
 * I was not able to code this problem in mock taken by mentor.
 * Refer https://leetcode.com/problems/zuma-game/description/?envType=problem-list-v2&envId=stack
 */
public class _1ZumaGame {

    public static void main(String[] args) {
        printMinBalls(1, "WRRBBW", "RB"); // Expected: -1
        printMinBalls(2, "WWRRBBWW", "WRBRW"); // Expected: 2
        printMinBalls(3, "G", "GGGGG"); // Expected: 2
        printMinBalls(4, "RRWWRRBBRR", "WB"); // Expected: 2 - CRITICAL
        printMinBalls(5, "RRGGBBYYWWRRGGBB", "RGBYW"); // TLE test -1
        printMinBalls(6, "RB", "GB"); // Expected: -1
        printMinBalls(7, "RRRR", ""); // Expected: 0
        printMinBalls(8, "W", "W"); // Expected: -1
        printMinBalls(9, "RRWWRR", "WW"); // Expected: 1
    }

    private static void printMinBalls(int test, String board, String hand) {
        System.out.println("TEST " + test + ":");
        System.out.println("Min balls to win by approach1: " + approach1(board, hand));
        System.out.println("Min balls to win by approach2: " + approach2(board, hand));
        System.out.println();
    }

    /**
     * Approach 1 - DFS
     * - This is an approach that follow Depth First Search.
     * - Process are as follows:
     * 1. Count hand colors
     * 2. Resolve board
     * 3. If board empty → return 0
     * 4. Try every color
     * 5. Try every position
     * 6. Recur
     * 7. Take minimum
     * 8. Memoize answer
     * <p>
     * Time Complexity:
     * Overall: Exponential in the length of the board (n) and the size of the hand (m), due to the combinatorial explosion of possible
     * board configurations after insertions and cleanups, combined with hand state variations. Specifically, it's roughly
     * O(5^n * 6^m * n), where:
     * - 5^n accounts for the possible board states (5 colors, up to n characters, though cleanups reduce this in practice).
     * - 6^m accounts for hand states (each of m colors can have 0-5 counts, but m ≤ 5, so 6^5 ≈ 7776).
     * - n is the branching factor for insertion positions (up to n+1 per state).
     * <p>
     * Space Complexity:
     * Overall: O(number of memoized states * key size), which is exponential in n and m. Each memo key is a string (board + hand counts),
     * and the number of unique states can approach 5^n * 6^m in the worst case, though memoization and cleanups reduce this practically.
     * Breakdown:
     * - Memo map: Stores up to ~7776 hand states and a subset of board strings (each up to ~21 characters after insertions).
     * - Recursion stack: O(depth), where depth is the number of insertions (up to m=5 in practice, but could be more with retries).
     * - Hand object: O(1) (fixed 5 integers).
     */
    private static int approach1(String board, String hand) {
        HashMap<String, Integer> memo = new HashMap<>();
        Hand handState = new Hand(hand);
        return dfs(board, handState, Integer.MAX_VALUE, memo);
    }

    private static int dfs(String board, Hand hand, int maxDepthAllowed, HashMap<String, Integer> memo) {
        board = removeConsecutiveGroups(board);
        if (board.isEmpty()) {
            return 0;
        }
        String key = board + hand.toMemoKey();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (maxDepthAllowed <= 0 || !isPossibleToWin(board, hand)) {
            memo.put(key, -1);
            return -1;
        }
        int minSteps = -1;
        for (String color : hand.getAvailableColors()) {
            Hand nextHand = new Hand(hand);
            nextHand.useColor(color);
            ArrayList<Integer> positions = getEffectiveInsertPositions(color, board, nextHand.isEmpty());
            for (int position : positions) {
                String nextBoard = board.substring(0, position) + color + board.substring(position);
                int childResult = dfs(nextBoard, nextHand, minSteps == -1 ? maxDepthAllowed - 1 : minSteps - 1, memo);
                if (childResult != -1) {
                    int currentSteps = 1 + childResult;
                    if (minSteps == -1 || currentSteps < minSteps) {
                        minSteps = currentSteps;
                    }
                }
            }
        }
        memo.put(key, minSteps);
        return minSteps;
    }

    private static String removeConsecutiveGroups(String board) {
        int i = 0, n = board.length();
        while (i < n) {
            int j = i;
            while (j < n && board.charAt(i) == board.charAt(j)) {
                j++;
            }
            if (j - i >= 3) {
                return removeConsecutiveGroups(board.substring(0, i) + board.substring(j));
            } else {
                i = j;
            }
        }
        return board;
    }

    private static boolean isPossibleToWin(String board, Hand handCount) {
        Hand boardCount = new Hand(board);
        return ((boardCount.red == 0 || boardCount.red + handCount.red >= 3)
                && (boardCount.blue == 0 || boardCount.blue + handCount.blue >= 3)
                && (boardCount.green == 0 || boardCount.green + handCount.green >= 3)
                && (boardCount.white == 0 || boardCount.white + handCount.white >= 3)
                && (boardCount.yellow == 0 || boardCount.yellow + handCount.yellow >= 3));
    }

    private static ArrayList<Integer> getEffectiveInsertPositions(String color, String board, boolean isLastBallOfThisColor) {
        ArrayList<Integer> bestPositions = new ArrayList<>();
        ArrayList<Integer> secondBestPositions = new ArrayList<>();
        ArrayList<Integer> thirdBestPositions = new ArrayList<>();
        int n = board.length();
        for (int i = 0; i <= n; i++) {
            if (i < n - 1 && board.substring(i, i + 2).equals(color + color)) {
                bestPositions.add(i);
                i += 2;
            } else if (i < n && board.substring(i, i + 1).equals(color)) {
                secondBestPositions.add(i);
                i++;
            } else if (i > 0 && i < n && board.charAt(i - 1) == board.charAt(i)) {
                thirdBestPositions.add(i);
            }
        }
        if (isLastBallOfThisColor) {
            return bestPositions;
        }
        bestPositions.addAll(secondBestPositions);
        bestPositions.addAll(thirdBestPositions);
        return bestPositions;
    }

    /**
     * Approach 2 - BFS
     * - This is a better approach than the DFS as it reduces the rapidly growing space.
     * <p>
     * Explanation of BFS Approach:
     * - Queue and State: Each State holds the current board, hand, and steps. We start with the initial board and hand at step 0.
     * - Visited Set: Prevents processing the same (board, hand) state multiple times, reducing redundant work.
     * - Exploration: For each state, if the board isn't empty and winning is possible, try inserting each available color at prioritized
     * positions. After insertion and cleaning, enqueue the new state if not visited.
     * - Termination: Return steps when the board is empty. If the queue empties without success, return -1.
     * - Complexity: Similar to DFS—time is exponential in board/hand size (but BFS may visit fewer states due to level-order), space is
     * O(queue size + visited), which is manageable for the constraints.
     */
    private static int approach2(String board, String hand) {
        HashSet<String> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        Hand initialHand = new Hand(hand);
        queue.offer(new State(board, initialHand, 0));
        visited.add(board + initialHand.toMemoKey());
        while (!queue.isEmpty()) {
            State current = queue.poll();
            String currentBoard = removeConsecutiveGroups(current.board);
            if (currentBoard.isEmpty()) {
                return current.steps;
            }
            if (!isPossibleToWin(currentBoard, current.hand)) {
                continue;
            }
            for (String color : current.hand.getAvailableColors()) {
                Hand nextHand = new Hand(current.hand);
                nextHand.useColor(color);
                ArrayList<Integer> positions = getEffectiveInsertPositions(color, currentBoard, nextHand.isEmpty());
                for (int position : positions) {
                    String nextBoard = currentBoard.substring(0, position) + color + currentBoard.substring(position);
                    nextBoard = removeConsecutiveGroups(nextBoard);
                    String key = nextBoard + nextHand.toMemoKey();
                    if (!visited.contains(key)) {
                        visited.add(key);
                        queue.offer(new State(nextBoard, nextHand, current.steps + 1));
                    }
                }
            }
        }
        return -1;
    }
}

class Hand {

    int red, blue, green, white, yellow;

    Hand(String hand) {
        for (char color : hand.toCharArray()) {
            switch (color) {
                case 'R' -> red++;
                case 'B' -> blue++;
                case 'G' -> green++;
                case 'W' -> white++;
                case 'Y' -> yellow++;
            }
        }
    }

    Hand(Hand hand) {
        if (hand == null) {
            return;
        }
        this.red = hand.red;
        this.blue = hand.blue;
        this.green = hand.green;
        this.white = hand.white;
        this.yellow = hand.yellow;
    }

    boolean isEmpty() {
        return (red == 0 && blue == 0 && green == 0 && white == 0 && yellow == 0);
    }

    ArrayList<String> getAvailableColors() {
        ArrayList<String> availableColors = new ArrayList<>();
        if (red > 0) {
            availableColors.add("R");
        }
        if (blue > 0) {
            availableColors.add("B");
        }
        if (green > 0) {
            availableColors.add("G");
        }
        if (white > 0) {
            availableColors.add("W");
        }
        if (yellow > 0) {
            availableColors.add("Y");
        }
        return availableColors;
    }

    void useColor(String color) {
        switch (color) {
            case "R" -> red--;
            case "B" -> blue--;
            case "G" -> green--;
            case "W" -> white--;
            case "Y" -> yellow--;
        }
    }

    String toMemoKey() {
        return (red + "," + blue + "," + green + "," + white + "," + yellow);
    }

}

class State {
    String board;
    Hand hand;
    int steps;

    State(String board, Hand hand, int steps) {
        this.hand = hand;
        this.steps = steps;
        this.board = board;
    }
}