package br.com.kleyber.trieautocomplete.trie;

import java.util.ArrayList;

public class TrieNode {
    boolean isWord;
    String Text;

    private ArrayList<TrieNode> children;
    private char name;
    private TrieNode parent = null;

    public TrieNode(char name) {
        this.name = name;
        children = new ArrayList<>();
    }


    public TrieNode addChild(char s) {
        TrieNode node = new TrieNode(s);
        return addChild(node);
    }

    public TrieNode addChild(TrieNode node) {
        int i = 0;
        while(i<children.size()){
            if(children.get(i).getName() == node.getName()){
                return node;
            }
            i++;
        }
        children.add(node);
        node.parent = this;
        return node;
    }

    public TrieNode addChildWord(char s) {
        TrieNode node = new TrieNode(s);
        node.isWord = true;
        return addChild(node);
    }

    public ArrayList<TrieNode> getChildren() {
        return children;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public TrieNode busca(char procurado) {
        if (procurado == name) {
            return this;
        }
        for (TrieNode filho : children) {
            TrieNode achou = filho.busca(procurado);
            if (achou != null) {
                return achou;
            }
        }
        return null;
    }
}
