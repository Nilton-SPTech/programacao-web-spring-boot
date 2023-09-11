package school.sptech.aula06pratica.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.aula06pratica.entity.RegistroFinanceiro;
import school.sptech.aula06pratica.repository.RegistroFinanceiroRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registros")
public class RegistroFinanceiroController {

    @Autowired
    private RegistroFinanceiroRepository repository;
    //private List<RegistroFinanceiro> listRegistro = new ArrayList<>();

    @PostMapping
    public ResponseEntity<RegistroFinanceiro> cadastrarRegistro(@RequestBody RegistroFinanceiro dados) {

        if (dados.getDescricao().isEmpty() || dados.getDescricao() == null) {
            return ResponseEntity.status(400).build();
        }

        if(dados.getValor().equals(0.0)){
            return ResponseEntity.status(400).build();
        }

        //INSERE AUTOMATICAMENTE NO BANCO E RETORNA O OBJETO QUE FOI INSERIDO (junto com o ID)
        RegistroFinanceiro registroSalvo = this.repository.save(dados);

        return ResponseEntity.status(201)
                .body(registroSalvo);
    }

    @GetMapping
    public ResponseEntity<List<RegistroFinanceiro>> listarRegistros() {

        List<RegistroFinanceiro> registros = this.repository.findAll();

        if(registros.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(registros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroFinanceiro> buscarRegistro(@PathVariable int id) {

        Optional<RegistroFinanceiro> registroOpt = this.repository.findById(id);

        if(registroOpt.isEmpty()){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200)
                .body(registroOpt.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroFinanceiro> atualizarRegistro(@PathVariable int id, @RequestBody RegistroFinanceiro dados) {

        dados.setId(id);

        //VALIDA SE O ID EXISTE
        if(this.repository.existsById(id)){

        //SAVE TEM 2 COMPORTAMENTOS
        // - Se o objeto NÃO POSSUI ID ele faz INSERT
        // - Se o objeto POSSUI ID ele faz UPDATE
            RegistroFinanceiro registroAtualizado = this.repository.save(dados);

            return ResponseEntity.status(200).body(dados);
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRegistro(@PathVariable int id) {

        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping("/ganhos")
    public ResponseEntity<List<RegistroFinanceiro>> listarGanhos() {

        List<RegistroFinanceiro> listRegistro = this.repository.findAll();

        List<RegistroFinanceiro> listGanhos = listRegistro.stream()
                .filter(registro -> registro.getValor() > 0)
                .toList();

        if (listGanhos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200)
                    .body(listGanhos);
        }
    }

    @GetMapping("/despesas")
    public ResponseEntity<List<RegistroFinanceiro>> listarDespesas() {

        List<RegistroFinanceiro> listRegistro = this.repository.findAll();

        if (listRegistro.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        List<RegistroFinanceiro> listDespesas = new ArrayList<>();

        for (RegistroFinanceiro r : listRegistro) {
            if (r.getValor() < 0.0) {
                listDespesas.add(r);
            }
        }

        return ResponseEntity.status(200)
                .body(listDespesas);
    }
}
