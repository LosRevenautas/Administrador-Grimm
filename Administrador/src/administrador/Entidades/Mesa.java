/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades;

import administrador.Entidades.EntidadesAbstractas.EntidadAbstracta;

/**
 * Clase que representa la mesa del bar. Almacena el pedido correspondiente a la
 * misma y permite ver el estado de la mesa.
 *
 * @author Merlin
 */
public class Mesa extends EntidadAbstracta {

    private final byte numMesa;
    private boolean Ocupada;
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Mesa(byte numMesa) {
        this.numMesa = numMesa;
        Ocupada = false;
    }

    public byte getNumMesa() {
        return numMesa;
    }

    public boolean isOcupada() {
        return Ocupada;
    }

    public void setOcupada(boolean isOcupada) {
        this.Ocupada = isOcupada;
    }

}
