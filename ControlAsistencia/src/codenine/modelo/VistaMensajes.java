/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codenine.modelo;

import javax.swing.UIManager;

/**
 *
 * @author Francisco Ninus
 */
public class VistaMensajes {
       public VistaMensajes() {
    }
    
    public  static void mensaje() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
    }
}
