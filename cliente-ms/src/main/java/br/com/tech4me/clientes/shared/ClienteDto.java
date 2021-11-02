package br.com.tech4me.clientes.shared;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ClienteDto {
  private String id;

  @NotEmpty(message = "O nome deve ser preenchido")
  @NotBlank(message = "Nome não pode ter apenas espaços em branco")
  @Size(min = 3, message = "Nome tem que ter pelo menos 3 caracteres")
  private String nome;

  @NotEmpty(message = "O CPF deve ser preenchido")
  @NotBlank(message = "CPF não pode ter apenas espaços em branco")
  private String cpf;

  @NotEmpty(message = "A cnh deve ser preenchida")
  @NotBlank(message = "A cnh não pode ter apenas espaços em branco")
  private int cnh;

  @NotEmpty(message = "A data de nascimento deve ser preenchida")
  @NotBlank(message = "A data de nascimento não pode ter apenas espaços em branco")
  private LocalDate nascimento;

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
