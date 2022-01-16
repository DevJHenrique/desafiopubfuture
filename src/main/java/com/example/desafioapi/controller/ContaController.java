package com.example.desafioapi.controller;

import java.util.List;

import com.example.desafioapi.model.ContaModel;
import com.example.desafioapi.service.ContasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas")
public class ContaController {

  @Autowired
  private ContasService contasService;

  @GetMapping(value = "/getall")
  public List<ContaModel> getContas() {
    return contasService.getContas();
  }

  @PostMapping(value = "/new")
  @ResponseStatus(value = HttpStatus.CREATED)
  public ContaModel addConta(@RequestBody ContaModel conta) {
    return contasService.addConta(conta);
  }

  @PostMapping(value = "/update/{id}")
  public ContaModel updateContaById(
    @PathVariable("id") Long id,
    @RequestBody ContaModel conta
  ) {
    return contasService.updateContaById(id, conta);

  }

  @DeleteMapping(value = "/delete/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public Boolean deleteConta(@PathVariable("id") Long id) {
    return contasService.deleteConta(id);
  }

  @GetMapping(value = "/total")
  public Float getSaldoContas() {
    return contasService.getSaldoContas();
  }

  @PutMapping(value = "/transferir/{idOrigem}/{idDestino}/{valor}")
  public ContaModel transferir(
    @PathVariable("idOrigem") Long idOrigem,
    @PathVariable("idDestino") Long idDestino,
    @PathVariable("valor") float valor
  ) {
    return contasService.transferir(idOrigem, idDestino, valor);
  }
}
