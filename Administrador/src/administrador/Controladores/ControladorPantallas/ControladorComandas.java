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
import administrador.Pantallas.Paneles.DialogAbrirMesa;
import administrador.Pantallas.Paneles.IngresarPedidos;
import administrador.Pantallas.PantallasAbstractas.PantallaAbstracta;
import administrador.Utils.ReadPropertie;
import java.awt.Color;
import java.awt.GridLayout;
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
    private JPanel pnlMesas;
    GridLayout pnlMesasLayout = new GridLayout(5, 4);
    ArrayList<JButton> listBtnMesas;
    int eleccion;
    int numMoso;
    int numCubiertos;
    IngresarPedidos pnlPedidos;
    Pedido pedidoActual;
    DialogAbrirMesa dialogAbrirMesa;

    /**
     * Setea las mesas configuradas en config.properties. Inicializa el panel y
     * el frame en esta instancia. Añade los botones creados al array list y lo
     * devuelve como retorno.
     *
     * @param comandas la instancia de la pantalla comandas
     * @param panelMesas el panel que albergara las mesas
     *
     */
    public void crearPedido(){}
    
    public void initMesas(PantallaAbstracta comandas, JPanel panelMesas) {
        numMesas = Integer.valueOf(reader.getPropertie("numMesas"));
        listBtnMesas = new ArrayList<>(numMesas);
        this.comandas = comandas;
        panelMesas.setLayout(pnlMesasLayout);
        pnlMesasLayout.setHgap(10);
        pnlMesasLayout.setVgap(10);
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
    }

    /**
     * Respuesta al click en una mesa. Verifica el estado de la misma y muestra
     * el panel correspondiente Si la mesa esta ocupada: Obtiene el pedido de la
     * mesa. Carga los valores en el Panel. y muestra el panel CargaPedidos para
     * modificar el pedido de la mesa. Si la mesa no estubiera ocupada: Prepara
     * el panel para mostrar la ventana de inicializacion de mesa. Si en la
     * ventana se preciona "No". vuelve a la ventana PantallaComandas. Si se
     * preciona "Si" crea un pedido con los datos base ingresados añade el
     * pedido a la lista global y a la mesa. Por ultimo marca el boton en verde
     * para mostrar que la mesa esta ocupada.
     *
     * @param evt
     */
    public void onClick(ActionEvent evt) {
        JButton btnClick = (JButton) evt.getSource();
        Mesa clickedMesa = Contenedor.LISTMESA.get(Integer.valueOf(btnClick.getText()));
        if(clickedMesa.isOcupada()){
        //obtiene el pedido asignado a la mesa y muestra el panel con los datos del mismo para agregar productos
            pedidoActual = clickedMesa.getPedido();
            pnlPedidos = new IngresarPedidos(comandas, true);
            pnlPedidos.setTextMesa(String.valueOf(pedidoActual.getIdMesa()));
            pnlPedidos.setTextMozo(String.valueOf(pedidoActual.getIdMozo()));
            pnlPedidos.setTextCubierto(String.valueOf(pedidoActual.getCubiertos()));
            pnlPedidos.setPedido(pedidoActual);
            pnlPedidos.setVisible(true);
        }
        else{
            dialogAbrirMesa = new DialogAbrirMesa(comandas, true);
            dialogAbrirMesa.setVisible(true);
            dialogAbrirMesa.setMesa(clickedMesa);
            pnlPedidos = new IngresarPedidos(comandas, true);
        }
    }
        public static void abrirMesa(Mesa clickedMesa, int numMoso, int numCubiertos){
        clickedMesa.setOcupada(true);
        pedidoActual = new Pedido((byte) clickedMesa.getNumMesa(), (byte) numMoso, (byte) numCubiertos, "Habilitada");
        }
    /**
     * Dado un pedido calcula la sumatoria del valor de todas las consumisiones
     * del mismo con una presicion de 2 decimales y redondeo hacia arriba.
     *
     * @param pedido El pedido sobre el cual se efectuara la sumatoria.
     * @return
     */
    public static BigDecimal calcMonto(Pedido pedido) {
        BigDecimal total = new BigDecimal(0);
        total = total.setScale(2, RoundingMode.UP);
        BigDecimal multiplicand;
        Consumision consum;
        float cant;
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
