package br.com.kleyber.trieautocomplete;

import br.com.kleyber.trieautocomplete.trie.TrieNode;

import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        TrieNode trie = new TrieNode(' ');
        Scanner leitor = new Scanner(System.in);
        String escolha = "0";

        while(!escolha.equalsIgnoreCase("05")){
            System.out.println("Escolha uma das seguintes opções:");
            System.out.println("      01 - Cadastrar palavra\n      02 - Buscar palavra\n      03 - Remover palavra" +
                    "\n      04 - Autocompletar da palavra\n      05 - Sair do programa");
            System.out.print("Opção: ");
            escolha = leitor.next();

            if (escolha.equalsIgnoreCase("01")){
                adicionaPalavra(trie);
            } else if (escolha.equalsIgnoreCase("02")){
                buscaPalavra(trie);
            } else if(escolha.equalsIgnoreCase("03")){
                removePalavra(trie);
            } else if (escolha.equalsIgnoreCase("04")){
            }
        }
    }

    public static void adicionaPalavra(TrieNode trie){
        Scanner leitor1 = new Scanner(System.in);
        String palavra;
        System.out.print("Digite a palavra: ");
        palavra = leitor1.next();
        trie.addChild(palavra);
    }

    public static void buscaPalavra(TrieNode trie){
        Scanner leitor2 = new Scanner(System.in);
        String palavraBusca;
        System.out.print("Digite a palavra: ");
        palavraBusca = leitor2.next();
        TrieNode achou = new TrieNode();
        String palavraFinal = new String();
        int i = 0;
        while(i < palavraBusca.length()) {
            achou = trie.busca(trie, palavraBusca.charAt(i));
            if (achou != null) {
                if(i == palavraBusca.length()-1){
                    if(!achou.isWord){
                        palavraFinal = " ";
                    }
                }
                palavraFinal += achou.getName();
                i++;
            }
        }
        if(palavraFinal.equalsIgnoreCase(palavraBusca)){
            System.out.println("Palavra Encontrada");
        } else {
            System.out.println("Palavra não encontrada");
        }
    }

    public static void removePalavra(TrieNode trie){
        Scanner leitor2 = new Scanner(System.in);
        String palavraRemove;
        System.out.print("Digite a palavra: ");
        palavraRemove = leitor2.next();
        TrieNode remove = new TrieNode();
        remove = trie.busca(trie, palavraRemove.charAt(palavraRemove.length()-1));
        if(remove != null){
            remove.isWord  = false;
            System.out.println("Palavra Removida com sucesso!");
        } else {
            System.out.println("Palavra Não Encontrada!");
        }
    }
}
