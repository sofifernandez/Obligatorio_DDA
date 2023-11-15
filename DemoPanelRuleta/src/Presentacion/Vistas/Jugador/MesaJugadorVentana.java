/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion.Vistas.Jugador;

import Logica.JugadorMesa;
import Presentacion.Controladores.MesaJugadorControlador;
import Presentacion.Interfaces.MesaJugadorInterface;
import componente.PanelRuleta;
import componente.PanelRuleta.Escuchador;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author sofia
 */
public class MesaJugadorVentana extends javax.swing.JFrame implements MesaJugadorInterface{

    private MesaJugadorControlador controlador;
    private int fichaSeleccionada;
    
    public MesaJugadorVentana(JugadorMesa jm) {
        initComponents();
        fichas();
        controlador=new MesaJugadorControlador(jm, this);
        fichaSeleccionada=-1;
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        panelRuleta1 = new componente.PanelRuleta();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ficha1 = new javax.swing.JButton();
        ficha5 = new javax.swing.JButton();
        ficha10 = new javax.swing.JButton();
        ficha50 = new javax.swing.JButton();
        ficha100 = new javax.swing.JButton();
        lblSaldo = new javax.swing.JLabel();
        lblMesa = new javax.swing.JLabel();
        lblRonda = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblSorteado = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel4.setText("SALDO:");

        jLabel5.setText("MESA:");

        jLabel6.setText("RONDA:");

        ficha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ficha1ActionPerformed(evt);
            }
        });

        ficha5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ficha5ActionPerformed(evt);
            }
        });

        ficha10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ficha10ActionPerformed(evt);
            }
        });

        ficha50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ficha50ActionPerformed(evt);
            }
        });

        ficha100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ficha100ActionPerformed(evt);
            }
        });

        lblSorteado.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(818, 818, 818)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(148, 148, 148)
                                        .addComponent(ficha1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ficha5)
                                        .addGap(26, 26, 26)
                                        .addComponent(ficha10)
                                        .addGap(18, 18, 18)
                                        .addComponent(ficha50)
                                        .addGap(18, 18, 18)
                                        .addComponent(ficha100)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                        .addComponent(lblSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(panelRuleta1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ficha100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ficha1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(ficha5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ficha10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ficha50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblUsername)
                        .addGap(47, 47, 47)
                        .addComponent(lblSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(panelRuleta1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    public void fichas(){
        ficha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ficha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componente/coin.gif"))); // NOI18N
        ficha1.setText("1");
        ficha1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ficha1.setIconTextGap(0);
        ficha1.setMaximumSize(new java.awt.Dimension(80, 80));
        ficha1.setMinimumSize(new java.awt.Dimension(80, 80));
        ficha1.setPreferredSize(new java.awt.Dimension(80, 80));
        
        ficha5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ficha5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componente/coin.gif"))); // NOI18N
        ficha5.setText("5");
        ficha5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ficha5.setIconTextGap(0);
        ficha5.setMaximumSize(new java.awt.Dimension(80, 80));
        ficha5.setMinimumSize(new java.awt.Dimension(80, 80));
        ficha5.setPreferredSize(new java.awt.Dimension(80, 80));
        
        ficha10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ficha10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componente/coin.gif"))); // NOI18N
        ficha10.setText("10");
        ficha10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ficha10.setIconTextGap(0);
        ficha10.setMaximumSize(new java.awt.Dimension(80, 80));
        ficha10.setMinimumSize(new java.awt.Dimension(80, 80));
        ficha10.setPreferredSize(new java.awt.Dimension(80, 80));
        
        
        ficha50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ficha50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componente/coin.gif"))); // NOI18N
        ficha50.setText("50");
        ficha50.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ficha50.setIconTextGap(0);
        ficha50.setMaximumSize(new java.awt.Dimension(80, 80));
        ficha50.setMinimumSize(new java.awt.Dimension(80, 80));
        ficha50.setPreferredSize(new java.awt.Dimension(80, 80));
        
        ficha100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ficha100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/componente/coin.gif"))); // NOI18N
        ficha100.setText("100");
        ficha100.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ficha100.setIconTextGap(0);
        ficha100.setMaximumSize(new java.awt.Dimension(80, 80));
        ficha100.setMinimumSize(new java.awt.Dimension(80, 80));
        ficha100.setPreferredSize(new java.awt.Dimension(80, 80));
        
    }
    
    private void ficha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ficha1ActionPerformed
        fichaSeleccionada=1;
    }//GEN-LAST:event_ficha1ActionPerformed

    private void ficha5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ficha5ActionPerformed
        fichaSeleccionada=5;
    }//GEN-LAST:event_ficha5ActionPerformed

    private void ficha10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ficha10ActionPerformed
        fichaSeleccionada=10;
    }//GEN-LAST:event_ficha10ActionPerformed

    private void ficha50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ficha50ActionPerformed
        fichaSeleccionada=50;
    }//GEN-LAST:event_ficha50ActionPerformed

    private void ficha100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ficha100ActionPerformed
        fichaSeleccionada=100;
    }//GEN-LAST:event_ficha100ActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ficha1;
    private javax.swing.JButton ficha10;
    private javax.swing.JButton ficha100;
    private javax.swing.JButton ficha5;
    private javax.swing.JButton ficha50;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblRonda;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblSorteado;
    private javax.swing.JLabel lblUsername;
    private componente.PanelRuleta panelRuleta1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizarSaldo(int saldo) {
        lblSaldo.setText(""+saldo);
        
    }

    @Override
    public void actualizarNumRonda(int idRonda) {
        lblRonda.setText(""+idRonda);
    }

    @Override
    public void actualizarNumMesa(int idMesa) {
        lblMesa.setText(""+idMesa);
    }

    @Override
    public void actualizarNumSorteado(int numeroSorteado) {
        lblSorteado.setText(""+numeroSorteado);
    }

    @Override
    public void setNombreJugador(String nombreCompleto) {
        lblUsername.setText(nombreCompleto);
    }

    @Override
    public void bloquearMesa() {
        panelRuleta1.pausar();
    }

    @Override
    public void desbloquearMesa() {
        panelRuleta1.reanudar();
    }

    @Override
    public void setTiposHabilitados(List<Integer> casilleros) {
        for(Integer i: casilleros){
            panelRuleta1.setVisible(i, true);
        }
        
    }

    @Override
    public void setCasilleros(int i) {
        panelRuleta1.setVisible(i, false);
       // panelRuleta1.habilitar(i, true);

    }

    @Override
    public void setApuesta(int cellCode, int valorFicha) {
        panelRuleta1.setApuesta(cellCode, valorFicha);
    }

    @Override
    public void mostrarError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void setBotonesCasilleros() {
               panelRuleta1.agregar(new PanelRuleta.Escuchador() {
                @Override
                public void celdaSeleccionada(int universalCellCode) {
                    controlador.setApuesta(universalCellCode, fichaSeleccionada);
                    panelRuleta1.setApuesta(universalCellCode, fichaSeleccionada+ panelRuleta1.getApuesta(universalCellCode));
                }                
            });
    }

    @Override
    public void limpiarMesa() {
        panelRuleta1.limpiar();
    }
    
   

    

   
}
