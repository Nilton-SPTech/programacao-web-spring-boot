package school.sptech.aula02nivelamento;

import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
    @RestController
    @RequestMapping("/herois")
    public class HeroiController {

        private List<Heroi> listaHerois = new ArrayList<Heroi>(List.of(
                new Heroi("Homem Sereia", 800, "Nadar", 130, true),
                new Heroi("Batman", 9000, "Rico", 46, true)
        ));

        @GetMapping
        public List<Heroi> listarTodos(){
            return listaHerois;
        }

        @GetMapping("/{indice}")
        public Heroi mostrarHeroi(@PathVariable int indice){
            return listaHerois.get(indice);
        }

        @PostMapping("/cadastrar/{nome}/{forca}/{habilidade}/{idade}/{vivo}")
        public Heroi cadastrarHeroi(@PathVariable String nome, @PathVariable int forca,@PathVariable  String habilidade,@PathVariable  int idade,@PathVariable  boolean vivo){
            Heroi heroi = new Heroi(nome, forca, habilidade, idade, vivo);

            listaHerois.add(heroi);
            return heroi;
        }

        @PatchMapping("/atualizar/{indice}/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
        public Heroi atualizarHeroi(@PathVariable int indice, @PathVariable String nome,@PathVariable String habilidade, @PathVariable int idade, @PathVariable int forca, @PathVariable boolean vivo ){

            if(validarIndice(indice)){
                Heroi novoHeroi = new Heroi(nome, forca, habilidade, idade, vivo );

                listaHerois.set(indice, novoHeroi);
                return novoHeroi;
            }
            return null;
        }

        @DeleteMapping("/remover/{indice}")
        public String removerHeroi(@PathVariable int indice){
            if (validarIndice(indice)){
                listaHerois.remove(indice);
                return "Herói removido da lista";
            }
            return "Herói não encontrado";
        }

        public boolean validarIndice(int indice){
            return listaHerois.size() > 0 && indice < listaHerois.size() ? true : false;
        }
    }
