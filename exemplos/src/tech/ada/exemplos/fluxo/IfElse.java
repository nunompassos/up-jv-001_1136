package tech.ada.exemplos.fluxo;

import java.util.Random;

public class IfElse {
    public static void main(String[] args) {
        boolean condicao1 = new Random().nextBoolean();
        boolean condicao2 = new Random().nextBoolean();
        boolean condicao3 = new Random().nextBoolean();
        if (condicao1) {
            if (condicao2) {
                // Bloco de código a ser executado se a condição 1 e 2 for verdadeira
            } else {
                // Bloco de código a ser executado se a condição 1 for verdadeira
                // e a condição 2 for falsa
            }
        } else if (condicao3) {
            // Bloco de código a ser executado apenas se a condição 3 for verdadeira
        }
    }
}
