package main.java.com.meuapp.controller;
import main.java.com.meuapp.model.Event;
import main.java.com.meuapp.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class EventController {
    private List<Event> eventos;


    public EventController() {
        this.eventos = new ArrayList<>();
    }

    public void adicionarEvento(Event evento) {
        this.eventos.add(evento);
    }

    public Event getEvento(String nome) {
        for (Event evento : this.eventos) {
            if (evento.getNome().equals(nome)) {
                return evento;
            }
        }
        return null;
    }

    public void adicionarParticipante(Event evento, Usuario usuario) {
        evento.adicionarParticipante(usuario);
    }

    public List<Event> getEventos() {
        return this.eventos;
    }

    public void removerEvento(Event evento) {
        this.eventos.remove(evento);
    }
}
