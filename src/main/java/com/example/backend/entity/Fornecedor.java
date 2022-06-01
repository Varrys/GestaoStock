package com.example.backend.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "FORNECEDOR")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Fornecedor.findAll", query = "SELECT c FROM Fornecedor c"),
        @NamedQuery(name = "Fornecedor.findAllByIdFornecedor", query = "SELECT c FROM Fornecedor c WHERE c.idfornecedor like :idFornecedor"),
        @NamedQuery(name = "Fornecedor.findByNome", query = "SELECT c FROM Fornecedor c WHERE c.nome = :nome"),
        @NamedQuery(name = "Fornecedor.findByEmail", query = "SELECT c FROM Fornecedor c WHERE c.email = :email"),
        @NamedQuery(name = "Fornecedor.findByRua", query = "SELECT c FROM Fornecedor c WHERE c.rua = :rua"),
        @NamedQuery(name = "Fornecedor.findByNPorta", query = "SELECT c FROM Fornecedor c WHERE c.nporta = :nporta"),
        @NamedQuery(name = "Fornecedor.findByTelefone", query = "SELECT c FROM Fornecedor c WHERE c.telefone = :telefone"),
        @NamedQuery(name = "Fornecedor.findByNif", query = "SELECT c FROM Fornecedor c WHERE c.nif = :nif"),
        @NamedQuery(name = "Fornecedor.findByCodPostal", query = "SELECT c FROM Fornecedor c WHERE c.codpostalByCodpostal = :codpostalByCodpostal")})

public class Fornecedor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDFORNECEDOR", nullable = false, precision = 0)
    private BigInteger idfornecedor;
    @Basic
    @Column(name = "NOME", nullable = true, length = 50)
    private String nome;
    @Basic
    @Column(name = "EMAIL", nullable = true, length = 50)
    private String email;
    @Basic
    @Column(name = "RUA", nullable = true, length = 50)
    private String rua;
    @Basic
    @Column(name = "NPORTA", nullable = true, precision = 0)
    private BigInteger nporta;
    @Basic
    @Column(name = "TELEFONE", nullable = true, precision = 0)
    private Long telefone;
    @Basic
    @Column(name = "NIF", nullable = true, precision = 0)
    private Long nif;
    @OneToMany(mappedBy = "idencomenda")
    private Collection<Encomenda> encomendasByIdfornecedor;
    @ManyToOne
    @JoinColumn(name = "codpostal", referencedColumnName = "codpostal")
    private Codpostal codpostalByCodpostal;

    public BigInteger getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(BigInteger idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public BigInteger getNporta() {
        return nporta;
    }

    public void setNporta(BigInteger nporta) {
        this.nporta = nporta;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Long getNif() {
        return nif;
    }

    public void setNif(Long nif) {
        this.nif = nif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fornecedor that = (Fornecedor) o;

        if (idfornecedor != null ? !idfornecedor.equals(that.idfornecedor) : that.idfornecedor != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (rua != null ? !rua.equals(that.rua) : that.rua != null) return false;
        if (nporta != null ? !nporta.equals(that.nporta) : that.nporta != null) return false;
        if (telefone != null ? !telefone.equals(that.telefone) : that.telefone != null) return false;
        if (nif != null ? !nif.equals(that.nif) : that.nif != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = idfornecedor != null ? idfornecedor.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (nporta != null ? nporta.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (nif != null ? nif.hashCode() : 0);

        return result;
    }

    public Collection<Encomenda> getEncomendasByIdfornecedor() {
        return encomendasByIdfornecedor;
    }

    public void setEncomendasByIdfornecedor(Collection<Encomenda> encomendasByIdfornecedor) {
        this.encomendasByIdfornecedor = encomendasByIdfornecedor;
    }

    public Codpostal getCodpostalByCodpostal() {
        return codpostalByCodpostal;
    }

    public void setCodpostalByCodpostal(Codpostal codpostalByCodpostal) {
        this.codpostalByCodpostal = codpostalByCodpostal;
    }
}
