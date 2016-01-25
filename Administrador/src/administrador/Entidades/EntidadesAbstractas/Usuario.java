/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades.EntidadesAbstractas;

import java.util.Calendar;

/**
 * Clase padre de todas las clases de usuario. Administra los datos de los mismo
 * y permite polimorfismo.
 *
 * @author Merlin
 */
public abstract class Usuario extends EntidadAbstracta {

    private String nombre;
    private int telefono;
    private String direccion;
    private Calendar inicioContrato;
    private Calendar finContrato;
    private boolean[] permisos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Calendar getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(Calendar inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public Calendar getFinContrato() {
        return finContrato;
    }

    public void setFinContrato(Calendar finContrato) {
        this.finContrato = finContrato;
    }

    public boolean[] getPermisos() {
        return permisos;
    }

    public void setPermisos(boolean[] permisos) {
        this.permisos = permisos;
    }

}
