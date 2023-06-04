/*package br.ufmt.GPP.controllers;

import br.ufmt.GPP.Request.ProdutoRequest;
import br.ufmt.GPP.Responses.ProdutoResponse;
import br.ufmt.GPP.models.Fornecedor;
import br.ufmt.GPP.models.Produto;
import br.ufmt.GPP.repositorys.CategoriaRepository;
import br.ufmt.GPP.repositorys.FornecedorRepository;
import br.ufmt.GPP.repositorys.ProdutoRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/produto")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoRepository repository;
    private final CategoriaRepository repositoryCategoria;
    private final FornecedorRepository repositoryFornecedor;

    @GetMapping(path = "/")
    public List<ProdutoResponse> index(){
        List<Produto> found = repository.findAll();
        List<ProdutoResponse> retorno = new ArrayList<>();
        for(int i = 0; i<found.toArray().length; i++){
            retorno.add(ProdutoResponse.from(found.get(i)));
        }
        return retorno;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void>remover(@PathVariable(value="id")int id){
        try{
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException error){
            return ResponseEntity.notFound().build();
        }
    }
/*
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody ProdutoRequest request){
        Produto produto = new Produto();
        produto.setNome(request.getNome());
        produto.setCategoria(repositoryCategoria.findById(request.getCategoria_id()).get());
        produto.setFornecedor(repositoryFornecedor.findById(request.getFornecedor_id()).get());
        produto.setDescricao(request.getDescricao());
        produto.setQuantidade(request.getQuantidade());
        try{
            repository.save(produto);
        }catch (IllegalArgumentException error){
            return ResponseEntity.badRequest().body("Dados Invalidos");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado");
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@)

}
 */
