//leetcode 208

class Trie {

    class TrieNode{
        TrieNode[] children;
        boolean endOfString;
        public TrieNode(){
            this.children = new TrieNode[26];
            boolean endOfString = false;
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.endOfString = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.endOfString;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(node.children[idx] == null) return false;
            node = node.children[idx];
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
