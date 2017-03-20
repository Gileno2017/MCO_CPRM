/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cprm.gov.gilenomacedo.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author gileno.macedo
 */

@Entity
@NamedQueries({
//    @NamedQuery(name = "Cotacao.ConsultaTodos",
//            query = "SELECT e FROM  Cotacao e ORDER BY e.datas DESC"),
//select inner join com 3 tabelas
  @NamedQuery(name = "Cotacao.ConsultaTodos",
            query = "SELECT c FROM Cotacao c inner join Fornecedor f on c.idcotacao = f.fk_rcs inner join Produto p on f.idfornecedor = p.fk_fornecedor"),})

public class Cotacao implements Serializable{
    
    @Id  
    @SequenceGenerator(name = "seq_cotacao", sequenceName = "seq_cod_cotacao", allocationSize = 1)
    @GeneratedValue(generator = "seq_cotacao", strategy = GenerationType.SEQUENCE)
    private Long idCotacao;
    private Integer processo;
    private Integer numColetaPrecos;
    private String datas;
    private String gerencia;
    private String superintendencia;
    private Integer rcs;
    
    @OneToMany
    private List<Fornecedor> listFornecedores; 
     @OneToMany
    private List<Produto> listprodutos; 

    public Long getIdCotacao() {
        return idCotacao;
    }

    public void setIdCotacao(Long idCotacao) {
        this.idCotacao = idCotacao;
    }

    public Integer getProcesso() {
        return processo;
    }

    public void setProcesso(Integer processo) {
        this.processo = processo;
    }

    public Integer getNumColetaPrecos() {
        return numColetaPrecos;
    }

    public void setNumColetaPrecos(Integer numColetaPrecos) {
        this.numColetaPrecos = numColetaPrecos;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getSuperintendencia() {
        return superintendencia;
    }

    public void setSuperintendencia(String superintendencia) {
        this.superintendencia = superintendencia;
    }

    public Integer getRcs() {
        return rcs;
    }

    public void setRcs(Integer rcs) {
        this.rcs = rcs;
    }

    public List<Fornecedor> getListFornecedores() {
        return listFornecedores;
    }

    public void setListFornecedores(List<Fornecedor> listFornecedores) {
        this.listFornecedores = listFornecedores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idCotacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cotacao other = (Cotacao) obj;
        if (!Objects.equals(this.idCotacao, other.idCotacao)) {
            return false;
        }
        if (!Objects.equals(this.processo, other.processo)) {
            return false;
        }
        if (!Objects.equals(this.numColetaPrecos, other.numColetaPrecos)) {
            return false;
        }
        if (!Objects.equals(this.datas, other.datas)) {
            return false;
        }
        if (!Objects.equals(this.gerencia, other.gerencia)) {
            return false;
        }
        if (!Objects.equals(this.superintendencia, other.superintendencia)) {
            return false;
        }
        if (!Objects.equals(this.rcs, other.rcs)) {
            return false;
        }
        return Objects.equals(this.listFornecedores, other.listFornecedores);
    }

    public List<Produto> getListprodutos() {
        return listprodutos;
    }

    public void setListprodutos(List<Produto> listprodutos) {
        this.listprodutos = listprodutos;
    }

    
}
