package tech.ada.exemplos.poo2;

public class ContadorPar extends Contador {
    public ContadorPar(String nome) {
        super(nome);
    }

    @Override
    public void incrementar() {
        setNumAtual(getNumAtual() + 2);
    }
}
