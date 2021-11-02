package br.com.tech4me.clientes.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.clientes.model.Cliente;
import br.com.tech4me.clientes.repository.ClienteRepository;
import br.com.tech4me.clientes.shared.ClienteDto;

@Service
public class ClienteServiceImpl implements ClienteService {
  @Autowired
  ClienteRepository repositorio;

  @Override
  public List<ClienteDto> obterTodos() {
    List<Cliente> client = repositorio.findAll();

    return client.stream().map(p -> new ModelMapper().map(p, ClienteDto.class)).collect(Collectors.toList());
  }

  @Override
  public Optional<ClienteDto> obterClientePorId(String id) {
    Optional<Cliente> client = repositorio.findById(id);

    if (client.isPresent()) {
      return Optional.of(new ModelMapper().map(client.get(), ClienteDto.class));
    }
    return Optional.empty();
  }

  @Override
  public ClienteDto cadastrarCliente(ClienteDto cliente) {
    ModelMapper mapper = new ModelMapper();
    Cliente clientParaSalvar = mapper.map(cliente, Cliente.class);
    clientParaSalvar = repositorio.save(clientParaSalvar);
    return mapper.map(clientParaSalvar, ClienteDto.class);
  }

  @Override
  public void excluirClientePorId(String id) {
    repositorio.deleteById(id);

  }

  @Override
  public Optional<ClienteDto> atualizarClientePorId(String id, ClienteDto cliente) {
    ModelMapper mapper = new ModelMapper();
    Optional<Cliente> client = repositorio.findById(id);
    Cliente clientParaSalvar = mapper.map(cliente, Cliente.class);

    if (client.isPresent()) {
      clientParaSalvar.setId(id);
      clientParaSalvar = repositorio.save(clientParaSalvar);
      return Optional.of(mapper.map(clientParaSalvar, ClienteDto.class));
    }

    return Optional.empty();

  }

}
