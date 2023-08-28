package school.sptech.aula04.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Filme {
    private String nome;
    private String diretor;
    private Integer anoLancamento;
    private BigDecimal custoProducao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public BigDecimal getCustoProducao() {
        return custoProducao;
    }

    public void setCustoProducao(BigDecimal custoProducao) {
        this.custoProducao = custoProducao;
    }
}
