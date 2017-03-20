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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Fornecedor.ConsultaTodos",
            query = "SELECT e FROM  Fornecedor e ")
    })

public class Fornecedor implements Serializable {
    
  @Id 
  @SequenceGenerator(name = "seq_fornecedor", sequenceName = "seq_id_fornecedor", allocationSize = 1)
  @GeneratedValue(generator = "seq_fornecedor", strategy = GenerationType.SEQUENCE)
    private Long idFornecedor;

   
    private String fornecedor;
    private String cgc;
    private String tel;
    private String nomeContato;
    private String formaPagamento;
    private String uf;
    private String entrega;
    
    @ManyToOne
    @JoinColumn(name = "fk_rcs")
    private Cotacao cotacao;
           
     @OneToMany
    private List<Produto> listadeProdutos;
    
    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCgc() {
        return cgc;
    }

    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

   

   public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }   
   
    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
    

       @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.idFornecedor);
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.idFornecedor, other.idFornecedor)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.cgc, other.cgc)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.nomeContato, other.nomeContato)) {
            return false;
        }
        if (!Objects.equals(this.formaPagamento, other.formaPagamento)) {
            return false;
        }               
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        return Objects.equals(this.entrega, other.entrega);
    }

    public Cotacao getCotacao() {
        return cotacao;
    }

    public void setCotacao(Cotacao cotacao) {
        this.cotacao = cotacao;
    }



    public List<Produto> getListadeProdutos() {
        return listadeProdutos;
    }

    public void setListadeProdutos(List<Produto> listadeProdutos) {
        this.listadeProdutos = listadeProdutos;
    }
    
}
