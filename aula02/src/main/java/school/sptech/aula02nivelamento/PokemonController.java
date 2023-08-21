package school.sptech.aula02nivelamento;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemon")

public class PokemonController {
    List<String> listaPokemon = new ArrayList<>();

    @GetMapping
    public String totalPokemon(){
        return String.format("Total de pokemon cadastro: %d", listaPokemon.size());
    }

    @PostMapping("/cadastrar/{pokemon}")
    public String cadastrarPokemon(@PathVariable String pokemon) {
        listaPokemon.add(pokemon);
        return "Pokemon cadastrado";
    }

    @GetMapping("/recuperar/{indice}")
    public String recuperarPokemon(@PathVariable int indice){
        return validarIndice(indice) ? listaPokemon.get(indice) : "Pokemon não encontrado";
    }
    
    @DeleteMapping("/excluir/{indice}")
    public String excluirPokemon(@PathVariable int indice){
        Integer tamanhoLista = listaPokemon.size();

        if(validarIndice(indice)){
            listaPokemon.remove(indice);
            return "Pokemon excluido";
        }
        else{
            return "Pokemon não encontrado";
        }
    }

    @PutMapping("/atualizar/{indice}/{novoNome}")
    public String atualizarPokemon(@PathVariable int indice, @PathVariable String novoNome){
        Integer tamanhoLista = listaPokemon.size();

        if(validarIndice(indice)){
            listaPokemon.set(indice, novoNome);
            return "Pokemon atualizado";
        }
        else{
            return "Pokemon não encontrado";
        }
    }

    private boolean validarIndice(Integer indice) {
        return (listaPokemon.size() > 0 && indice < listaPokemon.size()) ? true : false;
    }
}
