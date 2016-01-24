/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Controladores.ControladorPantallas;

import administrador.Controladores.ControladoresAbstractos.ControladorPantallaAbstracto;
import administrador.Entidades.EntidadesAbstractas.Consumision;
import administrador.Entidades.EntidadesAbstractas.Contenedor;
import administrador.Entidades.Mesa;
import administrador.Entidades.Pedido;
import administrador.Pantallas.Paneles.CargaPedidos;
import administrador.Pantallas.PantallasAbstractas.PantallaAbstracta;
import administrador.Utils.ReadPropertie;
import com.sun.glass.events.KeyEvent;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Clase encargada de manipular la funcionalidad de PantallaComandas.
 *
 * @author Merlin
 */
public class ControladorComandas extends ControladorPantallaAbstracto {

    private final ReadPropertie reader = new ReadPropertie();
    private PantallaAbstracta comandas;
    private int numMesas = 0;
    private javax.swing.JPanel pnlMesas;
    GridLayout pnl2Layout = new GridLayout(5, 4);
    ArrayList<JButton> listBtnMesas;
    JPanel panelHabilitar = new JPanel();
    GridLayout layoutHabilitar = new GridLayout(1, 2);
    JLabel descripcion = new JLabel("Seleccionar: ");
    JLabel moso = new JLabel("Moso: ");
    JLabel cubierto = new JLabel("Cubiertos: ");
    JTextField txtMoso = new JTextField();
    JTextField txtCubiertos = new JTextField();
    int eleccion;
    int numMoso;
    int numCubiertos;
    private CargaPedidos pnlPedidos = new CargaPedidos();
    Pedido pedidoActual;

    /**
     * Setea las mesas configuradas en config.properties. Inicializa el panel y
     * el frame en esta instancia. Añade los botones creados al array list y lo
     * devuelve como retorno.
     *
     * @param comandas la instancia de la pantalla comandas
     * @param panelMesas el panel que albergara las mesas
     * @return ArrayList de JButtons creados para representar las mesas.
     */
    public ArrayList<JButton> initMesas(PantallaAbstracta comandas, JPanel panelMesas) {
        numMesas = Integer.valueOf(reader.getPropertie("numMesas"));
        listBtnMesas = new ArrayList<>(numMesas);
        this.comandas = comandas;
        panelMesas.setLayout(pnl2Layout);
        pnl2Layout.setHgap(10);
        pnl2Layout.setVgap(10);
        for (int i = 0; i < numMesas; i++) {
            listBtnMesas.add(new JButton("" + i));
            panelMesas.add(listBtnMesas.get(i));
            Contenedor.LISTMESA.add(new Mesa(i));
            listBtnMesas.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    onClick(evt);
                }
            });
        }
        comandas.pack();
        return listBtnMesas;
    }

    /**
     * Respuesta al click en una mesa. Verifica el estado de la misma y muestra
     * el panel correspondiente
     *
     * @param evt
     */
    public void onClick(ActionEvent evt) {
        //boton apretado
        JButton btnClick = (JButton) evt.getSource();
        Mesa clickedMesa = Contenedor.LISTMESA.get(Integer.valueOf(btnClick.getText()));
        //verifica si la mesa esta ocupada
        if (clickedMesa.isOcupada()) {
            //obtiene el pedido asignado a la mesa y muestra el panel con los datos del mismo para agregar productos
            pedidoActual = clickedMesa.getPedido();
            pnlPedidos.setTextMesa(String.valueOf(pedidoActual.getIdMesa()));
            pnlPedidos.setTextMozo(String.valueOf(pedidoActual.getIdMozo()));
            pnlPedidos.setTextCubierto(String.valueOf(pedidoActual.getCubiertos()));
            pnlPedidos.setPedido(pedidoActual);
            JOptionPane.showMessageDialog(comandas, pnlPedidos, "Modificar mesa", JOptionPane.PLAIN_MESSAGE);
            //si la mesa esta vacia muestra ventana para habilitarla
        } else {
            layoutHabilitar.setHgap(10);
            layoutHabilitar.setVgap(10);
            panelHabilitar.setLayout(layoutHabilitar);
            panelHabilitar.add(descripcion);
            panelHabilitar.add(moso);
            panelHabilitar.add(txtMoso);
            panelHabilitar.add(cubierto);
            panelHabilitar.add(txtCubiertos);

            eleccion = JOptionPane.showOptionDialog(comandas, panelHabilitar, "Habilitar Mesa", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
            //si se habilita la mesa se la marca como ocupada, se crea el pedido correspondiente con los datos de la mesa, el mozo y los cubiertos
            //
            if (eleccion
                    == 0) {
                try {
                    clickedMesa.setOcupada(true);
                    numMoso = Integer.valueOf(txtMoso.getText());
                    numCubiertos = Integer.valueOf(txtCubiertos.getText());
                    pedidoActual = new Pedido((byte) clickedMesa.getNumMesa(), (byte) numMoso, (byte) numCubiertos, "Habilitada");
                    Contenedor.LISTPEDIDO.add(pedidoActual);
                    clickedMesa.setPedido(pedidoActual);
                    pnlPedidos.setPedido(pedidoActual);
                    btnClick.setBackground(Color.GREEN);
                } catch (NumberFormatException ext) {
                    //A completar la respuesta a la excepcion
                    ext.printStackTrace();
                }

            } else {
                //no hacer nada
            }

        }

    }
    public static BigDecimal calcMonto(Pedido pedido){
        BigDecimal total = new BigDecimal(0);
        total = total.setScale(2, RoundingMode.UP);
        BigDecimal multiplicand;
        Consumision consum;
        int cant;
        for (int i = 0; i < pedido.getListaConsum().getListConsum().size(); i++) {
            consum = pedido.getListaConsum().getConsumision(i);
            cant = pedido.getListaConsum().getCantidad(i);
            multiplicand = new BigDecimal(cant);
            multiplicand = multiplicand.setScale(1, RoundingMode.DOWN);
            total = total.add(consum.getPrecio().multiply(multiplicand));
        }
        return total.setScale(2, RoundingMode.UP);
    }
}
