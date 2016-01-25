/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades;

import administrador.Controladores.ControladorPantallas.Listas.ListaConsumision;
import administrador.Entidades.EntidadesAbstractas.EntidadAbstracta;
import java.util.Calendar;

/**
 * Clase utilizada para administrar los consumos y estados de una mesa. Almacena
 * las consumisiones, el moso asignado, el numero de mesa, y la fecha del
 * pedido.
 *
 * @author Merlin
 */
public class Pedido extends EntidadAbstracta {

    private byte idMesa;
    private byte idMozo;
    private byte cubiertos;
    private final Calendar fecha;
    private String estado;
    ListaConsumision listConsum;

    /**
     * Crea un pedido con los datos administrados y la fecha de hoy. Crea una
     * lista de consumisiones para almacenar productos y recetas
     *
     * @param idMesa La nesa donde se origino el pedido
     * @param idMozo El moso que creo el pedido
     * @param cubiertos La cantidad de comensales en la mesa
     * @param estado El estado de la mesa
     */
    public Pedido(byte idMesa, byte idMozo, byte cubiertos, String estado) {
        fecha = Calendar.getInstance();
        this.idMesa = idMesa;
        this.idMozo = idMozo;
        this.cubiertos = cubiertos;
        this.estado = estado;
        listConsum = new ListaConsumision();
    }

    public byte getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(byte idMesa) {
        this.idMesa = idMesa;
    }

    public byte getIdMozo() {
        return idMozo;
    }

    public void setIdMozo(byte idMozo) {
        this.idMozo = idMozo;
    }

    public byte getCubiertos() {
        return cubiertos;
    }

    public void setCubiertos(byte cubiertos) {
        this.cubiertos = cubiertos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ListaConsumision getListaConsum() {
        return listConsum;
    }

}
