/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Relatorio;
import model.dao.RelatorioDAO;

/**
 *
 * @author William
 */
public class Relatorios extends javax.swing.JFrame {
        
    public Relatorios() {
        initComponents();
        setDate();        
        createGrafico();  
        readJTable();
        setIconTop ();
        DefaultTableModel modelo = (DefaultTableModel) relatorioTable.getModel();
        relatorioTable.setRowSorter(new TableRowSorter(modelo));
        this.getContentPane().setBackground(Color.WHITE);             
    }
    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        relatorio = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        relatorioTable = new javax.swing.JTable();
        graficoPicture = new javax.swing.JLabel();
        mortesGrafic = new javax.swing.JLabel();
        data = new javax.swing.JComboBox<>();

        setTitle("Relatórios");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        relatorio.setBackground(new java.awt.Color(255, 255, 255));
        relatorio.setForeground(new java.awt.Color(102, 102, 102));
        relatorio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        relatorioTable.setBackground(new java.awt.Color(255, 255, 255));
        relatorioTable.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        relatorioTable.setForeground(new java.awt.Color(52, 52, 52));
        relatorioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cidade", "População", "Evolução", "Porcentagem", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(relatorioTable);
        if (relatorioTable.getColumnModel().getColumnCount() > 0) {
            relatorioTable.getColumnModel().getColumn(0).setResizable(false);
            relatorioTable.getColumnModel().getColumn(1).setResizable(false);
            relatorioTable.getColumnModel().getColumn(2).setResizable(false);
            relatorioTable.getColumnModel().getColumn(3).setResizable(false);
        }

        relatorio.addTab("Evolução", jScrollPane1);

        graficoPicture.setBackground(new java.awt.Color(255, 255, 255));
        graficoPicture.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        relatorio.addTab("Evolução - Gráfico", graficoPicture);
        relatorio.addTab("Mortes", mortesGrafic);

        data.setBackground(new java.awt.Color(255, 255, 255));
        data.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        data.setForeground(new java.awt.Color(52, 52, 52));
        data.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dataItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(relatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
            .addComponent(data, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(relatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setDate();  
        readJTable();
        createGrafico();  
    }//GEN-LAST:event_formWindowActivated

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        createGrafico();  
        readJTable(); 
    }//GEN-LAST:event_formMousePressed

    private void dataItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dataItemStateChanged
        createGrafico(false);  
        readJTable();
    }//GEN-LAST:event_dataItemStateChanged

    RelatorioDAO rdao = new RelatorioDAO();
    Grafico grafic = new Grafico();

    private void createGrafico (boolean recriateGrafic) {
        try {
            graficoPicture.setIcon(  (Icon) new javax.swing.ImageIcon(   grafic.criarGrafico( currentDate() , graficoPicture.getWidth() , graficoPicture.getHeight()  )  )   );
            if (recriateGrafic) {
                mortesGrafic.setIcon(  (Icon) new javax.swing.ImageIcon(   grafic.criarGraficoMorte( graficoPicture.getWidth() , graficoPicture.getHeight()  )  )   );
            }
        } catch (IOException ex) {
            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    private void createGrafico () {
        createGrafico (true);
    }    
    
    public void readJTable() { 
        DefaultTableModel modelo = (DefaultTableModel) relatorioTable.getModel();
        modelo.setNumRows(0);
        DecimalFormat df =  new DecimalFormat();
        df.setMaximumFractionDigits(6);
        int soma = 0;
        double somaPercent = 0;
        String cidadeAnterior = "", cidadeAtual = "";
        for (Relatorio r : rdao.read(currentDate())) {
            cidadeAtual = r.getCidadeNome();
            if (cidadeAtual.equals(cidadeAnterior)) {
                soma += r.getCasos();
                somaPercent += r.getPercent();
            } else {
                soma = r.getCasos();
                somaPercent = r.getPercent();
            }
            modelo.addRow(new Object[]{    
                r.getCidadeNome(),      
                r.getPopulacao(),
                soma,
                df.format(somaPercent)+"%",
                r.getDataCasos()
            });
            cidadeAnterior = cidadeAtual; 
        }
    }    
    
    public String currentDate() {
        String value = "";
        try {
            if (!data.getSelectedItem().equals("TODAS DATAS")) {
            value = (String) data.getSelectedItem();
            }
        } catch (NullPointerException ex) {
        
        }
        return value;
    }
    
    public void setDate() {   
        data.removeAllItems();
        data.addItem("TODAS DATAS");
        for (Relatorio e : rdao.readDate()) {
            data.addItem(e.getDataCasos());          
        } 
    }  
    
    private void setIconTop () {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/relatorio.png")));
    }    
    /**
     * @param args the command line arguments
     */
@SuppressWarnings("unchecked")
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> data;
    private javax.swing.JLabel graficoPicture;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mortesGrafic;
    private javax.swing.JTabbedPane relatorio;
    private javax.swing.JTable relatorioTable;
    // End of variables declaration//GEN-END:variables
}
