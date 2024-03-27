package tech.ada.calculadora_financeira.aplicacao;

import java.util.List;
import java.util.Scanner;

import tech.ada.calculadora_financeira.aplicacao.dto.DespesaDto;

public class Aplicacao {

    private final AplicacaoDespesa appDespesa;
    private final Menu menu = new Menu();

    public Aplicacao(AplicacaoDespesa appDespesa) {
        this.appDespesa = appDespesa;
    }

    public void init() throws Exception {
        Scanner sc = new Scanner(System.in);
        int selecao = 0;
        do {
            menu.imprimirMenuInicial();
            selecao = sc.nextInt();
            switch (selecao) {
                case 1:
                    adicionarDespesa();
                    break;
                case 2:
                    listarDespesas();
                    break;
            }

        } while (selecao != 0);
    }

    private void adicionarDespesa() throws Exception {
        DespesaDto dto = new DespesaDto(null, null, null, null);
        appDespesa.criarDespesa(dto);
    }

    private void listarDespesas() {
        List<DespesaDto> despesas = appDespesa.listarDespesas();
        despesas.forEach(System.out::println);
    }

}
