package tech.ada.exemplos.fluxo;

import java.util.Random;

public class DeclaracaoSwitch {
    public static void main(String[] args) {
        int dia = new Random().nextInt(7) + 1;
        String nomeDoDia;
        switch (dia) {
            case 1:
                nomeDoDia = "Segunda-feira";
                break;
            case 2:
                nomeDoDia = "Terça-feira";
                break;
            case 3:
                nomeDoDia = "Quarta-feira";
                break;
            case 4:
                nomeDoDia = "Quinta-feira";
                break;
            case 5:
                nomeDoDia = "Sexta-feira";
                break;
            case 6:
                nomeDoDia = "Sábado";
                break;
            case 7:
                nomeDoDia = "Domingo";
                break;
            default:
                nomeDoDia = "Dia inválido";
                break;
        }
        System.out.println(nomeDoDia);
    }
}
