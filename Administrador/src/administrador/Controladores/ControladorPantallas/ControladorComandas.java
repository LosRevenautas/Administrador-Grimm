/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Controladores.ControladorPantallas;

import administrador.Controladores.ControladoresAbstractos.ControladorPantallaAbstracto;
import administrador.Entidades.EntidadesAbstractas.Contenedor;
import administrador.Entidades.Mesa;
import administrador.Entidades.Pedido;
import administrador.Pantallas.PantallasAbstractas.PantallaAbstracta;
import administrador.Utils.ReadPropertie;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
     * 
     * @param evt 
     */
    public void onClick(ActionEvent evt) {
        JButton btnClick = (JButton) evt.getSource();
        Mesa clickedMesa = Contenedor.LISTMESA.get(Integer.valueOf(btnClick.getText()));
        if (clickedMesa.isOcupada()) {
            JOptionPane.showMessageDialog(comandas, "La mesa esta ocupada", "Modificar mesa", JOptionPane.PLAIN_MESSAGE);
        } else {
            clickedMesa.setOcupada(true);
            layoutHabilitar.setHgap(10);
            layoutHabilitar.setVgap(10);
            panelHabilitar.setLayout(layoutHabilitar);
            panelHabilitar.add(descripcion);
            panelHabilitar.add(moso);
            panelHabilitar.add(txtMoso);
            panelHabilitar.add(cubierto);
            panelHabilitar.add(txtCubiertos);
            eleccion = JOptionPane.showOptionDialog(comandas, panelHabilitar, "Habilitar Mesa",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE , null, null, null);
            if(eleccion == 0){
                try{
                numMoso = Integer.valueOf(txtMoso.getText());
                numCubiertos = Integer.valueOf(txtCubiertos.getText());
                Pedido nuevoPedido = new Pedido((byte)clickedMesa.getNumMesa(), (byte)numMoso, (byte)numCubiertos, "Habilitada");
                Contenedor.LISTPEDIDO.add(nuevoPedido);
                btnClick.setBackground(Color.GREEN);
                }
                catch(NumberFormatException ext){
                    //A completar la respuesta a la excepcion
                ext.printStackTrace();
                }
                
            }
            else{
            //no hacer nada
            }
            
        }

    }

}
