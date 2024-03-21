package tech.ada.calculadora_financeira;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final double[] valoresDespesa = new double[3];
        String[] tiposDespesa = new String[3];
        List<String> listaTiposDespesa = new ArrayList<>();
        String[][][] tiposDespesaValor = new String[3][2][];

        for (int i = 0; i <= 2; i++) {
            valoresDespesa[i] = lerValorDespesa(scanner);
            tiposDespesa[i] = lerTipoDespesa(scanner);
            listaTiposDespesa.add(tiposDespesa[i]);

            if (valoresDespesa[i] < 0 || tiposDespesa[i] == null) {
                return;
            }

            System.out.printf("Despesa %d de %s no valor de R$ %.2f%n", i+1, tiposDespesa[i], valoresDespesa[i]);
        }

        double total = Arrays.stream(valoresDespesa).sum();
        // for (double d : valoresDespesa) {
        //     total += d;
        // }

        double media = Arrays.stream(valoresDespesa).average().getAsDouble();
        System.out.printf("Total de despesas: R$ %.2f, e média de R$ %.2f%n", total, media);

//        double valorDespesaA = lerValorDespesa(scanner);
//        String tipoDespesaA = lerTipoDespesa(scanner);
//
//        if (valorDespesaA < 0 || tipoDespesaA == null) {
//            return;
//        }
//
//        System.out.printf("Despesa de %s no valor de R$ %.2f", tipoDespesaA, valorDespesaA);
//
//        double valorDespesaB = lerValorDespesa(scanner);
//        String tipoDespesaB = lerTipoDespesa(scanner);
//
//        System.out.printf("Despesa de %s no valor de R$ %.2f", tipoDespesaB, valorDespesaB);

        scanner.close();
    }
    
    public static double lerValorDespesa(Scanner scanner) {
        System.out.print("Insira o  valor da sua despesa: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Valor Inválido");
            scanner.next();
        }
        final double despesa = scanner.nextDouble();
        if (despesa < 0) {
            System.out.println("Despesa não pode ser menor que R$ 0!");
            return -1;
        }
        return despesa;
    }
    
    public static String lerTipoDespesa(Scanner scanner) {
        String despesa = null;
        do {
            System.out.print("Insira o tipo da sua despesa: ");
            despesa = scanner.next();
            switch (despesa) {
                case "Eletrecidade":
                    System.out.println("Despesa atribuida a Eletrecidade");
                    break;
                case "Água":
                    System.out.println("Despesa atribuida a Água");
                    break;
                default:
                    System.out.println("Despesa não conhecida");
                    despesa = null;
            }
        } while (despesa == null);
        return despesa;
    }
}
