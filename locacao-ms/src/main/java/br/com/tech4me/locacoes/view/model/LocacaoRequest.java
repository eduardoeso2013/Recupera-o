package br.com.tech4me.locacoes.view.model;

import javax.validation.constraints.NotEmpty;

public class LocacaoRequest {

  @NotEmpty(message = "O veiculo deve ser preenchido!")
  private String veiculo;
  @NotEmpty(message = "O cliente deve ser preenchido!")
  private String cliente;
  // @NotEmpty(message = "A quantidade de diárias deve ser preenchida!")
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
