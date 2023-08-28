package org.example;

import java.util.ArrayList;
import java.util.List;

class ControleBonus {
    List<IBonus> listaBonus;

    public ControleBonus() {
        listaBonus = new ArrayList<IBonus>();
    }

    public void adicionarBonusReceiver(IBonus b){
        listaBonus.add(b);
    }

    public void exibirBonusReceivers(){
        for (IBonus bonus:
             listaBonus) {
            System.out.println(bonus);
        }
    }

    public Double calcularTotalBonus(){
        Double totalBonus = 0.0;

        for (IBonus bonus:
             listaBonus) {
            totalBonus += bonus.getValorBonus();
        }

        return totalBonus;
    }

}

