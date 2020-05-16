/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Cidade;
import model.bean.Exame;
import model.bean.Paciente;
import model.bean.Resultado;
import model.dao.ExameDAO;
import model.dao.PacienteDAO;
import model.dao.ResultadoDAO;

/**
 *
 * @author William
 */
public class Pacientes extends javax.swing.JFrame {

    private Cidades cidades = new Cidades();
    private Cidade cidade = new Cidade();
    private ExameDAO exdao = new ExameDAO();
    private Exame exame = new Exame();
    private Paciente p = new Paciente();
    private ResultadoDAO rdao = new ResultadoDAO();
    private PacienteDAO dao = new PacienteDAO(); 
    private int salvarStatus = 0; 
    private final String cidadeButton = cidade.getCurrentCidadeNome(), sexoButton = "Selecione";
    private boolean ckeckEditable = false;
    private int falecidoStatus = 0;
    private boolean updateState = false;
    
    public Pacientes() {
        initComponents();    
        readJTable();        
        novoExame.setEnabled(false);
        elementsEnabled(false,false);
        setIconTop ();
        buscarCidade.setText(cidadeButton);
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        nomeLabel = new javax.swing.JLabel();
        salvar = new javax.swing.JButton();
        nome = new javax.swing.JTextField();
        nasc = new javax.swing.JFormattedTextField();
        nascLabel = new javax.swing.JLabel();
        sexoLabel = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nomeS = new javax.swing.JFormattedTextField();
        backspace = new javax.swing.JToggleButton();
        editar = new javax.swing.JButton();
        apagar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        pacienteTable = new javax.swing.JTable();
        buscarCidade = new javax.swing.JButton();
        novo = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        novoExame = new javax.swing.JButton();
        statusExame = new javax.swing.JLabel();
        falecimentoCheck = new javax.swing.JLabel();
        falecidoLabel = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setTitle("Pacientes");
        setResizable(false);
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

        nomeLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nomeLabel.setText("Nome :  ");

        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        salvar.setText("SALVAR");
        salvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salvar.setName(""); // NOI18N
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        nome.setMaximumSize(new java.awt.Dimension(4, 19));

        try {
            nasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        nasc.setToolTipText("");
        nasc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nasc.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        nasc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nascKeyTyped(evt);
            }
        });

        nascLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        nascLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nascLabel.setText("Nasc : ");

        sexoLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        sexoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sexoLabel.setText("Sexo : ");

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Masculino", "Feminino", "Outro" }));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PACIENTES");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Nome : ");

        nomeS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TypingNome(evt);
            }
        });

        backspace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backspace.png"))); // NOI18N
        backspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backspaceActionPerformed(evt);
            }
        });

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edite.png"))); // NOI18N
        editar.setText(" EDITAR");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        apagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        apagar.setText("APAGAR");
        apagar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        apagar.setName(""); // NOI18N
        apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarActionPerformed(evt);
            }
        });

        pacienteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nome", "data criação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pacienteTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pacienteTableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(pacienteTable);
        if (pacienteTable.getColumnModel().getColumnCount() > 0) {
            pacienteTable.getColumnModel().getColumn(0).setResizable(false);
            pacienteTable.getColumnModel().getColumn(1).setResizable(false);
            pacienteTable.getColumnModel().getColumn(2).setResizable(false);
        }

        buscarCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cityAdd.png"))); // NOI18N
        buscarCidade.setText(" ");
        buscarCidade.setToolTipText("");
        buscarCidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buscarCidade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCidadeActionPerformed(evt);
            }
        });

        novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pacienteAdd.png"))); // NOI18N
        novo.setText("NOVO");
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });

        status.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        status.setForeground(new java.awt.Color(0, 153, 0));

        novoExame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exameAdd.png"))); // NOI18N
        novoExame.setText("NOVO EXAME ");
        novoExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoExameActionPerformed(evt);
            }
        });

        statusExame.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        statusExame.setForeground(new java.awt.Color(51, 51, 51));
        statusExame.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        falecimentoCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/radio-Button-Unchecked.png"))); // NOI18N
        falecimentoCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                falecimentoCheckMousePressed(evt);
            }
        });

        falecidoLabel.setBackground(new java.awt.Color(102, 102, 102));
        falecidoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        falecidoLabel.setForeground(new java.awt.Color(102, 102, 102));
        falecidoLabel.setText("Falecido?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apagar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nomeS, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backspace))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statusExame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(falecimentoCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(falecidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nomeLabel)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(buscarCidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nascLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nasc)
                            .addComponent(novoExame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(falecimentoCheck, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(falecidoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nascLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nasc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sexoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(novoExame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statusExame, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(backspace)
                    .addComponent(nomeS, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private String readJTableD() {
        String doençasLabel = ""; 
        for (Resultado d : rdao.read()) {
            doençasLabel += d.getNomeDoenca()+"\n";
        }             
        return doençasLabel;
    } 
    
    private int currentId (boolean disable){
        int id = 0;        
        if (disable) {  
            novo.setEnabled(true);            
            elementsEnabled(false);
        } 
        try {
            id = Integer.parseInt(String.valueOf(pacienteTable.getModel().getValueAt(pacienteTable.getSelectedRow(),0)));     
            nome.setEnabled(true);
        } catch (NumberFormatException ex) {
            if (disable) {
                elementsEnabled (false,false);
            }
            statusExame.setText("");
        }
        return id;  
    }

    private int currentId (){
        return currentId(true);
    }    
    
    private void elementsEnabled (boolean b, boolean c) {
        nome.setEditable(b);
        nomeLabel.setEnabled(b);
        nasc.setEnabled(b);
        nascLabel.setEnabled(b);        
        sexo.setEnabled(b);
        sexoLabel.setEnabled(b);        
        ckeckEditable = b;
        falecimentoCheck.setEnabled(b);
        falecidoLabel.setEnabled(b);
        buscarCidade.setEnabled(b);
        novoExame.setEnabled(!b & c);
        apagar.setEnabled(!b & c);
        salvar.setEnabled(b);
        editar.setEnabled(!b & c);
    } 
    
    private void elementsEnabled (boolean b) {
        elementsEnabled (b,true);
    } 
    
    private void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) pacienteTable.getModel();
        modelo.setNumRows(0);
        PacienteDAO pdao = new PacienteDAO();
        for (Paciente p : pdao.read(nomeS.getText(),true)) {
            modelo.addRow(new Object[]{ 
                p.getId(),                
                p.getNome(),              
                p.getData(),    
            });
        }      
    }
    
    private void setCidade () {  
        try {
            if (cidade.getCurrentCidadeId() != 0 && currentId(false) !=0) {
                buscarCidade.setText(cidade.getCurrentCidadeNome());
            }
        } catch (Exception ex) {
            if (cidade.getCurrentCidadeId() != 0 ) {
                buscarCidade.setText(cidade.getCurrentCidadeNome());

            }
        }
    }   
    
    private void setValue () {
        PacienteDAO pdao = new PacienteDAO();
        if (currentId() != 0){
            p = pdao.readById(currentId());       
            buscarCidade.setText(String.valueOf(p.getCidadeNome())); 
            cidade.setCurrentCidadeNome(String.valueOf(p.getCidadeNome()));   
            cidade.setCurrentCidadeId(p.getCidadeId());         
            nome.setText(p.getNome());  
            status.setText("");
            updateState = false;
            falecimentoToggle(p.getFalecido());
            falecidoStatus = p.getFalecido();
            int selecioneSexo;
            switch(p.getSexo()) {
                case 'F':
                   selecioneSexo = 2;
                   break;
                case 'M':   
                    selecioneSexo = 1;
                    break;
                case 'O':
                    selecioneSexo = 3;
                    break;
                default:
                    selecioneSexo = 0;
            }
            setStatusExame ();
            sexo.setSelectedIndex(selecioneSexo);
            selecioneSexo=0;
            nasc.setText(p.getNasc());                                   
            sexo.setSelectedItem(p.getSexo());
        } else {
            clear ();
        }
    }  
    
    private void setStatusExame () {
            try {
                exdao.readLastID(currentId(false));
                statusExame.setText("Saiu resultado do exame");
                if (updateState == false) {
                    novoExame.setEnabled(true);
                }
            } catch (Exception ex) {
                try {
                    if (exdao.lastExame(currentId(false)) != 0 ) {
                        novoExame.setEnabled(false);  
                        statusExame.setText("Aguardando resultado do exame");
                    } else {
                        statusExame.setText("");  
                        novoExame.setEnabled(true);    
                    }
                } catch (Exception aex ) {
                    
                }
            } 
            try {
               exame.setCurrentIdExame(String.valueOf(exdao.lastExame(currentId(false))));
            } catch (Exception aex ) {
                    
            }   
    }
    
    private void clear () {
        nome.setText("");
        nasc.setText("");
        buscarCidade.setText(cidadeButton);
        cidade.setCurrentCidade(cidadeButton,0);
        sexo.setSelectedItem(sexoButton);
        elementsEnabled (false,false);
        falecimentoToggle(0);
        exame.setCurrentIdExame(" ");
    }
    
    private void setPaciente ()  {
        try {
            p.setId(currentId ());
        } catch (Exception ex) { 
        }
        p.setFalecido(falecidoStatus);        
        p.setNome(nome.getText());
        p.setNasc(nasc.getText());
        p.setCidadeId(cidade.getCurrentCidadeId());
        p.setSexo(String.valueOf(sexo.getSelectedItem()).charAt(0));  
        System.out.println("Sexo : "+String.valueOf(sexo.getSelectedItem()).charAt(0) );
    }
    
    private void create () {
        setPaciente ();     
        dao.create(p);
        status.setText(dao.getStatus());
        readJTable();  
        selectLastPaciente();
    }
    
    private void update () {
        setPaciente ();
        if (getValidation () == true) {
            dao.update(p);  
            status.setText(dao.getStatus());
            readJTable(); 
            clear (); 
            updateState = false;
        }   
    }    
    
    private boolean getValidation () {
        boolean verdade = false;
        System.out.println("Cidade id : "+cidade.getCurrentCidadeId());
        if (cidade.getCurrentCidadeId() == 0) {
            JOptionPane.showMessageDialog(null,"Selecione a cidade!");
            verdade = false;
        } else if ( sexo.getSelectedItem().equals(sexoButton)) {
            JOptionPane.showMessageDialog(null,"Selecione o sexo do paciente!");            
            verdade = false;        
        } else {
            verdade = true;        
        }      
        return verdade;
    }
    
    private void delete () {
        String nomeLinha = "";
        try {
            nomeLinha = String.valueOf(pacienteTable.getModel().getValueAt(pacienteTable.getSelectedRow(),1));
            int question = 0;
            if (!(String.valueOf( currentId() )).equals("")) {
                question = JOptionPane.showConfirmDialog(null,"Deseja realmente apagar paciente  \n     de id : "+currentId()+"\n nome : "+nomeLinha+" ?");
            }
            if (question == 0) {
                p.setId(currentId());
                dao.delete(p);
                status.setText(dao.getStatus());                
                readJTable();     
                clear();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Selecione um paciente!");
        }
    }        
    
    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        if (getValidation () == true ) {
            if (salvarStatus == 1) {
                create ();  
            } else if (salvarStatus == 2) {
                update();
            } 
            this.salvarStatus = 0;
        }    
    }//GEN-LAST:event_salvarActionPerformed

    private void selectLastPaciente () {
        int index = pacienteTable.getModel().getRowCount()-1;
        pacienteTable.setRowSelectionInterval(index,index);
        setValue();
    }
    
    private void TypingNome(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TypingNome
        readJTable();
    }//GEN-LAST:event_TypingNome

    private void backspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backspaceActionPerformed
        nomeS.setText("");
        readJTable();
    }//GEN-LAST:event_backspaceActionPerformed

    private void apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarActionPerformed
        delete();
    }//GEN-LAST:event_apagarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        setValue();
        elementsEnabled(true); 
        updateState = true;
        this.salvarStatus = 2;
    }//GEN-LAST:event_editarActionPerformed

    private void pacienteTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pacienteTableMousePressed
        setValue();
    }//GEN-LAST:event_pacienteTableMousePressed

    private void buscarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCidadeActionPerformed
        cidades.setVisible(true);
    }//GEN-LAST:event_buscarCidadeActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        dao.clearStatus();
        status.setText("");
    }//GEN-LAST:event_formMousePressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setCidade(); 
        setStatusExame ();        
    }//GEN-LAST:event_formWindowActivated

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        clear();        
        elementsEnabled(true);  
        novo.setEnabled(false);
        pacienteTable.clearSelection();
        this.salvarStatus = 1;
    }//GEN-LAST:event_novoActionPerformed

    private void novoExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoExameActionPerformed
        exdao.create(currentId());
        exame.setCurrentIdExame(String.valueOf(exdao.lastExame(currentId())));
        statusExame.setText("Aguardando resultado do exame!");
        status.setText(exdao.getStatus());
        novoExame.setEnabled(false);        
    }//GEN-LAST:event_novoExameActionPerformed

    private void nascKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nascKeyTyped

    }//GEN-LAST:event_nascKeyTyped

    private void falecimentoCheckMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_falecimentoCheckMousePressed
        int r = 0;
        if (ckeckEditable && falecidoStatus == 0) {
            r = JOptionPane.showConfirmDialog(null,"Paciente faleceu por motivo de alguma \ndessas doenças? \n"+readJTableD());
            r = (r==0)?1:0;   
            falecimentoToggle (r);               
        } else if (ckeckEditable) {
            falecimentoToggle (0);                  
        }
    }//GEN-LAST:event_falecimentoCheckMousePressed
    private void falecimentoToggle (int r) {
        String check = "";
        if (r==1) {
            falecidoStatus=1;
            check = "radio-Button-Checked.png";
        } else {
            falecidoStatus=0;            
            check = "radio-Button-Unchecked.png";
        }
        falecimentoCheck.setIcon((Icon) new javax.swing.ImageIcon(getClass().getResource("../images/"+check+"")) );

    }    

    private void setIconTop () {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/paciente.png")));
    }
    
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apagar;
    private javax.swing.JToggleButton backspace;
    private javax.swing.JButton buscarCidade;
    private javax.swing.JButton editar;
    private javax.swing.JLabel falecidoLabel;
    private javax.swing.JLabel falecimentoCheck;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JFormattedTextField nasc;
    private javax.swing.JLabel nascLabel;
    private javax.swing.JTextField nome;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JFormattedTextField nomeS;
    private javax.swing.JButton novo;
    private javax.swing.JButton novoExame;
    private javax.swing.JTable pacienteTable;
    private javax.swing.JButton salvar;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JLabel sexoLabel;
    private javax.swing.JLabel status;
    private javax.swing.JLabel statusExame;
    // End of variables declaration//GEN-END:variables

}
