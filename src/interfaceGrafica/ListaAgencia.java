/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import classes.Agencia;
import classes.Categoria;
import classes.Curriculo;
import fachada.Fachada;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class ListaAgencia extends javax.swing.JFrame {

    Fachada fachada = new Fachada();
    DefaultTableModel tabela = new DefaultTableModel();
    int[] codigo;

    /**
     * Creates new form ListaAgencia
     */
    public ListaAgencia() {
        initComponents();
        atualizarTabela();
        try {
            
            ArrayList<Categoria> categorias = new ArrayList<>();
            categorias = fachada.listarCat();
            codigo = new int[categorias.size()];
            for (int i = 0; i < categorias.size(); i++) {
                jComboBox1.addItem(categorias.get(i).getTipo());
                codigo[i] = categorias.get(i).getCat_cod();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    private void listarCategoria() {
        int selectedRow = jTable1.getSelectedRow();
        DefaultTableModel tabela2 = new DefaultTableModel();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(rootPane, "Informe categoria da tabela");
        } else {
            ArrayList<Categoria> categoria = new ArrayList<>();
            int cod = (int) jTable1.getValueAt(selectedRow, 0);
            try {
                categoria = fachada.listarCatAg(cod);
                tabela2.setColumnIdentifiers(new String[]{"Categorias da Agência"});

                for (int i = 0; i < categoria.size(); i++) {
                    Categoria cat = new Categoria();
                    cat = fachada.procurarCat(categoria.get(i).getCat_cod());
                    tabela2.addRow(new Object[]{cat.getTipo()});
                }
                jTable2.setModel(tabela2);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
    }

    public void atualizarTabela() {
        tabela = new DefaultTableModel();
        ArrayList<Agencia> lista = new ArrayList<Agencia>();

        tabela.setColumnIdentifiers(new String[]{"Código", "Agência", "Telefone", "Email"});
        try {
            Agencia filtro = new Agencia();
            //pegar as infomrações do form
            lista = fachada.listar(filtro);
            for (int i = 0; i < lista.size(); i++) {
                tabela.addRow(new Object[]{lista.get(i).getAg_cod(), lista.get(i).getAg_nome(), lista.get(i).getAg_fone(), lista.get(i).getAg_email()});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Agência", "Telefone", "Email"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Lista de Agências");

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

        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton6.setText("Alterar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setText("Procurar:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel3.setText("Listar Agências por Categoria:");

        jButton3.setText("Listar Agências");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1)
            .add(layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(jButton2))
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jButton1)
                        .add(18, 18, 18)
                        .add(jButton4)
                        .add(18, 18, 18)
                        .add(jButton6))
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 518, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 0, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1))
                    .add(jLabel2)
                    .add(jTextField1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButton3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(13, 13, 13)
                .add(jLabel2)
                .add(1, 1, 1)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(jButton3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 152, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton4)
                    .add(jButton6))
                .add(18, 18, 18)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButton2)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tabela = new DefaultTableModel();
        ArrayList<Agencia> lista = new ArrayList<Agencia>();

        tabela.setColumnIdentifiers(new String[]{"Código", "Agência", "Telefone", "Email"});
        try {
            Agencia filtro = new Agencia();
            //pegar as infomrações do form
            lista = fachada.listar(filtro);
            for (int i = 0; i < lista.size(); i++) {
                tabela.addRow(new Object[]{lista.get(i).getAg_cod(), lista.get(i).getAg_nome(), lista.get(i).getAg_fone(), lista.get(i).getAg_email()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        DefaultTableModel tabela = new DefaultTableModel();
        try {
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecione um Item da tabela");
            } else {
                Agencia agencia = new Agencia();
                int cod = (Integer) jTable1.getValueAt(selectedRow, 0);
                agencia = fachada.procurarAg(cod);
                RemoverAgencia ra = new RemoverAgencia(agencia, this);
                ra.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        DefaultTableModel tabela = new DefaultTableModel();
        try {
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecione um Item da tabela");
            } else {
                Agencia agencia = new Agencia();
                int cod = (Integer) jTable1.getValueAt(selectedRow, 0);
                agencia = fachada.procurarAg(cod);
                AlterarAgencia aa = new AlterarAgencia(agencia, this);
                aa.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        this.listarCategoria();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        tabela = new DefaultTableModel();
        ArrayList<Agencia> lista = new ArrayList<Agencia>();

        tabela.setColumnIdentifiers(new String[]{"Código", "Agência", "Telefone", "Email"});
        try {
            lista = fachada.procurarAgNome(jTextField1.getText());
            for (int i = 0; i < lista.size(); i++) {
                tabela.addRow(new Object[]{lista.get(i).getAg_cod(), lista.get(i).getAg_nome(), lista.get(i).getAg_fone(), lista.get(i).getAg_email()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        tabela = new DefaultTableModel();
        ArrayList<Agencia> lista = new ArrayList<Agencia>();

        tabela.setColumnIdentifiers(new String[]{"Código", "Agência", "Telefone", "Email"});
        try {
            Agencia filtro = new Agencia();
            //pegar as infomrações do form
            lista = fachada.listarAgenciaCat(codigo[jComboBox1.getSelectedIndex()]);
            for (int i = 0; i < lista.size(); i++) {
                tabela.addRow(new Object[]{lista.get(i).getAg_cod(), lista.get(i).getAg_nome(), lista.get(i).getAg_fone(), lista.get(i).getAg_email()});
            }
            jTable1.setModel(tabela);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ListaAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAgencia().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
