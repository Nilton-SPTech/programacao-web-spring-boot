package school.sptech.aula04.controller;

import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.aula04.entity.Filme;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> listFilmes = new ArrayList<Filme>();

    @GetMapping
    public ResponseEntity<List<Filme>> listarFilme() {

        if(listFilmes.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listFilmes);
    }

    @PostMapping
    public Filme cadastrarFilme(@RequestBody Filme dados){
        listFilmes.add(dados);
        return dados;
    }

    //JEITO ERRADO [x]
    @PutMapping("/{indice}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable int indice, @RequestBody Filme dados){
        if(indice >= 0 || indice < listFilmes.size()){
            listFilmes.set(indice, dados);
            return ResponseEntity.status(200).body(dados); //REQUISIÇÃO OK, MAS NÃO ADICIONOU NADA
        }
        else{
            return ResponseEntity.status(404).build(); //NÃO ENCONTROU
        }
    }

    //JEITO ERRADO [x]
    @DeleteMapping("{indice}")
    //O VOID RETORNA SOMENTE O STATUS CODE
    public ResponseEntity<Void> deletarFilme(@PathVariable int indice){
        if(indice >= 0 && indice < listFilmes.size()){
            listFilmes.remove(indice);
            return ResponseEntity.status(204).build();
        }
        else {
            return ResponseEntity.status(404).build();
        }
    }

    //JEITO CERTO [!]
    @GetMapping("/{indice}")
    public ResponseEntity<Filme> getPorIndice(@PathVariable int indice){
        if(indice < 0 && indice >= listFilmes.size()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(listFilmes.get(indice));
    }

}
