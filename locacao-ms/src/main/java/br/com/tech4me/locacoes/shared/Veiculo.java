package br.com.tech4me.locacoes.shared;

public class Veiculo {
  private String id;
  private String marca;
  private String modelo;
  private int nrPassageiros;
  private Double vlDiaria;
  private String tpCombustivel;

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
}
