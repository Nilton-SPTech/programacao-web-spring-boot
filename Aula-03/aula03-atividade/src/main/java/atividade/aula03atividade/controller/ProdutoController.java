package atividade.aula03atividade.controller;

import atividade.aula03atividade.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private List<Produto> listProdutos = new ArrayList<>();

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto dados){
        listProdutos.add(dados);
        return dados;
    }

    @GetMapping
    public List<Produto> listarProduto(){
        return listProdutos;
    }

    @PutMapping("/{indice}")
    public Produto atualziarProduto(@PathVariable int indice, @RequestBody Produto dados){
        if(indice < listProdutos.size()){
            listProdutos.set(indice, dados);
            return dados;
        }
        else{
            return null;
        }
    }

    @GetMapping("/estoque/{qntEstoque}")
    public List<Produto> listarEstoquePorQuantidade(@PathVariable int qntEstoque){
        return listProdutos
                .stream()
                .filter(p -> p.getQntEstoque() > qntEstoque)
                .collect(Collectors.toList());
    }
}
