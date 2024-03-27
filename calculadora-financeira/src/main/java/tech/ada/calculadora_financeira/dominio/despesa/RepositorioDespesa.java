package tech.ada.calculadora_financeira.dominio.despesa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositorioDespesa {

    Despesa salvar(Despesa despesa);

    Optional<Despesa> buscarPorId(UUID id);

    List<Despesa> buscar();

    List<Despesa> buscarPorMesEAno(int mes, int ano);

}
