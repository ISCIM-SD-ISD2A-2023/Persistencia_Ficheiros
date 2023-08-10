package model;


import java.io.Serializable;

public class Estudante implements Serializable {
    private int nrMatricula;
    private String nome, apelido, contacto, endereco;

    public Estudante() {
    }

    public Estudante(int nrMatricula, String nome, String apelido, String contacto, String endereco) {
        this.nrMatricula = nrMatricula;
        this.nome = nome;
        this.apelido = apelido;
        this.contacto = contacto;
        this.endereco = endereco;
    }

    public int getNrMatricula() {
        return nrMatricula;
    }

    public void setNrMatricula(int nrMatricula) {
        this.nrMatricula = nrMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nrMatricula=" + nrMatricula +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", contacto='" + contacto + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
