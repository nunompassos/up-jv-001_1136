package tech.ada.calculadora_financeira.dominio.despesa;

public enum TipoDespesa {
    ELETRICIDADE(5),
    AGUA(3),
    COMBUSTIVEL(19),
    OPERADORA_TELEFONICA(10);

    private int taxa;

    TipoDespesa(int taxa) {
        this.taxa = taxa;
    }

    public double aplicarTaxa(double valor) {
        return valor * (1 + (taxa / 100));
    }
}
