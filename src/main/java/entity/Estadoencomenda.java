package entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;

@Entity
public class Estadoencomenda {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDESTADO", nullable = false, precision = 0)
    private BigInteger idestado;
    @Basic
    @Column(name = "ESTADO", nullable = true, length = 20)
    private String estado;
    @OneToMany(mappedBy = "idencomenda")
    private Collection<Encomenda> encomendasByIdestado;

    public BigInteger getIdestado() {
        return idestado;
    }

    public void setIdestado(BigInteger idestado) {
        this.idestado = idestado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estadoencomenda that = (Estadoencomenda) o;

        if (idestado != null ? !idestado.equals(that.idestado) : that.idestado != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idestado != null ? idestado.hashCode() : 0;
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public Collection<Encomenda> getEncomendasByIdestado() {
        return encomendasByIdestado;
    }

    public void setEncomendasByIdestado(Collection<Encomenda> encomendasByIdestado) {
        this.encomendasByIdestado = encomendasByIdestado;
    }
}
