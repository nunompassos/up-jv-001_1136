package tech.ada.exemplos.poo;

public class ContadorTriplo implements Contador {
    private int numAtual;
    private int numRestauros;
    private final String nome;

    public ContadorTriplo() {
        this("");
    }

    public ContadorTriplo(String nome) {
        numAtual = 0;
        numRestauros = 0;
        this.nome = nome;
    }

    @Override
    public void incrementar() {
        numAtual += 3;
    }

    @Override
    public void restaurar() {
        numAtual = 0;
        numRestauros++;
    }

    @Override
    public String toString() {
        return "Contador " + nome + " - Número atual: " + numAtual;
    }
}
