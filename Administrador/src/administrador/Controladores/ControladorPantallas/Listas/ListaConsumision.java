/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Controladores.ControladorPantallas.Listas;

import administrador.Entidades.EntidadesAbstractas.Consumision;
import administrador.Entidades.EntidadesAbstractas.Contenedor;
import java.util.ArrayList;

/**
 * Lista que contiene una lista de consumisiones y una lista paralela de
 * cantidades. Simula una sola lista que contiene ambos valores.
 *
 * @author Merlin
 */
public class ListaConsumision {

    ArrayList<Consumision> listConsum;
    ArrayList<Float> listCantidad;

    public ArrayList<Consumision> getListConsum() {
        return listConsum;
    }

    public void setListConsum(ArrayList<Consumision> listConsum) {
        this.listConsum = listConsum;
    }

    public ArrayList<Float> getListCantidad() {
        return listCantidad;
    }

    public void setListCantidad(ArrayList<Float> listCantidad) {
        this.listCantidad = listCantidad;
    }

    public ListaConsumision() {
        this.listConsum = new ArrayList<>();
        this.listCantidad = new ArrayList<>();
    }

    /**
     * Devuelve la consumision en la posicion i. Si se ejecuta el metodo
     * getCantidad con el mismo valor i se se obtiene la cantidad de esa
     * consumision cargada.
     *
     * @param i Posicion de la consumision a obtener
     * @return Un Objeto Consumision previamente guardado en la posicion i
     */
    public Consumision getConsumision(int i) {
        return listConsum.get(i);
    }

    /**
     * Devuelve la cantidad de una consumision. El valor i es el mismo que en el
     * metodo getConsumision.
     *
     * @param i La posicion donde se guardo la consumision cuya cantidad
     * queremos determinar
     * @return Un objeto Integer con el valor de la consumicion en la posicion i
     */
    public Float getCantidad(int i) {
        return listCantidad.get(i);
    }

    /**
     * Metodo Syncronizado. De no existir en la lista añade la consumision y la
     * cantidad en el ultimo lugar de las listas. Por ser sincronizado este
     * metodo se asegura que los valor de ambas listas siempre se correspondan.
     * Si la consumision ya esta cargada, le suma el valor de la cantidad
     * ingresada a la cantidad existente.
     *
     * @param consumision La consumision a agregar o modificar
     * @param cantidad La cantida de la consumision a agregar.
     */
    public synchronized void addConsumision(Consumision consumision, float cantidad) {
        if (!(listConsum.contains(consumision))) {
            listConsum.add(consumision);
            listCantidad.add(cantidad);
        } else {
            Float cantActual = listCantidad.get(listConsum.indexOf(consumision)) + cantidad;
            listCantidad.set(listConsum.indexOf(consumision), cantActual);
        }
    }

    /**
     * Metodo Syncronizado. De no existir en la lista añade la consumision y la
     * cantidad en el ultimo lugar de las listas. Por ser sincronizado este
     * metodo se asegura que los valor de ambas listas siempre se correspondan.
     * Si la consumision ya esta cargada, le suma el valor de la cantidad
     * ingresada a la cantidad existente. A diferencia del metodo normal, este
     * metodo maneja la conversion de String a los valores correspondientes
     * internamente.
     *
     * @param nombConsumision La consumision a agregar o modificar
     * @param strCantidad La cantida de la consumision a agregar.
     */
    public synchronized void addConsumision(String nombConsumision, String strCantidad) {
        try {
            float cantidad = Float.valueOf(strCantidad);
            Consumision consumision = null;
            for (Consumision tempConsum : Contenedor.LISTPRODUCTO) {
                if (tempConsum.getNombre().equals(nombConsumision)) {
                    consumision = tempConsum;
                    break;
                }
            }

            if (!(listConsum.contains(consumision))) {
                listConsum.add(consumision);
                listCantidad.add(cantidad);
            } else {
                Float cantActual = listCantidad.get(listConsum.indexOf(consumision)) + cantidad;
                listCantidad.set(listConsum.indexOf(consumision), cantActual);
            }
        } catch (NumberFormatException e) {
            //pendiente de implementar
        }
    }
    /**
     * Busca y de existir borra la consumision dada como parametro.
     * @param consumision La consumision a borrar.
     */
    public synchronized void delConsumision(Consumision consumision) {
        for (int i = 0; i < listConsum.size(); i++) {
            if (listConsum.get(i).getNombre().equals(consumision.getNombre())) {
                listConsum.remove(i);
                listCantidad.remove(i);
            }
        }
    }
    /**
     * devuelve el tamaño de la lista.
     * @return 
     */
    public int getSize() {
        return listConsum.size();
    }

}
