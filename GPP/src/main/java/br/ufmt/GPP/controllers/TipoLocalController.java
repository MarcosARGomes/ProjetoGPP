package br.ufmt.GPP.controllers;

import br.ufmt.GPP.Request.ResponsavelRequest;
import br.ufmt.GPP.Request.TipoLocalRequest;
import br.ufmt.GPP.Responses.ResponsavelResponse;
import br.ufmt.GPP.Responses.TipoLocalResponse;
import br.ufmt.GPP.models.TipoLocal;
import br.ufmt.GPP.repositorys.TipoLocalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tipolocal")
@RequiredArgsConstructor
public class TipoLocalController {
    private final TipoLocalRepository repository;

    @GetMapping(path = "/")
    public List<TipoLocalResponse> index() {
        List<TipoLocal> found = repository.findAll();
        List<TipoLocalResponse> retorno = new ArrayList<>();
        for (int i = 0; i < found.toArray().length; i++) {
            retorno.add(TipoLocalResponse.from(found.get(i)));
        }
        return retorno;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TipoLocalResponse> getById(@PathVariable(value = "id") int id) {
        Optional<TipoLocal> found = repository.findById(id);
        if (found.isPresent()) {
            TipoLocalResponse response = TipoLocalResponse.from(found.get());
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
    public ResponseEntity cadastrar(@RequestBody TipoLocalRequest request) {
        TipoLocal tipoLocal = new TipoLocal();
        tipoLocal.setTipoLocais(request.getNome());
        tipoLocal.setDescricao(request.getDescricao());
        try {
            repository.save(tipoLocal);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().body("Dados Invalidos");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody TipoLocalRequest request) {
        TipoLocal tipoLocal = new TipoLocal();
        tipoLocal.setTipoLocais(request.getNome());
        tipoLocal.setDescricao(request.getDescricao());
        try {
            repository.save(tipoLocal);
        } catch (IllegalArgumentException error) {
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}