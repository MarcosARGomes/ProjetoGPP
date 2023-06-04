package br.ufmt.GPP.controllers;

import br.ufmt.GPP.Request.ItemRequest;
import br.ufmt.GPP.Responses.ItemResponse;
import br.ufmt.GPP.models.Item;
import br.ufmt.GPP.repositorys.ItemRepository;
import br.ufmt.GPP.repositorys.LocalRepository;
import br.ufmt.GPP.repositorys.ProdutoRepository;
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
@RequestMapping(path = "/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository repository;
    private final LocalRepository repositoryLocal;
    private final TipoCodigoRepository repositoryTipoCodigo;
    private final ProdutoRepository repositoryProduto;

    @GetMapping(path = "/")
    public List<ItemResponse> index() {
        List<Item> found = repository.findAll();
        List<ItemResponse> retorno = new ArrayList<>();
        for (int i = 0; i < found.toArray().length; i++) {
            retorno.add(ItemResponse.from(found.get(i)));
        }
        return retorno;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ItemResponse> getById(@PathVariable(value = "id") int id){
        Optional<Item> found = repository.findById(id);
        if(found.isPresent()){
            ItemResponse response = ItemResponse.from(found.get());
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
    public ResponseEntity cadastrar (@RequestBody ItemRequest request){
        Item item = new Item();
        item.setNome(request.getNome());
        /*item.setProduto(repositoryProduto.findById(request.getProduto_id()));*/
        item.setDescricao(request.getDescricao());
        item.setLocal(repositoryLocal.findById(request.getLocal_id()).get());
        item.setTipoCodigo(repositoryTipoCodigo.findById(request.getTipo_codigo_id()).get());
        try {
            repository.save(item);
        }catch (IllegalArgumentException error){
            return ResponseEntity.badRequest().body("Dados Invalidos");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadasro realizado");
    }
    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar (@PathVariable int id, @RequestBody ItemRequest request){
        Item item = repository.getReferenceById(id);
        item.setNome(request.getNome());
      /*  item.setProduto(repositoryProduto.findById(request.getProduto_id()));*/
        item.setDescricao(request.getDescricao());
        item.setLocal(repositoryLocal.findById(request.getLocal_id()).get());
        item.setTipoCodigo(repositoryTipoCodigo.findById(request.getTipo_codigo_id()).get());
        try {
            repository.save(item);
        } catch (IllegalArgumentException error) {
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    }

