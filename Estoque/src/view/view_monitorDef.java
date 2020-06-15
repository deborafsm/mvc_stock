/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.dao_kitSaida;
import dao.dao_monitorDef;
import dao.dao_pcDef;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;
import model.model_kitSaida;
import model.model_monitor;
import model.model_monitorDef;

/**
 *
 * @author jobhome
 */
public class view_monitorDef extends javax.swing.JInternalFrame {

    /**
     * Creates new form view_monitorDef
     */
    public view_monitorDef() {
        initComponents();
        readJtableMonitor();
        selecionaKitMonitor();
        date();
    }
public void date() { //Mostra data
        txtData.setEnabled(false);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(
                new Runnable() {
            public void run() {
                txtData.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
            }
        }, 1, 1, TimeUnit.SECONDS);

    }
    public void readJtableMonitor() {
        DefaultTableModel model = (DefaultTableModel) tblMonNovo.getModel();
        model.setNumRows(0);
        dao_kitSaida dao = new dao_kitSaida();
        dao.findAllMonitor().forEach((pc) -> {
            // for é usado para passar pelos objetos
            model.addRow(new Object[]{
                pc.getId_monitor(),
                pc.getCod_monitor(),
                pc.getMarcamon()

            });
        });
    }
//Para selecionar kits existentes no banco de dados
    public void selecionaKitMonitor() {
        DefaultTableModel model = (DefaultTableModel) tblMonitorKit.getModel();
        model.setNumRows(0);
        dao_monitorDef kitpc = new dao_monitorDef();
        kitpc.selecionaKit().forEach((pc) -> {
            // for é usado para passar pelos objetos
            model.addRow(new Object[]{
                pc.getId_kit(),
                pc.getLacre(),
                pc.getNome_operador(),
                pc.getEmail(),
                pc.getId_monitor(),
                pc.getCod_monitor(),
                pc.getMarca_monitor()
            });
        });
    }
    
    public void atualizarMonitor() {
        model_kitSaida monnv = new model_kitSaida();
        dao_kitSaida dao = new dao_kitSaida();
        if (tblMonNovo.getSelectedRow() != -1) {
            //Seta todos os campos que podem ser atualizados
            monnv.setStatus(cboSaida.getSelectedItem().toString());//Pega o valor do combobox
            //A atualização só vai ser possivel atraves do Código
            monnv.setCod_monitor((String) tblMonNovo.getValueAt(tblMonNovo.getSelectedRow(), 1));
            //Chama metodo UPDATE 
            dao.updateMonitor(monnv);
            //Atualiza os campos da tabela
            readJtableMonitor();
        }
    }
     //Para pesquisar operador
    public void pesquisarOperador(String nome_operador) {
        DefaultTableModel model = (DefaultTableModel) tblMonitorKit.getModel();
        model.setNumRows(0);
        dao_monitorDef dao = new dao_monitorDef();
        dao.findOperador(nome_operador).forEach((mon) -> {
            model.addRow(new Object[]{
                //Chama os itens 
                mon.getId_kit(),
                mon.getLacre(),
                mon.getNome_operador(),
                mon.getEmail(),
                mon.getId_monitor(),
                mon.getCod_monitor(),
                mon.getMarca_monitor()
            });
        });

    }
    public void pesquisarNvMonitor(String cod_monitor) {
        DefaultTableModel model = (DefaultTableModel) tblMonNovo.getModel();
        model.setNumRows(0);
        dao_monitorDef dao = new dao_monitorDef();
        dao.findMonitor(cod_monitor).forEach((mon) -> {
            model.addRow(new Object[]{
                //Chama os itens 
                mon.getId_monitor(),
                mon.getCod_monitor(),
                mon.getMarca_monitor()
            });
        });

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMonitorKit = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnPesquisarOP = new javax.swing.JButton();
        txtFindOp = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtNomeOP = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidKit = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtMarcaMonDef = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCodMonDef = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaDefMon = new javax.swing.JTextArea();
        cboStatusMonitor = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        btnAddDefMon = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMonNovo = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCodMonNV = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMonitorNV = new javax.swing.JTextField();
        txtMarcaMonNov = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCodMonitorFind = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cboSaida = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Kits Existentes"));

        tblMonitorKit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_KIT", "Lacre KIT", "Nome Operadora", "Email", "ID_Monitor", "Cod_monitor", "Marca Monitor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMonitorKit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonitorKitMouseClicked(evt);
            }
        });
        tblMonitorKit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblMonitorKitKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblMonitorKit);

        jLabel2.setText("Nome Operador(a):");

        btnPesquisarOP.setText("Pesquisar");
        btnPesquisarOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarOPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFindOp, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisarOP)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnPesquisarOP))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtFindOp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Do Operador"));

        jLabel15.setText("Nome:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel17.setText("E-mail:");

        txtData.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        jLabel24.setText("Data Kit Entrada");

        jLabel3.setText("ID:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(txtNomeOP, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(139, 139, 139)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtidKit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel3)
                    .addComponent(txtidKit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNomeOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitor no Kit Atual"));

        jLabel11.setText("Marca:");

        jLabel10.setText("Cod_MT");

        jLabel43.setText("Defeito Monitor:");

        txaDefMon.setColumns(20);
        txaDefMon.setRows(5);
        jScrollPane5.setViewportView(txaDefMon);

        cboStatusMonitor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Defeito" }));

        jLabel46.setText("Status:");

        btnAddDefMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/erro.png"))); // NOI18N
        btnAddDefMon.setText("Adicionar Defeito");
        btnAddDefMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDefMonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodMonDef, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtMarcaMonDef, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(18, 18, 18)
                        .addComponent(cboStatusMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddDefMon)))
                .addGap(14, 14, 14))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txtMarcaMonDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCodMonDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 32, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(cboStatusMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDefMon)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitores No Estoque"));

        tblMonNovo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "codigo", "marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMonNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonNovoMouseClicked(evt);
            }
        });
        tblMonNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblMonNovoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblMonNovo);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/refrescar (1).png"))); // NOI18N
        btnUpdate.setText("Atualizar Kit");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel12.setText("Id_MT:");

        jLabel14.setText("Marca:");

        jLabel13.setText("Cod_MT");

        jLabel1.setText("Código Monitor:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cboSaida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Saida" }));

        jLabel4.setText("Status Monitor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodMonitorFind, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodMonNV))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMonitorNV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMarcaMonNov, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodMonitorFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMonitorNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtMarcaMonNov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCodMonNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate))
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(325, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
    }//GEN-LAST:event_txtDataActionPerformed

    private void tblMonNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonNovoMouseClicked
if (tblMonNovo.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtMonitorNV.setText(tblMonNovo.getValueAt(tblMonNovo.getSelectedRow(), 0).toString());
            txtCodMonNV.setText(tblMonNovo.getValueAt(tblMonNovo.getSelectedRow(), 1).toString());
            txtMarcaMonNov.setText(tblMonNovo.getValueAt(tblMonNovo.getSelectedRow(), 2).toString());

        }
    }//GEN-LAST:event_tblMonNovoMouseClicked

    private void tblMonNovoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMonNovoKeyReleased
