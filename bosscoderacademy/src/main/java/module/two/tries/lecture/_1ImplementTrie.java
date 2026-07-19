package module.two.tries.lecture;

// Refer: https://leetcode.com/problems/implement-trie-prefix-tree/description/
public class _1ImplementTrie {

    static class TrieNode {
        TrieNode[] node;
        boolean isEnd;

        public TrieNode() {
            node = new TrieNode[26];
            isEnd = false;
        }

        public boolean containsKey(char c) {
            return node[c - 'a'] != null;
        }

        public void put(char c, TrieNode node) {
            this.node[c - 'a'] = node;
        }

        public TrieNode get(char c) {
            return node[c - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    static class Trie {
        TrieNode node;

        public Trie() {
            node = new TrieNode();
        }

        public void insert(String word) {
            TrieNode temp = node;
            for (char c : word.toCharArray()) {
                if (!temp.containsKey(c)) {
                    temp.put(c, new TrieNode());
                }
                temp = temp.get(c);
            }
            temp.setEnd();
        }

        public boolean search(String word) {
            TrieNode temp = node;
            for (char c : word.toCharArray()) {
                if (!temp.containsKey(c)) {
                    return false;
                }
                temp = temp.get(c);
            }
            return temp.isEnd();
        }

        public boolean startsWith(String prefix) {
            TrieNode temp = node;
            for (char c : prefix.toCharArray()) {
                if (!temp.containsKey(c)) {
                    return false;
                }
                temp = temp.get(c);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abacus");
        trie.insert("alphabet");
        trie.insert("alphabetical");
        System.out.println(trie.search("alpha"));
        System.out.println(trie.search("alphabet"));
        System.out.println(trie.startsWith("alpha"));
        System.out.println(trie.search("alphabets"));
    }

}
