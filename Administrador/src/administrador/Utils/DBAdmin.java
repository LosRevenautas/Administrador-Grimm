/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Utils;

import administrador.Entidades.Administrador;
import administrador.Entidades.EntidadesAbstractas.Usuario;
import administrador.Entidades.Pedido;
import administrador.Entidades.Producto;
import administrador.Entidades.Receta;
import administrador.Entidades.Retiro;

/**
 *
 * @author Merlin
 */
public class DBAdmin {
    
    public Usuario isValido(String user, String pass){
    Usuario logueado = new Administrador(); //buscar usuario logueado.
        return logueado;
    }
    
    
    public void setNumMesas(byte mesas){
        //place holder
    }
    
    public byte getNumMesas(){
    return 10;
    }
    
    public Pedido[] getPedidosPendientes(){
    Pedido[] pendientes = null;
    return pendientes;
    }
    
    public Pedido[] getPedidos(){
    Pedido[] pedidos = null;
    return pedidos;
    }
    
    //Guarda el pedido en la DB y devuelve el ID generado para el pedido
    public int addPedido(Pedido pedido){
    return 0;
    }
    
    public void changePedido(Pedido pedido){
        //place holder
    }
    
    public Retiro[] getRetiros(){
    Retiro[] listaRetiros = null;
    return listaRetiros;
    }
    
    public void addRetiro(Retiro retiro){
        //place holder
    }
    
    public void changeRetiro(Retiro retiro){
    }
    
    public int addProducto(Producto producto){
        return 0;
    }
    
    public void changeProducto(Producto producto){
        //place holder
    }
    
    public Producto[] getProductos(){
        Producto[] productosLista = null;
        return productosLista;
    }
    
    public Usuario[] getUsuarios(){
    Usuario[] usuarios = null;
    return usuarios;
    }
    
    public void addUsuario(Usuario usuario){
    //place holder
    }
    
    public void changeUsuario(Usuario usuario){
    //place holder
    }
    
    public Receta[] getRecetas(){
    Receta[] recetas = null;
    return recetas;
    }
    
    public void addReceta(Receta receta){
    //place holder
    }
    
    public void changeReceta(Receta receta){
    //place holder
    }
}
