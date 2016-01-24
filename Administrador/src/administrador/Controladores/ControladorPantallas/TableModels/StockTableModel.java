/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Controladores.ControladorPantallas.TableModels;

import administrador.Entidades.EntidadesAbstractas.Contenedor;
import javax.swing.table.AbstractTableModel;

/**
 * Modelo de tabla utilizado para reprecentar la Tabla de PantallaStock
 * @author Merlin
 */
public class StockTableModel extends AbstractTableModel {

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Nombre";
            case 1:
                return "Precio";
            case 2:
                return "Disponible";
            default:
                return "ERROR";
        }
    }

    @Override
    public int getRowCount() {
        return Contenedor.LISTPRODUCTO.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {

        switch (i1) {
            case 0:
                return Contenedor.LISTPRODUCTO.get(i).getNombre();
            case 1:
                return Contenedor.LISTPRODUCTO.get(i).getPrecio();
            case 2:
                return Contenedor.LISTPRODUCTO.get(i).getCantidad();
            default:
                return "ERROR";
        }
    }

}
