package br.com.tech4me.clientes.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.clientes.shared.ClienteDto;

public interface ClienteService {

  List<ClienteDto> obterTodos();

  Optional<ClienteDto> obterClientePorId(String id);

  ClienteDto cadastrarCliente(ClienteDto cliente);

  void excluirClientePorId(String id);

  Optional<ClienteDto> atualizarClientePorId(String id, ClienteDto cliente);

}
