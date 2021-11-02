package br.com.tech4me.locacoes.view.model;

public class LocacaoResponse {

  private String veiculo;
  private String cliente;
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
