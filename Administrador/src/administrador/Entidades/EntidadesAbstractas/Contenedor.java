/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades.EntidadesAbstractas;

import administrador.Entidades.Mesa;
import administrador.Entidades.Pedido;
import administrador.Entidades.Producto;
import java.util.ArrayList;

/**
 * Clase encargada de almacenar todas las listas de objetos.
 * @author Merlin
 */
public interface Contenedor {
    ArrayList<Mesa> LISTMESA = new ArrayList<>();
    ArrayList<Pedido> LISTPEDIDO = new ArrayList<>();
    ArrayList<Producto> LISTPRODUCTO = new ArrayList<>();
}
