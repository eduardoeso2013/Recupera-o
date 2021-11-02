package br.com.tech4me.locacoes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Veiculo")
public class Veiculo {
  @Id
  private String id;
  private String marca;
  private String modelo;
  private int nrPassageiros;
  private Double vlDiaria;
  private String tpCombustivel;

  public Veiculo(String id, String marca, String modelo, int nrPassageiros, Double vlDiaria, String tpCombustivel) {
    this.id = id;
    this.marca = marca;
    this.modelo = modelo;
    this.nrPassageiros = nrPassageiros;
    this.vlDiaria = vlDiaria;
    this.tpCombustivel = tpCombustivel;
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
    return nrPassageiros;
  }

  public void setNrPassageiros(int nrPassageiros) {
    this.nrPassageiros = nrPassageiros;
  }

  public Double getVlDiaria() {
    return vlDiaria;
  }

  public void setVlDiaria(Double vlDiaria) {
    this.vlDiaria = vlDiaria;
  }

  public String getTpCombustivel() {
    return tpCombustivel;
  }

  public void setTpCombustivel(String tpCombustivel) {
    this.tpCombustivel = tpCombustivel;
  }

  public String getModeloCompleto() {
    return String.format("%s %s", marca.trim(), modelo.trim());
  }
}
