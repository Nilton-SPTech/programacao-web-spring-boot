package org.example;

public class Coordenador implements IBonus {
    private String nome;
    private Integer qntHorasCoordenadas;
    private Double valorHoraCoordenada;

    public Coordenador (){}

    public Coordenador(String nome, Integer qntHorasCoordenadas, Double valorHoraCoordenada) {
        this.nome = nome;
        this.qntHorasCoordenadas = qntHorasCoordenadas;
        this.valorHoraCoordenada = valorHoraCoordenada;
    }

    @Override
    public Double getValorBonus() {
        return qntHorasCoordenadas * valorHoraCoordenada;
    }
}
