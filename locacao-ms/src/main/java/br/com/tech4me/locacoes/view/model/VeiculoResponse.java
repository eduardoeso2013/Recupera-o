package br.com.tech4me.locacoes.view.model;

public class VeiculoResponse {
  private String marca;
  private String modelo;
  private Integer passageiros;
  private Integer diarias;

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public Integer getPassageiros() {
    return passageiros;
  }

  public void setPassageiros(Integer passageiros) {
    this.passageiros = passageiros;
  }

  public Integer getDiarias() {
    return diarias;
  }

  public void setDiarias(Integer diarias) {
    this.diarias = diarias;
  }

}
