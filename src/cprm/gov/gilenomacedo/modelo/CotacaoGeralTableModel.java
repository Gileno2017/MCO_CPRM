/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cprm.gov.gilenomacedo.modelo;

import cprm.gov.gilenomacedo.controle.FornecedorDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gileno.macedo
 */
public class CotacaoGeralTableModel extends AbstractTableModel{
     public List<Fornecedor> listaFornec; 
     private final   FornecedorDao fDao = new FornecedorDao();     
   
    public CotacaoGeralTableModel() {
                this.listaFornec = new ArrayList();
                listaFornec = fDao.consultaTodosFornecedores();
           
    }
   
    public Fornecedor getLinhaCotacaoGeral(int linha){
      return listaFornec.get(linha);
    }
    
     @Override
    public int getRowCount() {
      return listaFornec.size();
    }

     @Override
    public int getColumnCount() {
       return 2;
    }
     
     @Override
     public String getColumnName(int coluna){
         switch(coluna){
             case 0:
                 return "RCS" ;
             case 1:
                 return "NOME FORNECEDOR";
                     
             default:
             return "";   
         }
                       
     }
     
     
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Fornecedor forn = listaFornec.get(rowIndex);
       
         
    
     switch(columnIndex){
         
         case 0:
                 return forn.getCotacao().getRcs();
           case 1:
                 return forn.getListadeProdutos();
           default:
               
               return "";               
           }
          
     
         }
    
    public void listaCotacaoGeral(){
          this.listaFornec = new ArrayList();
          listaFornec = fDao.consultaTodosFornecedores();
           fireTableRowsInserted(listaFornec.size() -1 , listaFornec.size() -1);   
          
          }
    
      
      
//        public void removeCotacao(Long idCotacao) throws Exception{       
//            cDao.removeCotacao(idCotacao);
//           listCotacoes.remove(idCotacao);
//           fireTableRowsInserted(listCotacoes.size() -1 , listCotacoes.size() -1);      
//      }
          public void atualizaListadeCotacaoGeral(Fornecedor f) throws Exception{              
              listaFornec.remove(f);            
              fireTableRowsInserted(listaFornec.size() -1 , listaFornec.size() -1);   
             
      }
          
    
}
