package br.com.tech4me.locacoes.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
// import javax.validation.constraints.Positive;

public class LocacaoDto {
  private String id;

  @NotEmpty(message = "O veiculo nao pode ficar vazio")
  @NotBlank(message = "O veiculo nao pode ficar em branco")
  private String veiculo;

  @NotEmpty(message = "O cliente nao pode ficar vazio")
  @NotBlank(message = "O cliente nao pode ficar em branco")
  private String cliente;

  @NotEmpty(message = "O veiculo nao pode ficar vazio")
  @NotBlank(message = "O veiculo nao pode ficar em branco")

  // @Positive(message = "A quantidade de diarias deve ser maior que 1")
  private Integer diarias;

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
