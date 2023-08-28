package org.example;

public class Professor implements IBonus{
    private String nome;
    private Integer qntdDeAulas;
    private Double valorHoraAulas;

    public Professor() {}

    public Professor(String nome, Integer qntdDeAulas, Double valorHoraAulas) {
        this.nome = nome;
        this.qntdDeAulas = qntdDeAulas;
        this.valorHoraAulas = valorHoraAulas;
    }


    @Override
    public Double getValorBonus() {
        return qntdDeAulas * valorHoraAulas;
    }
}
