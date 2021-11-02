package br.com.tech4me.clientes.view.controller;

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

import br.com.tech4me.clientes.service.ClienteService;
import br.com.tech4me.clientes.shared.ClienteDto;
import br.com.tech4me.clientes.view.model.ClienteRequest;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin
public class ClienteController {
  @Autowired
  ClienteService servico;

  @GetMapping
  public ResponseEntity<List<ClienteDto>> obterClientes() {
    return new ResponseEntity<>(servico.obterTodos(), HttpStatus.ACCEPTED);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ClienteDto> obterClientePorId(@PathVariable String id) {
    Optional<ClienteDto> client = servico.obterClientePorId(id);

    if (client.isPresent()) {
      return new ResponseEntity<>(client.get(), HttpStatus.FOUND);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

  }

  @PostMapping
  public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid ClienteDto cliente) {
    return new ResponseEntity<>(servico.cadastrarCliente(cliente), HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> excluirCliente(@PathVariable String id) {
    servico.excluirClientePorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable String id,
      @RequestBody @Valid ClienteRequest cliente) {
    ClienteDto dto = new ModelMapper().map(cliente, ClienteDto.class);
    Optional<ClienteDto> client = servico.atualizarClientePorId(id, dto);

    if (client.isPresent()) {
      return new ResponseEntity<>(client.get(), HttpStatus.OK);
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
   * @GetMapping public ResponseEntity<List<ClienteResponse>> obterClientes() {
   * List<ClienteDto> dto = servico.obterTodos();
   * 
   * List<ClienteResponse> response = dto.stream() .map(d -> new
   * ModelMapper().map(d, ClienteResponse.class)) .collect(Collectors.toList());
   * 
   * return new ResponseEntity<>(response, HttpStatus.ACCEPTED); }
   * 
   * @PostMapping public ResponseEntity<ClienteResponseComObservacao>
   * cadastrarCliente(@RequestBody ClienteRequestComObservacao pessoa) {
   * ModelMapper mapper = new ModelMapper(); ClienteDto dto = mapper.map(pessoa,
   * ClienteDto.class); dto = servico.cadastrarCliente(dto);
   * ClienteResponseComObservacao pessoaResponse = mapper.map(dto,
   * ClienteResponseComObservacao.class);
   * 
   * return new ResponseEntity<>(pessoaResponse, HttpStatus.CREATED); }
   */

}
