package school.sptech.aula03.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//Model
//Entity
public class Musica {

    @Getter @Setter private String nome;
    @Getter @Setter private String artista;
    @Getter @Setter private LocalDate dataCriacao = LocalDate.now();

    public Musica(){}
    public Musica(String nome, String artista) {
        this.nome = nome;
        this.artista = artista;
    }
}
