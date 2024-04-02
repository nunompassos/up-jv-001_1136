import java.util.Random;

import tech.ada.exemplos.poo2.Contador;
import tech.ada.exemplos.poo2.ContadorPar;
import tech.ada.exemplos.poo2.ContadorSimples;
import tech.ada.exemplos.poo2.ContadorTriplo;


public class Main {
    public static void main(String[] args) {

        if (new Random().nextBoolean()) {
            contar(new ContadorSimples("Contador Simples"));
        } else if(new Random().nextBoolean()) {
            contar(new ContadorPar("Contador Par"));
        } else {
            contar(new ContadorTriplo("Contador Triplo"));
        }

/*
        int[] array = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);


        System.out.println(Arrays.toString(array));
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i + 1 == array.length) {
                System.out.println("]");
            } else {
                System.out.print(", ");
            }
        }
        System.out.println(list);
*/
        /*double a = 2d;
        double b = 3d;

        System.out.println(soma(a, b));*/
    }

    public static int soma(int a, int b) {
        return a + b;
    }

    public  static long soma(long a, long b) {
        return a + b;
    }

    public static double soma(double a, double b) {
        return a + b;
    }

    public static void contar(Contador c) {
        int i = new Random().nextInt(100);
        for(int j = 0; j < i; j++) {
            c.incrementar();
        }
        System.out.println(c.toString());
    }
}
