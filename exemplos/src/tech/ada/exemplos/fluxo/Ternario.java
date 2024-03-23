package tech.ada.exemplos.fluxo;

import java.util.Random;

public class Ternario {
    public static void main(String[] args) {
        int idade = new Random().nextInt(100);
        String estado = idade < 18 ? "Menor" : "Adulto";
    }
}
