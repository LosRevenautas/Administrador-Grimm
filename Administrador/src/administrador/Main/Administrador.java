/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Main;

import administrador.Pantallas.PantallaPrincipal;
import javax.swing.SwingUtilities;

/**
 *
 * @author nunezput
 */
public class Administrador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        PantallaPrincipal principal = new PantallaPrincipal();
        principal.setVisible(true);
    }
});
        
    }
    
}
