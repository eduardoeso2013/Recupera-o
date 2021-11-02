package br.com.tech4me.locacoes.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.locacoes.shared.LocacaoDto;

public interface LocacaoService {

  List<LocacaoDto> obterTodos();

  Optional<LocacaoDto> obterLocacaoPorId(String id);

  LocacaoDto cadastrarLocacao(LocacaoDto locacao);

  void excluirLocacaoPorId(String id);

  Optional<LocacaoDto> atualizarLocacaoPorId(String id, LocacaoDto locacao);

}
