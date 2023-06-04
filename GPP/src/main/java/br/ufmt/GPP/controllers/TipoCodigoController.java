package br.ufmt.GPP.controllers;

import br.ufmt.GPP.Request.TipoCodigoRequest;
import br.ufmt.GPP.Responses.TipoCodigoResponse;
import br.ufmt.GPP.models.TipoCodigo;
import br.ufmt.GPP.repositorys.TipoCodigoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tipocodigo")
@RequiredArgsConstructor
public class TipoCodigoController {
    private final TipoCodigoRepository repository;

    @GetMapping(path = "/")
    public List<TipoCodigoResponse> index() {
        List<TipoCodigo> found = repository.findAll();
        List<TipoCodigoResponse> retorno = new ArrayList<>();
        for (int i = 0; i < found.toArray().length; i++){
            retorno.add((TipoCodigoResponse.from(found.get(i))));
        }
        return retorno;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TipoCodigoResponse> getById(@PathVariable(value = "id") int id){
        Optional<TipoCodigo> found = repository.findById(id);
        if (found.isPresent()){
            TipoCodigoResponse response = TipoCodigoResponse.from(found.get());
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
    public ResponseEntity cadastrar (@RequestBody TipoCodigoRequest request){
        TipoCodigo tipoCodigo = new TipoCodigo();
        tipoCodigo.setTipoCodigos(request.getNome());
        tipoCodigo.setDescricao(request.getDescricao());
        try {
            repository.save(tipoCodigo);
        } catch (IllegalArgumentException error){
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody TipoCodigoRequest request){
        TipoCodigo tipoCodigo = new TipoCodigo();
        tipoCodigo.setTipoCodigos(request.getNome());
        tipoCodigo.setDescricao(request.getDescricao());
        try {
            repository.save(tipoCodigo);
        } catch (IllegalArgumentException error){
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
