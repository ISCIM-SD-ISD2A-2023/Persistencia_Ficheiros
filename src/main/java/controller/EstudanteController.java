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

    public Estudante buscarEstudante(int nrMatricula) {
        return estudanteDAO.buscar(nrMatricula);
    }

    public List<Estudante> listarEstudantes() {
        return estudanteDAO.listar();
    }

    public void atualizarEstudante(Estudante estudante) {
        estudanteDAO.atualizar(estudante);
    }

    public void removerEstudante(int nrMatricula) {
        estudanteDAO.remover(nrMatricula);
    }
}
