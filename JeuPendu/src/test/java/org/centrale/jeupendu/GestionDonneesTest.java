/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.jeupendu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;



/**
 *
 * @author dytri
 */
class GestionDonneesTest {
    
    
    /**
     * Test of motAlea method, of class GestionDonnees.
     */
    @Test
    void testMotAleaDicoTrouve() {
        try {
            // Lire le fichier pour comparer
            String cheminFichier = "src/main/data/dico.txt";
            Path path = Path.of(cheminFichier);
            List<String> mots = Files.readAllLines(path);

            assertFalse(mots.isEmpty(), "Le dictionnaire ne doit pas être vide");

            String mot = GestionDonnees.motAlea();

            assertNotNull(mot, "Le mot retourné ne doit pas être null");
            assertFalse(mot.isEmpty(), "Le mot retourné ne doit pas être vide");
            assertTrue(mots.contains(mot), "Le mot retourné doit appartenir au dictionnaire");

        } catch (IOException e) {
            fail("Impossible de lire le fichier du dictionnaire : " + e.getMessage());
        }
    }
    
    /**
     * Test non instanciation de GestionDonnees
     */
    @Test
    void testConstructeurGestionDonnees() throws Exception{
        var constructor = Interface.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        assertThrows(Exception.class, constructor::newInstance);
    }
}
