package tech.ada.exemplos.saida.arquivo;

import java.io.FileWriter;
import java.io.IOException;

public class File {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("arquivo.txt", true);
            writer.write("Olá, mundo!");
            writer.close();
            System.out.println("Dados foram escritos no arquivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
