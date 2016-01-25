/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades;

import administrador.Controladores.ControladorPantallas.Listas.ListaProductos;
import administrador.Entidades.EntidadesAbstractas.Consumision;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Clase hija de Consumision. Representa una receta o plato de comida. Añade una
 * lista de ingredientes y la funcionalidad de añadir productos a la receta,
 * obtener el costo y el precio de la receta.
 *
 * @author Merlin
 */
public class Receta extends Consumision {

    private final ListaProductos listProd;
    private String nombre;
    private BigDecimal precio;

    public Receta(String nombre, String precio, ListaProductos prodList) {
        super(nombre, precio, 0);
        this.listProd = prodList;
    }

    public ListaProductos getProdList() {
        return listProd;
    }

    /**
     * Calcula y devuelve el costo de hacer esta receta, con una precision de 2
     * decimales.
     *
     * @return Un BigDecimal con precision de dos digitos y metodo de redondeo
     * hacia arriba.
     */
    public BigDecimal getCosto() {
        return this.calcPrecioReceta();
    }

    public void addProducto(Producto producto, int cantidad) {
        listProd.addProducto(producto, cantidad);
    }

    public void delProducto(Producto producto, int cant) {
        listProd.delProducto(producto, cant);
    }

    /**
     * Metodo privado que recorre la lista de productos de la receta, los
     * multiplica por las cantidades y devuelve el precio.
     *
     * @return Devuelve un BigDecimal con dos decimales de precision y metodo de
     * redeondeo hacia arriba.
     */
    private BigDecimal calcPrecioReceta() {
        BigDecimal total = new BigDecimal(0);
        total = total.setScale(2, RoundingMode.UP);
        BigDecimal multiplicand;
        Producto prod;
        int cant;
        for (int i = 0; i < listProd.getSize(); i++) {
            prod = listProd.getProducto(i);
            cant = listProd.getCantidad(i);
            multiplicand = new BigDecimal(cant);
            multiplicand = multiplicand.setScale(1, RoundingMode.DOWN);
            total = total.add(prod.getPrecio().multiply(multiplicand));
        }
        return total.setScale(2, RoundingMode.UP);
    }

}
