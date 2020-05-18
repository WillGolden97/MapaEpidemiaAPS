/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import model.bean.Cidade;
import model.bean.Estado;
import model.dao.EstadoDAO;
import model.dao.CidadeDAO;

/**
 *
 * @author William
 */
public class Cidades extends javax.swing.JFrame {
  
    private Cidade c = new Cidade();
    private EstadoDAO edao = new EstadoDAO(); 
    private CidadeDAO cdao = new CidadeDAO();

    public Cidades() {
        initComponents();
        readUF() ;
        readJTable();
        toggleElements(selecionar,false);
        setIconTop ();
        this.getContentPane().setBackground(Color.WHITE);             
    }
    
    private void toggleElements (JButton l, boolean toggle) {
        if(toggle){
            l.setForeground(Color.DARK_GRAY);  
        } else {
            l.setForeground(Color.LIGHT_GRAY);   
        }   
        l.setEnabled(toggle);        
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
        jLabel3 = new javax.swing.JLabel();
        uf = new javax.swing.JComboBox<>();
        cidadeS = new javax.swing.JTextField();
        city = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cidadesTable = new javax.swing.JTable();
        selecionar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setTitle("Cidades");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel2.setDisplayedMnemonic('C');
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cityBackground.png"))); // NOI18N
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("ESTADOS : ");

        uf.setBackground(new java.awt.Color(255, 255, 255));
        uf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        uf.setForeground(new java.awt.Color(51, 51, 51));
        uf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE" }));
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

        cidadeS.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cidadeS.setForeground(new java.awt.Color(51, 51, 51));
        cidadeS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cidadeSKeyTyped(evt);
            }
        });

        city.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        city.setForeground(new java.awt.Color(51, 51, 51));
        city.setText("CIDADE :");

        cidadesTable.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cidadesTable.setForeground(new java.awt.Color(51, 51, 51));
        cidadesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UF", "Cidades"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cidadesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cidadesTableMousePressed(evt);
            }
        });
        cidadesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cidadesTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cidadesTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(cidadesTable);
        if (cidadesTable.getColumnModel().getColumnCount() > 0) {
            cidadesTable.getColumnModel().getColumn(0).setResizable(false);
            cidadesTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            cidadesTable.getColumnModel().getColumn(1).setResizable(false);
        }

        selecionar.setBackground(new java.awt.Color(255, 255, 255));
        selecionar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        selecionar.setForeground(new java.awt.Color(51, 51, 51));
        selecionar.setText("SELECIONAR");
        selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(city)
                        .addGap(9, 9, 9)
                        .addComponent(cidadeS, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(uf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1))
            .addComponent(selecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void cidadesTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cidadesTableMousePressed
        c = cdao.readCurrentCidade(edao.readIdByUF((String) cidadesTable.getModel().getValueAt(cidadesTable.getSelectedRow(),0)).getEstadoId(), (String) cidadesTable.getModel().getValueAt(cidadesTable.getSelectedRow(),1));
        c.setCurrentCidade(c.getCidadeNome(),c.getCidadeId());  
        toggleElements(selecionar,true);
    }//GEN-LAST:event_cidadesTableMousePressed

    private void cidadesTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cidadesTableKeyReleased

    }//GEN-LAST:event_cidadesTableKeyReleased

    private void cidadesTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cidadesTableKeyPressed

    }//GEN-LAST:event_cidadesTableKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        c.setCurrentCidade("",0);  
        cidadeS.setText("");
        uf.setSelectedItem("Selecione");
        toggleElements(selecionar,false);         
    }//GEN-LAST:event_formWindowActivated

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        this.setVisible(false);
    }//GEN-LAST:event_formWindowLostFocus

    private void selecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_selecionarActionPerformed

    public int idByUF() {
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

    
    
    public void readUF() {   

        for (Estado e : edao.readUF()) {
            uf.addItem(e.getUF());
        } 
    }
 
    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) cidadesTable.getModel();
        modelo.setNumRows(0);
        String ufS = (String) uf.getSelectedItem();
        if (idByUF() == 0 ) {
            for (Cidade c : cdao.readCidadeNome(cidadeS.getText())) {
                modelo.addRow(new Object[]{ 
                    c.getUF(),                
                    c.getCidadeNome(),                                
                });
            }
        } else {
            for (Cidade c : cdao.readCidade((String) uf.getSelectedItem(),cidadeS.getText())) {
                modelo.addRow(new Object[]{ 
                    ufS,                
                    c.getCidadeNome(),                                
                });
            }            
        }
    }
    

    private void setIconTop () {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/city.png")));
    }
          
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cidadeS;
    private javax.swing.JTable cidadesTable;
    private javax.swing.JLabel city;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton selecionar;
    private javax.swing.JComboBox<String> uf;
    // End of variables declaration//GEN-END:variables
}
