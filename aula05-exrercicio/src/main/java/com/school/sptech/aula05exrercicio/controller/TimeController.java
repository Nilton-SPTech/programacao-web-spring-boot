package com.school.sptech.aula05exrercicio.controller;

import com.school.sptech.aula05exrercicio.entity.Time;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    private List<Time> listTime = new ArrayList<Time>();
    @PostMapping
    public ResponseEntity<Time> cadastrarTime(@RequestBody Time dado){


        if(dado.getNome().length() < 3 || dado.getNome().isBlank() || dado.getNome().isEmpty() || dado.getNome() == null){
            return ResponseEntity.status(400).build();
        }

        if(dado.getTreinador().length() < 2 ||dado.getTreinador().isBlank() || dado.getTreinador().isEmpty() || dado.getTreinador() == null){
            return ResponseEntity.status(400).build();
        }

        if(dado.getDerrotas() < 0 || dado.getEmpates() < 0 || dado.getVitorias() < 0){
            return ResponseEntity.status(400).build();
        }

        listTime.add(dado);
        return ResponseEntity.status(201).body(dado);
    }

    @GetMapping
    public ResponseEntity<List<Time>> listTimes(){
        if(listTime.size() == 0){
            return ResponseEntity.status(204).build();
        }


        return ResponseEntity.status(200).body(listTime);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Time> listTimeIndice(@PathVariable int indice){
        if(indice < 0 || indice > listTime.size() ){
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.status(200).body(listTime.get(indice));
    }

    @PostMapping("/{indice}/registrar-vitoria")
    public ResponseEntity<Void> registrarVitoria(@PathVariable int indice){
        if(indice < 0 || indice > listTime.size() ){
            return ResponseEntity.status(400).build();
        }

        Time timeAtual = listTime.get(indice);
        timeAtual.setVitorias(timeAtual.getVitorias() + 1);
        listTime.set(indice, timeAtual);

        return ResponseEntity.status(200).build();
    }

    @PostMapping("/{indice}/registrar-derrota")
    public ResponseEntity<Void> registrarDerrota(@PathVariable int indice){
        if(indice < 0 || indice > listTime.size() ){
            return ResponseEntity.status(400).build();
        }

        Time timeAtual = listTime.get(indice);
        timeAtual.setDerrotas(timeAtual.getDerrotas() + 1);
        listTime.set(indice, timeAtual);

        return ResponseEntity.status(200).build();
    }

    @PostMapping("/{indice}/registrar-empate")
    public ResponseEntity<Void> registrarEmpate(@PathVariable int indice){
        if(indice < 0 || indice > listTime.size() ){
            return ResponseEntity.status(400).build();
        }

        Time timeAtual = listTime.get(indice);
        timeAtual.setEmpates(timeAtual.getEmpates() + 1);
        listTime.set(indice, timeAtual);

        return ResponseEntity.status(200).build();
    }
}
