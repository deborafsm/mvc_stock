/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.dao_kitSaida;
import dao.dao_pcDef;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.model_kitSaida;
import model.model_pc;
import model.model_pcDef;

/**
 *
 * @author jobhome
 */
public class view_pcDef extends javax.swing.JInternalFrame {

    /**
     * Creates new form view_kitEntrada
     */
    public view_pcDef() {
        initComponents();
        selecionaKit();//Seleciona kits existentes
        readJtable(); //Seleciona os pcs no estoque
        date();//Mostra a data
        offTablePCnv();//desabilita a tabela para novo pc

    }

    public void date() { //Mostra data
        txtDataDK.setEnabled(false);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(
                new Runnable() {
            public void run() {
                txtDataDK.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
            }
        }, 1, 1, TimeUnit.SECONDS);

    }
    
    //Desabilita tabela de pc nv
    public void offTablePCnv() {
        tblPCnv.setEnabled(false);
        tblPCnv.setForeground(Color.gray);
    }
    //Habilita tabela de pc nv
    public void OnTablePCnv() {
        tblPCnv.setEnabled(true);
        tblPCnv.setForeground(Color.black);
    }
    
    //Desabilita campos do pc com defeito
    public void desabilitarPane() {
        txtCodPcDefeito.setEnabled(false);
        txtDataDK.setEnabled(false);
        txtPCDefeito.setEnabled(false);
        txtMarcapcDefeito.setEnabled(false);
        txtmodelopcDef.setEnabled(false);
        txtsoDefeito.setEnabled(false);
        txtGarDefeito.setEnabled(false);
        txtRamDefeito.setEnabled(false);
        txtCPUDefeito.setEnabled(false);
        txtHDDefeito.setEnabled(false);
        cboStatusMonitor.setEnabled(false);
        txaDescPC.setEnabled(false);
        txtEmail.setEnabled(false);
        txtNomeOP.setEnabled(false);
        txtIDfORM.setEnabled(false);
        brnDefeito.setEnabled(false);
    }
    public void habilitarFields() {
        txtCodPcDefeito.setEnabled(true);
        txtDataDK.setEnabled(true);
        txtPCDefeito.setEnabled(true);
        txtMarcapcDefeito.setEnabled(true);
        txtmodelopcDef.setEnabled(true);
        txtsoDefeito.setEnabled(true);
        txtGarDefeito.setEnabled(true);
        txtRamDefeito.setEnabled(true);
        txtCPUDefeito.setEnabled(true);
        txtHDDefeito.setEnabled(true);
        cboStatusMonitor.setEnabled(true);
        txaDescPC.setEnabled(true);
        txtEmail.setEnabled(true);
        txtNomeOP.setEnabled(true);
        txtIDfORM.setEnabled(true);
        brnDefeito.setEnabled(true);
    }
    //Para pesquiar operador
    public void pesquisarOperador(String nome_operador) {
        DefaultTableModel model = (DefaultTableModel) tblKitPc.getModel();
        model.setNumRows(0);
        dao_pcDef dao = new dao_pcDef();

        dao.pesquisaOperador(nome_operador).forEach((pc) -> {
            model.addRow(new Object[]{
                //Chama os itens 
                pc.getId_kit(),
                pc.getLacre(),
                pc.getNome_operador(),
                pc.getEmail(),
                pc.getCod_pcDef(),
                pc.getNomePcDef(),
                pc.getMarca_pcDef(),
                pc.getModelo_pcDef(),
                pc.getCpu_pcDef(),
                pc.getHd_pcDef(),
                pc.getRam_pcDef(),
                pc.getSo_pcDef(),
                pc.getGarantia_pcDef()
            });
        });

    }
    //Para pesquisar pc
    public void pesquisaPC(String cod_pc) {
        DefaultTableModel model = (DefaultTableModel) tblPCnv.getModel();
        model.setNumRows(0);
        dao_pcDef dao = new dao_pcDef();

        dao.pesquisarPc(cod_pc).forEach((pc) -> {
            model.addRow(new Object[]{
                //Chama os itens 

                pc.getNomepc(),
                pc.getCodPC(),
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
    //Para selecionar kits existentes no banco de dados
    public void selecionaKit() {
        DefaultTableModel model = (DefaultTableModel) tblKitPc.getModel();
        model.setNumRows(0);
        dao_pcDef kitpc = new dao_pcDef();

        kitpc.selecionaKit().forEach((pc) -> {
            // for é usado para passar pelos objetos
            model.addRow(new Object[]{
                pc.getId_kit(),
                pc.getLacre(),
                pc.getNome_operador(),
                pc.getEmail(),
                pc.getCod_pcDef(),
                pc.getNomePcDef(),
                pc.getMarca_pcDef(),
                pc.getModelo_pcDef(),
                pc.getCpu_pcDef(),
                pc.getHd_pcDef(),
                pc.getRam_pcDef(),
                pc.getSo_pcDef(),
                pc.getGarantia_pcDef()

            });
        });
    }

    public void readJtable() {
        DefaultTableModel model = (DefaultTableModel) tblPCnv.getModel();
        model.setNumRows(0);
        dao_kitSaida dao = new dao_kitSaida();
        dao.findAll().forEach((pc) -> {
            // for é usado para passar pelos objetos
            model.addRow(new Object[]{
                pc.getNome(),
                pc.getCod_pc(),
                pc.getMarca(),
                pc.getModelo(),
                pc.getProcessador(),
                pc.getMemoria(),
                pc.getSo(),
                pc.getHd(),
                pc.getGarantia(),});
        });
    }
    //Campos do pc com defeito
    public void campos(model_pcDef pcDef) {
        pcDef.setCod_pcDef(txtCodPcDefeito.getText());
        pcDef.setDatadef(txtDataDK.getText());
        pcDef.setNomePcDef(txtPCDefeito.getText());
        pcDef.setMarca_pcDef(txtMarcapcDefeito.getText());
        pcDef.setModelo_pcDef(txtmodelopcDef.getText());
        pcDef.setSo_pcDef(txtsoDefeito.getText());
        pcDef.setGarantia_pcDef(txtGarDefeito.getText());
        pcDef.setRam_pcDef(txtRamDefeito.getText());
        pcDef.setCpu_pcDef(txtCPUDefeito.getText());
        pcDef.setHd_pcDef(txtHDDefeito.getText());
        pcDef.setStatus_pcDef(cboStatusMonitor.getSelectedItem().toString());
        pcDef.setDescricao_pcDef(txaDescPC.getText());
        pcDef.setEmail(txtEmail.getText());
        pcDef.setNome_operador(txtNomeOP.getText());

    }
    //campos do pc novo
    public void camposPCnovo(model_pc pc) {
        pc.setNomepc(txtPCnv.getText());
        pc.setCodPC(txtCodPcnv.getText());
        pc.setMarca(txtMarcapcnv.getText());
        pc.setModelo(txtpcModelonv.getText());
        pc.setProcessador(txtCPUnv.getText());
        pc.setMemoria(txtRamnv.getText());
        pc.setSo(txtsonv.getText());
        pc.setHd(txtHDnv.getText());
        pc.setGarantia(txtGarnv.getText());
    }
    //para limpar campos
    public void limparTudo() {
        txtEmail.setText("");
        txtPCDefeito.setText("");
        txtCodPcDefeito.setText("");
        txtMarcapcDefeito.setText("");
        txtmodelopcDef.setText("");
        txtCPUDefeito.setText("");
        txtRamDefeito.setText("");
        txtsoDefeito.setText("");
        txtHDDefeito.setText("");
        txtGarDefeito.setText("");
        txtPCnv.setText("");
        txtCodPcnv.setText("");
        txtMarcapcnv.setText("");
        txtpcModelonv.setText("");
        txtCodPcnv.setText("");
        txtRamnv.setText("");
        txtsonv.setText("");
        txtHDnv.setText("");
        txtGarnv.setText("");

    }
    //Atualiza o status para "Saida"
    public void atualizaPC() {
        model_kitSaida pcnv = new model_kitSaida();
        dao_kitSaida dao = new dao_kitSaida();
        if (tblPCnv.getSelectedRow() != -1) {
            //Seta todos os campos que podem ser atualizados
            pcnv.setStatus(cboStatusPC.getSelectedItem().toString());//Pega o valor do combobox
            //A atualização só vai ser possivel atraves do Código
            pcnv.setCod_pc((String) tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 1));
            //Chama metodo UPDATE 
            dao.updatePC(pcnv);
            //Atualiza os campos da tabela
            readJtable();
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

        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtNomeOP = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtDataDK = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtIDfORM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pnlPCDEFEITO = new javax.swing.JPanel();
        txtPCDefeito = new javax.swing.JTextField();
        txtMarcapcDefeito = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtCodPcDefeito = new javax.swing.JTextField();
        txtmodelopcDef = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtRamDefeito = new javax.swing.JTextField();
        txtHDDefeito = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtCPUDefeito = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtGarDefeito = new javax.swing.JTextField();
        txtsoDefeito = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaDescPC = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        cboStatusMonitor = new javax.swing.JComboBox<>();
        brnDefeito = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKitPc = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtFindop = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPCnv = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtFindPc = new javax.swing.JTextField();
        txtPCnv = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCodPcnv = new javax.swing.JTextField();
        txtpcModelonv = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtMarcapcnv = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtsonv = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtCPUnv = new javax.swing.JTextField();
        txtGarnv = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtHDnv = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtRamnv = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboStatusPC = new javax.swing.JComboBox<>();
        btnAtualizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1439, 690));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Do Operador"));

        jLabel15.setText("Nome:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel17.setText("E-mail:");

        txtDataDK.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtDataDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataDKActionPerformed(evt);
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
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtDataDK, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDfORM, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNomeOP)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDataDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDfORM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNomeOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pnlPCDEFEITO.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Dados do PC"), "PC com Defeito"));

        txtPCDefeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPCDefeitoActionPerformed(evt);
            }
        });

        jLabel29.setText("Marca:");

        jLabel12.setText("Nome PC:");

        jLabel13.setText("Cod_PC");

        jLabel30.setText("Modelo:");

        txtmodelopcDef.setPreferredSize(new java.awt.Dimension(20, 20));
        txtmodelopcDef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmodelopcDefActionPerformed(evt);
            }
        });

        jLabel32.setText("RAM:");

        jLabel31.setText("CPU:");

        jLabel33.setText("S.O:");

        jLabel35.setText("Garantia:");

        jLabel34.setText("HD:");

        txaDescPC.setColumns(20);
        txaDescPC.setRows(5);
        jScrollPane4.setViewportView(txaDescPC);

        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("Defeito PC:");

        jLabel46.setText("Status:");

        cboStatusMonitor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Defeito" }));

        brnDefeito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/erro.png"))); // NOI18N
        brnDefeito.setText("Adicionar Defeito");
        brnDefeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnDefeitoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPCDEFEITOLayout = new javax.swing.GroupLayout(pnlPCDEFEITO);
        pnlPCDEFEITO.setLayout(pnlPCDEFEITOLayout);
        pnlPCDEFEITOLayout.setHorizontalGroup(
            pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(brnDefeito)
                    .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                        .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                                .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                                        .addComponent(txtsoDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel35))
                                    .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                                        .addComponent(txtRamDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHDDefeito)))
                                .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtGarDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPCDEFEITOLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCPUDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                                .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPCDefeito)
                                    .addComponent(txtMarcapcDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtmodelopcDef, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCodPcDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addGap(4, 4, 4)
                                .addComponent(cboStatusMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlPCDEFEITOLayout.setVerticalGroup(
            pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                        .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtPCDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtMarcapcDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel33)
                            .addComponent(txtsoDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGarDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtRamDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(txtHDDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(txtCPUDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(cboStatusMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPCDEFEITOLayout.createSequentialGroup()
                        .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCodPcDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPCDEFEITOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel30)
                                .addComponent(txtmodelopcDef, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(brnDefeito)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlPCDEFEITOLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMarcapcDefeito, txtmodelopcDef});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Kits Existentes"));

        tblKitPc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_KIT", "Lacre KIT", "Nome Operadora", "Email", "Cod_PC", "Nome_PC", "Marca", "Modelo", "Processador", "HD", "Memoria", "SO", "Garantia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKitPc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKitPcMouseClicked(evt);
            }
        });
        tblKitPc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblKitPcKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblKitPc);
        if (tblKitPc.getColumnModel().getColumnCount() > 0) {
            tblKitPc.getColumnModel().getColumn(4).setResizable(false);
            tblKitPc.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel2.setText("Nome Operador(a):");

        jButton2.setText("Pesquisar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtFindop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFindop, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jButton2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtFindop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("PC novo"));

        tblPCnv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome_PC", "Cod_PC", "Marca_PC", "Modelo_PC", "Processador", "Memoria", "S.O", "HD", "Garantia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPCnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPCnvMouseClicked(evt);
            }
        });
        tblPCnv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPCnvKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblPCnv);

        jLabel1.setText("Cod_PC:");

        txtPCnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPCnvActionPerformed(evt);
            }
        });

        jLabel14.setText("Cod_PC");

        txtpcModelonv.setPreferredSize(new java.awt.Dimension(20, 20));
        txtpcModelonv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpcModelonvActionPerformed(evt);
            }
        });

        jLabel36.setText("Modelo:");

        jLabel37.setText("Marca:");

        jLabel16.setText("Nome PC:");

        jLabel38.setText("S.O:");

        jLabel39.setText("Garantia:");

        jLabel40.setText("CPU:");

        jLabel41.setText("HD:");

        jLabel42.setText("RAM:");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Status");

        cboStatusPC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Saida" }));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/refrescar (1).png"))); // NOI18N
        btnAtualizar.setText("Atualizar KIT");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFindPc, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboStatusPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAtualizar))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel37))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMarcapcnv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPCnv, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCodPcnv))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtpcModelonv, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel38))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel42)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtRamnv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel41)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHDnv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCPUnv))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtsonv, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel39)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtGarnv, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFindPc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtPCnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtpcModelonv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel42)
                                        .addComponent(txtRamnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel41)
                                        .addComponent(txtHDnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel40)
                                        .addComponent(txtCPUnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel36)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel37)
                                        .addComponent(txtMarcapcnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(txtCodPcnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel38)
                                .addComponent(txtsonv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel39))
                            .addComponent(txtGarnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboStatusPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAtualizar)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCPUnv, txtCodPcnv, txtGarnv, txtpcModelonv});

        jButton3.setText("Adicionar outro kit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlPCDEFEITO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))))
                .addGap(258, 258, 258))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPCDEFEITO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton3)
                        .addGap(125, 125, 125)))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPCDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPCDefeitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPCDefeitoActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtmodelopcDefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmodelopcDefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmodelopcDefActionPerformed

    private void txtDataDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataDKActionPerformed
    }//GEN-LAST:event_txtDataDKActionPerformed

    private void txtPCnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPCnvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPCnvActionPerformed

    private void txtpcModelonvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpcModelonvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpcModelonvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pesquisaPC(txtFindPc.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pesquisarOperador(txtFindop.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        model_pc pc = new model_pc();
        dao_pcDef dao = new dao_pcDef();
        //Campos para fazer atualização do pc no kit
        pc.setIdform(Integer.parseInt(txtIDfORM.getText()));
        pc.setNomepc(txtPCnv.getText());
        pc.setCod(txtCodPcnv.getText());
        pc.setMarca(txtMarcapcnv.getText());
        pc.setModelo(txtpcModelonv.getText());
        pc.setProcessador(txtCPUnv.getText());
        pc.setMemoria(txtRamnv.getText());
        pc.setSo(txtsonv.getText());
        pc.setHd(txtHDnv.getText());
        pc.setGarantia(txtGarnv.getText());
        dao.atualizaKIT(pc);//Atualiza o kit
        selecionaKit(); //Atualiza kit
        
        atualizaPC();//Atualiza status do pc para "Saida"
        btnAtualizar.setEnabled(false);

    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void tblKitPcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKitPcKeyReleased
        if (tblKitPc.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtIDfORM.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 0).toString());
            txtNomeOP.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 2).toString());
            txtEmail.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 3).toString());
            txtCodPcDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 4).toString());
            txtPCDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 5).toString());
            txtMarcapcDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 6).toString());
            txtmodelopcDef.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 7).toString());
            txtCPUDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 8).toString());
            txtHDDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 9).toString());
            txtRamDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 10).toString());
            txtsoDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 11).toString());
            txtGarDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 12).toString());

        }
    }//GEN-LAST:event_tblKitPcKeyReleased

    private void tblKitPcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKitPcMouseClicked
        if (tblKitPc.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela
            txtIDfORM.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 0).toString());
            txtNomeOP.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 2).toString());
            txtEmail.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 3).toString());
            txtCodPcDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 4).toString());
            txtPCDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 5).toString());
            txtMarcapcDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 6).toString());
            txtmodelopcDef.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 7).toString());
            txtCPUDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 8).toString());
            txtHDDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 9).toString());
            txtRamDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 10).toString());
            txtsoDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 11).toString());
            txtGarDefeito.setText(tblKitPc.getValueAt(tblKitPc.getSelectedRow(), 12).toString());

        }
    }//GEN-LAST:event_tblKitPcMouseClicked

    private void tblPCnvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPCnvKeyReleased
        if (tblPCnv.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela

            txtPCnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 0).toString());
            txtCodPcnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 1).toString());
            txtMarcapcnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 2).toString());
            txtpcModelonv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 3).toString());
            txtCPUnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 4).toString());
            txtRamnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 5).toString());
            txtsonv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 6).toString());
            txtHDnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 7).toString());
            txtGarnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 8).toString());

        }
    }//GEN-LAST:event_tblPCnvKeyReleased

    private void tblPCnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPCnvMouseClicked
        if (tblPCnv.getSelectedRow() != -1) {
            //Preenche os campos ao clicar dentro de um dado na tabela

            txtPCnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 0).toString());
            txtCodPcnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 1).toString());
            txtMarcapcnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 2).toString());
            txtpcModelonv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 3).toString());
            txtCPUnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 4).toString());
            txtRamnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 5).toString());
            txtsonv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 6).toString());
            txtHDnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 7).toString());
            txtGarnv.setText(tblPCnv.getValueAt(tblPCnv.getSelectedRow(), 8).toString());

        }
    }//GEN-LAST:event_tblPCnvMouseClicked

    private void brnDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnDefeitoActionPerformed
        model_pcDef pcDef = new model_pcDef(); //Chama os modificadores
        dao_pcDef dao = new dao_pcDef();//Classe de comandos para o banco de dados
        campos(pcDef); //Campos para inserir o pc na tabela (pcdefeito)
        dao.inserirPCDefeito(pcDef);//Chama a classe para inserir o pc com defeito
        JOptionPane.showMessageDialog(null, "Escolha um novo PC.");//mostra uma mensagem para escolher um novo pc
        OnTablePCnv();//Habilita os campos da table para escolha do novo pc
        desabilitarPane();//Desabilita os campos do pc velho
        selecionaKit();//Atualiza o kit com o novo pc escolhido


    }//GEN-LAST:event_brnDefeitoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       OnTablePCnv();
       btnAtualizar.setEnabled(true);
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtFindopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindopActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnDefeito;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JComboBox<String> cboStatusMonitor;
    private javax.swing.JComboBox<String> cboStatusPC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnlPCDEFEITO;
    private javax.swing.JTable tblKitPc;
    private javax.swing.JTable tblPCnv;
    private javax.swing.JTextArea txaDescPC;
    private javax.swing.JTextField txtCPUDefeito;
    private javax.swing.JTextField txtCPUnv;
    private javax.swing.JTextField txtCodPcDefeito;
    private javax.swing.JTextField txtCodPcnv;
    private javax.swing.JTextField txtDataDK;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFindPc;
    private javax.swing.JTextField txtFindop;
    private javax.swing.JTextField txtGarDefeito;
    private javax.swing.JTextField txtGarnv;
    private javax.swing.JTextField txtHDDefeito;
    private javax.swing.JTextField txtHDnv;
    private javax.swing.JTextField txtIDfORM;
    private javax.swing.JTextField txtMarcapcDefeito;
    private javax.swing.JTextField txtMarcapcnv;
    private javax.swing.JTextField txtNomeOP;
    private javax.swing.JTextField txtPCDefeito;
    private javax.swing.JTextField txtPCnv;
    private javax.swing.JTextField txtRamDefeito;
    private javax.swing.JTextField txtRamnv;
    private javax.swing.JTextField txtmodelopcDef;
    private javax.swing.JTextField txtpcModelonv;
    private javax.swing.JTextField txtsoDefeito;
    private javax.swing.JTextField txtsonv;
    // End of variables declaration//GEN-END:variables
}
