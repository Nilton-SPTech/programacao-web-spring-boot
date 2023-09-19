package school.sptech.aula07.validacoesdecampo.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.LocalDate;

public class MusicaCriacaoDto {
    @Id // -> Indica uma chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //-> Indica AUTO-INCREMENT
    private Integer id;

    @NotBlank
    private String nome;

    @Size(min = 3, max = 30)
    @NotBlank
    private String album;

    @Past
    private LocalDate dataLancamento;

    @DecimalMin(value = "1.0", inclusive = true)
    @DecimalMax(value = "5.0", inclusive = true)
    private Double nota;

    @Min(1)
    private int ranking;

    @CNPJ
    private String cnpjProdutora;

    @Email(regexp = ".+@.+\\..+")
    private String email;

    @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}")
    private String telefoneContato;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getCnpjProdutora() {
        return cnpjProdutora;
    }

    public void setCnpjProdutora(String cnpjProdutora) {
        this.cnpjProdutora = cnpjProdutora;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }
}
