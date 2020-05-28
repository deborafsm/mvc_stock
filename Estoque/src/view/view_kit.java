/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.dao_kitSaida;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;
import model.model_head;
import model.model_kitSaida;

/**
 *
 * @author Debora Freire T.I JobHome
 */
public class view_kit extends javax.swing.JInternalFrame {

    /**
     * Creates new form view_kit
     */
    public view_kit() {
        initComponents();
        date();
        cabos();
        readJtable();
        readJtableMonitor();
        readJtableOp();
        readJtableMouse();
        readJtableTeclado();
        cboWebCam();
        cboHead();
    }

    public void valorCbo() {
        cboHead.setSelectedItem(0);
    }

    //Valores Padroes de cabos 
    public void cabos() {
        txtEnerg.setText("2");
        txtEnerg.setEnabled(false);
        txtVGA.setText("1");
        txtVGA.setEnabled(false);

    }

    //Data do formulario
    public void date() {
        txtData.setEnabled(false);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(
                new Runnable() {
            public void run() {
                txtData.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
            }
        }, 1, 1, TimeUnit.SECONDS);

    }

    //Exibe no CBO - (Código do WebCam)
    public void cboWebCam() {//Chama dados do bd no combobox
        dao_kitSaida dao = new dao_kitSaida();
        for (model_kitSaida w : dao.findWebCam()) {
            cboWeb.addItem(w);
        }
    }

    //Exibe no CBO - (Código do head)
    public void cboHead() {//Chama dados do bd no combobox
        dao_kitSaida dao = new dao_kitSaida();
        for (model_head h : dao.findHead()) {
            cboHead.addItem(h);
        }
    }

    //Exibe na tabela - (Dados do PC)
    public void readJtable() {
        DefaultTableModel model = (DefaultTableModel) tblPC.getModel();
        model.setNumRows(0);
        dao_kitSaida dao = new dao_kitSaida();
        dao.findAll().forEach((pc) -> {
            // for é usado para passar pelos objetos
            model.addRow(new Object[]{
                pc.getId_pc(),
                pc.getCod_pc(),
                pc.getMarca(),
                pc.getModelo(),
                pc.getProcessador(),
                pc.getMemoria(),
                pc.getSo(),
                pc.getHd(),
                pc.getGarantia()

            });
        });
    }

    //Exibe na tabela os dadaos do monitor 
    public void readJtableMonitor() {
        DefaultTableModel model = (DefaultTableModel) tblMonitor.getModel();
        model.setNumRows(0);
        dao_kitSaida dao = new dao_kitSaida();
        dao.findAllMonitor().forEach((pc) -> {
            // for é usado para passar pelos objetos
            model.addRow(new Object[]{
                pc.getId_monitor(),
                pc.getCod_monitor(),
                pc.getMarcamon(),
                pc.getModelmon()

            });
        });
    }

    //Exibe na tabela os dados do (OPERADOR)
    public void readJtableOp() {
        DefaultTableModel model = (DefaultTableModel) tbOperador.getModel();
        model.setNumRows(0);
        dao_kitSaida dao = new dao_kitSaida();
        dao.findAllOp().forEach((pc) -> {
            // for é usado para passar pelos objetos
            model.addRow(new Object[]{
                pc.getId_operador(),
                pc.getNome(),
                pc.getTelefone(),
                pc.getEmail(),
                pc.getEndereco(),
                pc.getCargo(),
                pc.getSetor(),
                pc.getSupervisor()

            });
        });
    }

    //Exibe na tabela os dados do (MOUSE)
    public void readJtableMouse() {
        DefaultTableModel model = (DefaultTableModel) tblMouse.getModel();
        model.setNumRows(0);
        dao_kitSaida dao = new dao_kitSaida();
        dao.findMouse().forEach((pc) -> {
            model.addRow(new Object[]{
                pc.getCod_mouse(),
                pc.getMarcamouse()
            });
        });
    }

