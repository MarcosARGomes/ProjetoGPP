package br.ufmt.GPP.Responses;

import br.ufmt.GPP.models.Cidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CidadeResponse {
    private int id;
    private String nome;
    private int codPostal;
    private String estado_id;
    public static CidadeResponse from (Cidade entidade){
        CidadeResponse response = new CidadeResponse();
        response.setId(entidade.getId());
        response.setNome(entidade.getNome());
        response.setCodPostal(entidade.getCodPostal());
        response.setEstado_id(entidade.getEstado().getEstado());
        return  response;
    }
}
