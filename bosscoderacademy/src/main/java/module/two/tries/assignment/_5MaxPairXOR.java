package module.two.tries.assignment;

// Refer _4MaxPairXOR.java from package module.two.trie.notes.
public class _5MaxPairXOR {

    static class TrieNode {
        TrieNode[] binary = new TrieNode[2];
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(int num) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.binary[bit] == null) {
                    node.binary[bit] = new TrieNode();
                }
                node = node.binary[bit];
            }
        }

        int xor(int num) {
            int xor = 0;
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.binary[1 - bit] != null) {
                    xor = xor | (1 << i);
                    node = node.binary[1 - bit];
                } else {
                    node = node.binary[bit];
                }
            }
            return xor;
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insert(num);
        }
        int maximumXOR = 0;
        for (int num : nums) {
            maximumXOR = Math.max(maximumXOR, trie.xor(num));
        }
        return maximumXOR;
    }

    public static void main(String[] args) {
        System.out.println("Maximum xor is " + new _5MaxPairXOR().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println("Maximum xor is " + new _5MaxPairXOR().findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
    }

}