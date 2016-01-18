/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Entidades;

import administrador.Entidades.EntidadesAbstractas.EntidadAbstracta;
import java.util.Calendar;

/**
 *
 * @author Merlin
 */
public class Pedido extends EntidadAbstracta{
    private int idMesa;
    private byte idMozo;
    private byte cubiertos;
    private final Calendar fecha = Calendar.getInstance();
    
}
