package school.sptech.RA01222078pratica.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.RA01222078pratica.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> listUsuario = new ArrayList<Usuario>();

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario dados) {
        if (dados.getEmail() == null || dados.getEmail().length() < 10 || !dados.getEmail().contains("@")) {
            return ResponseEntity.status(400).build();
        }

        for (Usuario u : listUsuario) {
            if (u.getEmail().equals(dados.getEmail())) {
                return ResponseEntity.status(409).build();
            }
        }

        if (listUsuario.size() > 0) {
            int posicao = listUsuario.size();

            dados.setId(listUsuario.get(posicao - 1).getId() + 1);
        } else {
            dados.setId(1);
        }

        listUsuario.add(dados);
        return ResponseEntity.status(201).body(dados);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
        if (listUsuario.size() < 0) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(listUsuario);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Usuario> buscarUsuarioIndice(@PathVariable int indice) {

        if (indice > listUsuario.size()) {
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.status(200).body(listUsuario.get(indice));
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable int indice, @RequestBody Usuario dados){
        if (indice > listUsuario.size()) {
            return ResponseEntity.status(400).build();
        }

        if (dados.getEmail() == null || dados.getEmail().length() < 10 || !dados.getEmail().contains("@")) {
            return ResponseEntity.status(400).build();
        }

        for (Usuario u : listUsuario) {
            if (u.getEmail().equals(dados.getEmail())) {
                return ResponseEntity.status(409).build();
            }
        }

        dados.setId(listUsuario.get(indice).getId());

        listUsuario.set(indice, dados);
        return ResponseEntity.status(200).body(dados);
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable int indice){
        if (indice > listUsuario.size()) {
            return ResponseEntity.status(400).build();
        }

        listUsuario.remove(indice);
        return ResponseEntity.status(200).build();

    }

}
