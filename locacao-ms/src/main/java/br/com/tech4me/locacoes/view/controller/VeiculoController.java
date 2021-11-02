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

import br.com.tech4me.locacoes.service.VeiculoService;
import br.com.tech4me.locacoes.shared.VeiculoDto;
import br.com.tech4me.locacoes.view.model.VeiculoRequest;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin
public class VeiculoController {
  @Autowired
  VeiculoService servico;

  @GetMapping
  public ResponseEntity<List<VeiculoDto>> obterVeiculos() {
    return new ResponseEntity<>(servico.obterTodos(), HttpStatus.ACCEPTED);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<VeiculoDto> obterVeiculoPorId(@PathVariable String id) {
    Optional<VeiculoDto> loc = servico.obterVeiculoPorId(id);

    if (loc.isPresent()) {
      return new ResponseEntity<>(loc.get(), HttpStatus.FOUND);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

  }

  @PostMapping
  public ResponseEntity<VeiculoDto> cadastrarVeiculo(@RequestBody @Valid VeiculoDto veiculo) {
    return new ResponseEntity<>(servico.cadastrarVeiculo(veiculo), HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> excluirVeiculo(@PathVariable String id) {
    servico.excluirVeiculoPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<VeiculoDto> atualizarVeiculo(@PathVariable String id,
      @RequestBody @Valid VeiculoRequest veiculo) {
    VeiculoDto dto = new ModelMapper().map(veiculo, VeiculoDto.class);
    Optional<VeiculoDto> veic = servico.atualizarVeiculoPorId(id, dto);

    if (veic.isPresent()) {
      return new ResponseEntity<>(veic.get(), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

  }
}
