package br.ufmt.GPP.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "item")
@SequenceGenerator(name = "seqItem", sequenceName = "seq_item_id", allocationSize = 1)
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(generator = "seqItem", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 100)
    private String nome;

    /*@OneToMany(mappedBy = "produto")
    private List<Produto> produtos;
*/
    @Column(name = "descricao", length = 200)
    private String descricao;

    @Column(name = "codigo", length = 50)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "tipo_codigo_id")
    private TipoCodigo tipoCodigo;

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
        Item other = (Item) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
