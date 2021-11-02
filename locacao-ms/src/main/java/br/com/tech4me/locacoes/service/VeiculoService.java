package br.com.tech4me.locacoes.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.locacoes.shared.VeiculoDto;

public interface VeiculoService {

  List<VeiculoDto> obterTodos();

  Optional<VeiculoDto> obterVeiculoPorId(String id);

  VeiculoDto cadastrarVeiculo(VeiculoDto locacal);

  void excluirVeiculoPorId(String id);

  Optional<VeiculoDto> atualizarVeiculoPorId(String id, VeiculoDto locacao);
}
