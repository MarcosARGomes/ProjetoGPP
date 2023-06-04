package br.ufmt.GPP.Request;

public class CidadeRequest {
    private String nome;
    private Integer codPostal;
    private Integer estado_id;

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCodPostal(Integer codPostal){this.codPostal = codPostal;}
    public void setEstado_Id(Integer estado_id){this.estado_id = estado_id;}

    public String getNome(){
        return nome;
    }
    public Integer getCodPostal(){return codPostal;}

    public Integer getEstado_id(){return estado_id;}

}
