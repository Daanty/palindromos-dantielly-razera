
package br.palindromo.palindromo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PalindromeModel {

    @Id
    private String id;
    private String word;

    // Getters
    public String getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
