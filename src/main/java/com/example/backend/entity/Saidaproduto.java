package com.example.backend.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "SAIDAPRODUTO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Saidaproduto.findAll", query = "SELECT c FROM Saidaproduto c"),
        @NamedQuery(name = "Saidaproduto.findAllByIdSaidaProduto", query = "SELECT c FROM Saidaproduto c WHERE c.idsaidaproduto like :idsaidaproduto"),
        @NamedQuery(name = "Saidaproduto.findByIdUtilizador", query = "SELECT c FROM Saidaproduto c WHERE c.idutilizador = :idutilizador"),
        @NamedQuery(name = "Saidaproduto.findByReferencia", query = "SELECT c FROM Saidaproduto c WHERE c.produtoByReferencia = :produtoByReferencia"),
        @NamedQuery(name = "Saidaproduto.findByQuantidade", query = "SELECT c FROM Saidaproduto c WHERE c.quantidade = :quantidade"),
        @NamedQuery(name = "Saidaproduto.findByPreco", query = "SELECT c FROM Saidaproduto c WHERE c.preco = :preco"),
        @NamedQuery(name = "Saidaproduto.findByDataSaida", query = "SELECT c FROM Saidaproduto c WHERE c.datasaida = :datasaida")})

public class Saidaproduto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDSAIDAPRODUTO", nullable = false, precision = 0)
    private BigInteger idsaidaproduto;
    @Basic
    @Column(name = "IDUTILIZADOR", nullable = true, precision = 0)
    private BigInteger idutilizador;
//    @Basic
//    @Column(name = "REFERENCIA", nullable = true, precision = 0)
//    private BigInteger referencia;
    @Basic
    @Column(name = "QUANTIDADE", nullable = true, precision = 0)
    private BigInteger quantidade;
    @Basic
    @Column(name = "PRECO", nullable = true, precision = 0)
    private Double preco;
    @Basic
    @Column(name = "DATASAIDA", nullable = true)
    private Date datasaida;
    @ManyToOne
    @JoinColumn(name = "referencia", referencedColumnName = "REFERENCIA")
    private Produto produtoByReferencia;

    public BigInteger getIdsaidaproduto() {
        return idsaidaproduto;
    }

    public void setIdsaidaproduto(BigInteger idsaidaproduto) {
        this.idsaidaproduto = idsaidaproduto;
    }

    public BigInteger getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(BigInteger idutilizador) {
        this.idutilizador = idutilizador;
    }

//    public BigInteger getReferencia() {
//        return referencia;
//    }
//
//    public void setReferencia(BigInteger referencia) {
//        this.referencia = referencia;
//    }

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

    public Date getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Saidaproduto that = (Saidaproduto) o;

        if (idsaidaproduto != null ? !idsaidaproduto.equals(that.idsaidaproduto) : that.idsaidaproduto != null)
            return false;
        if (idutilizador != null ? !idutilizador.equals(that.idutilizador) : that.idutilizador != null) return false;
//        if (referencia != null ? !referencia.equals(that.referencia) : that.referencia != null) return false;
        if (quantidade != null ? !quantidade.equals(that.quantidade) : that.quantidade != null) return false;
        if (preco != null ? !preco.equals(that.preco) : that.preco != null) return false;
        if (datasaida != null ? !datasaida.equals(that.datasaida) : that.datasaida != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsaidaproduto != null ? idsaidaproduto.hashCode() : 0;
        result = 31 * result + (idutilizador != null ? idutilizador.hashCode() : 0);
//        result = 31 * result + (referencia != null ? referencia.hashCode() : 0);
        result = 31 * result + (quantidade != null ? quantidade.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        result = 31 * result + (datasaida != null ? datasaida.hashCode() : 0);
        return result;
    }

    public Produto getProdutoByReferencia() {
        return produtoByReferencia;
    }

    public void setProdutoByReferencia(Produto produtoByReferencia) {
        this.produtoByReferencia = produtoByReferencia;
    }
}
