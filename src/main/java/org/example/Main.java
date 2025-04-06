package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "C:\\Users\\joaop\\Desktop\\atividade-5.4-erinaldo\\src\\main\\java\\org\\example\\rotas_de_transportes.txt";

        ListaRota rotas = new ListaRota(new LinkedList<>());

        rotas.readRota(url);

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Listar rotas (início ao fim)");
            System.out.println("2 - Listar rotas (fim ao início)");
            System.out.println("3 - Filtrar por região");
            System.out.println("4 - Filtrar por tipo de transporte");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    rotas.listarRotasInicio();
                    break;
                case 2:
                    rotas.listarRotasFinal();
                    break;
                case 3:
                    System.out.print("Informe a região: ");
                    String regiao = scanner.nextLine();
                    List<Rota> regiaoFiltradas = rotas.filtrarPorRegiao(regiao);
                    for (Rota rota : regiaoFiltradas) {
                        System.out.println(rota);
                    }
                    break;
                case 4:
                    System.out.print("Informe o tipo de transporte (Onibus, Metro, Trem): ");
                    String tipo = scanner.nextLine();
                    List<Rota> transporteFiltradas = rotas.filtrarPorTipoTransporte(tipo);
                    for (Rota rota : transporteFiltradas) {
                        System.out.println(rota);
                    }
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

}