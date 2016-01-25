/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades;

import administrador.Entidades.EntidadesAbstractas.Consumision;
import java.math.BigDecimal;

/**
 * Es una clase hija de la clase Consumision. Solo agrega la implementacion del
 * metodo equals que compara los productos por nombre.
 *
 * @author Merlin
 */
public class Producto extends Consumision {

    private String nombre;
    private BigDecimal precio;
    private int cantidad;

    public Producto(String nombre, String precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public boolean equals(Object o) {
        if (this.getNombre().equals(((Producto) o).getNombre())) {
            return true;
        } else {
            return false;
        }
    }

}
