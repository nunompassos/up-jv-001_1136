package tech.ada.exemplos.poo2;

public abstract class Contador {

    private int numAtual;
    private int numRestauros;
    private final String nome;

    public Contador(String nome) {
        numAtual = 0;
        numRestauros = 0;
        this.nome = nome;
    }

    public abstract void incrementar();

    public void restaurar() {
        numAtual = 0;
        numRestauros++;
    }

    @Override
    public String toString() {
        return "Contador " + nome + " - Número atual: " + numAtual;
    }

    public void setNumAtual(int numAtual) {
        if (this.numAtual < numAtual) {
            this.numAtual = numAtual;
        }
    }

    public int getNumAtual() {
        return this.numAtual;
    }
}
