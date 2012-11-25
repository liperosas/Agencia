/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import classes.Curriculo;
import fachada.Fachada;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class ListaCurriculo extends javax.swing.JFrame {

    Fachada fachada = new Fachada();
    DefaultTableModel tabela = new DefaultTableModel();

    /**
     * Creates new form ListaCurriculo
     */
    public ListaCurriculo() {
        initComponents();
        atualizarTabela();
    }

    public void atualizarTabela() {
        tabela = new DefaultTableModel();
        ArrayList<Curriculo> lista = new ArrayList<Curriculo>();
        tabela.setColumnIdentifiers(new String[]{"Código", "Nome", "Sobrenome", "Fone", "Email"});
        try {
            lista = fachada.listar();
            for (int i = 0; i < lista.size(); i++) {
                tabela.addRow(new Object[]{lista.get(i).getCurriculoCod(), lista.get(i).getPrimeiroNome(), lista.get(i).getSobrenome(), lista.get(i).getContatoFone(), lista.get(i).getContatoEmail()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Listar Currículos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Sobrenome", "Fone", "Email"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Remover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Alterar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisa por nome:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel3.setText("Pesquisa por Sobrenome:");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jButton1)
                        .add(18, 18, 18)
                        .add(jButton4)
                        .add(18, 18, 18)
                        .add(jButton3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jButton2))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel2))
                                .add(33, 33, 33)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jTextField2))))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 18, Short.MAX_VALUE)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 258, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton2)
                    .add(jButton3)
                    .add(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tabela = new DefaultTableModel();
        ArrayList<Curriculo> lista = new ArrayList<Curriculo>();
        tabela.setColumnIdentifiers(new String[]{"Código", "Nome", "Sobrenome", "Fone", "Email"});
        try {
            lista = fachada.listar();
            for (int i = 0; i < lista.size(); i++) {
                tabela.addRow(new Object[]{lista.get(i).getCurriculoCod(), lista.get(i).getPrimeiroNome(), lista.get(i).getSobrenome(), lista.get(i).getContatoFone(), lista.get(i).getContatoEmail()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int selectedRow = jTable1.getSelectedRow();
        DefaultTableModel tabela = new DefaultTableModel();
        try {
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecione um Item da tabela");
            } else {
                Curriculo curriculo = new Curriculo();
                int cod = (Integer) jTable1.getValueAt(selectedRow, 0);
                curriculo = fachada.procurar(cod);
                RemoverCurriculo rc = new RemoverCurriculo(curriculo, this);
                rc.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        DefaultTableModel tabela = new DefaultTableModel();
        try {
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecione um Item da tabela");
            } else {
                Curriculo curriculo = new Curriculo();
                int cod = (Integer) jTable1.getValueAt(selectedRow, 0);
                curriculo = fachada.procurar(cod);
                AlterarCurriculo ac = new AlterarCurriculo(curriculo, this);
                ac.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        tabela = new DefaultTableModel();
        ArrayList<Curriculo> lista = new ArrayList<Curriculo>();

        tabela.setColumnIdentifiers(new String[]{"Código", "Nome", "Sobrenome", "Fone", "Email"});
        try {
            lista = fachada.listarNomeCur(jTextField1.getText());
            for (int i = 0; i < lista.size(); i++) {
                tabela.addRow(new Object[]{lista.get(i).getCurriculoCod(), lista.get(i).getPrimeiroNome(), lista.get(i).getSobrenome(), lista.get(i).getContatoFone(), lista.get(i).getContatoEmail()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        tabela = new DefaultTableModel();
        ArrayList<Curriculo> lista = new ArrayList<Curriculo>();

        tabela.setColumnIdentifiers(new String[]{"Código", "Nome", "Sobrenome", "Fone", "Email"});
        try {
            lista = fachada.listarSobreNomeCur(jTextField2.getText());
            for (int i = 0; i < lista.size(); i++) {
                tabela.addRow(new Object[]{lista.get(i).getCurriculoCod(), lista.get(i).getPrimeiroNome(), lista.get(i).getSobrenome(), lista.get(i).getContatoFone(), lista.get(i).getContatoEmail()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaCurriculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaCurriculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaCurriculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaCurriculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaCurriculo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
