
package br.palindromo.palindromo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ElementCollection;
import java.util.List;

@Entity
public class Palindrome {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ElementCollection
    private List<String> words;

    // Getters and setters
    // ...
}
