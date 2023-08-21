package school.sptech.aula03.controller;

import org.springframework.web.bind.annotation.*;
import school.sptech.aula03.entity.Musica;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    private List<Musica> musicas = new ArrayList<>();

    @GetMapping("/listar")
    public List<Musica> listar(){
        return this.musicas;
    }

    @GetMapping("/consultar/{indice}")
    public Musica consultarPorIndice(@PathVariable Integer indice){
        if(isIndicieValido(indice)){
            return musicas.get(indice);
        }
        return null;
    }

    @PostMapping
    public Musica cadastrar(@RequestBody Musica musica){
        musicas.add(musica);
        return musica;
    }

    @PutMapping("/{indice}")
    public Musica atualizar(@RequestBody Musica musicaNova, @PathVariable int indice){
        if(isIndicieValido(indice)){
            musicas.set(indice, musicaNova);
            return musicaNova;
        }
        return null;
    }

    @DeleteMapping("/{indice}")
    public String remover(@PathVariable int indice){
        if (isIndicieValido(indice)){
            musicas.remove(indice);
            return "Música removida com sucesso!";
        }
        return "Música não encontrada.";
    }

    private boolean isIndicieValido(int indice){
        return indice >= 0 && indice < this.musicas.size();
    }
}
