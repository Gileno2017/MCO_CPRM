/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cprm.gov.gilenomacedo.modelo;

import cprm.gov.gilenomacedo.controle.CotacaoDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gileno.macedo
 */
public class CotacaoTableModel extends AbstractTableModel{
     public List<Cotacao> listCotacoes;
     private final   CotacaoDao cDao = new CotacaoDao();     
   
     
    public CotacaoTableModel() {
                this.listCotacoes = new ArrayList();
                listCotacoes = cDao.consultaTodasCotacoes();
           
    }
   
    public Cotacao getLinhaCotacao(int linha){
      return listCotacoes.get(linha);
    }
    
     @Override
    public int getRowCount() {
      return listCotacoes.size();
    }

     @Override
    public int getColumnCount() {
       return 6;
    }
     
     @Override
     public String getColumnName(int coluna){
         switch(coluna){
             case 0:
                 return "RCS" ;
             case 1:
                 return "NRO COLETA";
             case 2:
                 return  "PROCESSO";
             case 3:
                  return "SUPERINTENDENCIA" ;               
             case 4:                 
                    return "GERENCIA" ;
             case 5:
                  return "DATA / ANO" ;
                          
             default:
             return "";   
         }
                       
     }
     
     
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Cotacao cota = listCotacoes.get(rowIndex);
         
    
     switch(columnIndex){
         
         case 0:
                 return cota.getRcs();           
           case 1:
                 return cota.getNumColetaPrecos();               
           case 2:
                 return cota.getProcesso();
           case 3:                   
                  return cota.getSuperintendencia();
           case 4:
                   return cota.getGerencia();               
           case 5:
                  return cota.getDatas();               
                           
                default:
               
               return "";               
           }
          
     
         }
    
  
    
      public void adcionarCotacao(Cotacao c) throws Exception{
           c = cDao.salvarCotacao(c);
           listCotacoes.add(c);
           fireTableRowsInserted(listCotacoes.size() -1 , listCotacoes.size() -1);      
          
      }
      
        public void removeCotacao(Long idCotacao) throws Exception{       
            cDao.removeCotacao(idCotacao);
           listCotacoes.remove(idCotacao);
           fireTableRowsInserted(listCotacoes.size() -1 , listCotacoes.size() -1);      
      }
          public void atualizaListadeCotacao(Cotacao c) throws Exception{              
              listCotacoes.remove(c);            
              fireTableRowsInserted(listCotacoes.size() -1 , listCotacoes.size() -1);   
             
      }
          
        
          
              
}
