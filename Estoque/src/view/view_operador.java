/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.controler_cadOperador;
import dao.dao_operador;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.model_operador;

/**
 *
 * @author Usuário
 */
public class view_operador extends javax.swing.JInternalFrame {

    /**
     * Creates new form view_analista
     */
    controler_cadOperador cont;

    public view_operador() {
        cont = new controler_cadOperador();
        initComponents();
        readJtable();
        date();
        txtId.setEnabled(false);
    }

    public void date() {
        txtDat.setEnabled(false);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(
                new Runnable() {
            public void run() {
                txtDat.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
            }
        }, 1, 1, TimeUnit.SECONDS);

    }

    public void readJtable() {
        DefaultTableModel model = (DefaultTableModel) tblOperador.getModel();
        model.setNumRows(0);
        dao_operador dao = new dao_operador();
        dao.selectOperador().forEach((op) -> {
            /*  # id_operador,  nome_operador, email_operador, tel, celular, endereco, 
            cep, numero, complemento, referencia, bairro, cidade, estado, setor, cargo, status_operador,
             empresa, supervisor
             */
            model.addRow(new Object[]{
                op.getId_operador(),
                op.getNome_operador(),
                op.getEmail(),
                op.getTel(),
                op.getCelular(),
                op.getEnd(),
                op.getCep(),
                op.getNum(),
                op.getComplemento(),
                op.getReferencia(),
                op.getBairro(),
                op.getCidade(),
                op.getEstado(),
                op.getSetor(),
                op.getCargo(),
                op.getStatus(),
                op.getEmpresa(),
                op.getSupervisor()

            });
        });
    }

    public void pesquisar(String nome) {
        DefaultTableModel model = (DefaultTableModel) tblOperador.getModel();
        model.setNumRows(0);
        dao_operador dao = new dao_operador();
        dao.findOperador(nome).forEach((op) -> {
            /*  # id_operador,  nome_operador, email_operador, tel, celular, endereco, 
            cep, numero, complemento, referencia, bairro, cidade, estado, setor, cargo, status_operador,
             empresa, supervisor
             */
            model.addRow(new Object[]{
                op.getId_operador(),
                op.getNome_operador(),
                op.getEmail(),
                op.getTel(),
                op.getCelular(),
                op.getEnd(),
                op.getCep(),
                op.getNum(),
                op.getComplemento(),
                op.getReferencia(),
                op.getBairro(),
                op.getCidade(),
                op.getEstado(),
                op.getSetor(),
                op.getCargo(),
                op.getStatus(),
                op.getEmpresa(),
                op.getSupervisor()

            });
        });
    }

    public void campos(model_operador op) {
        op.setDatacad(txtDat.getText());
        op.setNome_operador(txtnome.getText());
        op.setEmail(txtemail.getText());
        op.setTel(txttel.getText());
        op.setCelular(txtcel.getText());
        op.setEnd(txtend.getText());
        op.setCep(txtcep.getText());
        op.setNum(txtnum.getText());
        op.setComplemento(txtcomp.getText());
        op.setReferencia(txtref.getText());
        op.setBairro(txtbairro.getText());
        op.setCidade(txtcity.getText());
        op.setEstado(txtest.getText());
        op.setEmpresa(txtope.getText());
        op.setSetor(txtset.getText());
        op.setSupervisor(txtsup.getText());
        op.setCargo(txtcargo.getText());
        op.setStatus(cboStatus.getSelectedItem().toString());

    }

