package br.ufmt.GPP.Responses;

import br.ufmt.GPP.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {
    private int id;
    private String nome;
    private String categoria_id;
    private String fornecedor_id;
    private String descricao;
    private Integer quantidade;
    public static ProdutoResponse from (Produto entidade){
        ProdutoResponse response = new ProdutoResponse();
        response.setId(entidade.getId());
        response.setNome(entidade.getNome());
        response.setCategoria_id(entidade.getCategoria().getCategorias());
        response.setFornecedor_id(entidade.getFornecedor().getFornecedor());
        return response;
    }

}
