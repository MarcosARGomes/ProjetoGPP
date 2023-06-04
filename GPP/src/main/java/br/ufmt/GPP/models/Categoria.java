package br.ufmt.GPP.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categoria")
@SequenceGenerator(name= "seqCategoria", sequenceName = "seq_Categoria_id", allocationSize = 1)
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(generator = "seqCategoria", strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;

    @Column(name = "nome", length = 50)
    private String categorias ;

    @Column(name = "descricao", length = 50)
    private String descricao;

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
        Categoria other = (Categoria) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
