package com.example.backend.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "TIPOUTILIZADOR")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TipoUtilizador.findAll", query = "SELECT c FROM Tipoutilizador c"),
        @NamedQuery(name = "TipoUtilizador.findAllByCodTipo", query = "SELECT c FROM Tipoutilizador c WHERE c.codtipo like :codtipo"),
        @NamedQuery(name = "TipoUtilizador.findByDescricao", query = "SELECT c FROM Tipoutilizador c WHERE c.descricao = :descricao")})
public class Tipoutilizador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODTIPO", nullable = false, precision = 0)
    private BigInteger codtipo;
    @Basic
    @Column(name = "DESCRICAO", nullable = true, length = 100)
    private String descricao;
    @OneToMany(mappedBy = "tipoutilizadorByCodtipo")
    private Collection<Utilizador> utilizadores;

    public BigInteger getCodtipo() {
        return codtipo;
    }

    public void setCodtipo(BigInteger codtipo) {
        this.codtipo = codtipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tipoutilizador that = (Tipoutilizador) o;

        if (codtipo != null ? !codtipo.equals(that.codtipo) : that.codtipo != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codtipo != null ? codtipo.hashCode() : 0;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}
