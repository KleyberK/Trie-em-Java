package br.com.kleyber.trieautocomplete.trie;

import java.util.ArrayList;

public class TrieNode {
    public boolean isWord;
    String Text;
    public ArrayList<TrieNode> children;
    private char name;
    private TrieNode parent = null;

    public TrieNode(){
        this.isWord = false;
    }

    public TrieNode(char name) {
        this.name = name;
        children = new ArrayList<>();
    }


    public void addChild(String palavra) {
        for(int i = 0; i < palavra.length(); i++){
            char p = palavra.charAt(i);
            int j = 0;
            while(j<children.size()){
                if(children.get(j).getName() == p){
                    i++;
                    TrieNode nodeFilho = new TrieNode(palavra.charAt(i));
                    nodeFilho.parent = this;
                    addChild(nodeFilho);
                }
                j++;
            }
            if(i == palavra.length() -1){
                this.addChildWord(p);
            } else {
                TrieNode node = new TrieNode(p);
                addChild(node);
            }

        }
    }

    public TrieNode addChild(TrieNode node) {
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

    public TrieNode busca(TrieNode pai, char procurado) {
        if (procurado == name) {
            return this;
        }
        for (TrieNode filho : pai.children) {
            TrieNode achou = filho.busca(procurado);
            if (achou != null) {
                return achou;
            } else{
                TrieNode achou2 = filho.busca(filho, procurado);
                if (achou2 != null){
                    return achou2;
                }
            }
        }
        return null;
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
