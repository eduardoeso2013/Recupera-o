package br.com.tech4me.locacoes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Locacao")
public class Locacao {
  @Id
  private String id;
  private String veiculo;
  private String cliente;
  private Integer diarias;

  public Locacao(String veiculo, String cliente, Integer diarias) {
    this.veiculo = veiculo;
    this.cliente = cliente;
    this.diarias = diarias;
  }

  public Locacao(String id, String veiculo, String cliente, Integer diarias) {
    this.id = id;
    this.veiculo = veiculo;
    this.cliente = cliente;
    this.diarias = diarias;
  }

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

  public Integer getDiarias() {
    return diarias;
  }

  public void setDiarias(Integer diarias) {
    this.diarias = diarias;
  }

}
