/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeupendu;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dytri
 */
public class GestionDonnees {
    
    private static final SecureRandom random = new SecureRandom();
    
    private static final Logger logger = LoggerFactory.getLogger(Interface.class);
    
    private GestionDonnees() {
        throw new IllegalStateException("Utility class");
    }
    
     /**
     * Lit un fichier texte et retourne la liste de mots (1 mot par ligne)
     *
     * @return StringList contenant tous les mots
     * @throws IOException si le fichier n'existe pas ou ne peut pas être lu
     */
    public static String motAlea() throws IOException {
        String cheminFichier = "src/main/data/dico.txt";
        try{
            Path path = Path.of(cheminFichier);

            List<String> mots = Files.readAllLines(path);
            int index = random.nextInt(mots.size());
        
            return mots.get(index);
        } catch (IOException e){
            logger.info("Vérifiez le dictionnaire ou jouer à deux joueurs");
        }
        return null;
    }
}
