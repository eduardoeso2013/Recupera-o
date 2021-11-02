package br.com.tech4me.locacoes.view.model;

import javax.validation.constraints.NotEmpty;

public class VeiculoRequest {

  private String id;
  @NotEmpty(message = "A  marca nao pode ficar em branco")
  private String marca;
  @NotEmpty(message = "O modelo não pode ficar em branco")
  private String modelo;
  @NotEmpty(message = "A quantidade de passageiros nao pode ficar em branco")
  private int passageiros;

  @NotEmpty(message = "A quantidade de diarias nao pode ficar em branco")
  private Double diarias;

  @NotEmpty(message = "O tipo de combustível nao pode ficar em branco")
  private String combustivel;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public int getPassageiros() {
    return passageiros;
  }

  public void setPassageiros(int passageiros) {
    this.passageiros = passageiros;
  }

  public Double getDiarias() {
    return diarias;
  }

  public void setDiarias(Double diarias) {
    this.diarias = diarias;
  }

  public String getCombustivel() {
    return combustivel;
  }

  public void setCombustivel(String combustivel) {
    this.combustivel = combustivel;
  }

}
