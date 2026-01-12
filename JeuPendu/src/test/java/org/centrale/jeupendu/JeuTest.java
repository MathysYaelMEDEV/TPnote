/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.jeupendu;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JeuTest {

    private final InputStream systemIn = System.in;

    @BeforeEach
    void setUp() {
        // sauvegarde du System.in
        System.setIn(systemIn);
    }

    @AfterEach
    void restoreSystemIn() {
        // restauration après test
        System.setIn(systemIn);
    }

    /**
     * Test que le main ne plante pas avec des entrées simulées
     */
    @Test
    void mainNeDoitPasLeverException() {
        // Simule les entrées utilisateur pour initMotSecret et initMaxErreur
        // Exemple : choix mode solo (1), max erreur = 5, et lettres 'a', 'b', 'c', ...
        String simulatedInput = "1\n5\na\nb\nc\nd\ne\nf\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> Jeu.main(new String[]{}));
    }
}
