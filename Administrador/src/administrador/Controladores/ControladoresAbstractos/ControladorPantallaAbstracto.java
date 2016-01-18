/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Controladores.ControladoresAbstractos;

import administrador.Pantallas.PantallasAbstractas.PantallaAbstracta;

/**
 *
 * @author Merlin
 */
public abstract class ControladorPantallaAbstracto {

    public static void doCambiar(PantallaAbstracta este, PantallaAbstracta anterior) {
        anterior.setPantallaAnterior(este);
        anterior.setBounds(este.getBounds());
        este.setVisible(false);
        anterior.setVisible(true);
    }
}
