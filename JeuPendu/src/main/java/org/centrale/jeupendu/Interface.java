/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeupendu;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Gère toutes les méthodes relatives à l'interface
 * @author yaelv
 */
public class Interface {
    
    private static final Logger logger = LoggerFactory.getLogger(Interface.class);
    
    private Interface(){
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * Initialise le mot secret selon le mode de jeu souhaité
     * @return le mot secret tiré aléatoirement ou rentré par le joueur selon le mode de jeu choisi
     */
    public static String initMotSecret(){
        String mot = "";
        Scanner scanner = new Scanner(System.in);
        
        logger.info("Sélectionnez le mode de jeu");
        logger.info("1 : Solo");
        logger.info("2 : Deux jouers");

        while(true){
            try{
                
                int mode = scanner.nextInt();
                scanner.nextLine();

                switch(mode){
                    case 1 -> mot = GestionDonnees.motAlea();
                    case 2 -> mot = demandeMotSecret();
                    default -> {
                        logger.info("Entrez 1 ou 2");
                        continue;
                    }
                }
                break;
            } catch (InputMismatchException e) {
                logger.info("Erreur : Saisissez un nombre valide (1 ou 2).");
                scanner.nextLine();
            }
        }
        scanner.close();
        
        return mot;
    }
    
    /**
     * Affiche un mot dans la console
     * 
     * @param mot sous forme de liste de String
     */
    public static void afficheMot(List<String> mot){
        String affichage = "";
        for(int i = 0; i < mot.size(); i++){
            if(mot.get(i)==null){
                affichage = affichage.concat("_ ");
            } else {
                affichage = affichage.concat(mot.get(i)).concat(" ");
            }
        }
        logger.info(affichage);
    }
    
    /**
     * Demande à l'utilisateur de rentrer son mot secret en testant sa validité
     * 
     * 
     */
    private static String demandeMotSecret() {
        String mot;
        Scanner scanner = new Scanner(System.in);
        
        logger.info("Entrez votre mot secret, n'utilisez que les 26 lettres minuscules de l'alphabet");
        
        while(true){
            mot = scanner.nextLine().trim();
            if (contientSeulementLettres(mot)) {
                logger.info("Mot valide");
                for(int i = 0; i < 50; i++){
                    logger.info("Ne regardez pas au dessus pour conserver un intérêt au jeu");
                }
                return mot;
            } else {
                logger.info("Erreur : Le mot ne doit contenir que des lettres minuscules (a-z). Réessayez.");
            }
        }
    }
    
    /**
     * Test si un mot ne contient que les 26 lettres de l'alphabet en minuscule
     * @param mot
     * @return 
     */
    private static boolean contientSeulementLettres(String mot) {
        // Vérifie que le mot n'est pas null et ne contient que des lettres (a-z ou A-Z)
        return mot != null && mot.matches("[a-z]+");
    }
    
    /**
     * Affiche la liste des lettres déjà données par le joueur cherchant le mot
     * 
     * @param listeLettres 
     */
    public static void afficheListeLettre(List<String> listeLettres){
        Collections.sort(listeLettres);
        logger.info(listeLettres.toString());
    }
    
    public static String demandeLettre(){
        String lettre;
        Scanner scanner = new Scanner(System.in);
        
        logger.info("Entrez une lettre à tester, n'utilisez que les 26 lettres minuscules de l'alphabet");
        
        while(true){
            lettre = scanner.nextLine().trim();
            if (estLettreValide(lettre)) {
                return lettre;
            } else {
                logger.info("Erreur : La lettre doit être une lettre minuscule (a-z). Réessayez.");
            }
        }
    }
    
    /**
     * Test si une lettre fait partie des 26 lettres minuscules de l'alphabet
     * @param lettre
     * @return 
     */
    private static boolean estLettreValide(String lettre) {
        // Vérifie que le mot n'est pas null et ne contient que des lettres (a-z ou A-Z)
        return lettre != null && lettre.matches("[a-z]");
    }  
    
}
