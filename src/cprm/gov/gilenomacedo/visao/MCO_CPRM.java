
package cprm.gov.gilenomacedo.visao;

import cprm.gov.gilenomacedo.modelo.Cotacao;
import cprm.gov.gilenomacedo.modelo.CotacaoGeralTableModel;
import cprm.gov.gilenomacedo.modelo.CotacaoTableModel;
import cprm.gov.gilenomacedo.modelo.Fornecedor;
import cprm.gov.gilenomacedo.modelo.FornecedorTableModel;
import cprm.gov.gilenomacedo.modelo.ProdutoTableModel;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gileno.macedo
 */
public class MCO_CPRM extends javax.swing.JFrame {

    CotacaoTableModel modeloTabelaCotacao = new CotacaoTableModel();
    FornecedorTableModel modeloTabelaFornecedor = new FornecedorTableModel();
    CotacaoGeralTableModel modeloTabelaCotacaoGeral = new CotacaoGeralTableModel();
    ProdutoTableModel modeloTabelaProdutos = new ProdutoTableModel();
    Cotacao cotacao;
    Fornecedor fornec;
    private Long idCotacao;
    private Long idFornecedor;
    private int resp = 0;
    private final LocalDate hoje = LocalDate.now();

    public MCO_CPRM() {
        initComponents();
        edt_regional.setText("SUREG-MA");
        edt_regional.setEditable(false);
        edt_dataAno.setText(String.valueOf(hoje));
        edt_dataAno.setEditable(false);
        setLocationRelativeTo(null);
    }

    public void salvarFornecedor() throws Exception {
       
        Fornecedor fornecedo = new Fornecedor();
        fornecedo.setIdFornecedor(idFornecedor);
        fornecedo.setFornecedor(edt_fornecedor.getText().toUpperCase());
        fornecedo.setCgc(edt_cgc.getText().toUpperCase());
        if (jC_empenho.isSelected()) {
            fornecedo.setFormaPagamento("EMPENHO");
        } else if (jC_boletoBancario.isSelected()) {
            fornecedo.setFormaPagamento("BOLETO BANCARIO");
            jC_boletoBancario.isSelected();
        }
         
        fornecedo.setNomeContato(edt_contato.getText().toUpperCase());
        fornecedo.setTel(edt_telefone.getText().toUpperCase());
        fornecedo.setUf(jC_uf.getSelectedItem().toString());
        fornecedo.setEntrega(edt_entrega.getText().toUpperCase());
        fornecedo.setCotacao(cotacao);
        modeloTabelaFornecedor.AdcionarFornecedor(fornecedo);
          modeloTabelaCotacaoGeral.listaCotacaoGeral();
    }

