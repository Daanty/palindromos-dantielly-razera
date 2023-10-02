
package br.palindromo.palindromo;

import br.palindromo.palindromo.model.PalindromeModel;
import br.palindromo.palindromo.repository.PalindromeRepository;
import br.palindromo.palindromo.service.PalindromeFinder;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PalindromeControllerTest {

    @Mock
    private PalindromeFinder palindromeFinder;

    @InjectMocks
    private PalindromeController palindromeController;

    @Mock
    private PalindromeRepository palindromeRepository;

@Test
public void testFindAndStorePalindromes() {
    MatrixRequest request = new MatrixRequest();
    request.setMatrix(new String[][] {
        {"A", "O", "S", "S", "O"},
        {"Y", "R", "Z", "X", "L"},
        {"J", "S", "A", "P", "M"},
        {"J", "K", "P", "R", "Z"},
        {"Y", "L", "E", "R", "A"}
    });    
    
    List<String> expectedPalindromes = Arrays.asList("radar", "level");
    
    when(palindromeRepository.save(any(PalindromeModel.class))).thenReturn(new PalindromeModel());
    when(palindromeFinder.findAllPalindromesInMatrix(any(String[][].class))).thenReturn(expectedPalindromes);
    
    ResponseEntity<List<String>> response = palindromeController.findPalindromes(request);
    List<String> result = (List<String>) response.getBody();

    verify(palindromeRepository, times(expectedPalindromes.size())).save(any(PalindromeModel.class));
    assertEquals(expectedPalindromes, result);
}

    @Test
    public void testFetchPalindromes() {
        String word = "radar";
        PalindromeModel model = new PalindromeModel();
        model.setId("1");
        model.setWord("radar");
        List<PalindromeModel> expectedModels = Arrays.asList(model);
        
        when(palindromeRepository.findByWord(word)).thenReturn(expectedModels);

        List<PalindromeModel> result = palindromeController.getPalindromes(word);

        assertEquals(expectedModels, result);
    }
    
}
