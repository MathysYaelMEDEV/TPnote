/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.jeupendu;

import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
}
