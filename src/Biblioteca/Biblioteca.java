package Biblioteca;

import Autor.Autor;
import Empretimo.Emprestimo;
import Livro.Livro;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca() {
        Scanner scanner = new Scanner(System.in);

        this.validateDatabasePath();
        this.loadFilesDatabase();

        int option = 0;

        while(option == 0) {
            System.out.println("Digite a opção desejada: \n");

            System.out.println("1. Listar livros disponíveis.");
            System.out.println("2. Realizar empréstimo de um livro.");
            System.out.println("3. Adicionar novo livro. \n");

            option = scanner.nextInt();
        }

        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private void validateDatabasePath() {
        File diretorio = new File("database");

        if(!diretorio.exists()) {
            diretorio.mkdir();
        }
    }

    private void loadFilesDatabase() {
        try {
            List<Path> files = Arrays.asList(
                Paths.get("database/autores.csv"),
                Paths.get("database/livros.csv"),
                Paths.get("database/emprestimos.csv")
            );

            for (Path file : files) {
                this.loadData(file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadData(Path file) {
        try {
            List<String> linhas = Files.readAllLines(file);

            for (int i = 0; i < linhas.toArray().length; i++) {
                if (i == 0) {
                    String[] cabeçalho = linhas[i].split(";");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
