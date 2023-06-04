package br.ufmt.GPP.Responses;

import br.ufmt.GPP.models.TipoCodigo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoCodigoResponse {
    private int id;
    private String nome;
    private String descricao;

   public static TipoCodigoResponse from (TipoCodigo entidade){
       TipoCodigoResponse response = new TipoCodigoResponse();
       response.setId(entidade.getId());
       response.setNome(entidade.getTipoCodigos());
       response.setDescricao(entidade.getDescricao());
       return response;
   }
}
