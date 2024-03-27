package tech.ada.calculadora_financeira.dominio.despesa;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DespesaTest {

    @Test
    public void testToStringMethodRoundingUp() throws Exception {
        final BigDecimal valor = new BigDecimal("12.345");
        final LocalDate data = LocalDate.now();
        final Despesa despesa = new Despesa(valor, TipoDespesa.ELETRICIDADE, data);
        final UUID id = despesa.id();
        final String expectedResult = """
            {
                id: '""" + id + """
            ',
                valor: 12.35,
                tipoDespesa: 'ELETRICIDADE',
                data: '""" + data.toString() + """
            '
            }""";

        Assertions.assertEquals(
            expectedResult, despesa.toString()
        );
    }

    @Test
    public void testToStringMethodRoundingDown() throws Exception {
        final BigDecimal valor = new BigDecimal("12.343");
        final LocalDate data = LocalDate.now();
        final Despesa despesa = new Despesa(valor, TipoDespesa.ELETRICIDADE, data);
        final UUID id = despesa.id();
        final String expectedResult = """
            {
                id: '""" + id + """
            ',
                valor: 12.34,
                tipoDespesa: 'ELETRICIDADE',
                data: '""" + data.toString() + """
            '
            }""";

        Assertions.assertEquals(
            expectedResult, despesa.toString()
        );
    }
}
