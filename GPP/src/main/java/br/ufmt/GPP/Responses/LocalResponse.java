package br.ufmt.GPP.Responses;

import br.ufmt.GPP.models.Local;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalResponse {
    private int id;
    private String nome;
    private String andar;
    private String numero;
    private String responsavel;
    private String tipoLocal;
    public static LocalResponse from (Local entidade){
        LocalResponse response = new LocalResponse();
        response.setId((entidade.getId()));
        response.setNome(entidade.getLocais());
        response.setAndar(entidade.getAndar());
        response.setNumero(entidade.getNumero());
        response.setResponsavel(entidade.getResponsavel().getResponsaveis());
        response.setTipoLocal(response.getNome());
        return  response;
    }
}
