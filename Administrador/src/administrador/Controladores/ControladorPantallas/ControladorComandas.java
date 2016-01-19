/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Controladores.ControladorPantallas;

import administrador.Controladores.ControladoresAbstractos.ControladorPantallaAbstracto;
import administrador.Pantallas.PantallaComandas;
import administrador.Pantallas.PantallasAbstractas.PantallaAbstracta;
import administrador.Utils.ReadPropertie;

/**
 *
 * @author Merlin
 */
public class ControladorComandas extends ControladorPantallaAbstracto {

    private ReadPropertie reader = new ReadPropertie();
    private PantallaAbstracta comandas;
    private int numMesas = 0;
    private javax.swing.JPanel pnlMesas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;

    public ControladorComandas(PantallaComandas comandas) {
        this.comandas = comandas;
        numMesas = Integer.valueOf(reader.getPropertie("numMesas"));
    }

    public void buildMesas() {
        pnlMesas = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        javax.swing.GroupLayout pnelMesasLayout = new javax.swing.GroupLayout(pnlMesas);
        pnlMesas.setLayout(pnelMesasLayout);
        pnelMesasLayout.setHorizontalGroup(pnelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnelMesasLayout.createSequentialGroup()
                        .addGroup(pnelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnelMesasLayout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))
                                .addComponent(jButton3))
                        .addGap(0, 224, Short.MAX_VALUE))
        );
        pnelMesasLayout.setVerticalGroup(pnelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnelMesasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addContainerGap(215, Short.MAX_VALUE))
        );
        comandas.add(pnlMesas, 1);
        comandas.pack();
    }
}
