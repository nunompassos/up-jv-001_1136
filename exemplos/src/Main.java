import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

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
}
