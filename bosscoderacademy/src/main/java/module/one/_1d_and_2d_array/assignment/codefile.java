package module.one._1d_and_2d_array.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class codefile {

    public static void main(String[] args) {
        solve(List.of(List.of(1, 0, 0), List.of(0, 0, 1), List.of(1, 0, 0)));
        solve(List.of(List.of(1, 0, 0), List.of(0, 1, 0), List.of(0, 0, 1)));
    }

    static void solve(List<List<Integer>> input) {
        int posCnt = 0;
        int m = input.size(), n = input.get(0).size();
        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(input.get(r).get(c) == 1){
                    rowOnes[r]++;
                    colOnes[c]++;
                }
            }
        }
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(input.get(r).get(c) == 1 && rowOnes[r] == 1 && colOnes[c] == 1){
                    posCnt++;
                }
            }
        }
        System.out.println("Count: " + posCnt);
    }

    static int solve1(List<List<Integer>> input) {
        int posCnt = 0;
        int m = input.size(), n = input.get(0).size();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (input.get(r).get(c) == 0) {
                    continue;
                }

                int count = 0;
                int i = r;
                while (i >= 0) {
                    count += input.get(i--).get(c);
                }
                if (count > 1) {
                    continue;
                }

                count = 0;
                i = r;
                while (i < m) {
                    count += input.get(i++).get(c);
                }
                if (count > 1) {
                    continue;
                }

                count = 0;
                i = c;
                while (i < n) {
                    count += input.get(r).get(i++);
                }
                if (count > 1) {
                    continue;
                }

                count = 0;
                i = c;
                while (i >= 0) {
                    count += input.get(r).get(i--);
                }
                if (count == 1) {
                    posCnt++;
                }
            }
            System.out.println();
        }
        return posCnt;
    }

}