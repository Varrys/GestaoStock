package entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Categoria {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIA_SEQ")
    //@SequenceGenerator(sequenceName = "CATEGORIA_SEQ", allocationSize = 1, name="CATEGORIA_SEQ")
    @Id
    @Column(name = "IDCATEGORIA", nullable = false, precision = 0)
    private BigInteger idcategoria;
    @Basic
    @Column(name = "ESTADO", nullable = true, length = 50)
    private String estado;

    public BigInteger getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(BigInteger idcategoria) {
        this.idcategoria = idcategoria;
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

        Categoria categoria = (Categoria) o;

        if (idcategoria != null ? !idcategoria.equals(categoria.idcategoria) : categoria.idcategoria != null)
            return false;
        if (estado != null ? !estado.equals(categoria.estado) : categoria.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcategoria != null ? idcategoria.hashCode() : 0;
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
