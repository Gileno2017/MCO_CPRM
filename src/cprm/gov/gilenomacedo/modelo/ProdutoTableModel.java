/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cprm.gov.gilenomacedo.modelo;

import cprm.gov.gilenomacedo.controle.ProdutoDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gileno.macedo
 */
public class ProdutoTableModel extends AbstractTableModel {
    private String fornecedor;
    public List<Produto> listProduto;
    private final ProdutoDao pDao = new ProdutoDao();

    public ProdutoTableModel() {
        this.listProduto = new ArrayList();        
      //  listProduto = pDao.consultarTodosProdutosPorFornecedor(fornecedor);
    
               
    }

    public Produto getLinhaProduto(int linha) {
        return listProduto.get(linha);
    }

    @Override
    public int getRowCount() {
        return listProduto.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            
            case 0:
                return "Item";
            case 1:
                return "Descrição";
            case 2:
                return "Quantidade";
            case 3:
                return "Valor Unitário";
                 case 4:
                return "Vallor Total";
                     

            default:
                return "";
        }

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto prod = listProduto.get(rowIndex);

        switch (columnIndex) {

              case 0:
                return prod.getItem();
            case 1:
                return prod.getDescricao();
            case 2:
                return prod.getQtd();
            case 3:
                return prod.getValorUnitario();
                  case 4:
                return prod.getValorTotal();


            default:

                return "";
        }

    }

    public void adcionarProduto(Produto p) throws Exception {
        p = pDao.salvarProduto(p);
        listProduto.add(p);
        fireTableRowsInserted(listProduto.size() - 1, listProduto.size() - 1);

    }

    public void removeProduto(Long idProduto) throws Exception {
        pDao.removeProduto(idProduto);   
        listProduto.remove(idProduto);
        fireTableRowsInserted(listProduto.size() - 1, listProduto.size() - 1);
    }

    public void atualizaListadeProduto(Produto p) throws Exception {
        listProduto.remove(p);
        fireTableRowsInserted(listProduto.size() - 1, listProduto.size() - 1);

    }
    
     public void consultaProdutoporFornecedor(String forne){
                this.listProduto = new ArrayList(); 
                listProduto = pDao.consultarTodosProdutosPorFornecedor(forne);
                fireTableRowsInserted(listProduto.size() -1 , listProduto.size() -1);   
                    
          }

  
    
}
