package main.java.com.meuapp.view;

import main.java.com.meuapp.controller.UsuarioController;
import main.java.com.meuapp.controller.EventController;
import main.java.com.meuapp.model.Usuario;
import main.java.com.meuapp.model.Event;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static UsuarioController usuarioController = new UsuarioController();
    private static EventController eventController = new EventController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Registrar usuário");
            System.out.println("2. Criar evento");
            System.out.println("3. Participar de evento");
            System.out.println("4. Listar usuários");
            System.out.println("5. Listar eventos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            switch (opcao) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    criarEvento();
                    break;
                case 3:
                    participarEvento();
                    break;
                case 4:
                    listarUsuarios();
                    break;
                case 5:
                    listarEventos();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void registrarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email do usuário: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha do usuário: ");
        String senha = scanner.nextLine();
        Usuario usuario = new Usuario(nome, email, senha);
        usuarioController.adicionarUsuario(usuario);
        System.out.println("Usuário registrado com sucesso!");
    }

    private static void criarEvento() {
        System.out.print("Digite o nome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o endereço do evento: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite a categoria do evento: ");
        String categoria = scanner.nextLine();
        System.out.print("Digite a descrição do evento: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a data e hora do evento no formato yyyy-MM-dd HH:mm: ");
        String dataHora = scanner.nextLine();
        LocalDateTime horario = LocalDateTime.parse(dataHora, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Event evento = new Event(nome, endereco, categoria, horario, descricao);
        eventController.adicionarEvento(evento);
        System.out.println("Evento criado com sucesso!");
    }

    private static void participarEvento() {
        System.out.print("Digite o email do usuário: ");
        String email = scanner.nextLine();
        Usuario usuario = usuarioController.getUsuario(email);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        System.out.print("Digite o nome do evento: ");
        String nomeEvento = scanner.nextLine();
        Event evento = eventController.getEvento(nomeEvento);
        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }
        eventController.adicionarParticipante(evento, usuario);
        System.out.println("Usuário adicionado ao evento com sucesso!");
    }

    private static void listarUsuarios() {
        List<Usuario> usuarios = usuarioController.getUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário registrado.");
        } else {
            System.out.println("Usuários registrados:");
            for (Usuario usuario : usuarios) {
                System.out.println("Nome: " + usuario.getNome() + ", Email: " + usuario.getEmail());
            }
        }
    }

    private static void listarEventos() {
        List<Event> eventos = eventController.getEventos();
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento criado.");
        } else {
            System.out.println("Eventos criados:");
            for (Event evento : eventos) {
                System.out.println("Nome: " + evento.getNome() + ", Endereço: " + evento.getEndereco() + ", Categoria: " + evento.getCategoria());
            }
        }
    }
}
