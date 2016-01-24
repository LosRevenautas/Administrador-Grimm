/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades;

import administrador.Entidades.EntidadesAbstractas.Consumision;
import administrador.Entidades.EntidadesAbstractas.EntidadAbstracta;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Merlin
 */
public class Receta extends Consumision {

    private Map<Producto, Integer> prodList = new LinkedHashMap<Producto, Integer>();
    private String nombre;
    private BigDecimal precio;

    public Receta(String nombre, String precio, LinkedHashMap prodList) {
        super(nombre, precio, 0);
        this.prodList = prodList;
    }

    public Map getProdList() {
        return prodList;
    }

    public void addProducto(Producto producto, int cantidad) {
        if (prodList.containsKey(producto)) {
            prodList.put(producto, prodList.get(producto) + cantidad);
        } else {
            prodList.put(producto, cantidad);
        }
    }

}
