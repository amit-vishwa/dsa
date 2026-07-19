package module.two.hashing.one.assignment;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class _5ValidSudoku {

    public static void main(String[] args) {
        printResult(getTestDataOne());
        printResult(getTestDataTwo());
    }

    private static ArrayList<ArrayList<Integer>> getTestDataOne() {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        board.add(new ArrayList<>(List.of(5, 3, 0, 0, 7, 0, 0, 0, 0)));
        board.add(new ArrayList<>(List.of(6, 0, 0, 1, 9, 5, 0, 0, 0)));
        board.add(new ArrayList<>(List.of(0, 9, 8, 0, 0, 0, 0, 6, 0)));
        board.add(new ArrayList<>(List.of(8, 0, 0, 0, 6, 0, 0, 0, 3)));
        board.add(new ArrayList<>(List.of(4, 0, 0, 8, 0, 3, 0, 0, 1)));
        board.add(new ArrayList<>(List.of(7, 0, 0, 0, 2, 0, 0, 0, 6)));
        board.add(new ArrayList<>(List.of(0, 6, 0, 0, 0, 0, 2, 8, 0)));
        board.add(new ArrayList<>(List.of(0, 0, 0, 4, 1, 9, 0, 0, 5)));
        board.add(new ArrayList<>(List.of(0, 0, 0, 0, 8, 0, 0, 7, 9)));
        return board;
    }

    private static ArrayList<ArrayList<Integer>> getTestDataTwo() {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        board.add(new ArrayList<>(List.of(8, 3, 0, 0, 7, 0, 0, 0, 0)));
        board.add(new ArrayList<>(List.of(6, 0, 0, 1, 9, 5, 0, 0, 0)));
        board.add(new ArrayList<>(List.of(0, 9, 8, 0, 0, 0, 0, 6, 0)));
        board.add(new ArrayList<>(List.of(8, 0, 0, 0, 6, 0, 0, 0, 3)));
        board.add(new ArrayList<>(List.of(4, 0, 0, 8, 0, 3, 0, 0, 1)));
        board.add(new ArrayList<>(List.of(7, 0, 0, 0, 2, 0, 0, 0, 6)));
        board.add(new ArrayList<>(List.of(0, 6, 0, 0, 0, 0, 2, 8, 0)));
        board.add(new ArrayList<>(List.of(0, 0, 0, 4, 1, 9, 0, 0, 5)));
        board.add(new ArrayList<>(List.of(0, 0, 0, 0, 8, 0, 0, 7, 9)));
        return board;
    }

    private static void printResult(ArrayList<ArrayList<Integer>> board) {
        System.out.println("Is valid sudoku by approach 1: " + approach1(board));
        System.out.println("Is valid sudoku by approach 2: " + approach2(board));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach.
     * - Here, we are just iterating over the 2D array board.
     * - Then checking if current cell value is not 0 the proceeding with the checks, else skipping it.
     * - For non-zero cell we are checking if for that particular row we already have that number.
     * - We are also checking in same column and block, if num is already present then return false.
     * - Else at last just return true.
     * - Time complexity: O(9^2) for outer loops * O(9) for check validity = O(9^3) i.e. constant as size is fixed.
     * - Space complexity: O(9^2) as it is already given, since size is fixed then it is constant.
     */
    private static boolean approach1(ArrayList<ArrayList<Integer>> board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.get(row).get(col) == 0) {
                    continue;
                }
                if (!isValid(board, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(ArrayList<ArrayList<Integer>> board, int row, int col) {
        int num = board.get(row).get(col);
        for (int r = 0; r < 9 && r != row; r++) {
            if (board.get(r).get(col) == num) {
                return false;
            }
        }
        for (int c = 0; c < 9 && c != col; c++) {
            if (board.get(row).get(c) == num) {
                return false;
            }
        }
        int rowStart = row / 3 * 3;
        int colStart = col / 3 * 3;
        for (int r = rowStart; r < rowStart + 3; r++) {
            for (int c = colStart; c < colStart + 3; c++) {
                if (r == row && c == col) {
                    continue;
                }
                if (board.get(r).get(c) == num) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Approach 2 - Optimal
     * - This is a better approach than the bruteforce one.
     * - Only change here is we have reduced the time complexity for checking validity by using HashSet list.
     * - For each row, col and block, we are checking if num is already there in HashSet.
     * - If it is there, then return false, else add num into those sets.
     * - Time complexity: O(9^2) as validity complexity is reduced using HashSet list.
     * - Space complexity: O(9^2) for board + O(3*9) for HashSets = O(9^2) i.e. constant
     */
    private static boolean approach2(ArrayList<ArrayList<Integer>> board) {
        ArrayList<HashSet<Integer>> rowSetList = new ArrayList<>();
        ArrayList<HashSet<Integer>> colSetList = new ArrayList<>();
        ArrayList<HashSet<Integer>> blockSetList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rowSetList.add(new HashSet<>());
            colSetList.add(new HashSet<>());
            blockSetList.add(new HashSet<>());
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int num = board.get(row).get(col);
                if (num == 0) {
                    continue;
                }
                int blockIndex = row / 3 * 3 + col / 3;
                if (rowSetList.get(row).contains(num) || colSetList.get(col).contains(num) ||
                        blockSetList.get(blockIndex).contains(num)) {
                    return false;
                }
                rowSetList.get(row).add(num);
                colSetList.get(col).add(num);
                blockSetList.get(blockIndex).add(num);
            }
        }
        return true;
    }

}