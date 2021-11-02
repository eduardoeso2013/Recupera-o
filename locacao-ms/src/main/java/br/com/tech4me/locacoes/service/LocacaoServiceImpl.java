package br.com.tech4me.locacoes.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.locacoes.model.Locacao;
import br.com.tech4me.locacoes.repository.LocacaoRepository;
import br.com.tech4me.locacoes.shared.LocacaoDto;

@Service
public class LocacaoServiceImpl implements LocacaoService {
  @Autowired
  LocacaoRepository repositorio;

  @Override
  public List<LocacaoDto> obterTodos() {
    List<Locacao> loc = repositorio.findAll();
    return loc.stream().map(p -> new ModelMapper().map(p, LocacaoDto.class)).collect(Collectors.toList());
  }

  @Override
  public Optional<LocacaoDto> obterLocacaoPorId(String id) {
    Optional<Locacao> loc = repositorio.findById(id);

    if (loc.isPresent()) {
      return Optional.of(new ModelMapper().map(loc.get(), LocacaoDto.class));
    }
    return Optional.empty();
  }

  @Override
  public LocacaoDto cadastrarLocacao(LocacaoDto locacao) {
    ModelMapper mapper = new ModelMapper();
    Locacao locParaSalvar = mapper.map(locacao, Locacao.class);
    locParaSalvar = repositorio.save(locParaSalvar);
    return mapper.map(locParaSalvar, LocacaoDto.class);
  }

  @Override
  public void excluirLocacaoPorId(String id) {
    repositorio.deleteById(id);
  }

  @Override
  public Optional<LocacaoDto> atualizarLocacaoPorId(String id, LocacaoDto locacao) {
    ModelMapper mapper = new ModelMapper();
    Optional<Locacao> loc = repositorio.findById(id);
    Locacao locParaSalvar = mapper.map(locacao, Locacao.class);

    if (loc.isPresent()) {
      locParaSalvar.setId(id);
      locParaSalvar = repositorio.save(locParaSalvar);
      return Optional.of(mapper.map(locParaSalvar, LocacaoDto.class));
    }

    return Optional.empty();

  }

}
