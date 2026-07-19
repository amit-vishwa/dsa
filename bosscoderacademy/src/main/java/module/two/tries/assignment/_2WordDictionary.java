package module.two.tries.assignment;

import java.util.HashMap;

/* Design Add and Search Words Data Structure:
 *
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * Implement the WordDictionary class:
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may
 * contain dots '.' where dots can be matched with any letter.
 *
 * Approach:
 * - The approach is little different than the normal Trie.
 * - We are using a HashMap of character and node, also one flag is used to specify the word has been found.
 * - Now insertion logic is similar to normal Trie.
 * - The search will have node, word and index.
 * - If index reaches the word length, that means we have searched all the characters, so return the flag value.
 * - Now, check if current character is '.', if it is just iterate over the map values and call the same function with
 * new node, word, and index + 1.
 * - If that call is true, then return true else repeat the same for all children, once coming out loop just return false.
 * - Also, if current character is not '.' the do normal search like check is that character present in Trie.
 * - If not then return false, else recursively call the function with new node and next index.
 * - Time complexity: O(N) where N is the word length.
 * - Space complexity: O(N) due to HashMap.
 *
 * Refer: https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 **/
public class _2WordDictionary {

    static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    TrieNode root;

    _2WordDictionary() {
        root = new TrieNode();
    }

    void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, val -> new TrieNode());
        }
        node.isEnd = true;
    }

    boolean search(String word) {
        return helper(root, word, 0);
    }

    private boolean helper(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode cur : node.children.values()) {
                if (helper(cur, word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
        TrieNode cur = node.children.get(c);
        if (cur == null) {
            return false;
        }
        return helper(cur, word, index + 1);
    }

    public static void main(String[] args) {
        _2WordDictionary obj = new _2WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}
