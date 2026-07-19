package module.two.tries.assignment;

import java.util.HashMap;

/**
 * Prefix and Suffix Search:
 * <p>
 * Design a special dictionary that searches the words in it by a prefix and a suffix.
 * <p>
 * Implement the WordFilter class:
 * WordFilter(string[] words) Initializes the object with the words in the dictionary.
 * f(string pref, string suff) Returns the index of the word in the dictionary, which has the prefix pref and the suffix suff.
 * If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * Output
 * [null, 0]
 * Explanation
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = "e".
 * <p>
 * Approach:
 * - The approach is quite straightforward.
 * - We are using hashmap to keep track of character and nodes, also index is used in trie node to keep track of character indexes.
 * - The insert logic is similar to normal insertion, only while proceeding to next node just keep on updating the index.
 * - The search logic is also same, only the word here will be the concatenation suffix + "#" + prefix.
 * - The main logic is there in constructor we can say, we have to iterate over array of strings using for loop only.
 * - Now update current word by prepending # in front of it, then insert the word along with current index.
 * - Again iterate over current word itself from end and keep on prepending chars to word and inserting with current index only.
 * - Time complexity: O(W) for string array * O(L) average word length = O(W * L)
 * - Space complexity: O(W) for string array * O(2 * L + 1) twice of length = O(W * L)
 * <p>
 * Refer: https://leetcode.com/problems/prefix-and-suffix-search/description/
 */
public class _3WordFilter {

    static class TrieNode {
        HashMap<Character, TrieNode> children;
        int index;

        TrieNode() {
            children = new HashMap<>();
            index = -1;
        }
    }

    TrieNode root = new TrieNode();

    private void insert(String word, int index) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, val -> new TrieNode());
            node.index = index;
        }
    }

    public _3WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String temp = "#" + word;
            insert(temp, i);
            for (int j = word.length() - 1; j >= 0; j--) {
                temp = word.charAt(j) + temp;
                insert(temp, i);
            }
        }
    }

    public int f(String pref, String suff) {
        String word = suff + "#" + pref;
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return -1;
            }
        }
        return node.index;
    }

    public static void main(String[] args) {
        _3WordFilter obj = new _3WordFilter(new String[]{"apple", "mapple", "scramble"});
        System.out.println("Word index containing both prefix and suffix: " + obj.f("a", "e"));
        System.out.println("Word index containing both prefix and suffix: " + obj.f("s", "e"));
        System.out.println("Word index containing both prefix and suffix: " + obj.f("s", "s"));
    }

}