    /*  # id_operador,  nome_operador, email_operador, tel, celular, endereco, 
            cep, numero, complemento, referencia, bairro, cidade, estado, setor, cargo, status_operador,
             empresa, supervisor
     */
    //Limpa os campos
    public void limpar() {
        txtnome.setText("");
        txtemail.setText("");
        txttel.setText("");
        txtcel.setText("");
        txtend.setText("");
        txtcep.setText("");
        txtnum.setText("");
        txtcomp.setText("");
        txtref.setText("");
        txtbairro.setText("");
        txtcity.setText("");
        txtest.setText("");
        txtset.setText("");
        txtcargo.setText("");
        txtope.setText("");
        cboStatus.setSelectedItem(null);//Combo box não seleciona nenhum item
        txtsup.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtset = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtsup = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtcargo = new javax.swing.JTextField();
        txttel = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtend = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcep = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtbairro = new javax.swing.JTextField();
        txtcity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcel = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtnum = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtcomp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtref = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtest = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtope = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDat = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtfindOP = new javax.swing.JTextField();
        btnFinder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOperador = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        brnDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1337, 690));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Operador"));

        jLabel16.setText("Nome:");

        jLabel17.setText("E-mail");

        jLabel18.setText("Telefone:");

        jLabel19.setText("Setor:");

        jLabel20.setText("Supervisor(a):");

        txtsup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsupActionPerformed(evt);
            }
        });

        jLabel21.setText("Cargo:");

        try {
            txttel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/op.png"))); // NOI18N

        jLabel2.setText("Endereço:");

        jLabel3.setText("Bairro:");

        jLabel4.setText("CEP:");

        try {
            txtcep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Cidade:");

        jLabel8.setText("Celular:");

        try {
            txtcel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Número:");

        jLabel10.setText("Complemento");

        jLabel11.setText("Referencia:");

        jLabel12.setText("Estado:");

        jLabel7.setText("Operação:");

        jLabel13.setText("Status:");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar:", "Sem Kit", "Com Kit" }));

        jLabel14.setText("ID:");

        jLabel15.setText("Data:");

        txtDat.setDisabledTextColor(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(102, 102, 102)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19)
                        .addComponent(jLabel3))
                    .addComponent(jLabel14))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcity))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(25, 25, 25)
                                .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtref, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtest, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtope, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDat, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnome))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtcel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtemail, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtset, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsup, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(348, 348, 348))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtcomp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4)
                    .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtref, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12)
                    .addComponent(txtest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtope, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(txtsup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel13)
                    .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar Operador"));

        jLabel5.setText("Nome Operador:");

        btnFinder.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnFinder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        btnFinder.setText("Pesquisar");
        btnFinder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinderActionPerformed(evt);
            }
        });

        tblOperador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome ", "E-mail", "Telefone", "Celular", "Endereço", "CEP", "Numero", "Complemento", "Referência", "Bairro", "Cidade", "Estado", "Setor", "Cargo", "Status", "Operação", "Supervisor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOperador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOperadorMouseClicked(evt);
            }
        });
        tblOperador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblOperadorKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblOperador);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfindOP, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinder)
                        .addGap(0, 811, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfindOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinder)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ferramentas-de-edicao.png"))); // NOI18N
        btnEdit.setText("Editar Operador");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        btnAdd.setText("Adicionar Operador");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        brnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        brnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/criss-cross.png"))); // NOI18N
        brnDelete.setText("Remover Operador");
        brnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnDeleteActionPerformed(evt);
            }
        });

        jButton1.setText("Limpar Campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEdit)
                        .addComponent(btnAdd)
                        .addComponent(brnDelete))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsupActionPerformed

    private void brnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnDeleteActionPerformed
        if (tblOperador.getSelectedRow() != -1) {
            model_operador op = new model_operador();
            dao_operador dao = new dao_operador();
            op.setId_operador(tblOperador.getValueAt(tblOperador.getSelectedRow(), 0).toString());
            dao.deleteOperador(op);
            readJtable();
        }
    }//GEN-LAST:event_brnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtnome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do operador");
        } else if (txtemail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o e-mail");
        } else {
            model_operador op = new model_operador();
            dao_operador dao = new dao_operador();
            //op.setId_operador(tblOperador.getValueAt(tblOperador.getSelectedRow(), 0).toString());
            campos(op);

            dao.addOp(op);
            readJtable();
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void tblOperadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOperadorMouseClicked
        if (tblOperador.getSelectedRow() != -1) {
            /*  # id_operador,  nome_operador, email_operador, tel, celular, endereco, 
            cep, numero, complemento, referencia, bairro, cidade, estado, setor, cargo, status_operador,
             empresa, supervisor
             */
            txtId.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 0).toString());
            txtnome.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 1).toString());
            txtemail.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 2).toString());
            // txtCpf.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 3).toString());
            txttel.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 3).toString());
            txtcel.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 4).toString());
            txtend.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 5).toString());
            txtcep.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 6).toString());
            txtnum.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 7).toString());
            txtcomp.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 8).toString());
            txtref.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 9).toString());
            txtbairro.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 10).toString());
            txtcity.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 11).toString());
            txtest.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 12).toString());
            txtset.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 13).toString());
            txtcargo.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 14).toString());
            cboStatus.setSelectedItem(tblOperador.getValueAt(tblOperador.getSelectedRow(), 15).toString());
            txtope.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 16).toString());
            txtsup.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 17).toString());
        }
    }//GEN-LAST:event_tblOperadorMouseClicked

    private void tblOperadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblOperadorKeyReleased
        if (tblOperador.getSelectedRow() != -1) {
            /*  # id_operador,  nome_operador, email_operador, tel, celular, endereco, 
            cep, numero, complemento, referencia, bairro, cidade, estado, setor, cargo, status_operador,
             empresa, supervisor
             */
            txtId.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 0).toString());
            txtnome.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 1).toString());
            txtemail.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 2).toString());
            // txtCpf.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 3).toString());
            txttel.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 3).toString());
            txtcel.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 4).toString());
            txtend.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 5).toString());
            txtcep.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 6).toString());
            txtnum.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 7).toString());
            txtcomp.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 8).toString());
            txtref.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 9).toString());
            txtbairro.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 10).toString());
            txtcity.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 11).toString());
            txtest.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 12).toString());
            txtset.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 13).toString());
            txtcargo.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 14).toString());
            cboStatus.setSelectedItem(tblOperador.getValueAt(tblOperador.getSelectedRow(), 15).toString());
            txtope.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 16).toString());
            txtsup.setText(tblOperador.getValueAt(tblOperador.getSelectedRow(), 17).toString());
        }
    }//GEN-LAST:event_tblOperadorKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFinderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinderActionPerformed
        pesquisar(txtfindOP.getText());
    }//GEN-LAST:event_btnFinderActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tblOperador.getSelectedRow() != -1) {
            model_operador op = new model_operador();
            dao_operador dao = new dao_operador();
            op.setId_operador(tblOperador.getValueAt(tblOperador.getSelectedRow(), 0).toString());
            op.setNome_operador(txtnome.getText());
            op.setEmail(txtemail.getText());
            op.setTel(txttel.getText());
            op.setCelular(txtcel.getText());
            op.setEnd(txtend.getText());
            op.setCep(txtcep.getText());
            op.setNum(txtnum.getText());
            op.setComplemento(txtcomp.getText());
            op.setReferencia(txtref.getText());
            op.setBairro(txtbairro.getText());
            op.setCidade(txtcity.getText());
            op.setEstado(txtest.getText());
            op.setEmpresa(txtope.getText());
            op.setSetor(txtset.getText());
            op.setSupervisor(txtsup.getText());
            op.setCargo(txtcargo.getText());
            op.setStatus(cboStatus.getSelectedItem().toString());
            dao.updateoperador(op);
            readJtable();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked

    }//GEN-LAST:event_btnAddMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnDelete;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFinder;
    private javax.swing.JComboBox<Object> cboStatus;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOperador;
    private javax.swing.JTextField txtDat;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JTextField txtcargo;
    private javax.swing.JFormattedTextField txtcel;
    private javax.swing.JFormattedTextField txtcep;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtcomp;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtend;
    private javax.swing.JTextField txtest;
    private javax.swing.JTextField txtfindOP;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtope;
    private javax.swing.JTextField txtref;
    private javax.swing.JTextField txtset;
    private javax.swing.JTextField txtsup;
    private javax.swing.JFormattedTextField txttel;
    // End of variables declaration//GEN-END:variables
}
