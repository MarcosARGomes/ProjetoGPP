package br.ufmt.GPP.Request;

public class TipoCodigoRequest {
    private String nome;

    private String descricao;

    public void setNome(String nome) {this.nome = nome;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getNome() { return nome;}
    public String getDescricao() {return descricao;}
}
