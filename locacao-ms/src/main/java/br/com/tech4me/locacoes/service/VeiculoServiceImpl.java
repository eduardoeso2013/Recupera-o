package br.com.tech4me.locacoes.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.locacoes.model.Veiculo;
import br.com.tech4me.locacoes.repository.VeiculoRepository;
import br.com.tech4me.locacoes.shared.VeiculoDto;

@Service
public class VeiculoServiceImpl implements VeiculoService {
  @Autowired
  VeiculoRepository repositorio;

  @Override
  public List<VeiculoDto> obterTodos() {
    List<Veiculo> vec = repositorio.findAll();
    return vec.stream().map(p -> new ModelMapper().map(p, VeiculoDto.class)).collect(Collectors.toList());
  }

  @Override
  public Optional<VeiculoDto> obterVeiculoPorId(String id) {
    Optional<Veiculo> vec = repositorio.findById(id);

    if (vec.isPresent()) {
      return Optional.of(new ModelMapper().map(vec.get(), VeiculoDto.class));
    }
    return Optional.empty();
  }

  @Override
  public VeiculoDto cadastrarVeiculo(VeiculoDto veiculo) {
    ModelMapper mapper = new ModelMapper();
    Veiculo vecParaSalvar = mapper.map(veiculo, Veiculo.class);
    vecParaSalvar = repositorio.save(vecParaSalvar);
    return mapper.map(vecParaSalvar, VeiculoDto.class);
  }

  @Override
  public void excluirVeiculoPorId(String id) {
    repositorio.deleteById(id);
  }

  @Override
  public Optional<VeiculoDto> atualizarVeiculoPorId(String id, VeiculoDto veiculo) {
    ModelMapper mapper = new ModelMapper();
    Optional<Veiculo> vec = repositorio.findById(id);
    Veiculo vecParaSalvar = mapper.map(veiculo, Veiculo.class);

    if (vec.isPresent()) {
      vecParaSalvar.setId(id);
      vecParaSalvar = repositorio.save(vecParaSalvar);
      return Optional.of(mapper.map(vecParaSalvar, VeiculoDto.class));
    }

    return Optional.empty();

  }

}
