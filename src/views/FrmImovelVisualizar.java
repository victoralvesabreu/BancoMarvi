/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import crud.ImovelCRUD;
import database.DatabaseFactory;
import domain.Imovel;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victo
 */
public class FrmImovelVisualizar extends javax.swing.JFrame {

    /**
     * Creates new form FrmImovelVisualizar
     */
    public FrmImovelVisualizar() {
        initComponents();
    }

    public void addRowsToTable() throws Exception {
        DefaultTableModel modelo = (DefaultTableModel) tbImovel.getModel();

        modelo.getDataVector().removeAllElements();

        Connection conn = DatabaseFactory.getDatabase("postgresql").connect();

        ImovelCRUD imovelCRUD = new ImovelCRUD();

        Object rowData[] = new Object[10];

        if (tfFiltro.getText().equals("")) {
            for (Imovel aux : imovelCRUD.read(conn)) {
                rowData[0] = aux.getId();
                rowData[1] = aux.getNome();
                rowData[2] = aux.getMetrosQuad();
                rowData[3] = aux.getPreco();
                rowData[4] = aux.getDescricao();
                rowData[5] = aux.getRua();
                rowData[6] = aux.getNumero();
                rowData[7] = aux.getCep();
                rowData[8] = aux.getBairro();
                rowData[9] = aux.getUf().getCodigoUf();
                modelo.addRow(rowData);
            }
        } else {
            modelo.getDataVector().removeAllElements();
            for (Imovel aux : imovelCRUD.read(tfFiltro.getText(), conn)) {

                rowData[0] = aux.getId();
                rowData[1] = aux.getNome();
                rowData[2] = aux.getMetrosQuad();
                rowData[3] = aux.getPreco();
                rowData[4] = aux.getDescricao();
                rowData[5] = aux.getRua();
                rowData[6] = aux.getNumero();
                rowData[7] = aux.getCep();
                rowData[8] = aux.getBairro();
                rowData[9] = aux.getUf().getCodigoUf();
                modelo.getDataVector().removeAllElements();
                modelo.addRow(rowData);
            }
        }

        DatabaseFactory.getDatabase("postgresql").disconnect(conn);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbFiltro = new javax.swing.JLabel();
        btListar = new javax.swing.JButton();
        tfFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbImovel = new javax.swing.JTable();
        pnBotao = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizar Imovel");
        setMinimumSize(new java.awt.Dimension(1158, 516));

        lbFiltro.setText("Filtro :");

        btListar.setText("Listar");
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });

        tbImovel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nome", "metros quadrado", "preco", "descricao", "rua", "numero", "cep", "bairro", "uf"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbImovel.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbImovel);
        if (tbImovel.getColumnModel().getColumnCount() > 0) {
            tbImovel.getColumnModel().getColumn(0).setMinWidth(50);
            tbImovel.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbImovel.getColumnModel().getColumn(0).setMaxWidth(60);
            tbImovel.getColumnModel().getColumn(6).setMinWidth(60);
            tbImovel.getColumnModel().getColumn(6).setPreferredWidth(60);
            tbImovel.getColumnModel().getColumn(6).setMaxWidth(60);
            tbImovel.getColumnModel().getColumn(9).setMinWidth(50);
            tbImovel.getColumnModel().getColumn(9).setPreferredWidth(50);
            tbImovel.getColumnModel().getColumn(9).setMaxWidth(50);
        }

        pnBotao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotaoLayout = new javax.swing.GroupLayout(pnBotao);
        pnBotao.setLayout(pnBotaoLayout);
        pnBotaoLayout.setHorizontalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBotaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBotaoLayout.setVerticalGroup(
            pnBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEditar)
                .addGap(18, 18, 18)
                .addComponent(btRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSair)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(pnBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbFiltro)
                        .addGap(4, 4, 4)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btListar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btListar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbFiltro)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        try {
            addRowsToTable();
        } catch (Exception ex) {
            Logger.getLogger(FrmImovelVisualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btListarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        FrmImovel imovel;
        try {
            imovel = new FrmImovel();
            imovel.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(FrmImovelVisualizar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btNovoActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        try {
            Connection conn = DatabaseFactory.getDatabase("postgres").connect();
            ImovelCRUD imovelCrud = new ImovelCRUD();
            int index = tbImovel.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) tbImovel.getModel();
            int id = Integer.parseInt(model.getValueAt(index, 0).toString());
            imovelCrud.delete(conn, id);
            DatabaseFactory.getDatabase("postgres").disconnect(conn);
        } catch (Exception ex) {
            Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        try {

            int index = tbImovel.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) tbImovel.getModel();
            int id = Integer.parseInt(model.getValueAt(index, 0).toString());
            FrmImovel editImovel = new FrmImovel(id);
            editImovel.setVisible(true);
        } catch (NumberFormatException ex) {
            Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btEditarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmImovelVisualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmImovelVisualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmImovelVisualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmImovelVisualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmImovelVisualizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btListar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFiltro;
    private javax.swing.JPanel pnBotao;
    private javax.swing.JTable tbImovel;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
