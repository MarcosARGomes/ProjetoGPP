package br.ufmt.GPP.Responses;

import br.ufmt.GPP.models.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoResponse {
    private int id;
    private String nome;

    public static EstadoResponse from (Estado entidade){
        EstadoResponse response = new EstadoResponse();
        response.setId(entidade.getId());
        response.setNome(entidade.getEstado());
        return response;

    }
}
