/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import classes.Agencia;
import classes.Vaga;
import fachada.Fachada;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lipe
 */
public class ListaVaga extends javax.swing.JFrame {

    Fachada fachada = new Fachada();

    /**
     * Creates new form ListaVaga
     */
    public ListaVaga() {
        initComponents();
        try {
            ArrayList<Vaga> vagas = new ArrayList<>();
            DefaultTableModel tabela = new DefaultTableModel();

            vagas = fachada.listarVag();

            tabela.setColumnIdentifiers(new String[]{"Código", "Agência", "Tipo da Vaga", "Pré-Requisito", "Local", "Número de Vagas"});

            for (int i = 0; i < vagas.size(); i++) {
                Agencia age = new Agencia();
                age = fachada.procurarAg(vagas.get(i).getAgencia().getAg_cod());
                tabela.addRow(new Object[]{vagas.get(i).getVaga_cod(), age.getAg_nome(), vagas.get(i).getTipo_vaga(), vagas.get(i).getPre_requisito(), vagas.get(i).getVaga_local(), vagas.get(i).getNum_vaga()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    public void atualizarTabela() {
        try {
            ArrayList<Vaga> vagas = new ArrayList<>();
            DefaultTableModel tabela = new DefaultTableModel();

            vagas = fachada.listarVag();

            tabela.setColumnIdentifiers(new String[]{"Código", "Agência", "Tipo da Vaga", "Pré-Requisito", "Local", "Número de Vagas"});

            for (int i = 0; i < vagas.size(); i++) {
                Agencia age = new Agencia();
                age = fachada.procurarAg(vagas.get(i).getAgencia().getAg_cod());
                tabela.addRow(new Object[]{vagas.get(i).getVaga_cod(), age.getAg_nome(), vagas.get(i).getTipo_vaga(), vagas.get(i).getPre_requisito(), vagas.get(i).getVaga_local(), vagas.get(i).getNum_vaga()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
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
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Lista de Vagas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
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

        jButton4.setText("Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Procurar por Agência:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel3.setText("Procurar por Tipo de Vaga:");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel4.setText("Procurar por Pré-Requisito:");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um item da tabela");
        } else {
            int codigo = (int) jTable1.getValueAt(selectedRow, 0);
            try {
                fachada.removerVag(codigo);
                JOptionPane.showMessageDialog(rootPane, "Removido com sucesso");

                ArrayList<Vaga> vagas = new ArrayList<>();
                DefaultTableModel tabela = new DefaultTableModel();

                vagas = fachada.listarVag();

                tabela.setColumnIdentifiers(new String[]{"Código", "Agência", "Tipo da Vaga", "Pré-Requisito", "Local", "Número de Vagas"});

                for (int i = 0; i < vagas.size(); i++) {
                    Agencia age = new Agencia();
                    age = fachada.procurarAg(vagas.get(i).getAgencia().getAg_cod());
                    tabela.addRow(new Object[]{vagas.get(i).getVaga_cod(), age.getAg_nome(), vagas.get(i).getTipo_vaga(), vagas.get(i).getPre_requisito(), vagas.get(i).getVaga_local(), vagas.get(i).getNum_vaga()});
                }
                jTable1.setModel(tabela);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um item da tabela");
        } else {
            int codigo = (int) jTable1.getValueAt(selectedRow, 0);
            Vaga vagas = new Vaga();
            try {
                vagas = fachada.procurarVag(codigo);
                AlterarVaga vag = new AlterarVaga(vagas, this);
                vag.setVisible(rootPaneCheckingEnabled);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ArrayList<Vaga> vagas = new ArrayList<>();
            DefaultTableModel tabela = new DefaultTableModel();

            vagas = fachada.listarVag();

            tabela.setColumnIdentifiers(new String[]{"Código", "Agência", "Tipo da Vaga", "Pré-Requisito", "Local", "Número de Vagas"});

            for (int i = 0; i < vagas.size(); i++) {
                Agencia age = new Agencia();
                age = fachada.procurarAg(vagas.get(i).getAgencia().getAg_cod());
                tabela.addRow(new Object[]{vagas.get(i).getVaga_cod(), age.getAg_nome(), vagas.get(i).getTipo_vaga(), vagas.get(i).getPre_requisito(), vagas.get(i).getVaga_local(), vagas.get(i).getNum_vaga()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        ArrayList<Vaga> vagas = new ArrayList<>();
        DefaultTableModel tabela = new DefaultTableModel();
        tabela = new DefaultTableModel();
        tabela.setColumnIdentifiers(new String[]{"Código", "Agência", "Tipo da Vaga", "Pré-Requisito", "Local", "Número de Vagas"});
        try {
            vagas = fachada.listarAgenciaVag(jTextField1.getText());
            for (int i = 0; i < vagas.size(); i++) {
                Agencia age = new Agencia();
                age = fachada.procurarAg(vagas.get(i).getAgencia().getAg_cod());
                tabela.addRow(new Object[]{vagas.get(i).getVaga_cod(), age.getAg_nome(), vagas.get(i).getTipo_vaga(), vagas.get(i).getPre_requisito(), vagas.get(i).getVaga_local(), vagas.get(i).getNum_vaga()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased

        ArrayList<Vaga> vagas = new ArrayList<>();
        DefaultTableModel tabela = new DefaultTableModel();
        tabela = new DefaultTableModel();
        tabela.setColumnIdentifiers(new String[]{"Código", "Agência", "Tipo da Vaga", "Pré-Requisito", "Local", "Número de Vagas"});
        try {
            vagas = fachada.listarTipoVag(jTextField2.getText());
            for (int i = 0; i < vagas.size(); i++) {
                Agencia age = new Agencia();
                age = fachada.procurarAg(vagas.get(i).getAgencia().getAg_cod());
                tabela.addRow(new Object[]{vagas.get(i).getVaga_cod(), age.getAg_nome(), vagas.get(i).getTipo_vaga(), vagas.get(i).getPre_requisito(), vagas.get(i).getVaga_local(), vagas.get(i).getNum_vaga()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        ArrayList<Vaga> vagas = new ArrayList<>();
        DefaultTableModel tabela = new DefaultTableModel();
        tabela = new DefaultTableModel();
        tabela.setColumnIdentifiers(new String[]{"Código", "Agência", "Tipo da Vaga", "Pré-Requisito", "Local", "Número de Vagas"});
        try {
            vagas = fachada.listarPreReqVag(jTextField3.getText());
            for (int i = 0; i < vagas.size(); i++) {
                Agencia age = new Agencia();
                age = fachada.procurarAg(vagas.get(i).getAgencia().getAg_cod());
                tabela.addRow(new Object[]{vagas.get(i).getVaga_cod(), age.getAg_nome(), vagas.get(i).getTipo_vaga(), vagas.get(i).getPre_requisito(), vagas.get(i).getVaga_local(), vagas.get(i).getNum_vaga()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jTextField3KeyReleased

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
            java.util.logging.Logger.getLogger(ListaVaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaVaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaVaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaVaga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaVaga().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
