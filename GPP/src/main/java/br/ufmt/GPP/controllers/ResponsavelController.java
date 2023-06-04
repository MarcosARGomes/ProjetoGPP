package br.ufmt.GPP.controllers;

import br.ufmt.GPP.Request.ResponsavelRequest;
import br.ufmt.GPP.Responses.ResponsavelResponse;
import br.ufmt.GPP.models.Responsavel;
import br.ufmt.GPP.repositorys.ResponsavelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/responsavel")
@RequiredArgsConstructor

public class ResponsavelController {
    private final ResponsavelRepository repository;

    @GetMapping(path = "/")
    public List<ResponsavelResponse> index(){
        List<Responsavel> found = repository.findAll();
        List<ResponsavelResponse> retorno = new ArrayList<>();
        for (int i = 0; i<found.toArray().length; i++){
            retorno.add(ResponsavelResponse.from(found.get(i)));
        }
        return retorno;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponsavelResponse> getById(@PathVariable(value = "id") int id){
        Optional<Responsavel> found = repository.findById(id);
        if(found.isPresent()){
            ResponsavelResponse response = ResponsavelResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>remover(@PathVariable(value = "id")int id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException erro) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody ResponsavelRequest request){
        Responsavel responsavel = new Responsavel();
        responsavel.setResponsaveis(request.getNome());
        responsavel.setCpf(request.getCpf());
        responsavel.setCargo(request.getCargo());
        responsavel.setSetor(request.getSetor());
        try {
            repository.save(responsavel);
        }catch (IllegalArgumentException error){
            return ResponseEntity.badRequest().body("Dados Inválidos!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody ResponsavelRequest request){
        Responsavel responsavel = new Responsavel();
        responsavel.setId(id);
        responsavel.setResponsaveis(request.getNome());
        responsavel.setCpf(request.getCpf());
        responsavel.setCargo(request.getCargo());
        responsavel.setSetor(request.getSetor());
        try{
            repository.save(responsavel);
        } catch (IllegalArgumentException error){
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
