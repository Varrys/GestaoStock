package com.example.backend.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "ENCOMENDA")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Encomenda.findAll", query = "SELECT c FROM Encomenda c"),
        @NamedQuery(name = "Encomenda.findAllByIdEncomenda", query = "SELECT c FROM Encomenda c WHERE c.idencomenda like :idencomenda"),
        @NamedQuery(name = "Encomenda.findByDataPedido", query = "SELECT c FROM Encomenda c WHERE c.datapedido = :datapedido"),
        @NamedQuery(name = "Encomenda.findByDataEntrega", query = "SELECT c FROM Encomenda c WHERE c.dataentrega = :dataentrega"),
        @NamedQuery(name = "Encomenda.findByDataIdEstado", query = "SELECT c FROM Encomenda c WHERE c.idestado = :idestado"),
        @NamedQuery(name = "Encomenda.findByIdUtilizador", query = "SELECT c FROM Encomenda c WHERE c.idutilizador = :idutilizador"),
        @NamedQuery(name = "Encomenda.findByIdFornecedor", query = "SELECT c FROM Encomenda c WHERE c.idfornecedor = :idfornecedor")})

public class Encomenda {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDENCOMENDA", nullable = false, precision = 0)
    private BigInteger idencomenda;
    @Basic
    @Column(name = "DATAPEDIDO", nullable = true)
    private Date datapedido;
    @Basic
    @Column(name = "DATAENTREGA", nullable = true)
    private Date dataentrega;
    @Basic
    @Column(name = "IDESTADO", nullable = true, precision = 0)
    private BigInteger idestado;
    @Basic
    @Column(name = "IDUTILIZADOR", nullable = true, precision = 0)
    private BigInteger idutilizador;
    @Basic
    @Column(name = "IDFORNECEDOR", nullable = true, precision = 0)
    private BigInteger idfornecedor;

    public BigInteger getIdencomenda() {
        return idencomenda;
    }

    public void setIdencomenda(BigInteger idencomenda) {
        this.idencomenda = idencomenda;
    }

    public Date getDatapedido() {
        return datapedido;
    }

    public void setDatapedido(Date datapedido) {
        this.datapedido = datapedido;
    }

    public Date getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(Date dataentrega) {
        this.dataentrega = dataentrega;
    }

    public BigInteger getIdestado() {
        return idestado;
    }

    public void setIdestado(BigInteger idestado) {
        this.idestado = idestado;
    }

    public BigInteger getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(BigInteger idutilizador) {
        this.idutilizador = idutilizador;
    }

    public BigInteger getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(BigInteger idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Encomenda encomenda = (Encomenda) o;

        if (idencomenda != null ? !idencomenda.equals(encomenda.idencomenda) : encomenda.idencomenda != null)
            return false;
        if (datapedido != null ? !datapedido.equals(encomenda.datapedido) : encomenda.datapedido != null) return false;
        if (dataentrega != null ? !dataentrega.equals(encomenda.dataentrega) : encomenda.dataentrega != null)
            return false;
        if (idestado != null ? !idestado.equals(encomenda.idestado) : encomenda.idestado != null) return false;
        if (idutilizador != null ? !idutilizador.equals(encomenda.idutilizador) : encomenda.idutilizador != null)
            return false;
        if (idfornecedor != null ? !idfornecedor.equals(encomenda.idfornecedor) : encomenda.idfornecedor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idencomenda != null ? idencomenda.hashCode() : 0;
        result = 31 * result + (datapedido != null ? datapedido.hashCode() : 0);
        result = 31 * result + (dataentrega != null ? dataentrega.hashCode() : 0);
        result = 31 * result + (idestado != null ? idestado.hashCode() : 0);
        result = 31 * result + (idutilizador != null ? idutilizador.hashCode() : 0);
        result = 31 * result + (idfornecedor != null ? idfornecedor.hashCode() : 0);
        return result;
    }
}
