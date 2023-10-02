
package br.palindromo.palindromo.repository;

import br.palindromo.palindromo.model.PalindromeModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeRepository extends JpaRepository<PalindromeModel, String> {

    @Query("SELECT p FROM PalindromeModel p WHERE LOWER(p.word) = LOWER(:word)")
    List<PalindromeModel> findByWord(String word);
}
