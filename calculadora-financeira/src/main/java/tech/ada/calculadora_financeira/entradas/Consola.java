package tech.ada.calculadora_financeira.entradas;

import java.util.Scanner;

public class Consola implements Entrada {

    private final Scanner scanner;

    public Consola(Scanner scanner) {
        this.scanner = scanner;
    }

    public int lerResultadoPrimeiroMenu() {
        System.out.println("Menu Principal");
        System.out.println("1 - Adicionar despesa");
        System.out.println("2 - Listar despesa");
        return scanner.nextInt();
    }

    @Override
    public void lerDespesa() {

    }

    @Override
    public void lerUtilizador() {

    }
}
