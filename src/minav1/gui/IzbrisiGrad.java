/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package minav1.gui;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import minav1.controller.Controller;
import minav1.domain.Grad;

/**
 *
 * @author aleks
 */
public class IzbrisiGrad extends javax.swing.JDialog {

    /**
     * Creates new form IzbrisiGrad
     */
    public IzbrisiGrad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        fillCmb();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbGradovi = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Odaberi grad za brisanje:");

        btnDelete.setText("Obrisi");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbGradovi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbGradovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnDelete)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        try {
            Grad grad = (Grad) cmbGradovi.getSelectedItem();
            if (grad == null) {
                return;
            }

            if (JOptionPane.showConfirmDialog(rootPane, grad) == JOptionPane.OK_OPTION) {
                Controller.getInstance().obrisiGrad(grad);
                System.out.println("potvrdjeno je brisanje");
                System.out.println("ostali gradovi posle brisanja: " + Controller.getInstance().vratiSveGradove());

                dispose();
            } else {
                System.out.println("NIJE potvrdjeno brisanje");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error while deleting city", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<Object> cmbGradovi;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void fillCmb() {
        try {
            List<Grad> gradovi = Controller.getInstance().vratiSveGradove();

// da bi ovo radilo, potrebno je uci u design -> klik na cmb -> tab properties ->
//   ->   izbrisati default stavke -> tab code -> type parameter podesiti na <Object>
            cmbGradovi.setModel(new DefaultComboBoxModel<>(gradovi.toArray()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error while filling cmb", JOptionPane.ERROR_MESSAGE);
        }
    }
}