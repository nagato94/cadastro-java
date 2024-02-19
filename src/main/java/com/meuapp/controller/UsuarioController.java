package main.java.com.meuapp.controller;
import main.java.com.meuapp.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public Usuario getUsuario(String email) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }
}
