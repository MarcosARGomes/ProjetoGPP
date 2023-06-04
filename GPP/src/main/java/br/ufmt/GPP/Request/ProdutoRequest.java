package br.ufmt.GPP.Request;

public class ProdutoRequest {

    private String nome;
    private String categoria_id;
    private String fornecedor_id;
    private String descricao;
    private Integer quantidade;

    public void setNome(String nome){this.nome = nome;}
    public void setCategoria_id(String categoria_id){this.categoria_id = categoria_id;}
    public void setFornecedor_id(String fornecedor_id){this.fornecedor_id = fornecedor_id;}
    public void setDescricao(String descricao){this.descricao = descricao;}
    public void setQuantidade(Integer quantidade){this.quantidade = quantidade;}

    public  String getNome(){
        return nome;
    }
    public String getCategoria_id(){return categoria_id;}
    public String getFornecedor_id(){return fornecedor_id;}
    public String getDescricao(){return descricao;}
    public Integer getQuantidade(){return quantidade;}
}
