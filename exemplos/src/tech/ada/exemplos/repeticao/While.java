package tech.ada.exemplos.repeticao;

import java.util.Random;

public class While {
    public static void main(String[] args) {
        int i = new Random().nextInt();
        while (i % 10 == 0) {
            System.out.println(i);
            i = new Random().nextInt();
        }
    }
}
