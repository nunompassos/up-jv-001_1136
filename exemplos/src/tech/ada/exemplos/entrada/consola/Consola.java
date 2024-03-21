package tech.ada.exemplos.entrada.consola;

import java.util.Scanner;

public class Consola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Captura de uma string
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        // Captura de um inteiro
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        // Exibição das informações capturadas
        System.out.println("Nome: " + nome + ", Idade: " + idade);

        // Fechando o scanner
        scanner.close();
    }
}
