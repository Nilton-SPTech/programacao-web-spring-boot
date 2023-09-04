package com.school.sptech.aula05exrercicio.controller;

import com.school.sptech.aula05exrercicio.entity.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private List<Aluno> listAluno = new ArrayList<Aluno>();

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno dados){
        if(dados.getNome().isBlank() || dados.getNome() == null || dados.getNome().length() < 3 ){
            return ResponseEntity.status(400).build();
        }

        if(dados.getEmail().isBlank() || dados.getEmail() == null || !dados.getEmail().contains("@") && !dados.getEmail().contains(".school")){
            return ResponseEntity.status(400).build();
        }


        if(dados.getNotaContinuada1() < 0.0 || dados.getNotaContinuada1() > 10.0){
            return ResponseEntity.status(400).build();
        }

        if(dados.getNotaContinuada2() < 0.0 || dados.getNotaContinuada2() > 10.0){
            return ResponseEntity.status(400).build();
        }

        if(dados.getNotaContinuada3() < 0.0 || dados.getNotaContinuada3() > 10.0){
            return ResponseEntity.status(400).build();
        }

        if(dados.getNotaIntegrada() < 0.0 || dados.getNotaIntegrada() > 10.0){
            return ResponseEntity.status(400).build();
        }

        listAluno.add(dados);
        return ResponseEntity.status(201).body(dados);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos(){
        if(listAluno.size() <= 0){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(listAluno);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Aluno> listarAlunoIndice(@PathVariable int indice){
        if(indice < 0 || indice > listAluno.size()){
            return ResponseEntity.status(400).build();
        }

        Aluno aluno = listAluno.get(indice);
        return ResponseEntity.status(200).body(aluno);
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable int indice, @RequestBody Aluno dados){
        if(dados.getNome().isBlank() || dados.getNome() == null || dados.getNome().length() < 3 ){
            return ResponseEntity.status(400).build();
        }

        if(dados.getEmail().isBlank() || dados.getEmail() == null || !dados.getEmail().contains("@") && !dados.getEmail().contains(".school")){
            return ResponseEntity.status(400).build();
        }

        if(dados.getNotaContinuada1() < 0.0 || dados.getNotaContinuada1() > 10.0){
            return ResponseEntity.status(400).build();
        }

        if(dados.getNotaContinuada2() < 0.0 || dados.getNotaContinuada2() > 10.0){
            return ResponseEntity.status(400).build();
        }

        if(dados.getNotaContinuada3() < 0.0 || dados.getNotaContinuada3() > 10.0){
            return ResponseEntity.status(400).build();
        }

        if(dados.getNotaIntegrada() < 0.0 || dados.getNotaIntegrada() > 10.0){
            return ResponseEntity.status(400).build();
        }

        listAluno.set(indice, dados);

        return ResponseEntity.status(200).body(dados);
    }
}
