package com.example.backend.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "UTILIZADOR")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Utilizador.findAll", query = "SELECT c FROM Utilizador c"),
        @NamedQuery(name = "Utilizador.findAllByIdUtilizador", query = "SELECT c FROM Utilizador c WHERE c.idutilizador like :idUtilizador"),
        @NamedQuery(name = "Utilizador.findByUsername", query = "SELECT c FROM Utilizador c WHERE c.username = :username"),
        @NamedQuery(name = "Utilizador.findByPassword", query = "SELECT c FROM Utilizador c WHERE c.password = :password"),
        @NamedQuery(name = "Utilizador.findByTelefone", query = "SELECT c FROM Utilizador c WHERE c.telefone = :telefone"),
        @NamedQuery(name = "Utilizador.findByNome", query = "SELECT c FROM Utilizador c WHERE c.nome = :nome"),
        @NamedQuery(name = "Utilizador.findByCodTipo", query = "SELECT c FROM Utilizador c WHERE c.tipoutilizadorByCodtipo = :codtipo")})
public class Utilizador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDUTILIZADOR", nullable = false, precision = 0)
    private BigInteger idutilizador;
    @Basic
    @Column(name = "USERNAME", nullable = true, length = 50)
    private String username;
    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 50)
    private String password;
    @Basic
    @Column(name = "TELEFONE", nullable = true, precision = 0)
    private BigInteger telefone;
    @Basic
    @Column(name = "NOME", nullable = true, length = 70)
    private String nome;
    @Basic
    //@Basic
    //@Column(name = "CODTIPO", nullable = true, precision = 0)
    //private BigInteger codtipo;
    @OneToMany(mappedBy = "idencomenda")
    private Collection<Encomenda> encomendasByIdutilizador;
    @OneToMany(mappedBy = "idsaidaproduto")
    private Collection<Saidaproduto> saidaprodutosByIdutilizador;
    @ManyToOne
    @JoinColumn(name = "codtipo", referencedColumnName = "codtipo")
    private Tipoutilizador tipoutilizadorByCodtipo;

    public BigInteger getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(BigInteger idutilizador) {
        this.idutilizador = idutilizador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getTelefone() {
        return telefone;
    }

    public void setTelefone(BigInteger telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //public BigInteger getCodtipo() {
    //    return codtipo;
    //}
/*
    public void setCodtipo(BigInteger codtipo) {
        this.codtipo = codtipo;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilizador that = (Utilizador) o;

        if (idutilizador != null ? !idutilizador.equals(that.idutilizador) : that.idutilizador != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (telefone != null ? !telefone.equals(that.telefone) : that.telefone != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        /*if (codtipo != null ? !codtipo.equals(that.codtipo) : that.codtipo != null) return false;*/

        return true;
    }

    @Override
    public int hashCode() {
        int result = idutilizador != null ? idutilizador.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
       /* result = 31 * result + (codtipo != null ? codtipo.hashCode() : 0);*/
        return result;
    }

    public Collection<Encomenda> getEncomendasByIdutilizador() {
        return encomendasByIdutilizador;
    }

    public void setEncomendasByIdutilizador(Collection<Encomenda> encomendasByIdutilizador) {
        this.encomendasByIdutilizador = encomendasByIdutilizador;
    }

    public Collection<Saidaproduto> getSaidaprodutosByIdutilizador() {
        return saidaprodutosByIdutilizador;
    }

    public void setSaidaprodutosByIdutilizador(Collection<Saidaproduto> saidaprodutosByIdutilizador) {
        this.saidaprodutosByIdutilizador = saidaprodutosByIdutilizador;
    }

    public Tipoutilizador getTipoutilizadorByCodtipo() {
        return tipoutilizadorByCodtipo;
    }

    public void setTipoutilizadorByCodtipo(Tipoutilizador tipoutilizadorByCodtipo) {
        this.tipoutilizadorByCodtipo = tipoutilizadorByCodtipo;
    }
}
