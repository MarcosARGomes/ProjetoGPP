package br.ufmt.GPP.Responses;

import br.ufmt.GPP.models.Responsavel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsavelResponse {
   private int id;
   private String nome;
   private String cpf;
   private String cargo;
   private String setor;

   public static ResponsavelResponse from (Responsavel entidade){
       ResponsavelResponse response = new ResponsavelResponse();
       response.setId(entidade.getId());
       response.setNome(entidade.getResponsaveis());
       response.setCpf(entidade.getCpf());
       response.setCargo(entidade.getCargo());
       response.setSetor(entidade.getSetor());
       return response;
   }

}
