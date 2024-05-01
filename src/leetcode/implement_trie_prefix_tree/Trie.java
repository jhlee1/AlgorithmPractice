package leetcode.implement_trie_prefix_tree;

// 208. Implement Trie (Prefix tree) https://leetcode.com/problems/implement-trie-prefix-tree/description/

import java.util.HashMap;
import java.util.Map;

class Trie {
    class Node {
        Map<Character, Node> children;
        boolean endOfWord;

        public Node() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode.children.putIfAbsent(c, new Node());
            currentNode = currentNode.children.get(c);
        }
        currentNode.endOfWord = true;
    }

    public boolean search(String word) {
        Node currentNode = root;
        for (char c : word.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.children.get(c);
        }

        return currentNode.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Node currentNode = root;
        for (char c : prefix.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.children.get(c);
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
