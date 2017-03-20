/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mco_cprm;

import cprm.gov.gilenomacedo.controle.CotacaoDao;
import cprm.gov.gilenomacedo.controle.FornecedorDao;
import cprm.gov.gilenomacedo.controle.ProdutoDao;
import cprm.gov.gilenomacedo.modelo.Cotacao;
import cprm.gov.gilenomacedo.modelo.Fornecedor;
import cprm.gov.gilenomacedo.modelo.Produto;
import static cprm.gov.gilenomacedo.modelo.Produto_.fornecedor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gileno.macedo
 */
public class MCO_CPRM {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        LocalDate hoje =  LocalDate.now();        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        hoje.format(formato);
        System.out.println(hoje);
        
         Fornecedor fornecedo = new Fornecedor(); 
         FornecedorDao fd = new FornecedorDao();
      //   produto = fd.consultaFornecedorId(7l);
    
         Produto p = new Produto();
         ProdutoDao pd = new ProdutoDao();
         List<Produto> list = new ArrayList<>();
         
         list = pd.consultaTodosProdutos();
                 for (Produto list1 : list) {
            System.out.println("Produto"+ list1.getFornecedor().getFornecedor()+list1.getDescricao());
        }
        
         
        
//         fornecedo.setFornecedor("RPB DA AMAZONIA ");
//         fornecedo.setCgc("123456789");
//         fornecedo.setFormaPagamento("EMPENHO");
//         //fornecedo.setGarantia("3 MESES");
//         fornecedo.setNomeContato("MARIA JOAO");
//         fornecedo.setTel("32239259");
//         fornecedo.setUf("AM");
//       //  fornecedo.setValidade("10/02/2016");
//         fornecedo.setEntrega("21/02/2015");         
//         FornecedorDao fDao = new FornecedorDao();         
////         fDao.salvarFornecedo(fornecedo);         
//        List<Produto> listProdutos = new  ArrayList<Produto>();
//        ProdutoDao p = new ProdutoDao();
//        
//        listProdutos = p.consultaTodosProdutos();
//        for (Produto listProduto : listProdutos) {
//            System.out.println("list "+ listProduto.getFornecedor());
            
        }
        
//        
//       Cotacao ct = new Cotacao();
//       ct.setDatas("12/01/2001");
//       ct.setGerencia("gerafi");
//       ct.setNumColetaPrecos(001);
//       ct.setProcesso(123);
//       ct.setRcs(1235);
//       ct.setSuperintendencia("suregmao");
//       
//       CotacaoDao cdao = new CotacaoDao();
//       
//       cdao.salvarCotacao(ct);
        
//        
//        
//        
//select * from produto
//select * from fornecedor
//select * from cotacao
//select descricao from produto p  where p.fk_fornecedor = 7 
//
//SELECT  a.rcs,a.idcotacao, b.fornecedor
//FROM cotacao a, fornecedor b
//WHERE a.idcotacao = 6;
//listar os fornecedores de cada cotacao
//select a.gerencia, f.fornecedor from cotacao a 
//inner join fornecedor f  on a.idcotacao =  f.fk_rcs 
        
       // listar os produtos de cada fornecedor
        //select f.fornecedor , p.descricao from fornecedor f inner join produto p on f.idfornecedor = p.fk_fornecedor
        
//        select f.fornecedor , p.descricao,c.gerencia from fornecedor f inner join produto p on f.idfornecedor = p.fk_fornecedor
//inner join cotacao c on fornecedor d  on c.idcotacao = d.fk_rcs
    }
    

