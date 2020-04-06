/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.DefaultTableModel;
import model.bean.Cidade;
import model.bean.Estado;
import model.bean.Paciente;
import model.dao.EstadoDAO;
import model.dao.CidadeDAO;

/**
 *
 * @author William
 */
public class Cidades extends javax.swing.JFrame {

    /**
     * Creates new form Cidades
     */
    public Cidades() {
        initComponents();
        readUF();
        readJTable();
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cidadesTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        uf = new javax.swing.JComboBox<>();
        cidadeS = new javax.swing.JTextField();
        city = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setTitle("Cidades");

        jLabel2.setDisplayedMnemonic('C');
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cityBackground.png"))); // NOI18N
        jLabel2.setToolTipText("");

        cidadesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cidades"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cidadesTable);
        if (cidadesTable.getColumnModel().getColumnCount() > 0) {
            cidadesTable.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("ESTADOS : ");

        uf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        uf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ufActionPerformed(evt);
            }
        });
        uf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ufKeyTyped(evt);
            }
        });

        cidadeS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cidadeSKeyTyped(evt);
            }
        });

        city.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        city.setText("CIDADE :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cidadeS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ufKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ufKeyTyped

    }//GEN-LAST:event_ufKeyTyped

    private void ufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ufActionPerformed
        readJTable();
    }//GEN-LAST:event_ufActionPerformed

    private void cidadeSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cidadeSKeyTyped
        readJTable();
    }//GEN-LAST:event_cidadeSKeyTyped
    
    Estado e = new Estado();
    EstadoDAO edao = new EstadoDAO();
    
    
    public int idById() {
        int id = 0;
        if (!uf.getSelectedItem().equals("Selecione")) { 
            try {
                id = edao.readIdByUF(  (String) uf.getSelectedItem()   ).getEstadoId(); 
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
           id = 0;     
        }      
        return  id;
    }
    /**
     * @param args the command line arguments
     */

    private void readUF() {

        for (Estado e : edao.readUF()) {
            uf.addItem(e.getUF());
        }      
    }


    
    private void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) cidadesTable.getModel();
        modelo.setNumRows(0);
        CidadeDAO cdao = new CidadeDAO();
        for (Cidade c : cdao.readCidade( idById(), cidadeS.getText() )) {
            modelo.addRow(new Object[]{ 
                c.getCidadeNome()
            });
        }      
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cidadeS;
    private javax.swing.JTable cidadesTable;
    private javax.swing.JLabel city;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> uf;
    // End of variables declaration//GEN-END:variables
}
