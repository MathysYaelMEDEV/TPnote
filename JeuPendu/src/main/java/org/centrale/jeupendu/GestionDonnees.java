/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeupendu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;


/**
 *
 * @author dytri
 */
public class GestionDonnees {
    
    private static Random random = new Random();
    
     /**
     * Lit un fichier texte et retourne la liste de mots (1 mot par ligne)
     *
     * @return StringList contenant tous les mots
     * @throws IOException si le fichier n'existe pas ou ne peut pas être lu
     */
    public static String motAlea() throws IOException {
        String cheminFichier = "src/main/data/dico.txt";
        Path path = Path.of(cheminFichier);
        
        

        List<String> mots = Files.readAllLines(path);
        int index = random.nextInt(mots.size());
        
        String mot = mots.get(index);
        
        return mot;
    }
    
}
