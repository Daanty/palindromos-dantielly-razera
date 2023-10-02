package br.palindromo.palindromo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.palindromo.palindromo.service.PalindromeFinder;

@SpringBootTest
public class PalindromeFinderTest {

     @Test
    public void testIsPalindrome() {
        PalindromeFinder palindromeFinder = new PalindromeFinder();
        assertTrue(palindromeFinder.isPalindrome("racecar"));
        assertTrue(palindromeFinder.isPalindrome("deified"));
        assertTrue(palindromeFinder.isPalindrome("level"));
        assertFalse(palindromeFinder.isPalindrome("hello"));
        assertFalse(palindromeFinder.isPalindrome("world"));
    }

    @Test
    public void testFindAllPalindromesInMatrix() {
        PalindromeFinder palindromeFinder = new PalindromeFinder();
        String[][] matrix = {
            {"A", "O", "S", "S", "O"},
            {"Y", "R", "Z", "X", "L"},
            {"J", "S", "A", "P", "M"},
            {"J", "K", "P", "R", "Z"},
            {"Y", "L", "E", "R", "A"}
        };
        List<String> expected = Arrays.asList("OSSO", "SS", "YJJY", "JJ", "RR", "ARA", "ARARA", "RAR", "ZPZ", "ARA", "LPPL", "PP", "SZS");
        List<String> actual = palindromeFinder.findAllPalindromesInMatrix(matrix);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testInvalidCharacterInMatrix() {
        PalindromeFinder palindromeFinder = new PalindromeFinder();
        String[][] matrix = {
            {"A", "O", "S", "S", "O"},
            {"Y", "R", "Z", "X", "L"},
            {"J", "S", "A", "P", "M"},
            {"J", "K", "P", "R", "Z"},
            {"Y", "L", "E", "R", "1"} // Invalid character
        };
        assertThrows(IllegalArgumentException.class, () -> {
            palindromeFinder.findAllPalindromesInMatrix(matrix);
        });
    }
}
