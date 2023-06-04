package br.ufmt.GPP.Request;

public class LocalRequest {
    private String nome;

    private String andar;
    private String numero;
    private Integer responsavel;
    private Integer tipoLocal;

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setAndar(String andar) {this.andar = andar;}
    public void setNumero(String numero) {this.numero = numero;}
    public void setResponsavel_id(Integer responsavel_id) {this.responsavel = responsavel_id;}
    public void setTipoLocal_id(Integer tipoLocal_id) {this.tipoLocal = tipoLocal_id;}

    public String getNome(){return nome;}
    public String getAndar() {return andar;}
    public String getNumero() {return numero;}
    public Integer getResponsavel_id(){return responsavel;}
    public Integer getTipoLocal_id() {return tipoLocal;}

}
