package br.com.tech4me.locacoes.shared;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class VeiculoDto {
  private String id;

  @NotEmpty(message = "A marca nao pode ficar vazia")
  private String marca;

  @NotEmpty(message = "O modelo nao pode ficar vazio")
  private String modelo;

  @NotEmpty(message = "A quantidade de passageriros deve ser informada")
  @Positive(message = "A quantidade deve ser um numero maior que 1")
  private Integer passageiros;

  @NotEmpty(message = "O valor da diária deve ser informado")
  private Double diaria;

  @NotEmpty(message = "O tipo de combustivel deve ser informado")
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

  public Integer getPassageiros() {
    return passageiros;
  }

  public void setPassageiros(Integer passageiros) {
    this.passageiros = passageiros;
  }

  public Double getDiaria() {
    return diaria;
  }

  public void setDiaria(Double diaria) {
    this.diaria = diaria;
  }

  public String getCombustivel() {
    return combustivel;
  }

  public void setCombustivel(String combustivel) {
    this.combustivel = combustivel;
  }

}
