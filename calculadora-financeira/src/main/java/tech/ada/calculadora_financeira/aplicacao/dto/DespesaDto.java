package tech.ada.calculadora_financeira.aplicacao.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import tech.ada.calculadora_financeira.dominio.despesa.Despesa;
import tech.ada.calculadora_financeira.dominio.despesa.TipoDespesa;

public record DespesaDto(
    UUID id,
    BigDecimal valor,
    TipoDespesa tipoDespesa,
    LocalDate data
) {
    public static DespesaDto de (Despesa entidade) {
        return new DespesaDto(entidade.id(), entidade.valor(), entidade.tipoDespesa(), entidade.data());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, tipoDespesa, data);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DespesaDto)) {
            return false;
        }
        DespesaDto other = (DespesaDto) obj;
        return this.id == other.id;
    }
}
