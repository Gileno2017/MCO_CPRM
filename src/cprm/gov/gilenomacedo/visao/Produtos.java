/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cprm.gov.gilenomacedo.visao;

import cprm.gov.gilenomacedo.controle.FornecedorDao;
import cprm.gov.gilenomacedo.modelo.Fornecedor;
import cprm.gov.gilenomacedo.modelo.Produto;
import cprm.gov.gilenomacedo.modelo.ProdutoTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gileno.macedo
 */
public final class Produtos extends javax.swing.JFrame {

    ProdutoTableModel modeloTabelaProduto = new ProdutoTableModel();
    double valorUnitario = 0, qtd = 0, valorTotal = 0;
    Produto produto;
    Long idProduto = null;
    Long idFornecedor = null;
    int resp;
     Fornecedor fornec = new Fornecedor();
    /**
     * Creates new form Produtos
     */
    public Produtos() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        // modeloTabelaProduto.consultaProdutoporFornecedor(jL_nomeFornecedor.getText());
      
    }

    
    public void salvarProdutos() throws Exception {
        Produto prod = new Produto();
        FornecedorDao fDao = new FornecedorDao();       
       fornec =  fDao.consultaFornecedorId(idFornecedor);      
        prod.setId(idProduto); 
        prod.setFornecedor(fornec);
        prod.setItem(edt_item.getText().toUpperCase());
        prod.setDescricao(edt_descricao.getText().toUpperCase());
        prod.setQtd(Integer.parseInt(edt_qtd.getText()));
        prod.setValorUnitario(Double.parseDouble(edt_valorUnitario.getText()));
        prod.setValorTotal(Double.parseDouble(edt_valorTotal.getText()));
        modeloTabelaProduto.adcionarProduto(prod);

    }
      
    public void dadosFornecedor(String nomeFornecedor,Long id){
         jL_nomeFornecedor.setText(nomeFornecedor);    
         idFornecedor = id;
         
       
    }

    public void calculaTotal() {
        valorUnitario = (Double.parseDouble(edt_valorUnitario.getText()));
        qtd = (Integer.parseInt(edt_qtd.getText()));
        valorTotal = (valorUnitario * qtd);
        edt_valorTotal.setText(String.valueOf(valorTotal));
    }
     
    public void linhaselecionadaProdutos(){
       produto =  modeloTabelaProduto.getLinhaProduto(tabelaProduto.getSelectedRow());
       edt_item.setText(produto.getItem());
       edt_descricao.setText(produto.getDescricao());
 //      edt_qtd.setText(String.valueOf(produto.getQtd()));
//       edt_valorUnitario.setText(String.valueOf(produto.getValorUnitario()));
//       edt_valorTotal.setText(String.valueOf(produto.getValorTotal()));       
       idProduto = produto.getId();
       }
    
    public void removeProduto() throws Exception{
         modeloTabelaProduto.removeProduto(idProduto);
    }
    
    private void limpaCamposProduto(){
      edt_descricao.setText("");
      edt_item.setText("");
      edt_qtd.setText("");
      edt_valorUnitario.setText("");
      edt_valorTotal.setText("");   
      idProduto=null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        edt_item = new javax.swing.JTextField();
        jL_item = new javax.swing.JLabel();
        jL_quantidade = new javax.swing.JLabel();
        edt_qtd = new javax.swing.JTextField();
        jL_descricao = new javax.swing.JLabel();
        edt_descricao = new javax.swing.JTextField();
        jL_valorunitario = new javax.swing.JLabel();
        edt_valorUnitario = new javax.swing.JTextField();
        jL_valortotal = new javax.swing.JLabel();
        edt_valorTotal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jL_nomeFornecedor = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jB_removerProduto = new javax.swing.JButton();
        jB_listar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(209, 197, 195));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        edt_item.setBackground(new java.awt.Color(209, 197, 195));
        edt_item.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_item.setForeground(new java.awt.Color(217, 15, 132));

        jL_item.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jL_item.setText("Item: ");

        jL_quantidade.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jL_quantidade.setText("Quantidade");

        edt_qtd.setBackground(new java.awt.Color(209, 197, 195));
        edt_qtd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_qtd.setForeground(new java.awt.Color(217, 15, 132));

        jL_descricao.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jL_descricao.setText("Descrição:");

        edt_descricao.setBackground(new java.awt.Color(209, 197, 195));
        edt_descricao.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_descricao.setForeground(new java.awt.Color(217, 15, 132));

        jL_valorunitario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jL_valorunitario.setText("Valor unitário:");

        edt_valorUnitario.setBackground(new java.awt.Color(209, 197, 195));
        edt_valorUnitario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_valorUnitario.setForeground(new java.awt.Color(217, 15, 132));
        edt_valorUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edt_valorUnitarioKeyPressed(evt);
            }
        });

        jL_valortotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jL_valortotal.setText("Valor Total:");

        edt_valorTotal.setBackground(new java.awt.Color(209, 197, 195));
        edt_valorTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edt_valorTotal.setForeground(new java.awt.Color(217, 15, 132));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Fornecedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(204, 0, 51))); // NOI18N

        jL_nomeFornecedor.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jL_nomeFornecedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_nomeFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_nomeFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jL_quantidade)
                                .addGap(18, 18, 18)
                                .addComponent(edt_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jL_item)
                                .addGap(18, 18, 18)
                                .addComponent(edt_item, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jL_descricao)
                                .addGap(18, 18, 18)
                                .addComponent(edt_descricao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jL_valorunitario)
                                .addGap(18, 18, 18)
                                .addComponent(edt_valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jL_valortotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edt_valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edt_item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_item)
                    .addComponent(jL_descricao)
                    .addComponent(edt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edt_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_quantidade)
                    .addComponent(jL_valorunitario)
                    .addComponent(edt_valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_valortotal)
                    .addComponent(edt_valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(225, 188, 188));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Tabela de Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(0, 0, 204))); // NOI18N

        tabelaProduto.setModel(modeloTabelaProduto);
        tabelaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProduto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jB_removerProduto.setText("Remover");
        jB_removerProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_removerProdutoActionPerformed(evt);
            }
        });

        jB_listar.setText("Listar produtos");
        jB_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_listarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_removerProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_listar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jB_removerProduto)
                    .addComponent(jB_listar))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            salvarProdutos();
            limpaCamposProduto();
           
        } catch (Exception ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void edt_valorUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edt_valorUnitarioKeyPressed

        if (evt.isShiftDown()) {
            calculaTotal();
            System.out.println(valorTotal);
    }//GEN-LAST:event_edt_valorUnitarioKeyPressed
    }
    private void jB_removerProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_removerProdutoActionPerformed
          if (idProduto == null) {
            JOptionPane.showMessageDialog(null, "Selecione  os Dados Que Deseja Excluir, Clicando na Linha da Tabela");
        } else {
            resp = JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir Estes Dados ?   " + produto.getDescricao()+"  " + JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_NO_OPTION) {
                try {
                    removeProduto();
                    limpaCamposProduto();
                    modeloTabelaProduto.atualizaListadeProduto(produto);
                } catch (Exception ex) {
                    Logger.getLogger(MCO_CPRM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jB_removerProdutoActionPerformed
        
    private void tabelaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutoMouseClicked
     linhaselecionadaProdutos();
    }//GEN-LAST:event_tabelaProdutoMouseClicked

    private void jB_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_listarActionPerformed
        modeloTabelaProduto.consultaProdutoporFornecedor(jL_nomeFornecedor.getText());
    }//GEN-LAST:event_jB_listarActionPerformed
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produtos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edt_descricao;
    private javax.swing.JTextField edt_item;
    private javax.swing.JTextField edt_qtd;
    private javax.swing.JTextField edt_valorTotal;
    private javax.swing.JTextField edt_valorUnitario;
    private javax.swing.JButton jB_listar;
    private javax.swing.JButton jB_removerProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jL_descricao;
    private javax.swing.JLabel jL_item;
    private javax.swing.JLabel jL_nomeFornecedor;
    private javax.swing.JLabel jL_quantidade;
    private javax.swing.JLabel jL_valortotal;
    private javax.swing.JLabel jL_valorunitario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaProduto;
    // End of variables declaration//GEN-END:variables
}
