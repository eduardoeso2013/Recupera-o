package br.com.tech4me.clientes.shared;

public class Locacao {
  private String id;
  private String veiculo;
  private String cliente;
  private int diaria;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public int getDiaria() {
    return diaria;
  }

  public void setDiaria(int diaria) {
    this.diaria = diaria;
  }

}
