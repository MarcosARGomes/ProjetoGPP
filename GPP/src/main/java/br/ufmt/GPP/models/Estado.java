package br.ufmt.GPP.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "estado")
@SequenceGenerator(name = "seqEstado", sequenceName = "seq_estado_id", allocationSize = 1)
@Getter
@Setter

public class Estado {
    @Id
    @GeneratedValue(generator = "seqEstado", strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany(mappedBy ="estado")
    private List<Cidade> cidades;

    @Column(name = "nome", length = 50)
    private String estado;

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
        Estado other = (Estado) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
