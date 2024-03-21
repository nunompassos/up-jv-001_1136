package tech.ada.exemplos.saida.arquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Buffered {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("arquivo.txt"));
            writer.write("Olá, mundo!");
            writer.close();
            System.out.println("Dados foram escritos no arquivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
