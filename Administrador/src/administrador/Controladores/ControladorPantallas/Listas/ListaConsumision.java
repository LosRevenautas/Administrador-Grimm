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
 *
 * @author Merlin
 */
public class ListaConsumision {

    ArrayList<Consumision> listConsum;
    ArrayList<Integer> listCantidad;

    public ArrayList<Consumision> getListConsum() {
        return listConsum;
    }

    public void setListConsum(ArrayList<Consumision> listConsum) {
        this.listConsum = listConsum;
    }

    public ArrayList<Integer> getListCantidad() {
        return listCantidad;
    }

    public void setListCantidad(ArrayList<Integer> listCantidad) {
        this.listCantidad = listCantidad;
    }

    public ListaConsumision() {
        this.listConsum = new ArrayList<>();
        this.listCantidad = new ArrayList<>();
    }

    public Consumision getConsumision(int i) {
        return listConsum.get(i);
    }

    public Integer getCantidad(int i) {
        return listCantidad.get(i);
    }

    public synchronized void addConsumision(Consumision consumision, int cantidad) {
        if (!(listConsum.contains(consumision))) {
            listConsum.add(consumision);
            listCantidad.add(cantidad);
        } else {
            Integer cantActual = listCantidad.get(listConsum.indexOf(consumision)) + cantidad;
            listCantidad.set(listConsum.indexOf(consumision), cantActual);
        }
    }

    public synchronized void addConsumision(String nombConsumision, String strCantidad) {
        try{
            int cantidad = Integer.valueOf(strCantidad);
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
            Integer cantActual = listCantidad.get(listConsum.indexOf(consumision)) + cantidad;
            listCantidad.set(listConsum.indexOf(consumision), cantActual);
        }
        }
        catch(NumberFormatException e){
            //pendiente de implementar
        }
        }

    public synchronized void delConsumision(Consumision consumision) {
        for (int i = 0; i < listConsum.size(); i++) {
            if (listConsum.get(i).getNombre().equals(consumision.getNombre())) {
                listConsum.remove(i);
                listCantidad.remove(i);
            }
        }
    }

    public int getSize() {
        return listConsum.size();
    }
    
}
