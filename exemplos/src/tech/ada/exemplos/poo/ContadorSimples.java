package tech.ada.exemplos.poo;

public class ContadorSimples implements Contador {

    public static void main(String[] args) {
        ContadorSimples c = new ContadorSimples();
        ContadorSimples c1 = new ContadorSimples();
        c1.numAtual = 4;
        c.numAtual = 25;
        c.numAtual = c.numAtual + 5;
        c.incrementar();
        System.out.println(c.toString());
        c.incrementar();
        System.out.println(c.toString());
    }

    public ContadorSimples() {
        this("");
    }

    public ContadorSimples(String nome) {
        numAtual = 0;
        numRestauros = 0;
        this.nome = nome;
    }

    private int numAtual;
    private int numRestauros;
    private final String nome;

    public void setNumAtual(final int numAtual) {
        if (this.numAtual == numAtual - 1) {
            this.numAtual = numAtual;
        }
    }

    public void incrementar() {
        numAtual++;
    }

    public void restaurar() {
        numAtual = 0;
        numRestauros++;
    }

    @Override
    public String toString() {
        return "Contador " + nome + " - Número atual: " + numAtual;
    }
}
