package main.java.com.meuapp.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
  private String nome;
  private String endereco;
  private String categoria;
  private LocalDateTime horario;
  private String descricao;
  private List<Usuario> participantes;

  // Construtor
  public Event(String nome, String endereco, String categoria, LocalDateTime horario, String descricao) {
    this.nome = nome;
    this.endereco = endereco;
    this.categoria = categoria;
    this.horario = horario;
    this.descricao = descricao;
    this.participantes = new ArrayList<>();
  }

  // Getters
  public String getNome() {
    return nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getCategoria() {
    return categoria;
  }

  public LocalDateTime getHorario() {
    return horario;
  }

  public String getDescricao() {
    return descricao;
  }

  public List<Usuario> getParticipantes() {
    return participantes;
  }


  // Setters
  public void setNome(String nome) {
    this.nome = nome;
  }
  public void adicionarParticipante(Usuario usuario) {
    this.participantes.add(usuario);
  }
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public void setHorario(LocalDateTime horario) {
    this.horario = horario;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
