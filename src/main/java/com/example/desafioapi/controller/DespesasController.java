package com.example.desafioapi.controller;

import java.sql.Date;
import java.util.List;

import com.example.desafioapi.dto.DespesaDTO;
import com.example.desafioapi.model.DespesaModel;
import com.example.desafioapi.service.DespesasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/despesas")
public class DespesasController {

  @Autowired
  private DespesasService despesasService;

  @GetMapping(value = "/getall")
  public List<DespesaModel> getDespesas() {
    return despesasService.getDespesas();
  }

  @GetMapping(value = "/total")
  public Float getTotalDespesas() {
    return despesasService.getTotalDespesas();
  }

  @PostMapping(value = "/new")
  @ResponseStatus(value = HttpStatus.CREATED)
  public DespesaModel addDespesa(@RequestBody DespesaDTO despesaDTO) {
    return despesasService.addDespesa(despesaDTO);
  }

  @PostMapping(value = "/update/{id}")
  public DespesaModel updateDespesaById(
    @PathVariable("id") Long id,
    @RequestBody DespesaDTO despesaDTO
  ) {
    return despesasService.updateDespesaById(id, despesaDTO);
  }

  @GetMapping(value = "/findByPeriod/{dataInicio}/{dataFim}")
  public List<DespesaModel> findBetweenDates(
    @PathVariable("dataInicio") Date dataInicio,
    @PathVariable("dataFim") Date dataFim
  ) {
    return despesasService.findBetweenDates(dataInicio, dataFim);
  }

  @GetMapping(value = "/type={tipoDespesa}")
  public List<DespesaModel> findDespesaType(
    @PathVariable("tipoDespesa") String tipoDespesa
  ) {
    return despesasService.findDespesaType(tipoDespesa);
  }

  @DeleteMapping(value = "/delete/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public Boolean deleteDespesa(@PathVariable("id") Long id) {
    return despesasService.deleteDespesa(id);
  }
}
