/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades;

import administrador.Entidades.EntidadesAbstractas.EntidadAbstracta;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Merlin
 */
public class Receta extends EntidadAbstracta {

    private Map<Producto, Integer> prodList = new LinkedHashMap<Producto, Integer>();
    private String nombre;
    private BigDecimal precio;

    public Receta(String nombre, BigDecimal precio, LinkedHashMap prodList) {
        this.nombre = nombre;
        this.precio = precio;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

}
