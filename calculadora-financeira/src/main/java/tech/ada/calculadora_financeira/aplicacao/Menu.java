package tech.ada.calculadora_financeira.aplicacao;

public class Menu {

    public void imprimirMenuInicial() {
        String ansiReset = "\u001B[0m";
        String ansiLightBlue = "\033[1;34m";
        String ansiPurple = "\u001B[35m";
        StringBuilder menu = new StringBuilder();
        menu.append(ansiPurple)
            .append("Menu Inicial")
            .append("-------------------------------------------------------------------")
            .append(ansiReset)
            .append("\n")
            .append(ansiLightBlue)
            .append("1 - Adicionar nova despesa")
            .append("\n")
            .append("2 - Listar todas as despesas")
            .append("\n")
            .append("3 - Atualizar despesa")
            .append("\n")
            .append("4 - Valor total do mês")
            .append("\n")
            .append("5 - Média diária do mês")
            .append("\n")
            .append("0 - Sair do menu")
            .append("\n")
            .append(ansiReset)
            .append(ansiPurple)
            .append("Digite sua opcao: ");
        System.out.print(menu.toString());
    }

}
