package module.two.tries.notes;

import java.util.HashMap;

/**
 * Counting Words With a Given Prefix:
 * <p>
 * You are given an array of string words and a string pref. Return the number of strings in words that contain pref as a prefix.
 * <p>
 * Example
 * Input: words = ["pay", "attention", "practice", "attend"], pref = "at"
 * Output: 2
 * <p>
 * Approach:
 * - The approach is a bit different from the normal trie implementation.
 * - We will have hashmap of character and trieNode and 2 variables for pass and end counts.
 * - Now, trie class will have insert and countPrefix methods.
 * - The insert method will be similar to normal insert, just simply increment the pass counter after a char insertion.
 * - And at last, we can increment the end counter.
 * - After this, the countPrefix method will be similar to prefix method.
 * - If char not found, just return count as 0, else iterate visit chars and at last just return the prefix count.
 * - Time complexity: O(N) for words * O(L) for average word length = O(N*L).
 * - Space complexity: O(1) as space is fixed.
 */
public class _1PrefixWordCount {

    static class TrieNode {
        HashMap<Character, TrieNode> children;
        int passCount, endCount;

        public TrieNode() {
            children = new HashMap<>();
            passCount = 0;
            endCount = 0;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode temp = root;
            for (char ch : word.toCharArray()) {
//                if (!temp.children.containsKey(ch)) {
//                    temp.children.put(ch, new TrieNode());
//                }
//                temp = temp.children.get(ch);
                // below works similar to above line
                temp = temp.children.computeIfAbsent(ch, node -> new TrieNode());
                temp.passCount++;
            }
            temp.endCount++;
        }

        public int prefixCount(String prefix) {
            TrieNode temp = root;
            for (char ch : prefix.toCharArray()) {
                temp = temp.children.get(ch);
                if (temp == null) {
                    return 0;
                }
            }
            return temp.passCount;
        }
    }

    public static void main(String[] args) {
        printPrefixCount(new String[]{"apay", "attention", "practice", "attend"}, "a");
    }

    private static void printPrefixCount(String[] words, String prefix) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        System.out.println("Prefix count: " + trie.prefixCount(prefix));
    }

}