/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Controladores.ControladorPantallas;

import administrador.Controladores.ControladorPantallas.TableModels.StockTableModel;
import administrador.Controladores.ControladoresAbstractos.ControladorPantallaAbstracto;
import administrador.Entidades.EntidadesAbstractas.Contenedor;
import administrador.Entidades.Producto;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Merlin
 */
public class ControladorStock extends ControladorPantallaAbstracto {

    /**
     * Intenta crear el producto con los valores provistos. Si los valores son
     * correctos crea el producto y lo añade a la lista.
     *
     * @param nombre el nombre del producto
     * @param precio el precio del producto
     * @param cantidad la cantidad de productos
     * @return true si el producto se creo y false si ocurrio un error
     */
    public static boolean crearProducto(String nombre, String precio, String cantidad) {
        try {
            float cantEnFloat = Float.valueOf(cantidad);
            if (!(nombre == null || nombre.equals("")) && !(precio == null || precio.equals(""))) {

                Producto nuevoProducto = new Producto(nombre, precio, cantEnFloat);
                if (!(Contenedor.LISTPRODUCTO.contains(nuevoProducto))) {
                    Contenedor.LISTPRODUCTO.add(nuevoProducto);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
                //pendiente de implementar manejo de datos
            }
        } catch (NumberFormatException e) {
            return false;
            //Pendiente de implentar manejo de excepcion
        }
    }

    public static void initTabla(JTable tabla, StockTableModel model) {
        tabla.setModel(model);
    }
    /**
     * Dada la posicion de un producto en la lista carga los valores del mismo en los campos de edicion.
     * @param nombre El nombre del producto seleccionado
     * @param precio El precio del producto seleccionado
     * @param cantidad la cantidad disponible del producto seleccionado
     * @param producto la posicion del producto seleccionado
     */
    public static void selectProducto(JTextField nombre, JTextField precio, JTextField cantidad, int producto) {
        nombre.setText(Contenedor.LISTPRODUCTO.get(producto).getNombre());
        precio.setText(String.valueOf(Contenedor.LISTPRODUCTO.get(producto).getPrecio()));
        cantidad.setText(String.valueOf(Contenedor.LISTPRODUCTO.get(producto).getCantidad()));
    }
    /**
     * Verifica si se selecciono un producto de la lista. Y de ser asi carga los valores de los campos de texto al mismo
     * Este metodo se encarga de validar los valores y de manejar la excepcion en caso de valores erroneos.
     * @param nombre El nuevo nombre del producto
     * @param precio El nuevo precio del producto
     * @param cantidad La nueva cantidad disponible del producto
     * @param producto el indice del producto seleccionado
     * @return True si el producto se modifico correctamente y false de no ser asi.
     */
    public static boolean modificarProducto(String nombre, String precio, String cantidad, int producto) {
        if (producto == -1) {
            return false;
        }
        try {
            float cantEnFloat = Float.valueOf(cantidad);
            if (!(nombre == null || nombre.equals("")) && !(precio == null || precio.equals(""))) {
                Contenedor.LISTPRODUCTO.get(producto).setNombre(nombre);
                Contenedor.LISTPRODUCTO.get(producto).setPrecio(precio);
                Contenedor.LISTPRODUCTO.get(producto).setCantidad(cantEnFloat);
                return true;
            } else {
                return false;
                //pendiente de implementar manejo de datos
            }
        } catch (NumberFormatException e) {
            return false;
            //Pendiente de implentar manejo de excepcion
        }
    }
    /**
     * Si el indice de producto es correcto, remueve el producto de la lista
     * @param producto El indice del producto a borrar.
     */
    public static void borrarProducto(int producto) {
        if ((producto != -1) && producto < Contenedor.LISTPRODUCTO.size()) {
            Contenedor.LISTPRODUCTO.remove(producto);
        }
    }
}
