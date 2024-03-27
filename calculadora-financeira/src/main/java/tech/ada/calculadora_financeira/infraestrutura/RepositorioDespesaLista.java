package tech.ada.calculadora_financeira.infraestrutura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import tech.ada.calculadora_financeira.dominio.despesa.Despesa;
import tech.ada.calculadora_financeira.dominio.despesa.RepositorioDespesa;

public class RepositorioDespesaLista implements RepositorioDespesa {

    List<Despesa> despesas = new ArrayList<>();

    @Override
    public Despesa salvar(Despesa despesa) {
        despesas.remove(despesa);
        despesas.add(despesa);
        return despesa;
    }

    @Override
    public Optional<Despesa> buscarPorId(UUID id) {
        return despesas.stream().filter(it -> it.id().equals(id)).findFirst();
    }

    @Override
    public List<Despesa> buscar() {
        return despesas;
    }

    @Override
    public List<Despesa> buscarPorMesEAno(int mes, int ano) {
        return null;
    }
}
