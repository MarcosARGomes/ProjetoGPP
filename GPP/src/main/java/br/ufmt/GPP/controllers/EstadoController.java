package br.ufmt.GPP.controllers;

import br.ufmt.GPP.Request.CidadeRequest;
import br.ufmt.GPP.Request.EstadoRequest;
import br.ufmt.GPP.Responses.EstadoResponse;
import br.ufmt.GPP.models.Cidade;
import br.ufmt.GPP.models.Estado;
import br.ufmt.GPP.repositorys.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/estado")
@RequiredArgsConstructor
public class EstadoController {
    private final EstadoRepository repository;
    @GetMapping(path = "/")
    public List<EstadoResponse> index(){
        List<Estado> found = repository.findAll();
        List<EstadoResponse> retorno = new ArrayList<>();
        for (int i = 0; i<found.toArray().length; i++){
            retorno.add(EstadoResponse.from(found.get(i)));
        }
        return retorno;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EstadoResponse> getById(@PathVariable(value = "id") int id){
        Optional<Estado> found = repository.findById(id);
        if(found.isPresent()){
            EstadoResponse response = EstadoResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        } return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>remover(@PathVariable(value = "id")int id){
        try{
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException erro){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody EstadoRequest request){
        Estado estado = new Estado();
        estado.setEstado(request.getNome());
        try {
            repository.save(estado);
        }catch (IllegalArgumentException error){
            return ResponseEntity.badRequest().body("Dados Inválidos!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id,
                                    @RequestBody EstadoRequest request){
        Estado estado = new Estado();
        estado.setId(id);
        estado.setEstado(request.getNome());

        try {
            repository.save(estado);
        } catch (IllegalArgumentException error){
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
