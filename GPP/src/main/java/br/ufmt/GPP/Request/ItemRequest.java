package br.ufmt.GPP.Request;

public class ItemRequest {
    private String nome;
    private Integer produto_id;
    private String descricao;
    private String codigo;
    private Integer local_id;
    private Integer tipo_codigo_id;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setLocal(Integer local_id) {
        this.local_id = local_id;
    }

    public void setTipo_codigo_id(Integer tipo_codigo_id) {
        this.tipo_codigo_id = tipo_codigo_id;
    }

    public String getNome(){return nome;}

    public Integer getProduto_id() {
        return produto_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getLocal_id() {
        return local_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public Integer getTipo_codigo_id() {
        return tipo_codigo_id;
    }
}
