package br.ufmt.GPP.controllers;

import br.ufmt.GPP.Request.CategoriaRequest;
import br.ufmt.GPP.Responses.CategoriaResponse;
import br.ufmt.GPP.models.Categoria;
import br.ufmt.GPP.repositorys.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categoria")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaRepository repository;

    @GetMapping(path = "/")
    public List<CategoriaResponse> index(){
        List<Categoria> found = repository.findAll();
        List<CategoriaResponse> retorno = new ArrayList<>();
        for(int i = 0; i<found.toArray().length;i++){
            retorno.add(CategoriaResponse.from(found.get(i)));
        }
        return retorno;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoriaResponse> getById(@PathVariable(value = "id") int id){
        Optional<Categoria> found = repository.findById(id);
        if (found.isPresent()){
            CategoriaResponse response = CategoriaResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable(value = "id") int id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException error) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody CategoriaRequest request){
        Categoria categoria = new Categoria();
        categoria.setCategorias(request.getNome());
        categoria.setDescricao(request.getDescricao());
        try {
            repository.save(categoria);
        }catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().body("Dados Invalidos");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody CategoriaRequest request){
        Categoria categoria = new Categoria();
        categoria.setCategorias(request.getNome());
        categoria.setDescricao(request.getDescricao());
        try {
            repository.save(categoria);
        }catch (IllegalArgumentException error) {
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}

