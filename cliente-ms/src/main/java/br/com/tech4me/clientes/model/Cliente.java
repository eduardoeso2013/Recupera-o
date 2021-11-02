package br.com.tech4me.clientes.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Cliente")
public class Cliente {
  @Id
  private String id;
  private String nome;
  private String cpf;
  private int cnh;
  // @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate nascimento;

  public Cliente() {

  }

  public Cliente(String nome, String cpf, int cnh, LocalDate nascimento) {
    this.nome = nome;
    this.cpf = cpf;
    this.cnh = cnh;
    this.nascimento = nascimento;
  }

  public Cliente(String id, String nome, String cpf, int cnh, LocalDate nascimento) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.cnh = cnh;
    this.nascimento = nascimento;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public int getCnh() {
    return cnh;
  }

  public void setCnh(int cnh) {
    this.cnh = cnh;
  }

  public LocalDate getNascimento() {
    return nascimento;
  }

  public void setNascimento(LocalDate nascimento) {
    this.nascimento = nascimento;
  }

}
