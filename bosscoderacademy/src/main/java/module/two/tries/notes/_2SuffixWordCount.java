package module.two.tries.notes;

import java.util.HashMap;

/**
 * Counting Words with a given suffix:
 * <p>
 * You are given an array of string words and a string stuff. Return the number of strings in words that contain stuff as a stuff.
 * <p>
 * Example
 * Input: words = ["abc", "edc", "fbc", "bf", "nf" ], suff= "c"
 * Output: 3
 * <p>
 * Approach is similar to _1PrefixWordCount.java, only here we are inserting words in reverse and checking suffix in reverse order.
 */
public class _2SuffixWordCount {

    static class TrieNode {
        HashMap<Character, TrieNode> node = new HashMap<>();
        int suffixCount = 0;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode temp = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (!temp.node.containsKey(ch)) {
                    temp.node.put(ch, new TrieNode());
                }
                temp = temp.node.get(ch);
                temp.suffixCount++;
            }
        }

        public int countSuffix(String suffix) {
            TrieNode temp = root;
            for (int i = suffix.length() - 1; i >= 0; i--) {
                if (!temp.node.containsKey(suffix.charAt(i))) {
                    return 0;
                }
                temp = temp.node.get(suffix.charAt(i));
            }
            return temp.suffixCount;
        }
    }

    public static void main(String[] args) {
        printSuffixCount(new String[]{"tuition", "attention", "practice", "attend", "attention"}, "tion");
        printSuffixCount(new String[]{"tuition", "practiced", "attended", "attention"}, "ed");
    }

    private static void printSuffixCount(String[] words, String suffix) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        System.out.println("Suffix count: " + trie.countSuffix(suffix));
    }

}
