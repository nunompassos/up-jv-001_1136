package tech.ada.calculadora_financeira.dominio.despesa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Despesa {
    private final UUID id;
    private BigDecimal valor;
    private TipoDespesa tipoDespesa;
    private LocalDate data;

    public Despesa(BigDecimal valor, TipoDespesa tipoDespesa, LocalDate data) throws Exception {
        this.id = UUID.randomUUID();
        valor(valor);
        tipoDespesa(tipoDespesa);
        data(data);
    }

    public Despesa(String id, String valor, String tipoDespesa, String data) throws Exception {
        this.id = UUID.fromString(id);
        valor(new BigDecimal(valor));
        tipoDespesa(TipoDespesa.valueOf(tipoDespesa));
        data(LocalDate.parse(data));
    }

    public void valor(final BigDecimal novoValor) throws Exception {
        if (novoValor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Valor tem de ser positivo!");
        }
        this.valor = novoValor;
    }

    public BigDecimal valor() {
        return this.valor;
    }

    public void tipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public TipoDespesa tipoDespesa() {
        return this.tipoDespesa;
    }

    public UUID id() {
        return this.id;
    }

    public LocalDate data() {
        return this.data;
    }

    public void data(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{\n" +
               "    id: '" + id + "',\n" +
               "    valor: " + valor.setScale(2, RoundingMode.HALF_UP) + ",\n" +
               "    tipoDespesa: '" + tipoDespesa + "',\n" +
               "    data: '" + data.toString() + "'\n" +
               "}";
    }
}
