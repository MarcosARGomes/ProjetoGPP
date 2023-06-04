package br.ufmt.GPP.Responses;

import br.ufmt.GPP.models.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponse {
    private int id;
    private String nome;
    private String descricao;

    public static CategoriaResponse from (Categoria entidade){
        CategoriaResponse response = new CategoriaResponse();
        response.setId(entidade.getId());
        response.setNome(entidade.getCategorias());
        response.setDescricao(entidade.getDescricao());
        return response;
    }
}