if (tblMonNovo.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtMonitorNV.setText(tblMonNovo.getValueAt(tblMonNovo.getSelectedRow(), 0).toString());
            txtCodMonNV.setText(tblMonNovo.getValueAt(tblMonNovo.getSelectedRow(), 1).toString());
            txtMarcaMonNov.setText(tblMonNovo.getValueAt(tblMonNovo.getSelectedRow(), 2).toString());

        }
    }//GEN-LAST:event_tblMonNovoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pesquisarNvMonitor(txtCodMonitorFind.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblMonitorKitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMonitorKitKeyReleased
        if (tblMonitorKit.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtidKit.setText(tblMonitorKit.getValueAt(tblMonitorKit.getSelectedRow(),0).toString());
            txtNomeOP.setText(tblMonitorKit.getValueAt(tblMonitorKit.getSelectedRow(), 2).toString());
            txtEmail.setText(tblMonitorKit.getValueAt(tblMonitorKit.getSelectedRow(), 3).toString());
            txtCodMonDef.setText(tblMonitorKit.getValueAt(tblMonitorKit.getSelectedRow(), 4).toString());
            txtMarcaMonDef.setText(tblMonitorKit.getValueAt(tblMonitorKit.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_tblMonitorKitKeyReleased

    private void tblMonitorKitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonitorKitMouseClicked
       if (tblMonitorKit.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtidKit.setText(tblMonitorKit.getValueAt(tblMonitorKit.getSelectedRow(),0).toString());
            txtNomeOP.setText(tblMonitorKit.getValueAt(tblMonitorKit.getSelectedRow(), 2).toString());
            txtEmail.setText(tblMonitorKit.getValueAt(tblMonitorKit.getSelectedRow(), 3).toString());
            txtCodMonDef.setText(tblMonitorKit.getValueAt(tblMonitorKit.getSelectedRow(), 4).toString());
            txtMarcaMonDef.setText(tblMonitorKit.getValueAt(tblMonitorKit.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_tblMonitorKitMouseClicked
        private void campos(model_monitorDef mdef){
            mdef.setNome_operador(txtNomeOP.getText());
            mdef.setEmail(txtEmail.getText());
            mdef.setCod_monitor(txtCodMonDef.getText());
            mdef.setMarca_monitor(txtMarcaMonDef.getText());
            mdef.setDescricao(txaDefMon.getText());
            mdef.setStatus(cboStatusMonitor.getSelectedItem().toString());
            mdef.setData(txtData.getText());
        }
    private void btnAddDefMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDefMonActionPerformed
        model_monitorDef mdef = new model_monitorDef();
        dao_monitorDef dao = new dao_monitorDef();
        campos(mdef);
        dao.addMonitorDef(mdef);
        selecionaKitMonitor();
    }//GEN-LAST:event_btnAddDefMonActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        model_monitorDef mdef = new model_monitorDef();
        dao_monitorDef dao = new dao_monitorDef();
        mdef.setId_monitor(txtMonitorNV.getText());
        mdef.setMarca_monitor(txtMarcaMonNov.getText());
        mdef.setCod_monitor(txtCodMonNV.getText());
        mdef.setId_kit(txtidKit.getText());
        dao.atualizaMonKIT(mdef);
        selecionaKitMonitor();  
        atualizarMonitor();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnPesquisarOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarOPActionPerformed
        pesquisarOperador(txtFindOp.getText());
    }//GEN-LAST:event_btnPesquisarOPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDefMon;
    private javax.swing.JButton btnPesquisarOP;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboSaida;
    private javax.swing.JComboBox<String> cboStatusMonitor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblMonNovo;
    private javax.swing.JTable tblMonitorKit;
    private javax.swing.JTextArea txaDefMon;
    private javax.swing.JTextField txtCodMonDef;
    private javax.swing.JTextField txtCodMonNV;
    private javax.swing.JTextField txtCodMonitorFind;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFindOp;
    private javax.swing.JTextField txtMarcaMonDef;
    private javax.swing.JTextField txtMarcaMonNov;
    private javax.swing.JTextField txtMonitorNV;
    private javax.swing.JTextField txtNomeOP;
    private javax.swing.JTextField txtidKit;
    // End of variables declaration//GEN-END:variables
}
