/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion.Vistas.Crupier;

import Logica.Crupier;
import Logica.Efecto;
import Logica.Jugador;
import Presentacion.Controladores.MesaCrupierControlador;
import Presentacion.Interfaces.MesaCrupierInterface;
import componente.PanelRuleta;
import java.awt.Component;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

/**
 *
 * @author sofia
 */
public class MesaCrupierVentana extends javax.swing.JFrame implements MesaCrupierInterface {

    private MesaCrupierControlador controlador;
    
    public MesaCrupierVentana(Crupier crupier) {
        initComponents();
        controlador=new MesaCrupierControlador(crupier, this);
        comboEfectos.setRenderer(new EfectoRenderer());
        listJugadores.setCellRenderer(new JugadoresRenderer());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelRuleta2 = new componente.PanelRuleta();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCerrarMesa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboEfectos = new javax.swing.JComboBox();
        btnLanzarPagar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        lblMesa = new javax.swing.JLabel();
        lblRonda = new javax.swing.JLabel();
        lblApuesta = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        lblSorteado = new javax.swing.JLabel();
        lblUltimosLanz = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listEstadisticas = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        listJugadores = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        lblUltimos = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("BALANCE:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("RONDA:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("MESA:");

        btnCerrarMesa.setBackground(new java.awt.Color(255, 153, 153));
        btnCerrarMesa.setText("Cerrar mesa");
        btnCerrarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarMesaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Apuestas:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Monto:");

        btnLanzarPagar.setBackground(new java.awt.Color(204, 255, 153));
        btnLanzarPagar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLanzarPagar.setText("Lanzar/Pagar");
        btnLanzarPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanzarPagarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Últimos lanzamientos:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Efecto:");

        lblBalance.setText("dd");

        lblMesa.setText("d");

        lblRonda.setText("d");

        lblApuesta.setText("d");

        lblMonto.setText("d");

        lblSorteado.setBackground(new java.awt.Color(255, 255, 204));
        lblSorteado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jScrollPane1.setViewportView(listEstadisticas);

        jScrollPane5.setViewportView(listJugadores);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("JUGADORES");

        lblUltimos.setText("jLabel9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(panelRuleta2, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
                                .addComponent(jSeparator1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(23, 23, 23)
                                            .addComponent(jLabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(76, 76, 76)
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(comboEfectos, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(131, 131, 131)
                                            .addComponent(btnLanzarPagar))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(lblMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(38, 38, 38)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUltimosLanz, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblUltimos, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(205, 205, 205)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)))))
                        .addGap(34, 34, 34)
                        .addComponent(lblSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrarMesa)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnCerrarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(lblRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(comboEfectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLanzarPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lblMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRuleta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblUltimosLanz)
                    .addComponent(lblUltimos)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 118, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLanzarPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanzarPagarActionPerformed
        controlador.lanzarPagar((Efecto) comboEfectos.getSelectedItem());
    }//GEN-LAST:event_btnLanzarPagarActionPerformed

    private void btnCerrarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarMesaActionPerformed
        controlador.cerrarMesa();
    }//GEN-LAST:event_btnCerrarMesaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarMesa;
    private javax.swing.JButton btnLanzarPagar;
    private javax.swing.JComboBox comboEfectos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblApuesta;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblRonda;
    private javax.swing.JLabel lblSorteado;
    private javax.swing.JLabel lblUltimos;
    private javax.swing.JLabel lblUltimosLanz;
    private javax.swing.JList listEstadisticas;
    private javax.swing.JList listJugadores;
    private componente.PanelRuleta panelRuleta2;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void actualizarNumRonda(int idRonda) {
        lblRonda.setText(""+idRonda);
    }
    

    @Override
    public void actualizarNumMesa(int idMesa) {
        lblMesa.setText(""+idMesa);
    }

    @Override
    public void actualizarNumSorteado(String numeroSorteado) {
        lblSorteado.setText(""+numeroSorteado);
    }
    
    @Override
    public void setTiposHabilitados(List<Integer> casilleros) {
        for(Integer i: casilleros){
            panelRuleta2.setVisible(i, true);
        }
    }

    @Override
    public void setCasilleros(int i) {
        panelRuleta2.setVisible(i, false);
        panelRuleta2.habilitar(i, true);
    }
    

    @Override
    public void setApuesta(int codUniversal, int totalApostado) {
         panelRuleta2.setApuesta(codUniversal, totalApostado);
    }

    @Override
    public void actualizarTextoBoton(String titulo) {
        btnLanzarPagar.setText(titulo);
    }

    @Override
    public void hidratarListaEfectos(List<Efecto> efectos) {
        for(Efecto e: efectos){
            comboEfectos.addItem(e);
        }
    }

    @Override
    public void bloquearMesa() {
        panelRuleta2.pausar();
    }

    @Override
    public void desbloquearMesa() {
        panelRuleta2.reanudar();
    }

    @Override
    public void limpiarMesa() {
        panelRuleta2.limpiar();
    }

    @Override
    public void actualizarJugadores(List<Jugador> jugadores) {
        listJugadores.setListData(jugadores.toArray());
    }

    @Override
    public void actualizarBalance(int balance) {
        lblBalance.setText(balance+"");
    }

    @Override
    public void actualizarNumApuestas(int apuestas) {
        lblApuesta.setText(apuestas+"");
    }

    @Override
    public void actualizarMontoApuestas(int montoTotalApuestas) {
        lblMonto.setText(montoTotalApuestas+"");
    }

    @Override
    public void actualizarUltimosLanzamientos(String ultimosResultadosString) {
        lblUltimos.setText(ultimosResultadosString);
    }

    @Override
    public void popularTabla(List<String> textos) {
        listEstadisticas.setListData(textos.toArray());
    }

    @Override
    public void desbloquearBotonCerrar() {
        btnCerrarMesa.setEnabled(true);}

    @Override
    public void bloquearBotonCerrar() {
        btnCerrarMesa.setEnabled(false);
    }

    @Override
    public int mensajeConfirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje,"Confirmar CRUPIER",JOptionPane.YES_NO_OPTION);
    }

    @Override
    public void cerrar() {
        dispose();
    }
    
    
    
    
    private class EfectoRenderer extends JLabel implements ListCellRenderer<Efecto> {
        @Override
        public Component getListCellRendererComponent(JList list, Efecto efecto, int index, boolean isSelected, boolean cellHasFocus) {
            this.setText(efecto.getNombre());
            return this;
        }
    }
    
    private class JugadoresRenderer extends JLabel implements ListCellRenderer<Jugador> {
        @Override
        public Component getListCellRendererComponent(JList list, Jugador jugador, int index, boolean isSelected, boolean cellHasFocus) {
            this.setText(jugador.getNombreCompleto() + " -- " + jugador.getSaldo());
            return this;
        }
    }
       
    
   
}
