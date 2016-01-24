/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Controladores.ControladorPantallas.TableModels;

import administrador.Entidades.EntidadesAbstractas.Consumision;
import administrador.Entidades.Pedido;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Merlin
 */
public class prodTableModel extends AbstractTableModel {

    Pedido selecPedido;

    public void setSelecPedido(Pedido pedido) {
        this.selecPedido = pedido;

    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Nombre";
            case 1:
                return "Cantidad";
            default:
                return "ERROR";
        }
    }

    @Override
    public int getRowCount() {
        return selecPedido.getListaConsum().getSize();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getValueAt(int i, int i1) {
        switch (i1) {
            case 0:
                return selecPedido.getListaConsum().getConsumision(i).getNombre();
            case 1:
                return String.valueOf(selecPedido.getListaConsum().getCantidad(i));
            default:
                return "ERROR";
        }
    }

}
