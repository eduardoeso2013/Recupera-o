package br.com.tech4me.locacoes.view.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class LocacaoRequest {

  @NotEmpty(message = "O veiculo deve ser preenchido!")
  private String veiculo;
  @NotEmpty(message = "O cliente deve ser preenchido!")
  private String cliente;
  @NotEmpty(message = "A quantidade de diárias deve ser preenchida!")
  @Positive(message = "A quantidade de diárias deve ser maior ou igual a zero")
  private Integer diarias;

  public String getVeiculo() {
    return veiculo;
  }

  public void setVeiculo(String veiculo) {
    this.veiculo = veiculo;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public Integer getDiarias() {
    return diarias;
  }

  public void setDiarias(Integer diarias) {
    this.diarias = diarias;
  }

}
