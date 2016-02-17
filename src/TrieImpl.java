/**
 * Created by PV029500 on 2/16/2016.
 */
public class TrieImpl {
    public static void main(String args[]) {
        Trie t = new Trie();
        t.insert("hello");
        System.out.println("\n" + t.search("hello"));
    }
}

class TrieNode {
    // Initialize your data structure here.
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
    char letter;
    public TrieNode() {

    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode tmp = root;
        for(int i = 0; i < word.length(); i++) {
            if (tmp.children[word.charAt(i) - 'a'] == null) {
                tmp.children[word.charAt(i) - 'a'] = new TrieNode();
                tmp.letter = word.charAt(i);
            }

            tmp = tmp.children[word.charAt(i)  - 'a'];
        }
        tmp.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode tmp = root;
        String str = "";
        for (int i = 0; i < word.length(); i++) {
            if (tmp.children[word.charAt(i) - 'a'] != null) {
                str += tmp.letter;
                tmp = tmp.children[word.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        System.out.print(str);
        return tmp.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (tmp.children[prefix.charAt(i) - 'a'] != null) {
                tmp = tmp.children[prefix.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}