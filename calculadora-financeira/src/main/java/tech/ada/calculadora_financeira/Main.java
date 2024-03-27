package tech.ada.calculadora_financeira;

import java.math.BigDecimal;
import java.nio.file.FileAlreadyExistsException;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.*;

import tech.ada.calculadora_financeira.aplicacao.Aplicacao;
import tech.ada.calculadora_financeira.aplicacao.dto.DespesaDto;
import tech.ada.calculadora_financeira.dominio.despesa.TipoDespesa;
import tech.ada.calculadora_financeira.entradas.Consola;
import tech.ada.calculadora_financeira.entradas.Entrada;
import tech.ada.calculadora_financeira.entradas.Ficheiro;

public class Main {
    public static void main(String... args) {

        UUID id = UUID.randomUUID();
        UUID id2 = UUID.fromString(id.toString());
        LocalDate now = LocalDate.now();
        DespesaDto d1 = new DespesaDto(id, new BigDecimal(1), TipoDespesa.ELETRICIDADE, now);
        DespesaDto d2 = new DespesaDto(id2, new BigDecimal(1), TipoDespesa.ELETRICIDADE, now);

        String a = "a";
        String a2 = "a";
        if (a == a2){
            System.out.println("==");
        }
        if (a.equals(a2)) {
            System.out.println("equals");
        }
        if (a.equalsIgnoreCase(a2)) {
            System.out.println("equalIgnoreCase");
        }

        if(d1.equals(d2)) {
            System.out.println("são iguais");
        }

        if (d1 != null) {
            return;
        }

        Scanner s = new Scanner(System.in);
        final Entrada c = new Ficheiro();
        //final Aplicacao app = new Aplicacao(c);

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
