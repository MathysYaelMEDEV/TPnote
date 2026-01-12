/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.jeupendu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 *
 * @author dytri
 */
class JeuPenduTest {
    
    private JeuPendu jeu;
    
    /**
     * Réinitialise le jeu avant tout les tests
     */
    @BeforeEach
    void setUp() {
        jeu = new JeuPendu(3, "test");
    }
 
    
    /**
     * Test si le mot n'est pas trouvé dès le départ
     */
    @Test
    void wordNotFoundAtStart() {
        assertFalse(jeu.wordFound());
    }
    
    /**
     * Test si le mot est bien trouvé quand le mot courant est égal à ce dernier
     */
    @Test
    void wordFoundWhenAllLettersPresent() {
        jeu.setCurrentWord(List.of("t", "e", "s", "t"));
            
        assertTrue(jeu.wordFound());
    }
    
    
    /**
     * Teste si une lettre correcte change le mot courant
     */
    @Test
    void correctLetterRevealsPositions() {
        jeu.tryLetter("t");

        assertEquals("t", jeu.getCurrentWord().get(0));
        assertEquals("t", jeu.getCurrentWord().get(3));
    }
    
    /**
     * Teste qu'une lettre incorrecte augmente le nombre d'erreur
     */
    @Test
    void wrongLetterIncreasesErrors() {
        jeu.tryLetter("x");
        assertEquals(1, jeu.getErrors());
    }
    
    /**
     * Teste si une lettre essayée est bien stockée, qu'elle soit valide ou non
     */
    @Test
    void letterIsStored() {
        jeu.tryLetter("e");
        jeu.tryLetter("x");
        assertTrue(jeu.getLetters().contains("e"));
        assertTrue(jeu.getLetters().contains("x"));
    }
    
    
    /**
     * Teste que le jeu n'est pas finie au départ
     */
    @Test
    void gameNotOverAtStart() {
        assertFalse(jeu.isOver());
        assertEquals(0, jeu.getState());
    }
    
    /**
     * Teste si le jeu est bien finie et une défaite quand il y a trop d'erreur
     */
    @Test
    void gameLostWhenMaxErrorsReached() {
        jeu.tryLetter("x");
        jeu.tryLetter("y");
        jeu.tryLetter("z");

        assertTrue(jeu.isOver());
        assertEquals(2, jeu.getState()); // défaite
    }
    
    /**
     * Teste si le jeu est bien finie et une victoire quand le mot est trouvé
     */
    @Test
    void gameWonWhenWordIsFound() {
        jeu.tryLetter("t");
        jeu.tryLetter("e");
        jeu.tryLetter("s");

        assertTrue(jeu.isOver());
        assertEquals(1, jeu.getState()); // victoire
    }    
}
