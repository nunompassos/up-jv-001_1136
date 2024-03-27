package tech.ada.calculadora_financeira.infraestrutura;

import java.io.*;
import java.math.RoundingMode;
import java.util.*;

import tech.ada.calculadora_financeira.dominio.despesa.Despesa;
import tech.ada.calculadora_financeira.dominio.despesa.RepositorioDespesa;

public class RepositorioDespesaFicheiro implements RepositorioDespesa {

    @Override
    public Despesa salvar(Despesa despesa) {
        final List<Despesa> despesas = buscar();
        try(PrintWriter writer = new PrintWriter(new FileWriter("despesas.csv"))) {
            despesas
                .stream()
                .filter(it -> it.id() != despesa.id())
                .forEach(it -> writer.printf("%s,%.2f,%s,%s%n", it.id().toString(), it.valor().setScale(2, RoundingMode.HALF_UP), it.tipoDespesa(), it.data().toString()));
            writer.printf("%s,%.2f,%s,%s%n", despesa.id().toString(), despesa.valor().setScale(2, RoundingMode.HALF_UP), despesa.tipoDespesa(), despesa.data().toString());
            return despesa;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Optional<Despesa> buscarPorId(UUID id) {
        return buscar().stream().filter(it -> it.id().equals(id)).findFirst();
    }

    @Override
    public List<Despesa> buscar() {
        List<Despesa> result = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("despesas.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] array = linha.split(",");
                result.add(new Despesa(array[0], array[1], array[2], array[3]));
            }
        } catch (IOException ex) {
            return Collections.emptyList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Despesa> buscarPorMesEAno(int mes, int ano) {
        return null;
    }
}
