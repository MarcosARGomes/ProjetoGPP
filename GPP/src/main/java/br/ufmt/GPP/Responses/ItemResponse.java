package br.ufmt.GPP.Responses;

import br.ufmt.GPP.models.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {
    private int id;
    private String nome;
    private int produto_id;
    private String descricao;
    private String codigo;
    private String local_id;
    private String tipo_codigo_id;
    public static ItemResponse from (Item entidade){
        ItemResponse response = new ItemResponse();
        response.setId(entidade.getId());
        response.setNome(entidade.getNome());
      /*  response.setProduto_id(entidade.getProduto().getItens());*/
        response.setDescricao(entidade.getDescricao());
        response.setCodigo(entidade.getCodigo());
        response.setTipo_codigo_id(entidade.getTipoCodigo().getTipoCodigos());
        response.setLocal_id(entidade.getLocal().getLocais());
        return response;
    }

    private void setProduto_id(List<Item> itens) {
    }
}
