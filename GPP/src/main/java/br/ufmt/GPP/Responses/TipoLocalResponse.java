package br.ufmt.GPP.Responses;

import br.ufmt.GPP.models.TipoLocal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoLocalResponse {
    private int id;
    private String nome;
    private String descricao;

    public static TipoLocalResponse from (TipoLocal entidade){
        TipoLocalResponse response = new TipoLocalResponse();
        response.setId(entidade.getId());
        response.setNome(entidade.getTipoLocais());
        response.setDescricao(entidade.getDescricao());
        return response;
    }
}
