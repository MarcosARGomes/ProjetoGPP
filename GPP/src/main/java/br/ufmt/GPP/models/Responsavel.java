package br.ufmt.GPP.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "responsavel")
@SequenceGenerator(name= "seqResponsavel", sequenceName = "seq_Responsavel_id", allocationSize = 1)
@Getter
@Setter

public class Responsavel {
    @Id
    @GeneratedValue(generator="seqResponsavel",strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany(mappedBy = "responsavel")
    private List<Local> locais;

    @Column(name = "nome", length = 50)
    private String responsaveis;

    @Column(name = "CPF", length = 15)
    private String cpf;

    @Column(name = "cargo", length = 20)
    private String cargo;

    @Column(name = "setor", length = 20)
    private String setor;

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
        Responsavel other = (Responsavel) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
