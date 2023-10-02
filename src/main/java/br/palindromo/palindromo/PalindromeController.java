
package br.palindromo.palindromo;

import br.palindromo.palindromo.model.PalindromeModel;
import br.palindromo.palindromo.repository.PalindromeRepository;
import br.palindromo.palindromo.service.PalindromeFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PalindromeController {

    @Autowired
    private PalindromeFinder palindromeFinder;

     @Autowired
    private PalindromeRepository palindromeRepository;

    @Autowired
        public void setPalindromeFinder(PalindromeFinder palindromeFinder) {
        this.palindromeFinder = palindromeFinder;
    }


    @PostMapping("/findPalindromes")
    public ResponseEntity findPalindromes(@RequestBody MatrixRequest request) {
        
        try{
            if (request == null) {
                throw new IllegalArgumentException("Request body cannot be null");
            }

            String[][] matrix = request.getMatrix();
            if (matrix == null) {
                throw new IllegalArgumentException("Matrix cannot be null");
            }

            List<String> palindromes = palindromeFinder.findAllPalindromesInMatrix(matrix);
            if (palindromes == null) {
                throw new IllegalArgumentException("Palindromes list cannot be null");
            }

            for (String palindrome : palindromes) {
                PalindromeModel model = new PalindromeModel();
                model.setId(UUID.randomUUID().toString());
                model.setWord(palindrome);
                palindromeRepository.save(model);
            }
            return new ResponseEntity<>(palindromes, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }

    @GetMapping("/getPalindromes")
    public List<PalindromeModel> getPalindromes(@RequestParam(required = false) String word) {
        if (word != null && !word.isEmpty()) {
            return palindromeRepository.findByWord(word);
        }
        return palindromeRepository.findAll();
    }

}
