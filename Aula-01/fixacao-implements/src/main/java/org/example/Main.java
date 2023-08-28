package org.example;
public class Main {
        public static void main(String[] args) {
            Professor professor = new Professor("João", 10, 50.0);
            Coordenador coordenador = new Coordenador("Maria", 20, 80.0);

            ControleBonus controleBonus = new ControleBonus();
            controleBonus.adicionarBonusReceiver(professor);
            controleBonus.adicionarBonusReceiver(coordenador);

            System.out.println("Lista de Funcionários e seus Bônus:");
            controleBonus.exibirBonusReceivers();

            System.out.println("Total de Bônus: " + controleBonus.calcularTotalBonus());
        }
}