package br.ufmt.GPP.controllers;

import br.ufmt.GPP.Request.LocalRequest;
import br.ufmt.GPP.Responses.LocalResponse;
import br.ufmt.GPP.models.Local;
import br.ufmt.GPP.models.Responsavel;
import br.ufmt.GPP.models.TipoLocal;
import br.ufmt.GPP.repositorys.LocalRepository;
import br.ufmt.GPP.repositorys.ResponsavelRepository;
import br.ufmt.GPP.repositorys.TipoLocalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/local")
@RequiredArgsConstructor

public class LocalController {
    private final LocalRepository repository;
    private final ResponsavelRepository repositoryResponsavel;
    private final TipoLocalRepository repositoryTipoLocal;

    @GetMapping(path = "/")
    public List<LocalResponse> index(){
        List<Local> found = repository.findAll();
        List<LocalResponse> retorno = new ArrayList<>();
        for (int i = 0; i<found.toArray().length; i++){
            retorno.add(LocalResponse.from(found.get(i)));
        }
        return retorno;
     }
    @GetMapping(path = "/{id}")
    public ResponseEntity<LocalResponse> getById(@PathVariable(value = "id") int id){
        Optional<Local> found = repository.findById(id);
        if (found.isPresent()){
            LocalResponse response = LocalResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>remover(@PathVariable(value = "id")int id){
        try{
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException error){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity cadastrar (@RequestBody LocalRequest request){
        Local local = new Local();
        local.setLocais(request.getNome());
        local.setAndar(request.getAndar());
        local.setNumero(request.getNumero());
        local.setResponsavel(repositoryResponsavel.findById(request.getResponsavel_id()).get());
        local.setTipoLocal(repositoryTipoLocal.findById(request.getTipoLocal_id()).get());
        try {
            repository.save(local);
        }catch (IllegalArgumentException error){
            return ResponseEntity.badRequest().body("Dados Invalidos");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado");
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody LocalRequest request) {
        Local local = repository.getReferenceById(id);
        local.setLocais(request.getNome());
        local.setAndar(request.getAndar());
        local.setNumero(request.getNumero());
        local.setResponsavel(repositoryResponsavel.findById(request.getResponsavel_id()).get());
        local.setTipoLocal(repositoryTipoLocal.findById(request.getTipoLocal_id()).get());
        try {
            repository.save(local);
        } catch (IllegalArgumentException error) {
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
