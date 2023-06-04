package br.ufmt.GPP.Request;

public class ResponsavelRequest {
    private String nome;
    private String cpf;
    private String cargo;
    private String setor;

    public void setNome(String nome) {this.nome = nome;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setCargo(String cargo){this.cargo = cargo;}
    public void setSetor(String setor){this.setor = setor;}

    public String getNome() {return nome;}
    public String getCpf() {return cpf;}
    public String getCargo() {return cargo;}
    public String getSetor() {return setor;}
}
