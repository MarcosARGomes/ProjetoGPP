package br.ufmt.GPP.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fornecedor")
@SequenceGenerator(name = "seqFornecedor", sequenceName = "seq_fornecedor_id", allocationSize = 1)
@Getter
@Setter

public class Fornecedor {

    @Id
    @GeneratedValue(generator = "seqFornecedor", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 100)
    private String fornecedor;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @Column(name = "cnpj",length = 20)
    private String cnpj;

    @Column(name = "telefone", length = 12)
    private String telefone;

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
        Fornecedor other = (Fornecedor) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
