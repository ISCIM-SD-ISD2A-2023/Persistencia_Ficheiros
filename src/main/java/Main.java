import controller.EstudanteController;

import java.util.Scanner;

public class Main {

    public static  void main(String [] args){
        EstudanteController controller = new EstudanteController();
        Scanner scanner = new Scanner(System.in);

        int opcao;
            do {
                System.out.println("Menu:");
                System.out.println("1. Adicionar Estudante");
                System.out.println("2. Buscar Estudante");
                System.out.println("3. Listar Estudantes");
                System.out.println("4. Atualizar Estudante");
                System.out.println("5. Remover Estudante");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1:
                        controller.adicionarEstudante();
                        break;
                    case 2:
                        // Lógica para buscar um estudante
                        break;
                    case 3:
                        // Lógica para listar estudantes
                        break;
                    case 4:
                        // Lógica para atualizar um estudante
                        break;
                    case 5:
                        // Lógica para remover um estudante
                        break;
                    case 0:
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 0);
        }
}
