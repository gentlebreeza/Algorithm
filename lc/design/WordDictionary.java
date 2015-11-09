package lc.design;

public class WordDictionary {
    private TrieNodes root;
    public WordDictionary() {
        root = new TrieNodes();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNodes curr = root;
        for(char c : word.toCharArray()) {
            if(curr.getChild(c-'a') == null) {
                curr.setChild(c-'a');
            }
            curr = curr.getChild(c-'a');
        }
        curr.setWord(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word, root, 0);
    }
    
    private boolean find(String word, TrieNodes root, int pos) {
        if(pos == word.length()) {
            return !root.getWord().equals("");
        }
        
        char c = word.charAt(pos);
        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                if(root.getChild(i) != null && find(word, root.getChild(i), pos+1)) {
                    return true;
                }
            }
            return false;
        } else {
            return root.getChild(c-'a') != null && find(word, root.getChild(c-'a'), pos+1);
        }
    }
    
}


class TrieNodes {
    private final TrieNodes[] children;
    private String word;
    
    public TrieNodes() {
        children = new TrieNodes[26];
        word = "";
    }
    
    public TrieNodes[] getChildren() {
        return children;
    }
    
    public String getWord() {
        return word;
    }
    
    public TrieNodes getChild(int i) {
        return children[i];
    }
    
    public void setChild(int i) {
        children[i] = new TrieNodes();
    }
    
    public void setWord(String word) {
        this.word = word;
    }
}