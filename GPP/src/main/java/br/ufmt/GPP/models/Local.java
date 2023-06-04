package br.ufmt.GPP.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name = "local")
@SequenceGenerator(name= "seqLocal", sequenceName = "seq_Local_id", allocationSize = 1)
@Getter
@Setter
public class Local {

    @Id
    @GeneratedValue(generator="seqLocal",strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 50)
    private String locais;

    @Column(name = "andar", length = 15)
    private String andar;

    @Column(name = "numero", length = 15)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Responsavel responsavel;

    @ManyToOne
    @JoinColumn(name = "tipoLocal_id")
    private TipoLocal tipoLocal;

    @OneToMany(mappedBy = "local")
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
        Local other = (Local) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
