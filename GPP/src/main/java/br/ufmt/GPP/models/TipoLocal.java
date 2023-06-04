package br.ufmt.GPP.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name = "tipo_local")
@SequenceGenerator(name= "seqTipoLocal", sequenceName = "seq_TipoLocal_id", allocationSize = 1)
@Getter
@Setter
public class TipoLocal {
    @Id
    @GeneratedValue(generator = "seqTipoLocal", strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany(mappedBy = "tipoLocal")
    private List<Local> locais ;

    @Column(name =" nome", length = 50)
    private String tipoLocais;

    @Column(name = "descricao", length = 250)
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
        TipoLocal other = (TipoLocal) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
