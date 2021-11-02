package br.com.tech4me.clientes.view.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

public class ClienteRequest {
  @NotEmpty(message = "O nome deve ser preenchido")
  private String nome;
  @NotEmpty(message = "O nome deve ser preenchido")
  private String cpf;

  private int cnh;

  private LocalDate nascimento;

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
