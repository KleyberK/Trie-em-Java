package br.com.kleyber.trieautocomplete;

import br.com.kleyber.trieautocomplete.trie.TrieNode;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TrieNode trie = new TrieNode(' ');
        Scanner leitor = new Scanner(System.in);
        String palavra;
        for(int i = 0; i < 2; i++){
            System.out.print("Digite uma palavra: ");
            palavra = leitor.next();
            adicionaPalavra(trie, palavra);
        }
        ArrayList<TrieNode> Children = new ArrayList<>(trie.getChildren());
        for(int i = 0; i < Children.size(); i++){
            System.out.println(Children.get(i).getName());
        }
    }

    public static void adicionaPalavra(TrieNode trie, String palavra){
        for(int i = 0; i < palavra.length(); i++){
            char p = palavra.charAt(i);
            if(i == palavra.length() -1){
                trie.addChildWord(p);
            } else {
                trie.addChild(p);
            }
        }
    }
}
