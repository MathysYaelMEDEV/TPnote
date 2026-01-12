/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.jeupendu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yael&mathys
 */
public class JeuPendu {
    
    private int maxError;
    private int errors;
    private String secretWord;
    private List<String> currentWord;
    private List<String> letters;
    private int state;// 0 = en cours, 1 = victoire du joueur qui cherche, 2 = défaite
    
    /**
     * Constructeur du jeu
     * 
     * @param maxError le nombre maximal d'erreur
     * @param secretWord le mot secret
     */
    public JeuPendu(int maxError, String secretWord) {
        this.maxError = maxError;
        this.errors = 0;
        this.secretWord = secretWord;
        this.currentWord = new ArrayList<>(secretWord.length());
        for (int i = 0; i < secretWord.length(); i++) {
            this.currentWord.add(null);
        }
        this.letters = new ArrayList<>();
        this.state = 0;
    }
    
    /**
     * Teste si le mot a été trouvé
     * 
     * @return booleen indiquant si le mot a été trouvé
     */
    private boolean wordFound(){
        for(String s : this.currentWord){
            if (s == null){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Teste si la partie est finie
     * 
     * @return booleen indiquant si la partie est finie
     */
    
    public boolean isOver(){
        
        if(errors == maxError){ //défaite
            state = 2;
            return true;
        }
        
        if(! wordFound()){ //en cours
            return false;
        }else{ // victoire
            state = 1;
            return true;
        }
        
    }
    
    /**
     * Teste la lettre l pour le mot secret
     * Met à jour les lettres déjà essayées, le mot courant et les erreurs
     * 
     * @param l 
     */
    public void tryLetter(String l){
        boolean found = false;
        for(int i = 0; i < secretWord.length(); i++){
            char c = secretWord.charAt(i);
            if(String.valueOf(c).equals(l)){
                found = true;
                currentWord.set(i,String.valueOf(c));//remplace la lettre dans la liste du mot en recherche
            }
        }
            
        if(!found){
            errors++;
        } 
        
        letters.add(l);
    }
    
    /**
     * 
     * @return 
     */
    public int getMaxError() {
        return maxError;
    }
    
    /**
     * 
     * @param maxError 
     */
    public void setMaxError(int maxError) {
        this.maxError = maxError;
    }
    
    /**
     * 
     * @return 
     */
    public int getErrors() {
        return errors;
    }

    /**
     * 
     * @param errors 
     */
    public void setErrors(int errors) {
        this.errors = errors;
    }

    /**
     * 
     * @return 
     */
    public String getSecretWord() {
        return secretWord;
    }

    /**
     * 
     * @param secretWord 
     */
    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    /**
     * 
     * @return 
     */
    public List<String> getCurrentWord() {
        return currentWord;
    }

    /**
     * 
     * @param currentWord 
     */
    public void setCurrentWord(List<String> currentWord) {
        this.currentWord = currentWord;
    }

    /**
     * 
     * @return 
     */
    public List<String> getLetters() {
        return letters;
    }

    /**
     * 
     * @param letters 
     */
    public void setLetters(List<String> letters) {
        this.letters = letters;
    }

    /**
     * 
     * @return 
     */
    public int getState() {
        return state;
    }

    /**
     * 
     * @param state 
     */
    public void setState(int state) {
        this.state = state;
    }
    
    
    
}
