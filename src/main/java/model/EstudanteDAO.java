package model;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO {
    private static final String ARQUIVO_ESTUDANTES = "estudantes.dat";

    public void adicionar(Estudante estudante) {
        List<Estudante> estudantes = listar();
        estudantes.add(estudante);

        salvarListaEstudantes(estudantes);
    }

    public Estudante buscar(int nrMatricula) {
        List<Estudante> estudantes = listar();

        for (Estudante estudante : estudantes) {
            if (estudante.getNrMatricula() == nrMatricula) {
                return estudante;
            }
        }

        return null; // Estudante não encontrado
    }

    public List<Estudante> listar() {
        File file = new File(ARQUIVO_ESTUDANTES);
        if (!file.exists()) {
            criarArquivo();
        }

        List<Estudante> estudantes = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ARQUIVO_ESTUDANTES))) {
            estudantes = (List<Estudante>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocorreu um erro na leitura do arquivo.");
        }

        return estudantes;
    }

    public void atualizar(Estudante estudanteAtualizado) {
        List<Estudante> estudantes = listar();

        for (int i = 0; i < estudantes.size(); i++) {
            Estudante estudante = estudantes.get(i);
            if (estudante.getNrMatricula() == estudanteAtualizado.getNrMatricula()) {
                estudantes.set(i, estudanteAtualizado);
                break;
            }
        }

        salvarListaEstudantes(estudantes);
    }

    public void remover(int nrMatricula) {
        List<Estudante> estudantes = listar();

        estudantes.removeIf(estudante -> estudante.getNrMatricula() == nrMatricula);

        salvarListaEstudantes(estudantes);
    }

    private void salvarListaEstudantes(List<Estudante> estudantes) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ARQUIVO_ESTUDANTES))) {
            outputStream.writeObject(estudantes);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro na gravação do arquivo.");
        }
    }

    private void criarArquivo() {
        try {
            File file = new File(ARQUIVO_ESTUDANTES);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro na criação do arquivo.");
        }
    }
}
