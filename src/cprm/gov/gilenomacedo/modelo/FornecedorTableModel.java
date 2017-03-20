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
public class FornecedorTableModel extends AbstractTableModel {
    
      public List<Fornecedor> listFornecedores;
     private final FornecedorDao fDao = new FornecedorDao();     
   
     
    public FornecedorTableModel() {
                this.listFornecedores = new ArrayList();
                listFornecedores = fDao.consultaTodosFornecedores();
           
    }
   
    public Fornecedor getLinhaFornecedor(int linha){
      return listFornecedores.get(linha);
    }
    
     @Override
    public int getRowCount() {
      return listFornecedores.size();
    }

     @Override
    public int getColumnCount() {
       return 4;
    }
     
     @Override
     public String getColumnName(int coluna){
         switch(coluna){
             case 0:
                 return "Fornecedor" ;
             case 1:
                 return "Cgc";
             case 2:
                 return  "Telefone";
             case 3:
                  return "Contato" ;             
                                        
             default:
             return "";   
         }
                       
     }
     
     
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Fornecedor fornecedor = listFornecedores.get(rowIndex);
         
    
     switch(columnIndex){
         
         case 0:
                 return fornecedor.getFornecedor();           
           case 1:
                 return fornecedor.getCgc();               
           case 2:
                 return fornecedor.getTel();
           case 3:                   
                  return fornecedor.getNomeContato();
                      
                           
                default:
               
               return "";               
           }
          
     
         }
    
  
    
      public void AdcionarFornecedor(Fornecedor f)throws Exception{
          
        f = fDao.salvarFornecedo(f);
           listFornecedores.add(f);
           fireTableRowsInserted(listFornecedores.size() -1 , listFornecedores.size() -1);      
          
      }
      
        public void RemoveFornecedor(Long id) throws Exception{   
           fDao.removeFornecedor(id);
           listFornecedores.remove(id);
           fireTableRowsInserted(listFornecedores.size() -1 , listFornecedores.size() -1);      
      }
          public void atualizaListadeFornecedores(Fornecedor f) throws Exception{              
              listFornecedores.remove(f);            
              fireTableRowsInserted(listFornecedores.size() -1 , listFornecedores.size() -1);   
             
      }
          
    
}
