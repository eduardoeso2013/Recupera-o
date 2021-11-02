package br.com.tech4me.locacoes.view.controller;

import java.util.List;

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
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/locacoes")
@CrossOrigin
public class LocacaoController {
  @Autowired
  LocacaoService servico;

  @GetMapping
  public ResponseEntity<List<LocacaoDto>> obterLocacaos() {
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

  /*
   * Os exemplos abaixo são para demonstrar o uso de classes específicas para os
   * dados de Request e Response. O uso desses modelos ajudam a proteger os dados
   * da aplicação, utilizando apenas os atributos que de fato precisam ser
   * demonstrados.
   * 
   * Utilizamos o ModelMapper junto com o DTO (Data Transfer Object) para
   * transferir os dados entre as classes.
   * 
   * @GetMapping public ResponseEntity<List<LocacaoResponse>> obterLocacaos() {
   * List<LocacaoDto> dto = servico.obterTodos();
   * 
   * List<LocacaoResponse> response = dto.stream() .map(d -> new
   * ModelMapper().map(d, LocacaoResponse.class)) .collect(Collectors.toList());
   * 
   * return new ResponseEntity<>(response, HttpStatus.ACCEPTED); }
   * 
   * @PostMapping public ResponseEntity<LocacaoResponseComObservacao>
   * cadastrarLocacao(@RequestBody LocacaoRequestComObservacao pessoa) {
   * ModelMapper mapper = new ModelMapper(); LocacaoDto dto = mapper.map(pessoa,
   * LocacaoDto.class); dto = servico.cadastrarLocacao(dto);
   * LocacaoResponseComObservacao pessoaResponse = mapper.map(dto,
   * LocacaoResponseComObservacao.class);
   * 
   * return new ResponseEntity<>(pessoaResponse, HttpStatus.CREATED); }
   */

}
