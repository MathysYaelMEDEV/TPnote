/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeupendu;

/**
 *
 * @author dytri
 */
public class Jeu {
    
    public static void main(String[] args){
        
        Interface.afficherIntro();
        
        //choisi parametre de la partie
        String motSecret = "";
        int maxErreur = 6;
        while(true){
            try{
                motSecret = Interface.initMotSecret();
                maxErreur = Interface.initMaxErreur();
                break;
            }catch (Exception e){
                continue;
            }
        }
        
        JeuPendu jeu = new JeuPendu(maxErreur, motSecret);
        
        boolean partie_finie = false;
        
        while(!partie_finie){
            
            Interface.afficheListeLettre(jeu.getLetters());
            Interface.afficheMot(jeu.getCurrentWord());
            Interface.afficheErreurRestantes(jeu.getMaxError(), jeu.getErrors());
            
            String l = Interface.demandeLettre();
            jeu.tryLetter(l);
            
            partie_finie = jeu.isOver();
            int etat = jeu.getState();
            if (etat > 0){
                Interface.afficheEtat(etat, jeu.getSecretWord());
            }
        }

        
    }
}
