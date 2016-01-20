/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Controladores.ControladorPantallas;

import administrador.Controladores.ControladoresAbstractos.ControladorPantallaAbstracto;
import administrador.Pantallas.PantallasAbstractas.PantallaAbstracta;
import administrador.Utils.ReadPropertie;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase encargada de manipular la funcionalidad de PantallaComandas.
 * @author Merlin
 */
public class ControladorComandas extends ControladorPantallaAbstracto {

    private final ReadPropertie reader = new ReadPropertie();
    private PantallaAbstracta comandas;
    private int numMesas = 0;
    private javax.swing.JPanel pnlMesas;
    GridLayout pnl2Layout = new GridLayout(5, 4);
    ArrayList<JButton> listMesas;

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
        listMesas = new ArrayList<>(numMesas);
        this.comandas = comandas;
        panelMesas.setLayout(pnl2Layout);
        pnl2Layout.setHgap(10);
        pnl2Layout.setVgap(10);
        for (int i = 0; i < numMesas; i++) {
            listMesas.add(new JButton("" + i));
            panelMesas.add(listMesas.get(i));
            listMesas.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    onClick(evt);
                }
            });
        }
        comandas.pack();
        return listMesas;
    }
    
        public void onClick(ActionEvent evt){
            JButton btnClick = (JButton)evt.getSource();
            btnClick.setBackground(Color.yellow);
        }

}
