package module.two.tries.notes;

import java.util.HashMap;

/**
 * Shortest Unique prefix for every word:
 * <p>
 * Given an array of words, find all the shortest unique prefixes to represent each word in the given array.
 * Assume that no word is a prefix of another.
 * <p>
 * Example
 * Input: N = 4 arr[] = {"zebra", "dog", "duck", "dove"}
 * Output: z dog du dov
 * <p>
 * Approach:
 * - The approach is little similar to count prefix problem.
 * - Only, here we have function called shortestPrefix which gives shorted prefix of a word.
 * - First will implement insert and then this function.
 * - In this function, we have to iterate all the characters of word.
 * - If current character related node is not there, then just return whole word as it is a unique word.
 * - Else just increment frequency and check if it is 1 then just return the appended prefixes.
 * - After completing the word traversal, just return the prefix.
 * - Time complexity: O(N*L)
 * - Space complexity: O(1)
 */
public class _3ShortestUniquePrefix {

    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        int freq = 0;
        boolean isEnd = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new TrieNode());
                cur.freq++;
                cur = cur.children.get(c);
            }
            cur.isEnd = true;
        }

        public String shortestPrefix(String word) {
            StringBuilder prefix = new StringBuilder();
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                cur = cur.children.get(c);
                if (cur == null) {
                    return word;
                }
                prefix.append(c);
                if (cur.freq == 1) {
                    return prefix.toString();
                }
            }
            return prefix.toString();
        }
    }

    public static void main(String[] args) {
        printShortestPrefix(new String[]{"zebra", "dog", "duck", "dove"});
    }

    private static void printShortestPrefix(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (String word : words) {
            System.out.print(trie.shortestPrefix(word) + " ");
        }
    }
}