/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cprm.gov.gilenomacedo.controle;

import cprm.gov.gilenomacedo.modelo.Cotacao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



/**
 *
 * @author gileno.macedo
 */
public class CotacaoDao {
       public EntityManager getEM(){
       EntityManagerFactory factory = Persistence.createEntityManagerFactory("MCO_CPRMPU");
        
       return factory.createEntityManager();
    }
  
     public Cotacao salvarCotacao(Cotacao cc) throws Exception {
            EntityManager em = getEM();

            try{
            em.getTransaction().begin();
            if(cc.getIdCotacao()== null){
                em.persist(cc);// salva cotacao no banco de dados
                
              }else{
                if(!em.contains(cc)){
                   if(em.find(Cotacao.class,cc.getIdCotacao()) == null){
                     throw new Exception("Erro ao Salvar a Cotacao");
                   }
                }
                cc = em.merge(cc);// faz update no banco de dados
               // JOptionPane.showMessageDialog(null, "Dados Alterado com Sucesso!!");
            }     
            em.getTransaction().commit();
            }finally{
               em.close();

                }
            return cc;
          }
       //METODO RESPONSAVEL POR REMOVER O FORNECEDOR
      public void removeCotacao(Long id)throws Exception{
          
              EntityManager em = getEM();
              Cotacao cotacao = em.find(Cotacao.class, id);
             try {
                  em.getTransaction().begin();
                  em.remove(cotacao);// remove o FORNECEDOR selecionado
                  em.getTransaction().commit();
              } finally {
                 em.close();
          }
          
      }
//      
       public Cotacao consultaCotacaoId(Long id){
              EntityManager em = getEM();
              Cotacao cotacao = null;
              try {
               em.getTransaction().begin();
               cotacao = em.find(Cotacao.class, id);
               em.getTransaction().commit();
              } finally {
               em.close();
             }
            
             return cotacao;
          }
//          
       public List<Cotacao> consultaTodasCotacoes(){
           EntityManager em = getEM();
           List<Cotacao> listCotacao;
           
           try {
               Query q = em.createNamedQuery("Cotacao.ConsultaTodos");
               listCotacao = q.getResultList();
           } catch (Exception e) {
               listCotacao = new ArrayList();
           }finally{
           em.close();
            }
         return listCotacao;
      
       }   
       
    public List<Cotacao> consultarInnerJoin(Long id) {
    EntityManager entityManager = getEM();
    Query query = entityManager.createNamedQuery("Cotacao.InnerJoin");
    query.setParameter("InnerJoin", id );
  
    return query.getResultList();
  }

      
}