    public void salvarCotacao() {
        Cotacao cota = new Cotacao();
        Fornecedor forn = new Fornecedor();
        cota.setIdCotacao(idCotacao);
        cota.setGerencia(jC_gerencia.getSelectedItem().toString().toUpperCase());
        cota.setNumColetaPrecos(Integer.valueOf(edt_numeroColeta.getText()));
        cota.setDatas(String.valueOf(hoje));
        cota.setProcesso(Integer.parseInt(edt_processo.getText()));
        cota.setRcs(Integer.parseInt(edt_rcsNumero.getText()));
        cota.setSuperintendencia(edt_regional.getText().toUpperCase());
        forn.setCotacao(cota);
        try {
            modeloTabelaCotacao.adcionarCotacao(cota);
        } catch (Exception ex) {
            Logger.getLogger(MCO_CPRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeCotacao() throws Exception {
        modeloTabelaCotacao.removeCotacao(idCotacao);
    }

    public void removeFornecedor() throws Exception {
        modeloTabelaFornecedor.RemoveFornecedor(idFornecedor);
    }

    public void linhaSelecioandaCotacao() {
        cotacao = modeloTabelaCotacao.getLinhaCotacao(tabelaCotacao.getSelectedRow());
        edt_processo.setText(String.valueOf(cotacao.getProcesso()).toUpperCase());
        edt_rcsNumero.setText(String.valueOf(cotacao.getRcs()).toUpperCase());
        edt_dataAno.setText(cotacao.getDatas());
        edt_numeroColeta.setText(String.valueOf(cotacao.getNumColetaPrecos()).toUpperCase());
        jC_gerencia.setSelectedItem(cotacao.getGerencia().toUpperCase());
        edt_regional.setText(cotacao.getSuperintendencia().toUpperCase());
        idCotacao = cotacao.getIdCotacao();

    }

    public void linhaSelecioandaFornecedores() {
        fornec = modeloTabelaFornecedor.getLinhaFornecedor(tabelaFornecedor.getSelectedRow());
        edt_fornecedor.setText(fornec.getFornecedor().toUpperCase());
        edt_cgc.setText(fornec.getCgc().toUpperCase());
        edt_contato.setText(fornec.getNomeContato().toUpperCase());
        edt_entrega.setText(fornec.getEntrega().toUpperCase());        
        edt_telefone.setText(fornec.getTel().toUpperCase());
        jC_uf.setSelectedItem(fornec.getUf().toUpperCase());
        String formaPagamento = fornec.getFormaPagamento();
        if (formaPagamento.equals("EMPENHO")) {
            jC_empenho.setSelected(true);
        } else if (formaPagamento.equals("BOLETO BANCARIO")) {
            jC_boletoBancario.setSelected(true);
        }
        idFornecedor = fornec.getIdFornecedor();
    }

    
    private void limpaCamposCotacao() {
        edt_processo.setText("");
        edt_rcsNumero.setText("");
        edt_dataAno.setText(String.valueOf(hoje));
        edt_numeroColeta.setText("");
        jC_gerencia.setSelectedItem(null);
        idCotacao= null;     
    }

    private void limpaCamposFornecedor() {
        edt_fornecedor.setText("");
        edt_cgc.setText("");
        edt_contato.setText("");
        edt_entrega.setText("");        
        edt_telefone.setText("");
        jC_uf.setSelectedItem(null);
        idFornecedor = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_pagamentos = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jP_cotacoes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        edt_numeroColeta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edt_rcsNumero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edt_regional = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        edt_processo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        edt_dataAno = new javax.swing.JTextField();
        jC_gerencia = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jP_fornecedores = new javax.swing.JPanel();
        jL_fornecedor = new javax.swing.JLabel();
        edt_fornecedor = new javax.swing.JTextField();
        jL_cgc = new javax.swing.JLabel();
        jL_telefone = new javax.swing.JLabel();
        edt_telefone = new javax.swing.JTextField();
        jL_contato = new javax.swing.JLabel();
        edt_contato = new javax.swing.JTextField();
        edt_entrega = new javax.swing.JTextField();
        jL_entrega = new javax.swing.JLabel();
        jL_pagamento = new javax.swing.JLabel();
        jL_uf = new javax.swing.JLabel();
        edt_cgc = new javax.swing.JTextField();
        jC_uf = new javax.swing.JComboBox();
        jC_empenho = new javax.swing.JCheckBox();
        jC_boletoBancario = new javax.swing.JCheckBox();
        jP_tabelas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCotacao = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaFornecedor = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaColetaDePrecos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jB_inserirCotacao = new javax.swing.JButton();
        jB_removerCotacao = new javax.swing.JButton();
        jB_NovaCotacao = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jB_salvarFornecedor = new javax.swing.JButton();
        jB_alterarFornecedor = new javax.swing.JButton();
        jB_removeFornecedor = new javax.swing.JButton();
        jB_addProtudo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mapa Comparativo de Ofertas - MCO");

        jPanel2.setBackground(new java.awt.Color(209, 197, 195));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cprm/gov/gilenomacedo/imagens/Concurso-CPRM-2013.jpg"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jP_cotacoes.setBackground(new java.awt.Color(209, 197, 195));
        jP_cotacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Cotação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 0, 18), new java.awt.Color(255, 39, 94))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Coleta de Preços  Nº : ");

        edt_numeroColeta.setBackground(new java.awt.Color(209, 197, 195));
        edt_numeroColeta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_numeroColeta.setForeground(new java.awt.Color(217, 15, 132));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Rcs Nº :");

        edt_rcsNumero.setBackground(new java.awt.Color(209, 197, 195));
        edt_rcsNumero.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_rcsNumero.setForeground(new java.awt.Color(217, 15, 132));
        edt_rcsNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edt_rcsNumeroActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Sureg:");

        edt_regional.setEditable(false);
        edt_regional.setBackground(new java.awt.Color(209, 197, 195));
        edt_regional.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_regional.setForeground(new java.awt.Color(98, 102, 111));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Gerência :");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Processo :");

        edt_processo.setBackground(new java.awt.Color(209, 197, 195));
        edt_processo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_processo.setForeground(new java.awt.Color(217, 15, 132));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Data :");

        edt_dataAno.setBackground(new java.awt.Color(209, 197, 195));
        edt_dataAno.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_dataAno.setForeground(new java.awt.Color(98, 102, 111));

        jC_gerencia.setBackground(new java.awt.Color(209, 197, 195));
        jC_gerencia.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jC_gerencia.setForeground(new java.awt.Color(217, 15, 132));
        jC_gerencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "GERAFI", "GEHITE", "GEREMI", "GERIDE", "SUREG-MA" }));

        javax.swing.GroupLayout jP_cotacoesLayout = new javax.swing.GroupLayout(jP_cotacoes);
        jP_cotacoes.setLayout(jP_cotacoesLayout);
        jP_cotacoesLayout.setHorizontalGroup(
            jP_cotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_cotacoesLayout.createSequentialGroup()
                .addGroup(jP_cotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_cotacoesLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(jP_cotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_cotacoesLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_cotacoesLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_cotacoesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jP_cotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edt_processo)
                    .addComponent(edt_numeroColeta)
                    .addComponent(jC_gerencia, 0, 229, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(jP_cotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jP_cotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edt_regional, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edt_rcsNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edt_dataAno, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_cotacoesLayout.setVerticalGroup(
            jP_cotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_cotacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_cotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(edt_numeroColeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(edt_rcsNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_cotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edt_regional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(edt_processo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_cotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edt_dataAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jC_gerencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_cotacoesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {edt_processo, jC_gerencia});

        jPanel4.setBackground(new java.awt.Color(209, 197, 195));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(214, 21, 98));
        jLabel2.setText("MAPA COMPARATIVO DE OFERTAS - MCO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(85, 85, 85))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jP_fornecedores.setBackground(new java.awt.Color(209, 197, 195));
        jP_fornecedores.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Fornecedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Narrow", 0, 18), new java.awt.Color(211, 0, 234))); // NOI18N

        jL_fornecedor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jL_fornecedor.setText("Fornecedor :");

        edt_fornecedor.setBackground(new java.awt.Color(209, 197, 195));
        edt_fornecedor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_fornecedor.setForeground(new java.awt.Color(217, 15, 132));
        edt_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edt_fornecedorActionPerformed(evt);
            }
        });

        jL_cgc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jL_cgc.setText("Cgc :");

        jL_telefone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jL_telefone.setText("Telefone :");

        edt_telefone.setBackground(new java.awt.Color(209, 197, 195));
        edt_telefone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_telefone.setForeground(new java.awt.Color(217, 15, 132));

        jL_contato.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jL_contato.setText("Contato :");

        edt_contato.setBackground(new java.awt.Color(209, 197, 195));
        edt_contato.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_contato.setForeground(new java.awt.Color(217, 15, 132));

        edt_entrega.setBackground(new java.awt.Color(209, 197, 195));
        edt_entrega.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_entrega.setForeground(new java.awt.Color(217, 15, 132));

        jL_entrega.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jL_entrega.setText("Entrega :");

        jL_pagamento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jL_pagamento.setText("Pagamento:");

        jL_uf.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jL_uf.setText("UF:");

        edt_cgc.setBackground(new java.awt.Color(209, 197, 195));
        edt_cgc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_cgc.setForeground(new java.awt.Color(217, 15, 132));

        jC_uf.setBackground(new java.awt.Color(209, 197, 195));
        jC_uf.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jC_uf.setForeground(new java.awt.Color(217, 15, 132));
        jC_uf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE"
            , "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC"
            , "SE", "SP", "TO"}));

buttonGroup_pagamentos.add(jC_empenho);
jC_empenho.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
jC_empenho.setText("Empenho");

buttonGroup_pagamentos.add(jC_boletoBancario);
jC_boletoBancario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
jC_boletoBancario.setText("Boleto Bancario");

javax.swing.GroupLayout jP_fornecedoresLayout = new javax.swing.GroupLayout(jP_fornecedores);
jP_fornecedores.setLayout(jP_fornecedoresLayout);
jP_fornecedoresLayout.setHorizontalGroup(
    jP_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jP_fornecedoresLayout.createSequentialGroup()
        .addGap(33, 33, 33)
        .addGroup(jP_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jL_fornecedor)
            .addComponent(jL_cgc)
            .addComponent(jL_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(29, 29, 29)
        .addGroup(jP_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addGroup(jP_fornecedoresLayout.createSequentialGroup()
                .addComponent(jC_empenho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jC_boletoBancario))
            .addComponent(edt_cgc, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(edt_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(27, 27, 27)
        .addGroup(jP_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jL_entrega, javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jL_contato, javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jL_telefone, javax.swing.GroupLayout.Alignment.LEADING))
        .addGap(18, 18, 18)
        .addGroup(jP_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addGroup(jP_fornecedoresLayout.createSequentialGroup()
                .addComponent(edt_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jL_uf)
                .addGap(18, 18, 18)
                .addComponent(jC_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(edt_telefone)
            .addComponent(edt_contato))
        .addContainerGap(126, Short.MAX_VALUE))
    );
    jP_fornecedoresLayout.setVerticalGroup(
        jP_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jP_fornecedoresLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jP_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jL_fornecedor)
                .addComponent(edt_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jL_telefone)
                .addComponent(edt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jP_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jL_contato)
                .addGroup(jP_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_cgc)
                    .addComponent(edt_cgc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edt_contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jP_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jP_fornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_entrega)
                    .addComponent(edt_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_pagamento)
                    .addComponent(jL_uf)
                    .addComponent(jC_empenho)
                    .addComponent(jC_boletoBancario))
                .addComponent(jC_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(24, Short.MAX_VALUE))
    );

    jP_fornecedoresLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {edt_contato, jC_uf});

    jP_tabelas.setBackground(new java.awt.Color(225, 188, 188));
    jP_tabelas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

    tabelaCotacao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    tabelaCotacao.setModel(modeloTabelaCotacao);
    tabelaCotacao.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaCotacaoMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(tabelaCotacao);

    tabelaFornecedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
    tabelaFornecedor.setModel(modeloTabelaFornecedor);
    tabelaFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaFornecedorMouseClicked(evt);
        }
    });
    jScrollPane3.setViewportView(tabelaFornecedor);

    javax.swing.GroupLayout jP_tabelasLayout = new javax.swing.GroupLayout(jP_tabelas);
    jP_tabelas.setLayout(jP_tabelasLayout);
    jP_tabelasLayout.setHorizontalGroup(
        jP_tabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jP_tabelasLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
            .addContainerGap())
    );
    jP_tabelasLayout.setVerticalGroup(
        jP_tabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_tabelasLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jP_tabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addContainerGap())
    );

    jPanel3.setBackground(new java.awt.Color(225, 188, 188));
    jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

    tabelaColetaDePrecos.setModel(modeloTabelaCotacaoGeral);
    jScrollPane1.setViewportView(tabelaColetaDePrecos);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1)
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addContainerGap())
    );

    jPanel5.setBackground(new java.awt.Color(208, 172, 175));
    jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

    jB_inserirCotacao.setText("Inserir");
    jB_inserirCotacao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jB_inserirCotacaoActionPerformed(evt);
        }
    });

    jB_removerCotacao.setText("remover");
    jB_removerCotacao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jB_removerCotacaoActionPerformed(evt);
        }
    });

    jB_NovaCotacao.setText("Novo");
    jB_NovaCotacao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jB_NovaCotacaoActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jB_NovaCotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jB_removerCotacao)
                .addComponent(jB_inserirCotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addContainerGap(22, Short.MAX_VALUE)
            .addComponent(jB_inserirCotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jB_removerCotacao)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jB_NovaCotacao)
            .addGap(16, 16, 16))
    );

    jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_NovaCotacao, jB_inserirCotacao, jB_removerCotacao});

    jPanel6.setBackground(new java.awt.Color(208, 172, 175));
    jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

    jB_salvarFornecedor.setText("Inserir");
    jB_salvarFornecedor.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jB_salvarFornecedorActionPerformed(evt);
        }
    });

    jB_alterarFornecedor.setText("Alterar");
    jB_alterarFornecedor.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jB_alterarFornecedorActionPerformed(evt);
        }
    });

    jB_removeFornecedor.setText("remover");
    jB_removeFornecedor.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jB_removeFornecedorActionPerformed(evt);
        }
    });

    jB_addProtudo.setText("Add produto");
    jB_addProtudo.setBorderPainted(false);
    jB_addProtudo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jB_addProtudoActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jB_removeFornecedor)
                .addComponent(jB_alterarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jB_salvarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20))
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jB_addProtudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addComponent(jB_salvarFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jB_alterarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jB_removeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jB_addProtudo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jP_tabelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jP_fornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jP_cotacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addContainerGap(28, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jP_cotacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jP_fornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jP_tabelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(18, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(24, 24, 24))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edt_rcsNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edt_rcsNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edt_rcsNumeroActionPerformed

    private void jB_salvarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salvarFornecedorActionPerformed
        try {
            salvarFornecedor();
            limpaCamposFornecedor();
          
         
        } catch (Exception ex) {
            Logger.getLogger(MCO_CPRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jB_salvarFornecedorActionPerformed

    private void jB_inserirCotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_inserirCotacaoActionPerformed
        if (idCotacao == null) {
            try {
                salvarCotacao();
                limpaCamposCotacao();
            } catch (Exception ex) {
                Logger.getLogger(MCO_CPRM.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resp = JOptionPane.showConfirmDialog(null, "Deseja Realmente Alerar dos dodos da Cotação?   " + cotacao.getRcs()+"  " + fornec.getFornecedor() + JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_NO_OPTION) {
                try {
                  //  salvarCotacao();
                    limpaCamposFornecedor();
                    //  modeloTabelaFornecedor.atualizaListadeFornecedores(fornec);
                } catch (Exception ex) {
                    Logger.getLogger(MCO_CPRM.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jB_inserirCotacaoActionPerformed
  
 
    private void tabelaCotacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCotacaoMouseClicked
        linhaSelecioandaCotacao();
    }//GEN-LAST:event_tabelaCotacaoMouseClicked

    private void jB_removerCotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_removerCotacaoActionPerformed
        if (idCotacao == null) {
            JOptionPane.showMessageDialog(null, "Selecione  os Dados Que Deseja Excluir, Clicando na Linha da Tabela");
        } else {
            resp = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir Estes Dados ?   " + cotacao.getRcs()+"  " + JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_NO_OPTION) {
                try {
                    removeCotacao();
                    limpaCamposCotacao();
                    modeloTabelaCotacao.atualizaListadeCotacao(cotacao);
                } catch (Exception ex) {
                    Logger.getLogger(MCO_CPRM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jB_removerCotacaoActionPerformed

    private void tabelaFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFornecedorMouseClicked
        linhaSelecioandaFornecedores();
    }//GEN-LAST:event_tabelaFornecedorMouseClicked

    private void jB_removeFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_removeFornecedorActionPerformed
        if (idFornecedor == null) {
            JOptionPane.showMessageDialog(null, "Selecione  os Dados Que Deseja Excluir Clicando na Linha da Tabela ");
        } else {
            resp = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir Estes Dados ? " + fornec.getFornecedor()+" " + JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_NO_OPTION) {
                try {
                    removeFornecedor();
                    limpaCamposFornecedor();
                    modeloTabelaFornecedor.atualizaListadeFornecedores(fornec);
                } catch (Exception ex) {
                    Logger.getLogger(MCO_CPRM.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jB_removeFornecedorActionPerformed

    private void edt_fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edt_fornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edt_fornecedorActionPerformed

    private void jB_alterarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_alterarFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_alterarFornecedorActionPerformed

    private void jB_addProtudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_addProtudoActionPerformed
        Produtos p = new Produtos();
        p.setVisible(true);
        p.dadosFornecedor(fornec.getFornecedor(),idFornecedor);
        ProdutoTableModel pt = new ProdutoTableModel();
        ProdutoTableModel ptm = new ProdutoTableModel();
        ptm.consultaProdutoporFornecedor(fornec.getFornecedor());
       // pt.consultaProdutoporFornecedor(fornec.getFornecedor());
   
        
      
        

    }//GEN-LAST:event_jB_addProtudoActionPerformed

    private void jB_NovaCotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_NovaCotacaoActionPerformed
      limpaCamposCotacao();
    }//GEN-LAST:event_jB_NovaCotacaoActionPerformed

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
            java.util.logging.Logger.getLogger(MCO_CPRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MCO_CPRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MCO_CPRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MCO_CPRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MCO_CPRM().setVisible(true);
                              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_pagamentos;
    private javax.swing.JTextField edt_cgc;
    private javax.swing.JTextField edt_contato;
    private javax.swing.JTextField edt_dataAno;
    private javax.swing.JTextField edt_entrega;
    private javax.swing.JTextField edt_fornecedor;
    private javax.swing.JTextField edt_numeroColeta;
    private javax.swing.JTextField edt_processo;
    private javax.swing.JTextField edt_rcsNumero;
    private javax.swing.JTextField edt_regional;
    private javax.swing.JTextField edt_telefone;
    private javax.swing.JButton jB_NovaCotacao;
    private javax.swing.JButton jB_addProtudo;
    private javax.swing.JButton jB_alterarFornecedor;
    private javax.swing.JButton jB_inserirCotacao;
    private javax.swing.JButton jB_removeFornecedor;
    private javax.swing.JButton jB_removerCotacao;
    private javax.swing.JButton jB_salvarFornecedor;
    private javax.swing.JCheckBox jC_boletoBancario;
    private javax.swing.JCheckBox jC_empenho;
    private javax.swing.JComboBox jC_gerencia;
    private javax.swing.JComboBox jC_uf;
    private javax.swing.JLabel jL_cgc;
    private javax.swing.JLabel jL_contato;
    private javax.swing.JLabel jL_entrega;
    private javax.swing.JLabel jL_fornecedor;
    private javax.swing.JLabel jL_pagamento;
    private javax.swing.JLabel jL_telefone;
    private javax.swing.JLabel jL_uf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jP_cotacoes;
    private javax.swing.JPanel jP_fornecedores;
    private javax.swing.JPanel jP_tabelas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaColetaDePrecos;
    private javax.swing.JTable tabelaCotacao;
    private javax.swing.JTable tabelaFornecedor;
    // End of variables declaration//GEN-END:variables

}
