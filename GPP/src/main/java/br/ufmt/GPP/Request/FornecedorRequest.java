package br.ufmt.GPP.Request;

public class FornecedorRequest {
    private String nome;
    private Integer cidade_id;
    private String cnpj;
    private String telefone;

    public void setNome(String nome){this.nome = nome;}
    public void setCidade_id(Integer cidade_id){this.cidade_id = cidade_id;}
    public void setCnpj(String cnpj){this.cnpj = cnpj;}
    public void setTelefone(String telefone){this.telefone = telefone;}
    public String getNome(){
        return nome;
    }
    public Integer getCidade_id(){return cidade_id;}
    /*public Integer getCidade_id(){return cidade_id;}*/
    public String getCnpj(){return cnpj;}
    public String getTelefone(){return telefone;}
}
