package school.sptech.aula06pratica.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.aula06pratica.entity.RegistroFinanceiro;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroFinanceiroController {
    private List<RegistroFinanceiro> listRegistro = new ArrayList<>();

    @PostMapping
    public ResponseEntity<RegistroFinanceiro> cadastrarRegistro(@RequestBody RegistroFinanceiro dados) {

        if (dados.getDescricao().isEmpty() || dados.getDescricao() == null) {
            return ResponseEntity.status(400).build();
        }

        if(dados.getValor().equals(0.0)){
            return ResponseEntity.status(400).build();
        }

        listRegistro.add(dados);
        return ResponseEntity.status(201).body(dados);
    }

    @GetMapping
    public ResponseEntity<List<RegistroFinanceiro>> listarRegistros() {

        if (listRegistro.size() == 0) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(listRegistro);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<RegistroFinanceiro> buscarRegistro(@PathVariable int indice) {

        if (indice < 0 || indice > listRegistro.size()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(listRegistro.get(indice));
    }

    @PutMapping("/{indice}")
    public ResponseEntity<RegistroFinanceiro> atualizarRegistro(@PathVariable int indice, @RequestBody RegistroFinanceiro dados) {

        if (indice < 0 || indice > listRegistro.size()) {
            return ResponseEntity.status(404).build();
        }

        if (dados.getDescricao().isEmpty() || dados.getDescricao() == null) {
            return ResponseEntity.status(400).build();
        }

        if(dados.getValor().equals(0.0)){
            return ResponseEntity.status(400).build();
        }

        listRegistro.set(indice, dados);
        return ResponseEntity.status(200).body(dados);
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> deletarRegistro(@PathVariable int indice) {

        if (indice < 0 || indice > listRegistro.size()) {
            return ResponseEntity.status(404).build();
        }

        listRegistro.remove(indice);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/ganhos")
    public ResponseEntity<List<RegistroFinanceiro>> listarGanhos(){
        if(listRegistro.size() == 0){
            return ResponseEntity.status(204).build();
        }

        List<RegistroFinanceiro> listGanhos = new ArrayList<>();

        for (RegistroFinanceiro r: listRegistro) {
            if(r.getValor() > 0.0){
                listGanhos.add(r);
            }
        }

        return ResponseEntity.status(200).body(listGanhos);
    }

    @GetMapping("/despesas")
    public ResponseEntity<List<RegistroFinanceiro>> listarDespesas(){
        if(listRegistro.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        List<RegistroFinanceiro> listDespesas = new ArrayList<>();

        for (RegistroFinanceiro r: listRegistro) {
            if(r.getValor() < 0.0){
                listDespesas.add(r);
            }
        }

        return ResponseEntity.status(200).body(listDespesas);
    }
}
