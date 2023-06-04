package br.ufmt.GPP.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cidade")
@SequenceGenerator(name = "seqCidade", sequenceName = "seq_cidade_id", allocationSize = 1)
@Getter
@Setter
public class Cidade {
    @Id
    @GeneratedValue(generator = "seqCidade", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cod_postal", length = 15)
    private int codPostal;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @OneToMany(mappedBy = "cidade")
    private List<Fornecedor> fornecedores;

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
        Cidade other = (Cidade) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
