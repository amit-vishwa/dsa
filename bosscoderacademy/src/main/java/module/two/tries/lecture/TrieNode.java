package module.two.tries.lecture;

public class TrieNode {

    private TrieNode[] trieNodes;
    private boolean isEnd;

    public TrieNode() {
        this.trieNodes = new TrieNode[26];
        this.isEnd = false;
    }

    public boolean containsKey(char ch) {
        return this.trieNodes[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode trieNode) {
        this.trieNodes[ch - 'a'] = trieNode;
    }

    public TrieNode get(char ch) {
        return this.trieNodes[ch - 'a'];
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

}
