package school.sptech.aula07.validacoesdecampo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.aula07.validacoesdecampo.entity.Musica;
import school.sptech.aula07.validacoesdecampo.repository.MusicaRepository;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaRepository repository;

    @GetMapping
    private ResponseEntity<List<Musica>>listar(){
        List<Musica> musicas = this.repository.findAll();

        if(musicas.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(musicas);
    }

    @PostMapping
    private ResponseEntity<Musica> cadastrar(@RequestBody @Valid Musica dados){
        if(dados.getNota() < 0.0){
            return ResponseEntity.status(400).build();
        }

        Musica musica = this.repository.save(dados);

        return ResponseEntity.status(201).body(musica);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Musica> atualizar(@PathVariable int id, @RequestBody @Valid Musica dados){
        if(dados.getNota() < 0.0){
            return ResponseEntity.status(400).build();
        }

        Musica musica = this.repository.save(dados);

        return ResponseEntity.status(200).body(musica);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletar(@PathVariable int id) {

        if(!repository.existsById(id)){
            return ResponseEntity.status(400).build();
        }

        this.repository.deleteById(id);

        return ResponseEntity.status(204).build();
    }

}
