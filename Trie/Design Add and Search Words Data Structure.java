//leetcode 211

class WordDictionary {
    
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        this.root.addTrieWord(word, root);
    }
    
    public boolean search(String word) {
        return this.root.searchTrieWord(word, root);
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
        
    public void addTrieWord(String word, TrieNode root) {
    
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            TrieNode child = node.children[c-'a'];
            if(child==null) {
                child = new TrieNode();
            }
            node.children[c-'a'] = child;
            node = child;
        }
        node.isWord = true;
    }    
    
    public boolean searchTrieWord(String word, TrieNode root) {
    
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(c=='.') {
                for(TrieNode child: node.children) {
                if(child!=null && searchTrieWord(word.substring(i+1, word.length()), child)==true)
                        return true;
                }
                return false;
            }
            node = node.children[c-'a'];
            if(node==null)
                return false;
        }
        return node.isWord==true;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
