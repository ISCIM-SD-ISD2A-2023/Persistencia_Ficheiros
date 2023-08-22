package controller;
import model.*;
import java.util.List;
import java.util.Scanner;

public class EstudanteController {
    private EstudanteDAO estudanteDAO;
    private Scanner scanner;

    public EstudanteController() {
        estudanteDAO = new EstudanteDAO();
        scanner = new Scanner(System.in);
    }

    public void adicionarEstudante() {
        System.out.println("Informe os dados do estudante:");

        System.out.print("Número de Matrícula: ");
        int nrMatricula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Apelido: ");
        String apelido = scanner.nextLine();

        System.out.print("Contacto: ");
        String contacto = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Estudante estudante = new Estudante(nrMatricula, nome, apelido, contacto, endereco);
        estudanteDAO.adicionar(estudante);

        System.out.println("Estudante adicionado com sucesso!");
    }

    public void buscarEstudante() {
        System.out.print("Digite o numero de Matricula: ");
        int nrMatricula = scanner.nextInt();
        System.out.println(estudanteDAO.buscar(nrMatricula));
    }

    public void  listarEstudantes() {
        //Usando o foreach
        /*
        for (Estudante estudante: estudanteDAO.listar()) {
            System.out.println(estudante.toString());
        }*/

        //Usando o Lambda

        estudanteDAO.listar().forEach(estudante -> System.out.println(estudante.toString()));
    }
    //Vou adicionar um comentario so para explicar o commit

    public void atualizarEstudante(Estudante estudante) {
        //Colocando as instrucoes a funcionar...
        System.out.println("***************************************");
        System.out.println("--------ATUALIZANDO--------");

        System.out.print("Número de Matrícula do estudante: ");
        int nrMatricula = scanner.nextInt();
        System.out.println(estudanteDAO.buscar(nrMatricula));

            scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Apelido: ");
            String apelido = scanner.nextLine();

            System.out.print("Contacto: ");
            String contacto = scanner.nextLine();

            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            Estudante estudante2 = new Estudante(nrMatricula, nome, apelido, contacto, endereco);
            estudanteDAO.atualizar(estudante2);
            System.out.println("Dados atualizados com sucesso!");
            System.out.println("******************************");
    }

    public void removerEstudante(int nrMatricula) {
        //colocando as instrucoes a funcionar...
        System.out.println("***************************************");
        System.out.println("--------REMOVENDO--------");
        System.out.println("Digite o numero de matricula");
        int nrMatricula = scanner.nextInt();
            estudanteDAO.remover(nrMatricula);
            System.out.println("Dados removidos com sucesso!");
        System.out.println("***************************************");
    }
}
