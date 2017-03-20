/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cprm.gov.gilenomacedo.controle;

import cprm.gov.gilenomacedo.modelo.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author gileno.macedo
 */
public class FornecedorDao {
     public EntityManager getEM(){
     EntityManagerFactory factory = Persistence.createEntityManagerFactory("MCO_CPRMPU");
        
    return factory.createEntityManager();
    }
  
    
      public Fornecedor salvarFornecedo(Fornecedor fornecedor )throws Exception {
            EntityManager em = getEM();
         
            try{
            em.getTransaction().begin();
            if(fornecedor.getIdFornecedor() == null){
                em.persist(fornecedor);// salva o FORNECEDOR no banco de dados
                JOptionPane.showMessageDialog(null,"Salvo com sucesso");
                
              }else{
                if(!em.contains(fornecedor)){
                   if(em.find(Fornecedor.class,fornecedor.getIdFornecedor()) == null){
                     throw new Exception("Erro ao Salvar o Fornecedor");
                   }
                }
                fornecedor = em.merge(fornecedor);// faz update no banco de dados              
            }     
            em.getTransaction().commit();
            }finally{
               em.close();
            }
            return fornecedor;
          }
      
      
      //METODO RESPONSAVEL POR REMOVER O FORNECEDOR
      public void removeFornecedor(Long id)throws Exception{
          
              EntityManager em = getEM();
              Fornecedor fornecedor = em.find(Fornecedor.class, id);
             try {
                  em.getTransaction().begin();
                  em.remove(fornecedor);// remove o FORNECEDOR selecionado
                  em.getTransaction().commit();
              } finally {
                 em.close();
          }
          
      }
//      
       public Fornecedor consultaFornecedorId(Long id){
              EntityManager em = getEM();
              Fornecedor fornecedor = null;
              try {
               em.getTransaction().begin();
               fornecedor = em.find(Fornecedor.class, id);
               em.getTransaction().commit();
              } finally {
               em.close();
             }
            
             return fornecedor;
          }
//          
       public List<Fornecedor> consultaTodosFornecedores(){
           EntityManager em = getEM();
           List<Fornecedor> listFornecedor;
           
           try {
               Query q = em.createNamedQuery("Fornecedor.ConsultaTodos");
               listFornecedor = q.getResultList();
           } catch (Exception e) {
               listFornecedor = new ArrayList();
           }finally{
           em.close();
            }
         return listFornecedor;
      
       }       

}
