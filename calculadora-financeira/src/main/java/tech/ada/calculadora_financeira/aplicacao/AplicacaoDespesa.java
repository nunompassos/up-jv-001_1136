package tech.ada.calculadora_financeira.aplicacao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import tech.ada.calculadora_financeira.aplicacao.dto.DespesaDto;
import tech.ada.calculadora_financeira.dominio.despesa.Despesa;
import tech.ada.calculadora_financeira.dominio.despesa.RepositorioDespesa;

public class AplicacaoDespesa {

    private final RepositorioDespesa repositorio;

    public AplicacaoDespesa(RepositorioDespesa repositorio) {
        this.repositorio = repositorio;
    }

    public DespesaDto criarDespesa(DespesaDto dto) throws Exception {
        final Despesa despesa = new Despesa(dto.valor(), dto.tipoDespesa(), dto.data());
        return DespesaDto.de(repositorio.salvar(despesa));
    }

    public DespesaDto atualizarDespesa(DespesaDto dto) throws Exception {
        final Despesa entidade = repositorio.buscarPorId(dto.id()).orElseThrow(() ->new Exception("Despesa não encontrada"));
        if (dto.valor() != null && !dto.valor().equals(entidade.valor())) {
            entidade.valor(dto.valor());
        }
        if (dto.tipoDespesa() != null && !dto.tipoDespesa().equals(entidade.tipoDespesa())) {
            entidade.tipoDespesa(dto.tipoDespesa());
        }
        return DespesaDto.de(repositorio.salvar(entidade));
    }

    public BigDecimal totalGastosMensais(int mes, int ano) {
        final List<Despesa> despesas = repositorio.buscarPorMesEAno(mes, ano);
        return despesas.stream().map(Despesa::valor).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal mediaGastosDiarios(int mes, int ano) {
        final List<Despesa> despesas = repositorio.buscarPorMesEAno(mes, ano);
        final BigDecimal total = despesas.stream().map(Despesa::valor).reduce(BigDecimal.ZERO, BigDecimal::add);
        final Set<Integer> dias = despesas.stream().map(it -> it.data().getDayOfMonth()).collect(Collectors.toSet());
        return total.divide(BigDecimal.valueOf(dias.size()), RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
    }

    public List<DespesaDto> listarDespesas() {
        return repositorio.buscar().stream().map(DespesaDto::de).collect(Collectors.toList());
    }

    public List<DespesaDto> listarDespesasDoMes(int mes, int ano) {
        return repositorio.buscarPorMesEAno(mes, ano).stream().map(DespesaDto::de).collect(Collectors.toList());
    }
}
