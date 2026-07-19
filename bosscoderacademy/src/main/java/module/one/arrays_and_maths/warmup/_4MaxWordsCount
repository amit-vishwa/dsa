package module.one.arrays_and_maths.warmup;

public class _4MaxWordsCount {

    public static void main(String[] args) {
        solve(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"});
        solve(new String[]{"please wait", "continue to fight", "continue to win"});
    }

    private static void solve(String[] sentences) {
        System.out.println("Max words count by approach1: " + approach1(sentences));
        System.out.println("Max words count by approach2: " + approach2(sentences));
        System.out.println();
    }

    // Bruteforce with TC O(N) and SC O(N)
    private static int approach1(String[] sentences) {
        int maxWordsCount = 0;
        for (String sentence : sentences) {
            maxWordsCount = Math.max(maxWordsCount, sentence.split(" ").length);
        }
        return maxWordsCount;
    }

    // Optimal with TC O(N) and SC O(1)
    private static int approach2(String[] sentences) {
        int maxWordsCount = 0;
        for (String sentence : sentences) {
            int wordsCount = getWordsCount(sentence);
            maxWordsCount = Math.max(maxWordsCount, wordsCount);
        }
        return maxWordsCount;
    }

    private static int getWordsCount(String sentence) {
        int wordsCount = 1;
        for (char c : sentence.toCharArray()) {
            if (c == ' ') {
                wordsCount++;
            }
        }
        return wordsCount;
    }

}