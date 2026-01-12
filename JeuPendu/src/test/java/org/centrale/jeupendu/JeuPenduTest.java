/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.jeupendu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 *
 * @author dytri
 */
public class JeuPenduTest {
    
    private JeuPendu jeu;
    
    @BeforeEach
    public void setUp() {
        jeu = new JeuPendu(3, "test");
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    

    @Test
    void wordNotFoundAtStart() {
        assertFalse(jeu.wordFound());
    }
    
    @Test
    void wordFoundWhenAllLettersPresent() {
        jeu.setCurrentWord(List.of("t", "e", "s", "t"));
            
        assertTrue(jeu.wordFound());
    }
    
    
    
    @Test
    void correctLetterRevealsPositions() {
        jeu.tryLetter("t");

        assertEquals("t", jeu.getCurrentWord().get(0));
        assertEquals("t", jeu.getCurrentWord().get(3));
    }
    
    @Test
    void wrongLetterIncreasesErrors() {
        jeu.tryLetter("x");
        assertEquals(1, jeu.getErrors());
    }
    
    @Test
    void letterIsStored() {
        jeu.tryLetter("e");
        jeu.tryLetter("x");
        assertTrue(jeu.getLetters().contains("e"));
        assertTrue(jeu.getLetters().contains("x"));
    }
    
    
    
    @Test
    void gameNotOverAtStart() {
        assertFalse(jeu.isOver());
        assertEquals(0, jeu.getState());
    }

    @Test
    void gameLostWhenMaxErrorsReached() {
        jeu.tryLetter("x");
        jeu.tryLetter("y");
        jeu.tryLetter("z");

        assertTrue(jeu.isOver());
        assertEquals(2, jeu.getState()); // défaite
    }
    
    @Test
    void gameWonWhenWordIsFound() {
        jeu.tryLetter("t");
        jeu.tryLetter("e");
        jeu.tryLetter("s");

        assertTrue(jeu.isOver());
        assertEquals(1, jeu.getState()); // victoire
    }    
}
