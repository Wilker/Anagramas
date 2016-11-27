/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagramas;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author wilker
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Digite a Palavra  ~~>");
        String palavra = in.nextLine();

        Set<String> anagramas = new HashSet<>();
        generateAnagramas("", palavra, anagramas);
        String words[] = anagramas.toArray(new String[anagramas.size()]);
        Arrays.sort(words);
        System.out.printf("Total de %d anagramas\n",words.length);
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }

    public static void generateAnagramas(String prefix, String word, Set<String> anagrama) {
        if (word.length() <= 1) {
            anagrama.add(prefix.toUpperCase() + word.toUpperCase());
        } else {
            for (int i = 0; i < word.length(); i++) {
                String cur = word.substring(i, i + 1);
                String before = word.substring(0, i);
                String after = word.substring(i + 1);
                generateAnagramas(prefix + cur, before + after, anagrama);
            }
        }
    }
}
