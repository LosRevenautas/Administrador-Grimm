/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades.EntidadesAbstractas;

/**
 * Clase padre de todas las entidades. Encargada de administrar los IDs y
 * habilitar polimorfismo.
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
