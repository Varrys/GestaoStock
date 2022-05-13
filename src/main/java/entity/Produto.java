package entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Produto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "REFERENCIA", nullable = false, precision = 0)
    private BigInteger referencia;
    @Basic
    @Column(name = "NOME", nullable = true, length = 50)
    private String nome;
    @Basic
    @Column(name = "DESCRICAO", nullable = true, length = 200)
    private String descricao;
    @Basic
    @Column(name = "MARCA", nullable = true, length = 50)
    private String marca;
    @Basic
    @Column(name = "QUANTIDADE", nullable = true, precision = 0)
    private BigInteger quantidade;
    @Basic
    @Column(name = "PRECO", nullable = true, precision = 0)
    private Double preco;
    @Basic
    @Column(name = "IDCATEGORIA", nullable = true, precision = 0)
    private BigInteger idcategoria;
    @Basic
    @Column(name = "IVA", nullable = true, precision = 0)
    private Double iva;
    @Basic
    @Column(name = "PRECO_IVA", nullable = true, precision = 0)
    private Double precoIva;
    @ManyToOne
    @JoinColumn(name = "idcategoria", referencedColumnName = "IDCATEGORIA")
    private Categoria categoriaByIdcategoria;

    public BigInteger getReferencia() {
        return referencia;
    }

    public void setReferencia(BigInteger referencia) {
        this.referencia = referencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public BigInteger getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(BigInteger idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getPrecoIva() {
        return precoIva;
    }

    public void setPrecoIva(Double precoIva) {
        this.precoIva = precoIva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (referencia != null ? !referencia.equals(produto.referencia) : produto.referencia != null) return false;
        if (nome != null ? !nome.equals(produto.nome) : produto.nome != null) return false;
        if (descricao != null ? !descricao.equals(produto.descricao) : produto.descricao != null) return false;
        if (marca != null ? !marca.equals(produto.marca) : produto.marca != null) return false;
        if (quantidade != null ? !quantidade.equals(produto.quantidade) : produto.quantidade != null) return false;
        if (preco != null ? !preco.equals(produto.preco) : produto.preco != null) return false;
        if (idcategoria != null ? !idcategoria.equals(produto.idcategoria) : produto.idcategoria != null) return false;
        if (iva != null ? !iva.equals(produto.iva) : produto.iva != null) return false;
        if (precoIva != null ? !precoIva.equals(produto.precoIva) : produto.precoIva != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = referencia != null ? referencia.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        result = 31 * result + (quantidade != null ? quantidade.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        result = 31 * result + (idcategoria != null ? idcategoria.hashCode() : 0);
        result = 31 * result + (iva != null ? iva.hashCode() : 0);
        result = 31 * result + (precoIva != null ? precoIva.hashCode() : 0);
        return result;
    }

    public Categoria getCategoriaByIdcategoria() {
        return categoriaByIdcategoria;
    }

    public void setCategoriaByIdcategoria(Categoria categoriaByIdcategoria) {
        this.categoriaByIdcategoria = categoriaByIdcategoria;
    }
}
