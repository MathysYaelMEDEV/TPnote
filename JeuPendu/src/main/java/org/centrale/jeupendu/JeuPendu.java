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
    
    public JeuPendu(int maxError, String secretWord) {
        this.maxError = maxError;
        this.errors = 0;
        this.secretWord = secretWord;
        this.currentWord = new ArrayList<>(secretWord.length());
        this.letters = new ArrayList<>();
        this.state = 0;
    }
    
    public boolean wordFound(){
        for(String s : this.currentWord){
            if (s == null || "".equals(s)){
                return false;
            }
        }
        return true;
    }
    
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
    
    public void tryLetter(String l){
        boolean found = false;
        for(int i = 0; i < secretWord.length(); i++){
            char c = secretWord.charAt(i);
            if(String.valueOf(c).equals(l)){
                found = true;
                currentWord.set(i,String.valueOf(c));//remplace la lettre dans la liste du mot en recherche
            }
        }
            
        if(found){
            errors++;
            letters.add(l);
        } 
    }

    public int getMaxError() {
        return maxError;
    }

    public void setMaxError(int maxError) {
        this.maxError = maxError;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public List<String> getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(List<String> currentWord) {
        this.currentWord = currentWord;
    }

    public List<String> getLetters() {
        return letters;
    }

    public void setLetters(List<String> letters) {
        this.letters = letters;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
    
}
