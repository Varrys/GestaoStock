package entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

public class ProdutoencomendaPK implements Serializable {
    @Column(name = "IDENCOMENDA", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idencomenda;
    @Column(name = "REFERENCIA", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger referencia;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdutoencomendaPK that = (ProdutoencomendaPK) o;

        if (idencomenda != null ? !idencomenda.equals(that.idencomenda) : that.idencomenda != null) return false;
        if (referencia != null ? !referencia.equals(that.referencia) : that.referencia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idencomenda != null ? idencomenda.hashCode() : 0;
        result = 31 * result + (referencia != null ? referencia.hashCode() : 0);
        return result;
    }
}
