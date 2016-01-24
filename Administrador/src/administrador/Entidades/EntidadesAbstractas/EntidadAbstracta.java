/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades.EntidadesAbstractas;

import administrador.Entidades.Mesa;
import java.util.ArrayList;

/**
 *
 * @author Merlin
 */
public abstract class EntidadAbstracta {

    private int ID = 0;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        if (this.ID == 0) {
            this.ID = ID;
        }

    }
}
