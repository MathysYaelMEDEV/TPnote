/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.jeupendu;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author yaelv
 */
class InterfaceTest {
    
    /**
     * Test de la méthode contientSeulementLettres via réflexion
     */
    @Test
    void testMotValide() throws Exception {
        var method = Interface.class.getDeclaredMethod("contientSeulementLettres", String.class);
        method.setAccessible(true);

        assertTrue((boolean) method.invoke(null, "pendu"));
        assertFalse((boolean) method.invoke(null, "Pendu"));
        assertFalse((boolean) method.invoke(null, "pen1du"));
        assertFalse((boolean) method.invoke(null, ""));
        assertFalse((boolean) method.invoke(null, (Object) null));
    }

    /**
     * Test de la validation d’une lettre
     */
    @Test
    void testLettreValide() throws Exception {
        var method = Interface.class
                .getDeclaredMethod("estLettreValide", String.class);
        method.setAccessible(true);

        assertTrue((boolean) method.invoke(null, "a"));
        assertFalse((boolean) method.invoke(null, "A"));
        assertFalse((boolean) method.invoke(null, "ab"));
        assertFalse((boolean) method.invoke(null, "1"));
        assertFalse((boolean) method.invoke(null, ""));
        assertFalse((boolean) method.invoke(null, "é"));
    }

    /**
     * Test de demandeLettre avec une entrée valide
     */
    @Test
    void testDemandeLettreValide() {
        String input = "b\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String lettre = Interface.demandeLettre();
        assertEquals("b", lettre);
    }

    /**
     * Test de demandeLettre avec entrée invalide puis valide
     */
    @Test
    void testDemandeLettreInvalidePuisValide() {
        String input = "1\nA\nc\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String lettre = Interface.demandeLettre();
        assertEquals("c", lettre);
    }

    /**
     * Test affichage du mot (pas d’assertion sur la console, juste vérification d’absence d’erreur)
     */
    @Test
    void testAfficheMot() {
        List<String> mot = new ArrayList<>();
        mot.add("p");
        mot.add(null);
        mot.add("n");

        assertDoesNotThrow(() -> Interface.afficheMot(mot));
    }

    /**
     * Test affichage de la liste de lettres
     */
    @Test
    void testAfficheListeLettre() {
        List<String> lettres = new ArrayList<>();
        lettres.add("z");
        lettres.add("a");
        lettres.add("m");

        assertDoesNotThrow(() -> Interface.afficheListeLettre(lettres));
    }
    
    /**
     * Test non instanciation d'Interface
     */
    @Test
    void testConstructeurInterface() throws Exception{
        var constructor = Interface.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        assertThrows(Exception.class, constructor::newInstance);
    }
    
    /**
     * Test renvoi d'un mot dans le mode solo
     */
    @Test
    void initMotSecretModeSolo() throws IOException {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));

        String mot = Interface.initMotSecret();

        assertNotNull(mot);
    }
    
    /**
     * Test renvoi du mot passé en argument
     */
    @Test
    void initMotSecretModeDeuxJoueurs() throws IOException {
        System.setIn(new ByteArrayInputStream("2\npendu\n".getBytes()));

        String mot = Interface.initMotSecret();

        assertEquals("pendu", mot);
    }
    
    /**
     * Test entrée invalide puis valide
     */
    @Test
    void initMotSecretEntreeInvalidePuisValide() throws IOException {
        System.setIn(new ByteArrayInputStream("abc\n1\n".getBytes()));

        String mot = Interface.initMotSecret();

        assertNotNull(mot);
    }
    
    /**
     * Test entrée invalide puis valide
     */
    @Test
    void initMaxErreurEntreeInvalidePuisValide() throws IOException {
        System.setIn(new ByteArrayInputStream("abc\n6\n".getBytes()));

        int maxErreur = Interface.initMaxErreur();

        assertNotNull(maxErreur);
    }
    
    /**
     * Test methode afficherIntro ne lève pas exception
     */
    @Test
    void afficherIntroNeDoitPasLeverException() {
        assertDoesNotThrow(() -> Interface.afficherIntro());
    }
}
