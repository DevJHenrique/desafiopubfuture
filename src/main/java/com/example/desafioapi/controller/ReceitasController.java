package com.example.desafioapi.controller;

import java.sql.Date;
import java.util.List;

import com.example.desafioapi.dto.ReceitaDTO;
import com.example.desafioapi.model.ReceitaModel;
import com.example.desafioapi.service.ReceitasService;

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
@RequestMapping("/receitas")
public class ReceitasController {

  @Autowired
  private ReceitasService receitasService;

  @GetMapping(value = "/getall")
  public List<ReceitaModel> getReceitas() {
    return receitasService.getReceitas();
  }

  @GetMapping(value = "/total")
  public Float getTotalReceitas() {
    return receitasService.getTotalReceitas();
  }

  @GetMapping(value = "/findByPeriod/{dataInicio}/{dataFim}")
  public List<ReceitaModel> findBetweenDates(
    @PathVariable("dataInicio") Date dataInicio,
    @PathVariable("dataFim") Date dataFim
  ) {
    return receitasService.findBetweenDates(dataInicio, dataFim);
  }

  @GetMapping(value = "/type={tipoReceita}")
  public List<ReceitaModel> findReceitaType(
    @PathVariable("tipoReceita") String tipoReceita
  ) {
    return receitasService.findReceitaType(tipoReceita);
  }

  @PostMapping(value = "/new")
  @ResponseStatus(value = HttpStatus.CREATED)
  public ReceitaModel addReceita(@RequestBody ReceitaDTO receitaDTO) {
    return receitasService.addReceita(receitaDTO);
  }

  @PostMapping(value = "/update/{id}")
  public ReceitaModel updateReceitaById(
    @PathVariable("id") Long id,
    @RequestBody ReceitaDTO receitaDTO
  ) {
    return receitasService.updateReceitaById(id, receitaDTO);
  }

  @DeleteMapping(value = "/delete/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public Boolean deleteReceita(@PathVariable("id") Long id) {
    return receitasService.deleteReceita(id);
  }
}
