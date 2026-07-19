package module.two.hashing.two.notes;

import java.util.HashMap;

// Refer _2MaxPointsOnLine.java from package module.two.hashing.two.lecture;
public class _3MaxPointsOnLine {

    public static void main(String[] args) {
        System.out.println("Max points: " + maxPoints(new int[][]{
                {-1, 1}, {0, 0}, {1, 1}, {2, 2}, {3, 3}, {3, 4}
        })); // 4
        System.out.println("Max points: " + maxPoints(new int[][]{
                {1, 1}, {2, 2}, {3, 3}
        })); // 3
    }

    private static int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int maxPointsOnLine = 0;
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int duplicates = 1, localMax = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                String key = dy + "/" + dx;
                map.put(key, map.getOrDefault(key, 0) + 1);
                localMax = Math.max(localMax, map.get(key));
            }
            maxPointsOnLine = Math.max(maxPointsOnLine, localMax + duplicates);
        }
        return maxPointsOnLine;
    }

    private static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

}
