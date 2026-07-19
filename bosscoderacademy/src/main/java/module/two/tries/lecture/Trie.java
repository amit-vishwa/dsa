package module.two.tries.lecture;

public class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = this.root;
        for (char ch : word.toCharArray()) {
            if (!temp.containsKey(ch)) {
                temp.put(ch, new TrieNode());
            }
            temp = temp.get(ch);
        }
        temp.setEnd();
    }

    public boolean search(String word) {
        TrieNode temp = this.root;
        for (char ch : word.toCharArray()) {
            if (!temp.containsKey(ch)) {
                return false;
            }
            temp = temp.get(ch);
        }
        return temp.isEnd();
    }

    public boolean prefix(String word) {
        TrieNode temp = this.root;
        for (char ch : word.toCharArray()) {
            if (!temp.containsKey(ch)) {
                return false;
            }
            temp = temp.get(ch);
        }
        return true;
    }

}
