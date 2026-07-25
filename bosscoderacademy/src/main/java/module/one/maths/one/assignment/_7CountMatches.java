package module.one.maths.one.assignment;

/**
 * Count Of Matches: [Leetcode 1688. Count of Matches in Tournament]
 *
 * You are given an integer n, the number of teams in a tournament that has strange rules:
 * If the current number of teams is even, each team gets paired with another team. A total of n / 2 matches are played,
 * and n / 2 teams advance to the next round.
 * If the current number of teams is odd, one team randomly advances in the tournament, and the rest gets paired.
 * A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
 *
 * Return the number of matches played in the tournament until a winner is decided.
 *
 * Input 1: n = 7
 * Output 1: 6
 * Explanation 1:
 * Details of the tournament:
 * - 1st Round: Teams = 7, Matches = 3, and 4 teams advance.
 * - 2nd Round: Teams = 4, Matches = 2, and 2 teams advance.
 * - 3rd Round: Teams = 2, Matches = 1, and 1 team is declared the winner.
 * Total number of matches = 3 + 2 + 1 = 6.
 *
 * Input 2: n = 14
 * Output 2: 13
 *
 * Constraints:
 * 1 <= n <= 200
 * */
public class _7CountMatches {

    public static void main(String[] args) {
        printMatchesCount(7);
        printMatchesCount(14);
    }

    private static void printMatchesCount(int teams) {
        System.out.println("Matches to be played by approach1: " + approach1(teams));
        System.out.println("Matches to be played by approach2: " + approach2(teams));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - This can be termed as the actual solution by following the steps asked in the problem statement.
     * - This is bruteforce because of time complexity, as we have an approach with constant time complexity.
     * - Here, we are simply reducing the teams by 2 and adding 1 to it if teams are in odd numbers.
     * - We are counting the teams that played matches as the matches count.
     * - At last, we are returning the final matches played until a winner is declared.
     * - Time complexity: O(log(N)), as we are reducing by 2.
     * - Space complexity: O(1) as no extra space is used.
     * */
    private static int approach1(int teams) {
        int matchesPlayed = 0;
        while (teams > 1) {
            matchesPlayed += teams / 2;
            teams = (teams & 1) == 1 ? (teams / 2) + 1 : teams / 2;
        }
        return matchesPlayed;
    }

    /**
     * Approach 2 - Optimal approach
     * - This approach don't consist of any specific steps.
     * - It just requires an intuition, it's simple thought process that if N number of teams are there,
     * then N-1 matches should be played until a winner is decided.
     * - Time complexity: O(1), since is a single operation
     * - Space complexity: O(1), nothing is used
     * */
    private static int approach2(int teams) {
        return teams - 1;
    }

}