package tech.ada.calculadora_financeira;

import java.nio.file.FileAlreadyExistsException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        // final double[] valoresDespesa = new double[3];
        final List<Double> valoresDespesa = new ArrayList<>();
        // String[] tiposDespesa = new String[3];
        List<String> tiposDespesa = new ArrayList<>();

        for (int i = 0; i <= 2; i++) {
            try {
                valoresDespesa.add(lerValorDespesa(scanner));
                tiposDespesa.add(lerTipoDespesa(scanner));
            } catch (InvalidParameterException | FileAlreadyExistsException e) {
                System.out.println(e.getMessage());
                return;
            } catch (Exception e) {

            } finally {

            }

            System.out.printf("Despesa %d de %s no valor de R$ %.2f%n", i+1, tiposDespesa.get(i), valoresDespesa.get(i));
        }

        valoresDespesa.forEach(System.out::println);

        double total = valoresDespesa.stream().reduce(0d, Double::sum);
        // double total = valoresDespesa.stream().mapToDouble(Double::doubleValue).filter(it -> it%10 == 0).sum();

        /*for (double d : valoresDespesa) {
            if (d %10 == 0) {
                total += d;
            }
        }*/

        double media = valoresDespesa.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
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
    
    public static double lerValorDespesa(Scanner scanner) throws Exception {
        System.out.print("Insira o  valor da sua despesa: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Valor Inválido");
            scanner.next();
        }
        final double despesa = scanner.nextDouble();
        if (despesa < 0) {
            throw new Exception("O valor " + despesa + " não é válido");
            // System.out.println("Despesa não pode ser menor que R$ 0!");
            // return -1;
        }
        return despesa;
    }
    
    public static String lerTipoDespesa(Scanner scanner) throws Exception {
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
                    throw new Exception("Despesa " + despesa + " não conhecida!");
                    // System.out.println("Despesa não conhecida");
                    // despesa = null;
            }
        } while (despesa == null);
        return despesa;
    }
}
