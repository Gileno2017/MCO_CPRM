/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cprm.gov.gilenomacedo.controle;


import cprm.gov.gilenomacedo.modelo.Produto;
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
public class ProdutoDao {
    
     public EntityManager getEM(){
       EntityManagerFactory factory = Persistence.createEntityManagerFactory("MCO_CPRMPU");
        
       return factory.createEntityManager();
    }
  
    
      public Produto salvarProduto(Produto produto)throws Exception {
            EntityManager em = getEM();

            try{
            em.getTransaction().begin();
            if(produto.getId()== null){
                em.persist(produto);// salva mapa no banco de dados
                
              }else{
                if(!em.contains(produto)){
                   if(em.find(Produto.class,produto.getId()) == null){
                     throw new Exception("Erro ao salvar o PRODUTO");
                   }
                }
                produto = em.merge(produto);// faz update no banco de dados
                         }     
            em.getTransaction().commit();
            }finally{
               em.close();

                }
            return produto;
          }
      
       //METODO RESPONSAVEL POR REMOVER O FORNECEDOR
      public void removeProduto(Long id)throws Exception{
          
              EntityManager em = getEM();
              Produto produto = em.find(Produto.class, id);
             try {
                  em.getTransaction().begin();
                  em.remove(produto);// remove o FORNECEDOR selecionado
                  em.getTransaction().commit();
              } finally {
                 em.close();
          }
          
      }
//      
       public Produto consultaProdutoId(Long id){
              EntityManager em = getEM();
              Produto produto = null;
              try {
               em.getTransaction().begin();
               produto = em.find(Produto.class, id);
               em.getTransaction().commit();
              } finally {
               em.close();
             }
            
             return produto;
          }
//          
       public List<Produto> consultaTodosProdutos(){
           EntityManager em = getEM();
           List<Produto> listProdutos;
           
           try {
               Query q = em.createNamedQuery("Produto.ConsultaTodos");
               listProdutos = q.getResultList();
           } catch (Exception e) {
               listProdutos = new ArrayList();
           }finally{
           em.close();
            }
         return listProdutos;
      
       }     
       
    public List<Produto> consultarTodosProdutosPorFornecedor(String forne) {
    EntityManager entityManager = getEM();
    Query query = entityManager.createNamedQuery("Produto.ConsultaporNome");
    query.setParameter("fornecedor",forne);  
    return query.getResultList();
  }

      
    
}
