/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Controladores.ControladoresAbstractos;

import administrador.Pantallas.PantallasAbstractas.PantallaAbstracta;

/**
 * Clase padre de todos los otros controladores. Implementa el metodo doCambiar.
 * @author Merlin
 */
public abstract class ControladorPantallaAbstracto {
        /**
         * Cambia de la ventana actual a la ventana anterior, replicando tamaño y posicion.
         * @param este la ventana actual
         * @param anterior la ventana a la que nos vamos a cambiar
         */
    public static void doCambiar(PantallaAbstracta este, PantallaAbstracta anterior) {
        anterior.setPantallaAnterior(este);
        anterior.setBounds(este.getBounds());
        este.setVisible(false);
        anterior.setVisible(true);
    }
}
