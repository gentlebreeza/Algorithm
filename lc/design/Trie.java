package lc.design;

class TrieNode {
    private final TrieNode[] children;
    private String word;
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        word = "";
    }
    public TrieNode[] getChildren() {
        return children;
    }
    public TrieNode getChild(char c) {
        return children[c-'a'];
    }
    public String getWord() {
        return word;
    }
    public void setChild(char c) {
        children[c-'a'] = new TrieNode();
    }
    public void setWord(String word) {
        this.word = word;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if(curr.getChild(letter) == null) {
                curr.setChild(letter);
            }
            curr = curr.getChild(letter);
        }
        curr.setWord(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if(curr.getChild(letter) == null) return false;
            curr = curr.getChild(letter);
        }
        return curr.getWord().equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if(curr.getChild(letter) == null) return false;
            curr = curr.getChild(letter);
        }
        return true;
    }
}
