/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Controladores.ControladorPantallas.Listas;

import administrador.Entidades.EntidadesAbstractas.Contenedor;
import administrador.Entidades.Producto;
import java.util.ArrayList;

/**
 * Lista que contiene una lista de productos de una receta y una lista paralela
 * de cantidades. Simula una sola lista que contiene ambos valores.
 *
 * @author Merlin
 */
public class ListaProductos {

    ArrayList<Producto> listProd;
    ArrayList<Integer> listCantidad;

    public ArrayList<Producto> getListProd() {
        return listProd;
    }

    public void setListProd(ArrayList<Producto> listConsum) {
        this.listProd = listConsum;
    }

    public ArrayList<Integer> getListCantidad() {
        return listCantidad;
    }

    public void setListCantidad(ArrayList<Integer> listCantidad) {
        this.listCantidad = listCantidad;
    }

    public ListaProductos() {
        this.listProd = new ArrayList<>();
        this.listCantidad = new ArrayList<>();
    }

    /**
     * Devuelve el producto en la posicion i. Si se ejecuta el metodo
     * getCantidad con el mismo valor i se se obtiene la cantidad de ese
     * producto cargada.
     *
     * @param i Posicion de el producto a obtener
     * @return Un Objeto Producto previamente guardado en la posicion i
     */
    public Producto getProducto(int i) {
        return listProd.get(i);
    }

    /**
     * Devuelve la cantidad de un producto. El valor i es el mismo que en el
     * metodo getProducto.
     *
     * @param i La posicion donde se guardo el producto cuya cantidad queremos
     * determinar
     * @return Un objeto Integer con el valor de el producto en la posicion i
     */
    public Integer getCantidad(int i) {
        return listCantidad.get(i);
    }

    /**
     * Metodo Syncronizado. De no existir en la lista añade el producto y la
     * cantidad en el ultimo lugar de las listas. Por ser sincronizado este
     * metodo se asegura que los valor de ambas listas siempre se correspondan.
     * Si el producto ya esta cargado, le suma el valor de la cantidad ingresada
     * a la cantidad existente.
     *
     * @param producto El producto a agregar o modificar
     * @param cantidad La cantida del producto a agregar.
     */
    public synchronized void addProducto(Producto producto, int cantidad) {
        if (!(listProd.contains(producto))) {
            listProd.add(producto);
            listCantidad.add(cantidad);
        } else {
            Integer cantActual = listCantidad.get(listProd.indexOf(producto)) + cantidad;
            listCantidad.set(listProd.indexOf(producto), cantActual);
        }
    }

    /**
     * Metodo Syncronizado. De no existir en la lista añade el producto y la
     * cantidad en el ultimo lugar de las listas. Por ser sincronizado este
     * metodo se asegura que los valor de ambas listas siempre se correspondan.
     * Si el producto ya esta cargado, le suma el valor de la cantidad ingresada
     * a la cantidad existente. A diferencia del metodo normal, este metodo
     * maneja la conversion de String a los valores correspondientes
     * internamente.
     *
     * @param nombProducto El producto a agregar o modificar
     * @param strCantidad La cantida del producto a agregar.
     */
    public synchronized void addProducto(String nombProducto, String strCantidad) {
        try {
            int cantidad = Integer.valueOf(strCantidad);
            Producto producto = null;
            for (Producto tempProd : Contenedor.LISTPRODUCTO) {
                if (tempProd.getNombre().equals(nombProducto)) {
                    producto = tempProd;
                    break;
                }
            }

            if (!(listProd.contains(producto))) {
                listProd.add(producto);
                listCantidad.add(cantidad);
            } else {
                Integer cantActual = listCantidad.get(listProd.indexOf(producto)) + cantidad;
                listCantidad.set(listProd.indexOf(producto), cantActual);
            }
        } catch (NumberFormatException e) {
            //pendiente de implementar
        }
    }

    /**
     * Busca y de existir remueve la cantidad especificada de producto. Si lo
     * removido es igual o mayor a lo almacenado remueve el producto totalmente.
     *
     * @param producto El producto a borrar.
     * @param cantidad La cantidad de producto a remover.
     */
    public synchronized void delProducto(Producto producto, int cantidad) {

        for (int i = 0; i < listProd.size(); i++) {
            if (listProd.get(i).getNombre().equals(producto.getNombre())) {
                if (cantidad <= listProd.get(i).getCantidad()) {
                    listProd.remove(i);
                    listCantidad.remove(i);
                } else {
                    listProd.get(i).setCantidad(listProd.get(i).getCantidad() - cantidad);
                }
            }
        }
    }

    /**
     * devuelve el tamaño de la lista.
     *
     * @return
     */
    public int getSize() {
        return listProd.size();
    }

}
