package br.ufmt.GPP.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tipo_codigo")
@SequenceGenerator(name="seqTipoCodigo", sequenceName = "seq_TipoLocal_id", allocationSize = 1)
@Getter
@Setter
public class TipoCodigo {
    @Id
    @GeneratedValue(generator ="seqTipoCodigo", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name =" nome", length = 50)
    private String tipoCodigos;

    @Column(name = "descricao", length = 250)
    private String descricao;

    @OneToMany(mappedBy = "tipoCodigo")
    private List<Item> itens;

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
        TipoCodigo other = (TipoCodigo) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
