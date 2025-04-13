import java.util.Scanner;

public class MenuPilha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IEstruturaSimples pilha = new PilhaSimples();
        int opcao;

        do {
            System.out.println("\n MENU PILHA SIMPLES");
            System.out.println("1. Empilhar elemento");
            System.out.println("2. Empilhar sequência");
            System.out.println("3. Desempilhar");
            System.out.println("4. Remover todas ocorrências");
            System.out.println("5. Verificar se está cheia");
            System.out.println("6. Verificar se está vazia");
            System.out.println("7. Buscar elemento");
            System.out.println("8. Buscar por índice");
            System.out.println("9. Ordenar crescente");
            System.out.println("10. Ordenar decrescente");
            System.out.println("11. Quantidade de elementos");
            System.out.println("12. Dobrar capacidade");
            System.out.println("13. Editar elemento");
            System.out.println("14. Limpar pilha");
            System.out.println("15. Exibir pilha");
            System.out.println("16. Obter primeiro elemento");
            System.out.println("17. Obter topo da pilha");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt(); scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento: ");
                    pilha.inserirElemento(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Quantos elementos? ");
                    int n = scanner.nextInt(); scanner.nextLine();
                    Object[] seq = new Object[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Elemento " + (i+1) + ": ");
                        seq[i] = scanner.nextLine();
                    }
                    pilha.inserirSequencia(seq);
                    break;
                case 3:
                    pilha.removerElemento();
                    break;
                case 4:
                    System.out.print("Elemento a remover: ");
                    pilha.removerTodasOcorrencias(scanner.nextLine());
                    break;
                case 5:
                    System.out.println(pilha.estaCheia() ? "Cheia" : "Tem espaço");
                    break;
                case 6:
                    System.out.println(pilha.estaVazia() ? "Vazia" : "Contém elementos");
                    break;
                case 7:
                    System.out.print("Buscar elemento: ");
                    System.out.println(pilha.buscarElemento(scanner.nextLine()) ? "Encontrado!" : "Não encontrado.");
                    break;
                case 8:
                    System.out.print("Índice: ");
                    System.out.println(pilha.buscarElementoIndice(scanner.nextInt()));
                    break;
                case 9:
                    pilha.ordenarCrescente(); break;
                case 10:
                    pilha.ordenarDecrescente(); break;
                case 11:
                    System.out.println("Quantidade: " + pilha.quantidadeElementos());
                    break;
                case 12:
                    pilha.dobrarCapacidade(); break;
                case 13:
                    System.out.print("Elemento antigo: ");
                    String antigo = scanner.nextLine();
                    System.out.print("Novo elemento: ");
                    String novo = scanner.nextLine();
                    pilha.editarElemento(antigo, novo);
                    break;
                case 14:
                    pilha.limpar(); break;
                case 15:
                    pilha.exibir(); break;
                case 16:
                    System.out.println("Primeiro: " + pilha.obterPrimeiroElemento());
                    break;
                case 17:
                    System.out.println("Topo: " + pilha.obterUltimoElemento());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
