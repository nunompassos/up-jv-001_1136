package tech.ada.exemplos.saida.arquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Print {
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("arquivo.txt"));
            writer.println("Olá, mundo!");
            writer.printf("Número: %d, Preço: %.2f%n", 10, 20.50);
            writer.close();
            System.out.println("Dados foram escritos no arquivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
