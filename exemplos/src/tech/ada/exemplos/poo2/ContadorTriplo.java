package tech.ada.exemplos.poo2;

public class ContadorTriplo extends Contador{
    public ContadorTriplo(String nome) {
        super(nome);
    }

    @Override
    public void incrementar() {
        setNumAtual(getNumAtual() + 3);
    }
}
