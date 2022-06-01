package com.example.backend.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@IdClass(ProdutoencomendaPK.class)
public class Produtoencomenda {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDENCOMENDA", nullable = false, precision = 0)
    private BigInteger idencomenda;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "REFERENCIA", nullable = false, precision = 0)
    private BigInteger referencia;
    @Basic
    @Column(name = "QUANTIDADE", nullable = true, precision = 0)
    private BigInteger quantidade;
    @Basic
    @Column(name = "PRECO", nullable = true, precision = 0)
    private Double preco;
    @ManyToOne
    @JoinColumn(name = "idencomenda", referencedColumnName = "idencomenda", nullable = false)
    private Encomenda encomendaByIdencomenda;
    @ManyToOne
    @JoinColumn(name = "referencia", referencedColumnName = "REFERENCIA", nullable = false)
    private Produto produtoByReferencia;

    public BigInteger getIdencomenda() {
        return idencomenda;
    }

    public void setIdencomenda(BigInteger idencomenda) {
        this.idencomenda = idencomenda;
    }

    public BigInteger getReferencia() {
        return referencia;
    }

    public void setReferencia(BigInteger referencia) {
        this.referencia = referencia;
    }

    public BigInteger getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigInteger quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produtoencomenda that = (Produtoencomenda) o;

        if (idencomenda != null ? !idencomenda.equals(that.idencomenda) : that.idencomenda != null) return false;
        if (referencia != null ? !referencia.equals(that.referencia) : that.referencia != null) return false;
        if (quantidade != null ? !quantidade.equals(that.quantidade) : that.quantidade != null) return false;
        if (preco != null ? !preco.equals(that.preco) : that.preco != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idencomenda != null ? idencomenda.hashCode() : 0;
        result = 31 * result + (referencia != null ? referencia.hashCode() : 0);
        result = 31 * result + (quantidade != null ? quantidade.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        return result;
    }

    public Encomenda getEncomendaByIdencomenda() {
        return encomendaByIdencomenda;
    }

    public void setEncomendaByIdencomenda(Encomenda encomendaByIdencomenda) {
        this.encomendaByIdencomenda = encomendaByIdencomenda;
    }

    public Produto getProdutoByReferencia() {
        return produtoByReferencia;
    }

    public void setProdutoByReferencia(Produto produtoByReferencia) {
        this.produtoByReferencia = produtoByReferencia;
    }
}
