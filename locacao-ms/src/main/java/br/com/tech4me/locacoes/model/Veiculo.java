package br.com.tech4me.locacoes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Veiculo")
public class Veiculo {
  @Id
  private String id;
  private String marca;
  private String modelo;
  private int passageiros;
  private Double diarias;
  private String combustivel;

  public Veiculo(String id, String marca, String modelo, int passageiros, Double diarias, String combustivel) {
    this.id = id;
    this.marca = marca;
    this.modelo = modelo;
    this.passageiros = passageiros;
    this.diarias = diarias;
    this.combustivel = combustivel;
  }

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

  public void setModel(String modelo) {
    this.modelo = modelo;
  }

  public int getNrPassageiros() {
    return passageiros;
  }

  public void setNrPassageiros(int passageiros) {
    this.passageiros = passageiros;
  }

  public Double getVlDiaria() {
    return diarias;
  }

  public void setVlDiaria(Double diarias) {
    this.diarias = diarias;
  }

  public String getTpCombustivel() {
    return combustivel;
  }

  public void setTpCombustivel(String combustivel) {
    this.combustivel = combustivel;
  }

  public String getModeloCompleto() {
    return String.format("%s %s", marca.trim(), modelo.trim());
  }
}
