/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.jeupendu;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yaelv
 */
public class Interface {
    
    private static final Logger logger = LoggerFactory.getLogger(Interface.class);
    
    public String initMotSecret(){
        String mot = null;
        
        
        return mot;
    }
    
    public void afficheMot(List<String> mot){
        for(int i = 0; i < mot.size(); i++){
            if(mot.get(i)==null){
                logger.info("_");
            } else {
                logger.info(mot.get(i));
            }
        }
    }
}
