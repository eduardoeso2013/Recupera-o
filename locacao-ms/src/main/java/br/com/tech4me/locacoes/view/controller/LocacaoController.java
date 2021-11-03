package br.com.tech4me.locacoes.view.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.locacoes.service.LocacaoService;
import br.com.tech4me.locacoes.shared.LocacaoDto;
import br.com.tech4me.locacoes.view.model.LocacaoRequest;
import br.com.tech4me.locacoes.view.model.LocacaoResponse;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/locacoes")
@CrossOrigin
public class LocacaoController {
  @Autowired
  LocacaoService servico;

  @GetMapping
  public ResponseEntity<List<LocacaoDto>> obterLocacoes() {
    return new ResponseEntity<>(servico.obterTodos(), HttpStatus.ACCEPTED);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<LocacaoDto> obterLocacaoPorId(@PathVariable String id) {
    Optional<LocacaoDto> loc = servico.obterLocacaoPorId(id);

    if (loc.isPresent()) {
      return new ResponseEntity<>(loc.get(), HttpStatus.FOUND);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

  }

  @PostMapping
  public ResponseEntity<LocacaoDto> cadastrarLocacao(@RequestBody @Valid LocacaoDto locacao) {
    return new ResponseEntity<>(servico.cadastrarLocacao(locacao), HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> excluirLocacao(@PathVariable String id) {
    servico.excluirLocacaoPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<LocacaoDto> atualizarLocacao(@PathVariable String id,
      @RequestBody @Valid LocacaoRequest locacao) {
    LocacaoDto dto = new ModelMapper().map(locacao, LocacaoDto.class);
    Optional<LocacaoDto> loc = servico.atualizarLocacaoPorId(id, dto);

    if (loc.isPresent()) {
      return new ResponseEntity<>(loc.get(), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

  }

  @GetMapping(value = "/{idCliente}/lista")
  public ResponseEntity<List<LocacaoDto>> obterPorCliente(@PathVariable String cliente) {
    List<LocacaoDto> dtos = servico.obterPorCliente(cliente);

    if (dtos.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    ModelMapper mapper = new ModelMapper();
    List<LocacaoResponse> resp = dtos.stream().map(dto -> mapper.map(dto, LocacaoResponse.class))
        .collect(Collectors.toList());

    return new ResponseEntity<>(resp, HttpStatus.OK);
  }
}
