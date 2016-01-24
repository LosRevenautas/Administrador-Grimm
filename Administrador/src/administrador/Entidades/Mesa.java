/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades;

import administrador.Entidades.EntidadesAbstractas.EntidadAbstracta;

/**
 *
 * @author Merlin
 */
public class Mesa extends EntidadAbstracta {

    private int numMesa;
    private boolean Ocupada;
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Mesa(int numMesa) {
        this.numMesa = numMesa;
        Ocupada = false;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public boolean isOcupada() {
        return Ocupada;
    }

    public void setOcupada(boolean isOcupada) {
        this.Ocupada = isOcupada;
    }

}
