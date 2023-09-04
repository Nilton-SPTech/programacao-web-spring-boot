package com.school.sptech.aula05exrercicio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Aluno {
    @JsonIgnore
    private String nome;
    private String email;
    private Double notaContinuada1;
    private Double notaContinuada2;
    private Double notaContinuada3;
    private Double notaIntegrada;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getNotaContinuada1() {
        return notaContinuada1;
    }

    public void setNotaContinuada1(Double notaContinuada1) {
        this.notaContinuada1 = notaContinuada1;
    }

    public Double getNotaContinuada2() {
        return notaContinuada2;
    }

    public void setNotaContinuada2(Double notaContinuada2) {
        this.notaContinuada2 = notaContinuada2;
    }

    public Double getNotaContinuada3() {
        return notaContinuada3;
    }

    public void setNotaContinuada3(Double notaContinuada3) {
        this.notaContinuada3 = notaContinuada3;
    }

    public Double getNotaIntegrada() {
        return notaIntegrada;
    }

    public void setNotaIntegrada(Double notaIntegrada) {
        this.notaIntegrada = notaIntegrada;
    }

    public Double getNotaFinal(){ return (((notaContinuada1 + notaContinuada2 + notaContinuada3) / 3 ) * 0.4)+ (notaIntegrada * 0.6); }
}
