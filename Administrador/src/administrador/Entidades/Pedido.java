/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades;

import administrador.Entidades.EntidadesAbstractas.EntidadAbstracta;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Merlin
 */
public class Pedido extends EntidadAbstracta {

    private int idMesa;
    private byte idMozo;
    private byte cubiertos;
    private final Calendar fecha = Calendar.getInstance();
    private String estado;
    Map<Producto, Integer> bebidas = new LinkedHashMap<Producto, Integer>();
    Map<Receta, Integer> comidas = new LinkedHashMap<Receta, Integer>();

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
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

    public Map<Producto, Integer> getBebidas() {
        return bebidas;
    }

    public void addBebidas(Producto bebida, int cantidad) {
        if (bebidas.containsKey(bebida)) {
            bebidas.put(bebida, bebidas.get(bebida) + cantidad);
        } else {
            bebidas.put(bebida, cantidad);
        }
    }

    public Map<Receta, Integer> getComidas() {
        return comidas;
    }

    public void addComidas(Receta comida, int cantidad) {
        if (comidas.containsKey(comida)) {
            comidas.put(comida, comidas.get(comida) + cantidad);
        } else {
            comidas.put(comida, cantidad);
        }
    }

}
