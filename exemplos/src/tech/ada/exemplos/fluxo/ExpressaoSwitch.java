package tech.ada.exemplos.fluxo;

import java.util.Random;

public class ExpressaoSwitch {
    public static void main(String[] args) {
        int dia = new Random().nextInt(7) + 1;
        String nomeDoDia = switch (dia) {
            case 1 -> "Segunda-feira";
            case 2 -> "Terça-feira";
            case 3 -> "Quarta-feira";
            case 4 -> "Quinta-feira";
            case 5 -> "Sexta-feira";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "Dia inválido";
        };
        System.out.println(nomeDoDia);
    }
}
