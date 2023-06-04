package br.ufmt.GPP.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seqProduto", sequenceName = "seq_produto_id", allocationSize = 1)
@Getter
@Setter
public class Produto {
    @Id
    @GeneratedValue(generator = "seqProduto",strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    /*@OneToMany(mappedBy = "produto")
    private List<Item> itens;
*/
    @Column(name = "descricao", length = 200)
    private String descricao;

    @Column(name = "quantidade", length = 10)
    private int quantidade;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