    //Exibe na tabela os dados (TECLADO)
    public void readJtableTeclado() {
        DefaultTableModel model = (DefaultTableModel) tblTeclado.getModel();
        model.setNumRows(0);
        dao_kitSaida dao = new dao_kitSaida();
        dao.findTeclado().forEach((pc) -> {
            model.addRow(new Object[]{
                pc.getCod_teclado(),
                pc.getMarcateclado()
            });
        });
    }

    //Exibe na tabela os dados (WEBCAM)
    public void readJtableWebCam() {
        DefaultTableModel model = (DefaultTableModel) tblTeclado.getModel();
        model.setNumRows(0);
        dao_kitSaida dao = new dao_kitSaida();
        dao.findWebCam().forEach((pc) -> {
            model.addRow(new Object[]{
                pc.getCod_webcam(),});
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
        txtFindMonitor = new javax.swing.JTextField();
        btnMonitor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMonitor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtPC = new javax.swing.JTextField();
        btnPC = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPC = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        txtOperador = new javax.swing.JTextField();
        btnOp = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbOperador = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtMouse = new javax.swing.JTextField();
        btmMon = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMouse = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        txtTeclado = new javax.swing.JTextField();
        btnTeclado = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblTeclado = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtMonModel = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtCodMon = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCodPc = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtProcessador = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtRam = new javax.swing.JTextField();
        txtHD = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtSO = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtGarantia = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtIDOP = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        txtSetor = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtSuper = new javax.swing.JTextField();
        txtidMonitor = new javax.swing.JTextField();
        txtMonMarca = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtCodigoTeclado = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtCodMouse = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cboHead = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cboWeb = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtMarcaMouse = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMarcaTeclado = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtVGA = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtEnerg = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        cboWeb1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1600, 600));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitor"));

        txtFindMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindMonitorActionPerformed(evt);
            }
        });

        btnMonitor.setText("Pesquisar");
        btnMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorActionPerformed(evt);
            }
        });

        jLabel2.setText("Código do Monitor:");

        tblMonitor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "codigo", "marca", "modelo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonitorMouseClicked(evt);
            }
        });
        tblMonitor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblMonitorKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblMonitor);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFindMonitor)
                        .addGap(87, 87, 87)
                        .addComponent(btnMonitor))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMonitor)
                    .addComponent(txtFindMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("PC"));

        txtPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPCActionPerformed(evt);
            }
        });

        btnPC.setText("Pesquisar");
        btnPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPCActionPerformed(evt);
            }
        });

        jLabel1.setText("Código PC:");

        tblPC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "codigo", "marca", "modelo", "processador", "memoria", "so", "hd", "garantia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPCMouseClicked(evt);
            }
        });
        tblPC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPCKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPC);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPC)
                        .addGap(109, 109, 109)
                        .addComponent(btnPC))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPC)
                    .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Operador"));

        txtOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOperadorActionPerformed(evt);
            }
        });

        btnOp.setText("Pesquisar");
        btnOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpActionPerformed(evt);
            }
        });

        jLabel8.setText("Nome Operador:");

        tbOperador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_OPERADOR", "Nome ", "Telefone", "E-mail", "Endereço", "Cargo", "Setor", "Supervisor(a)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbOperador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOperadorMouseClicked(evt);
            }
        });
        tbOperador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbOperadorKeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(tbOperador);
        if (tbOperador.getColumnModel().getColumnCount() > 0) {
            tbOperador.getColumnModel().getColumn(2).setHeaderValue("Telefone");
            tbOperador.getColumnModel().getColumn(3).setHeaderValue("E-mail");
            tbOperador.getColumnModel().getColumn(4).setHeaderValue("Endereço");
            tbOperador.getColumnModel().getColumn(5).setHeaderValue("Cargo");
            tbOperador.getColumnModel().getColumn(6).setHeaderValue("Setor");
            tbOperador.getColumnModel().getColumn(7).setResizable(false);
            tbOperador.getColumnModel().getColumn(7).setHeaderValue("Supervisor(a)");
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtOperador)
                .addGap(93, 93, 93)
                .addComponent(btnOp))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOp)
                    .addComponent(txtOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Mouse"));

        txtMouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMouseActionPerformed(evt);
            }
        });

        btmMon.setText("Pesquisar");
        btmMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmMonActionPerformed(evt);
            }
        });

        jLabel6.setText("Código do Mouse:");

        tblMouse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "codigo", "marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMouse.setPreferredSize(new java.awt.Dimension(413, 64));
        tblMouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseMouseClicked(evt);
            }
        });
        tblMouse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblMouseKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblMouse);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMouse, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btmMon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btmMon)
                    .addComponent(txtMouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Teclado"));

        txtTeclado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTecladoActionPerformed(evt);
            }
        });

        btnTeclado.setText("Pesquisar");
        btnTeclado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTecladoActionPerformed(evt);
            }
        });

        jLabel9.setText("Código Teclado:");

        tblTeclado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "codigo", "marca "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTeclado.setPreferredSize(new java.awt.Dimension(413, 64));
        tblTeclado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTecladoMouseClicked(evt);
            }
        });
        tblTeclado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblTecladoKeyReleased(evt);
            }
        });
        jScrollPane9.setViewportView(tblTeclado);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtTeclado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTeclado))
            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTeclado)
                    .addComponent(txtTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Kit"));

        jLabel22.setText("Id_monitor");

        jLabel37.setText("Modelo:");

        jLabel23.setText("Cod_monitor");

        jLabel12.setText("ID_PC:");

        jLabel13.setText("Código PC:");

        jLabel30.setText("Modelo:");

        jLabel29.setText("Marca:");

        jLabel31.setText("Processador:");

        jLabel32.setText("Memoria:");

        jLabel34.setText("HD:");

        jLabel33.setText("S.O:");

        jLabel35.setText("Garantia:");

        txtData.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        jLabel24.setText("Data KIT:");

        jLabel14.setText("ID_Operador:");

        jLabel15.setText("Nome:");

        jLabel16.setText("Telefone:");

        jLabel17.setText("E-mail:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel7.setText("Endereço:");

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        txtSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSetorActionPerformed(evt);
            }
        });

        jLabel18.setText("Cargo:");

        jLabel19.setText("Setor:");

        jLabel20.setText("Supervisor(a):");

        txtidMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidMonitorActionPerformed(evt);
            }
        });

        jLabel36.setText("Marca:");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel5.setText("Empresa:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmpresa))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDOP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMonMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtidMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMonModel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCodMon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(199, 199, 199))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSuper))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTel))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNome))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtEmail))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel31)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtProcessador, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel32))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel33)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtSO, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel34))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel29))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel30))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                            .addGap(0, 0, Short.MAX_VALUE)
                                                            .addComponent(jLabel13)))))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtCodPc)
                                                .addComponent(txtModel)
                                                .addComponent(txtHD)
                                                .addComponent(txtRam, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtCodPc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtProcessador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(txtRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtSO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(txtHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtSuper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txtMonMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtidMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMonModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Kit Perifericos"));
        jPanel5.setPreferredSize(new java.awt.Dimension(427, 150));

        jLabel26.setText("cod_teclado:");

        jLabel25.setText("cod_mouse:");

        jLabel11.setText("WebCam:");

        cboWeb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboWebKeyReleased(evt);
            }
        });

        jLabel10.setText("Head: ");

        txtMarcaMouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaMouseActionPerformed(evt);
            }
        });

        jLabel3.setText("Marca Mouse:");

        jLabel4.setText("Marca Teclado:");

        txtMarcaTeclado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaTecladoActionPerformed(evt);
            }
        });

        jLabel39.setForeground(new java.awt.Color(255, 0, 0));
        jLabel39.setText("Cabo VGA:");

        txtVGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVGAActionPerformed(evt);
            }
        });

        jLabel38.setForeground(new java.awt.Color(255, 0, 0));
        jLabel38.setText("Energia:");

        jLabel21.setText("Status:");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Saida" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/promocoes.png"))); // NOI18N
        jButton1.setText("Adicionar Kit");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel40.setForeground(new java.awt.Color(255, 0, 0));
        jLabel40.setText("Cabo de Rede:");

        cboWeb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:", "Sim", "Não" }));
        cboWeb1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboWeb1KeyReleased(evt);
            }
        });

        jButton2.setText("Limpar campos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEnerg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(23, 23, 23)
                                    .addComponent(cboHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel25)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCodMouse))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel26)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCodigoTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMarcaMouse, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtMarcaTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(cboWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel39)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtVGA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel40)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboWeb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtCodMouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarcaMouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtCodigoTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMarcaTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cboWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtVGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(txtEnerg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(cboWeb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(401, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPCActionPerformed

    private void txtPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPCActionPerformed

    private void txtFindMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindMonitorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindMonitorActionPerformed

    private void btnMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMonitorActionPerformed

    private void txtOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOperadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOperadorActionPerformed

    private void btnOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpActionPerformed

    private void tblPCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPCKeyReleased
        if (tblPC.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtID.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 0).toString());
            txtCodPc.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 1).toString());
            txtMarca.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 2).toString());
            txtModel.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 3).toString());
            txtProcessador.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 4).toString());
            txtRam.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 5).toString());
            txtSO.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 6).toString());
            txtHD.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 7).toString());
            txtGarantia.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 8).toString());

        }
    }//GEN-LAST:event_tblPCKeyReleased

    private void tblPCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPCMouseClicked
        if (tblPC.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtID.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 0).toString());
            txtCodPc.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 1).toString());
            txtMarca.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 2).toString());
            txtModel.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 3).toString());
            txtProcessador.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 4).toString());
            txtRam.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 5).toString());
            txtSO.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 6).toString());
            txtHD.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 7).toString());
            txtGarantia.setText(tblPC.getValueAt(tblPC.getSelectedRow(), 8).toString());

        }
    }//GEN-LAST:event_tblPCMouseClicked

    private void tblMonitorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMonitorKeyReleased
        if (tblMonitor.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtidMonitor.setText(tblMonitor.getValueAt(tblMonitor.getSelectedRow(), 0).toString());
            txtCodMon.setText(tblMonitor.getValueAt(tblMonitor.getSelectedRow(), 1).toString());
            txtMonMarca.setText(tblMonitor.getValueAt(tblMonitor.getSelectedRow(), 2).toString());
            txtMonModel.setText(tblMonitor.getValueAt(tblMonitor.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_tblMonitorKeyReleased

    private void tblMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonitorMouseClicked
        if (tblMonitor.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtidMonitor.setText(tblMonitor.getValueAt(tblMonitor.getSelectedRow(), 0).toString());
            txtCodMon.setText(tblMonitor.getValueAt(tblMonitor.getSelectedRow(), 1).toString());
            txtMonMarca.setText(tblMonitor.getValueAt(tblMonitor.getSelectedRow(), 2).toString());
            txtMonModel.setText(tblMonitor.getValueAt(tblMonitor.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_tblMonitorMouseClicked

    private void tbOperadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbOperadorKeyReleased
        if (tbOperador.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtIDOP.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 0).toString());
            txtNome.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 1).toString());
            txtTel.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 2).toString());
            txtEmail.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 3).toString());
            txtEndereco.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 4).toString());
            txtCargo.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 5).toString());
            txtSetor.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 6).toString());
            txtSuper.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 7).toString());
        }
    }//GEN-LAST:event_tbOperadorKeyReleased

    private void tbOperadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOperadorMouseClicked
        if (tbOperador.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtIDOP.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 0).toString());
            txtNome.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 1).toString());
            txtTel.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 2).toString());
            txtEmail.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 3).toString());
            txtEndereco.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 4).toString());
            txtCargo.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 5).toString());
            txtSetor.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 6).toString());
            txtSuper.setText(tbOperador.getValueAt(tbOperador.getSelectedRow(), 7).toString());
        }
    }//GEN-LAST:event_tbOperadorMouseClicked

    private void txtMouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMouseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMouseActionPerformed

    private void btmMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmMonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btmMonActionPerformed

    private void tblMouseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseMouseClicked
        if (tblMouse.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtCodMouse.setText(tblMouse.getValueAt(tblMouse.getSelectedRow(), 0).toString());
            txtMarcaMouse.setText(tblMouse.getValueAt(tblMouse.getSelectedRow(), 1).toString());

        }
    }//GEN-LAST:event_tblMouseMouseClicked

    private void tblMouseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMouseKeyReleased
        if (tblMouse.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtCodMouse.setText(tblMouse.getValueAt(tblMouse.getSelectedRow(), 0).toString());
            txtMarcaMouse.setText(tblMouse.getValueAt(tblMouse.getSelectedRow(), 1).toString());

        }
    }//GEN-LAST:event_tblMouseKeyReleased

    private void txtTecladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTecladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTecladoActionPerformed

    private void btnTecladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTecladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTecladoActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtidMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidMonitorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidMonitorActionPerformed

    private void txtVGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVGAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVGAActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSetorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSetorActionPerformed

    private void txtMarcaTecladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaTecladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaTecladoActionPerformed

    private void tblTecladoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTecladoKeyReleased
        if (tblTeclado.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtCodigoTeclado.setText(tblTeclado.getValueAt(tblTeclado.getSelectedRow(), 0).toString());
            txtMarcaTeclado.setText(tblTeclado.getValueAt(tblTeclado.getSelectedRow(), 1).toString());

        }
    }//GEN-LAST:event_tblTecladoKeyReleased

    private void tblTecladoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTecladoMouseClicked
        if (tblTeclado.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtCodigoTeclado.setText(tblTeclado.getValueAt(tblTeclado.getSelectedRow(), 0).toString());
            txtMarcaTeclado.setText(tblTeclado.getValueAt(tblTeclado.getSelectedRow(), 1).toString());

        }
    }//GEN-LAST:event_tblTecladoMouseClicked

    private void cboWebKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboWebKeyReleased

    }//GEN-LAST:event_cboWebKeyReleased

    private void txtMarcaMouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaMouseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaMouseActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        txtData.setText(new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
    }//GEN-LAST:event_txtDataActionPerformed

    private void cboWeb1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboWeb1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cboWeb1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Insere 
        //Atualiza PC
        if (tblPC.getSelectedRow() != -1) {
            model_kitSaida kit = new model_kitSaida();
            dao_kitSaida dao = new dao_kitSaida();
            //Seta todos os campos que podem ser atualizados
            kit.setStatus(cboStatus.getSelectedItem().toString());
            //A atualização só vai ser possivel atraves do Código
            kit.setCod_pc((String) tblPC.getValueAt(tblPC.getSelectedRow(), 1));
            //Chama metodo UPDATE 
            dao.updateCliente(kit);
            //Atualiza os campos da tabela
            readJtable();
        }
        if (tblPC.getSelectedRow() != -1) {
            model_kitSaida kit = new model_kitSaida();
            dao_kitSaida dao = new dao_kitSaida();
            //Seta todos os campos que podem ser atualizados
            //A atualização só vai ser possivel atraves do Código
            //Chama metodo UPDATE 
            //Atualiza os campos da tabela
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void campos(model_kitSaida kit) {
        //Data
        kit.setDatakitSaida(txtData.getText());
        //PC
        kit.setId_pc(txtID.getText());
        kit.setCod_pc(txtCodPc.getText());
        kit.setMarca(txtMarca.getText());
        kit.setModelo(txtModel.getText());
        kit.setProcessador(txtProcessador.getText());
        kit.setMemoria(txtRam.getText());
        kit.setSo(txtSO.getText());
        kit.setHd(txtHD.getText());
        kit.setGarantia(txtGarantia.getText());
        //Operador
        kit.setId_operador(txtIDOP.getText());
        kit.setNome(txtNome.getText());
        kit.setTelefone(txtTel.getText());
        kit.setEmail(txtEmail.getText());
        kit.setEndereco(txtEndereco.getText());
        kit.setSetor(txtSetor.getText());
        kit.setCargo(txtCargo.getText());
        kit.setSupervisor(txtSuper.getText());
        kit.setId_monitor(txtFindMonitor.getText());
        kit.setCod_monitor(txtCodMon.getText());
        kit.setModelmon(txtMonModel.getText());
        kit.setMarcamon(txtMonMarca.getText());
        kit.setEmpresa(txtEmpresa.getText());
        //Status / Head / WebCam -------- ComboBox
        kit.setStatus(cboStatus.getSelectedItem().toString());
        kit.setId_head(cboHead.getSelectedItem().toString());//Codigo
        kit.setCod_webcam(cboWeb.getSelectedItem().toString());
        //Mouse
        kit.setCod_mouse(txtMouse.getText());
        kit.setMarcamouse(txtMouse.getText());
        //Teclaod
        kit.setCod_teclado(txtCodigoTeclado.getText());
        kit.setMarcateclado(txtMarcaTeclado.getText());
        //Cabos
        kit.setQntEnergia(txtEnerg.getText());
        kit.setQntVga(txtVGA.getText());
        kit.setRede(cboWeb1.getSelectedItem().toString());

    }

    public void limpar() {
        //Operador
        txtIDOP.setText("");
        txtNome.setText("");
        txtTel.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtSetor.setText("");
        txtCargo.setText("");
        txtSuper.setText("");
        //PC
        txtID.setText("");
        txtCodPc.setText("");
        txtMarca.setText("");
        txtModel.setText("");
        txtProcessador.setText("");
        txtRam.setText("");
        txtSO.setText("");
        txtHD.setText("");
        txtGarantia.setText("");
        //Monitr
        txtidMonitor.setText("");
        txtCodMon.setText("");
        txtMonMarca.setText("");
        txtMonModel.setText("");
        //Status n
        //cod head n
        // cod web n
        txtCodMouse.setText("");//Mouse
        txtMarcaMouse.setText("");
        txtCodigoTeclado.setText("");//Teclado
        txtMarcaTeclado.setText("");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmMon;
    private javax.swing.JButton btnMonitor;
    private javax.swing.JButton btnOp;
    private javax.swing.JButton btnPC;
    private javax.swing.JButton btnTeclado;
    private javax.swing.JComboBox<Object> cboHead;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JComboBox<Object> cboWeb;
    private javax.swing.JComboBox<Object> cboWeb1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable tbOperador;
    private javax.swing.JTable tblMonitor;
    private javax.swing.JTable tblMouse;
    private javax.swing.JTable tblPC;
    private javax.swing.JTable tblTeclado;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCodMon;
    private javax.swing.JTextField txtCodMouse;
    private javax.swing.JTextField txtCodPc;
    private javax.swing.JTextField txtCodigoTeclado;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEnerg;
    private javax.swing.JTextField txtFindMonitor;
    private javax.swing.JTextField txtGarantia;
    private javax.swing.JTextField txtHD;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDOP;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMarcaMouse;
    private javax.swing.JTextField txtMarcaTeclado;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtMonMarca;
    private javax.swing.JTextField txtMonModel;
    private javax.swing.JTextField txtMouse;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtOperador;
    private javax.swing.JTextField txtPC;
    private javax.swing.JTextField txtProcessador;
    private javax.swing.JTextField txtRam;
    private javax.swing.JTextField txtSO;
    private javax.swing.JTextField txtSetor;
    private javax.swing.JTextField txtSuper;
    private javax.swing.JTextField txtTeclado;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtVGA;
    private javax.swing.JTextField txtidMonitor;
    // End of variables declaration//GEN-END:variables
}
