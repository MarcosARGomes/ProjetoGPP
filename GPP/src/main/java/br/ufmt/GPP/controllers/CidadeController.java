package br.ufmt.GPP.controllers;

import br.ufmt.GPP.Request.CidadeRequest;
import br.ufmt.GPP.Responses.CidadeResponse;
import br.ufmt.GPP.models.Cidade;
import br.ufmt.GPP.repositorys.CidadeRepository;
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
@RequestMapping(path = "/cidade")
@RequiredArgsConstructor

public class CidadeController {
    private final CidadeRepository repository;
    private final EstadoRepository repositoryEstado;

    @GetMapping(path = "/")
    public List<CidadeResponse> index(){
        List<Cidade> found = repository.findAll();
        List<CidadeResponse> retorno = new ArrayList<>();
        for (int i = 0; i<found.toArray().length; i++){
            retorno.add(CidadeResponse.from(found.get(i)));
        }
        return retorno;
    }
    @GetMapping("/{id}")
    public ResponseEntity<CidadeResponse> getById(@PathVariable(value = "id") int id){
        Optional<Cidade> found = repository.findById(id);
        if (found.isPresent()){
            CidadeResponse response = CidadeResponse.from(found.get());
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
    public ResponseEntity cadastrar(@RequestBody CidadeRequest request){
        Cidade cidade = new Cidade();
        cidade.setNome(request.getNome());
        cidade.setCodPostal(request.getCodPostal());
        cidade.setEstado(repositoryEstado.findById(request.getEstado_id()).get());
        try {
            repository.save(cidade);
        } catch (IllegalArgumentException error){
            return ResponseEntity.badRequest().body("Dados Invalidos");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado");
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody CidadeRequest request){
        Cidade cidade = new Cidade();
        cidade.setId(id);
        cidade.setNome(request.getNome());
        cidade.setCodPostal(request.getCodPostal());
        cidade.setEstado(repositoryEstado.findById(request.getEstado_id()).get());
        try{
            repository.save(cidade);
        }catch (IllegalArgumentException error){
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
