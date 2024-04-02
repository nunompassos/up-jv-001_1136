package tech.ada.exemplos.poo2;

public class ContadorSimples extends Contador{

    public ContadorSimples(String nome) {
        super(nome);
    }

    @Override
    public void incrementar() {
        setNumAtual(getNumAtual() + 1);
    }

    public void zerar() {
        setNumAtual(0);
    }
}
