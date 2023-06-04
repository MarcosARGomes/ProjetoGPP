package br.ufmt.GPP.controllers;

import br.ufmt.GPP.Request.FornecedorRequest;
import br.ufmt.GPP.Responses.FornecedorResponse;
import br.ufmt.GPP.models.Fornecedor;
import br.ufmt.GPP.repositorys.CidadeRepository;
import br.ufmt.GPP.repositorys.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "/fornecedor")
@RequiredArgsConstructor

public class FornecedorController {
    private final FornecedorRepository repository;
    private final CidadeRepository repositoryCidade;

    @GetMapping(path = "/")
    public List<FornecedorResponse> index(){
        List<Fornecedor> found = repository.findAll();
        List<FornecedorResponse> retorno = new ArrayList<>();
        for(int i = 0; i<found.toArray().length;i++){
            retorno.add((FornecedorResponse.from(found.get(i))));
        }
        return retorno;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponse> getById(@PathVariable(value = "id") int id){
        Optional<Fornecedor> found = repository.findById(id);
        if (found.isPresent()){
            FornecedorResponse response = FornecedorResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>remover(@PathVariable(value = "id")int id){
        try{
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (EmptyResultDataAccessException erro){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody FornecedorRequest request){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setFornecedor(request.getNome());
        fornecedor.setCidade(repositoryCidade.findById(request.getCidade_id()).get());
        fornecedor.setCnpj(request.getCnpj());
        fornecedor.setTelefone(request.getTelefone());
        try{
            repository.save(fornecedor);
        }catch (IllegalArgumentException error){
            return ResponseEntity.badRequest().body("Dados Invalidos");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado");
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody Fornecedor request){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(id);
        fornecedor.setFornecedor(request.getFornecedor());
        fornecedor.setCnpj(request.getCnpj());
        fornecedor.setTelefone(request.getTelefone());
        try {
            repository.save(fornecedor);
        } catch (IllegalArgumentException error){
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}

