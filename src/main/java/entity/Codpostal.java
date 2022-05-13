package entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Codpostal.findAll", query = "SELECT c FROM Codpostal c")})

public class Codpostal {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODPOSTAL", nullable = true, length = 20)
    private String codpostal;
    @Basic
    @Column(name = "LOCALIDADE", nullable = true, length = 30)
    private String localidade;
    @Basic
    @Column(name = "DESCRICAO", nullable = true, length = 100)
    private String descricao;

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
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

        Codpostal codpostal1 = (Codpostal) o;

        if (codpostal != null ? !codpostal.equals(codpostal1.codpostal) : codpostal1.codpostal != null) return false;
        if (localidade != null ? !localidade.equals(codpostal1.localidade) : codpostal1.localidade != null)
            return false;
        if (descricao != null ? !descricao.equals(codpostal1.descricao) : codpostal1.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codpostal != null ? codpostal.hashCode() : 0;
        result = 31 * result + (localidade != null ? localidade.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Codpostal{" +
                "codpostal='" + codpostal + '\'' +
                ", localidade='" + localidade + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
