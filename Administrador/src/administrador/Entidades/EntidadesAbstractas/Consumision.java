/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades.EntidadesAbstractas;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Clase padre de Producto y Receta. Utilizada para englobar ambas en las situaciones donde no es necesario tratar la 
 * receta como tal y para implementar comportamientos correspondientes a las dos.
 * @author Merlin
 */
public class Consumision extends EntidadAbstracta {

    private String nombre;
    private BigDecimal precio;
    private float cantidad;

    public Consumision(String nombre, String precio, float cantidad) {
        this.nombre = nombre;
        this.precio = new BigDecimal(precio);
        this.precio = this.precio.setScale(2, RoundingMode.UP);
        this.cantidad = cantidad;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
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
    
    public void setPrecio(String precio) {
        this.precio = new BigDecimal(precio);
        this.precio = this.precio.setScale(2, RoundingMode.UP);
    }
}
