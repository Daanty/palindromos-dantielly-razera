
package br.palindromo.palindromo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PalindromeFinder {

    public List<String> findAllPalindromesInMatrix(String[][] stringMatrix) {
        List<String> palindromes = new ArrayList<>();

        // Converte de String[][] para char[][]
        int rows = stringMatrix.length;
        int cols = stringMatrix[0].length;
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String cell = stringMatrix[i][j];
                if (cell == null || cell.length() != 1 || !Character.isLetter(cell.charAt(0))) {
                    throw new IllegalArgumentException("A Matriz so pode conter letras.");
                }
                matrix[i][j] = cell.charAt(0);
            }
        }

        // Procura por palindromo na horizontal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = j; k < cols; k++) {
                    sb.append(matrix[i][k]);
                    String word = sb.toString();
                    if (word.length() >= 2 && isPalindrome(word)) {
                        palindromes.add(word);
                    }
                }
            }
        }

        // Procura por palindromo na vertical
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = j; k < rows; k++) {
                    sb.append(matrix[k][i]);
                    String word = sb.toString();
                    if (word.length() >= 2 && isPalindrome(word)) {
                        palindromes.add(word);
                    }
                }
            }
        }

        // Procura por palindromo diagonal, esquerda superior para direta inferior
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; i + k < rows && j + k < cols; k++) {
                    sb.append(matrix[i + k][j + k]);
                    String word = sb.toString();
                    if (word.length() >= 2 && isPalindrome(word)) {
                        palindromes.add(word);
                    }
                }
            }
        }

        // Procura por palindromo diagonal, esquerda inferior para direta superior
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; i - k >= 0 && j + k < cols; k++) {
                    sb.append(matrix[i - k][j + k]);
                    String word = sb.toString();
                    if (word.length() >= 2 && isPalindrome(word)) {
                        palindromes.add(word);
                    }
                }
            }
        }

        return palindromes;
    }

    public boolean isPalindrome(String str) {
        int i = 0; 
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
