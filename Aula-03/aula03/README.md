#AULA03
<h3>Sobrecarga de construtor:</h3>
- Criação de dois ou mais construtores de uma classe, para ser usado em mais de uma regra de chamada. 
```Java
// Construtor VAZIO
public Musica(){} 

// Construtor CHEIO
public Musica(String nome, String artistias) {  
    this.nome = nome;  
    this.artistia = artistia;  
    this.dataCriacao = LocalDate.now();  
}
```
>Conceito importante, pois o Spring deve ser inicializado com um construtor vazio


<h3>Conceito de anotação</h3>
- @RestController: Utilizada para criação de Controller para API REST
```Java
@RestController
public class MusicaController {  
}
```

 @Controller: Utilizada para criação de Controller que retorna paginas em HTML
```Java
@Controller
public class MusicaController {  
}
```


<h3>Getters e Setters e sua importância</h3>
- Os Getters e os Setters são métodos importantes para a criação dos objetos JSON
``` Java
@Getter @Setter private String nome;  
@Getter @Setter private String artista;  
@Getter @Setter private LocalDate dataCriacao ;
```
>Utilizando a dependência LOMBOK podemos passar os Getters e o Setter em somente uma linha do atributo


<h3>Criação de métodos para auxiliar no desenvolvimento das Controllers</h3>
- Utilizar métodos para criar validações de regra de negócio que iram se repetir em vários casos. 
```Java
private boolean isIndicieValido(int indice){  
    return indice >= 0 
	    && indice < this.musicas.size();  
}
```


<h3>Requisição HTTP</h3>
Em uma requisição **HTTP** sempre vai existir 4 tipos de partes necessárias: Métodos, URL, Cabeçalhos e Corpo 
- Métodos: 
	- ``GET -> @GetMapping``
	- ``POST -> @PostMapping
	- ``PUT -> @PutMapping`` (Atualização geral)
	- ``PATCH -> @PatchMapping`` (Atualização pontual)
	- ``DELET -> @DeleteMapping``
- URL: 
	- Endereço completo do ``Endpoint``.
- Cabeçalho: 
	- Informações que não vão para URL. 
	- Uma meta-programação / meta-informação.
- Corpo: 
	- Conteúdo da Requisição.


<h3>Mandando valores no Body - RequestBody</h3>
- RequestBody é a chamada de requisição pelo corpo da chamada do endpoint
```Java
@PostMapping  
public Musica cadastrar(@RequestBody Musica musica){  
  
    musicas.add(musica);  
    return musica;  
}
```
> Quando se passa por @RequestBody somos obrigados a utilizar uma ferramenta de chamada de API, como o Postman


<h3>Diferença entre URL e URI</h3>
- **URL** ``(Localizador uniforme de recurso)``- Se refere ao endereço de rede no qual se encontra algum recurso na web. 
	- ``htpp://localhost:8080``/variaveisDeCaminho?
- **URI** ``(Identificador Uniforme de Recursos)`` - Se refere a uma sequencia de caracteres após o endereço da página. 
	- htpp://localhost:8080``/variaveisDeCaminho?``


<h3>Status Code</h3>
- Status é um código numérico que indica um padrão no resultado geral da resposta:
	- ``STATUS 200`` - Retorno de **SUCESSO**
	- ``STATUS 400`` - Retorno de **FALHA**
	- ``STATUS 500`` - Retorno de **FALHA DE SERVIDOR**

>Erro de compilação o código não roda, erro de sintaxe.
>Erro de execução é o erro de lógica.

https://http.cat/