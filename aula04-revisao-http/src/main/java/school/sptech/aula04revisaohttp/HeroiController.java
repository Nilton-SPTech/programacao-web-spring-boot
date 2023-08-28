package school.sptech.aula04revisaohttp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

  private List<Heroi> herois = new ArrayList<>();

  @GetMapping
  public ResponseEntity<List<Heroi>> listar() {
    return ResponseEntity.status(200).body(herois);
  }

  @PostMapping("/cadastrarHeroi")
  public ResponseEntity<Heroi> cadastrarHeroi(@RequestBody Heroi dados){

    if(dados.getNome().length() < 3
            || dados.getNome().isEmpty()
            || dados.getNome() == null
            || dados.getNome().isBlank()){
      return ResponseEntity.status(400).build();
    }

    if(dados.getHabilidade().length() < 3
            || dados.getHabilidade().isEmpty()
            || dados.getHabilidade() == null
            || dados.getHabilidade().isBlank()){
      return ResponseEntity.status(400).build();
    }

    if(dados.getIdade() <= 0){
      return ResponseEntity.status(400).build();
    }

    if(dados.getForca() < 0 || dados.getForca() > 100){
      return ResponseEntity.status(400).build();
    }

    herois.add(dados);
    return ResponseEntity.status(201).body(dados);
  }

  @PutMapping("/atualizarHeroi/{indice}")
  public ResponseEntity<Heroi> atualizarHeroi(@PathVariable int indice, @RequestBody Heroi dados){
    if(dados.getNome().length() < 3
            || dados.getNome().isEmpty()
            || dados.getNome() == null
            || dados.getNome().isBlank()){
      return ResponseEntity.status(400).build();
    }

    if(dados.getHabilidade().length() < 3
            || dados.getHabilidade().isEmpty()
            || dados.getHabilidade() == null
            || dados.getHabilidade().isBlank()){
      return ResponseEntity.status(400).build();
    }

    if(dados.getIdade() <= 0){
      return ResponseEntity.status(400).build();
    }

    if(dados.getForca() < 0 || dados.getForca() > 100){
      return ResponseEntity.status(400).build();
    }

    herois.set(indice, dados);
    return ResponseEntity.status(200).body(dados);
  }


  @DeleteMapping("/deletarHeroi/{indice}")
  public ResponseEntity<Void> deletarHeroi(@PathVariable int indice){

    if(indice < 0 || indice > herois.size()){
      return ResponseEntity.status(400).build();
    }

    herois.remove(indice);
    return ResponseEntity.status(204).build();
  }
}
