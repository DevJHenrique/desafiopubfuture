package com.example.desafioapi.service;

import java.sql.Date;
import java.util.List;

import com.example.desafioapi.dto.DespesaDTO;
import com.example.desafioapi.model.ContaModel;
import com.example.desafioapi.model.DespesaModel;
import com.example.desafioapi.repository.ContaRepository;
import com.example.desafioapi.repository.DespesaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DespesasService {

  @Autowired
  private DespesaRepository despesaRepository;

  @Autowired
  private ContaRepository contaRepository;

  public List<DespesaModel> getDespesas() {
    return despesaRepository.findAll();
  }

  public Float getTotalDespesas() {
    Float result = despesaRepository.sumDespesa();
    if (result == null) {
      result = 0f;
    }
    return result;
  }

  public DespesaModel addDespesa(DespesaDTO despesaDTO) {
    try {
      Long contaId = despesaDTO.getContaId();
      ContaModel conta = contaRepository
        .findById(contaId)
        .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

      DespesaModel despesa = new DespesaModel();
      despesa.setValor(despesaDTO.getValor());
      despesa.setDataPagemento(despesaDTO.getDataPagemento());
      despesa.setDataPagementoEsperado(despesaDTO.getDataPagementoEsperado());
      despesa.setTipoDespesa(despesaDTO.getTipoDespesa());
      despesa.setConta(conta);

      return despesaRepository.save(despesa);
    } catch (Exception e) {
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST,
        "Erro ao adicionar uma nova despesa: " + e.getMessage()
      );
    }
  }

  public DespesaModel updateDespesaById(Long id, DespesaDTO despesaDTO) {
    try {
      Long contaId = despesaDTO.getContaId();
      ContaModel conta = contaRepository
        .findById(contaId)
        .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

      DespesaModel DespesaModel = despesaRepository.findById(id).get();
      DespesaModel.setValor(despesaDTO.getValor());
      DespesaModel.setDataPagemento(despesaDTO.getDataPagemento());
      DespesaModel.setDataPagementoEsperado(
        despesaDTO.getDataPagementoEsperado()
      );
      DespesaModel.setTipoDespesa(despesaDTO.getTipoDespesa());
      DespesaModel.setConta(conta);
      return despesaRepository.save(DespesaModel);
    } catch (Exception e) {
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST,
        "Erro ao atualizar despesa: " + e.getMessage()
      );
    }
  }

  public List<DespesaModel> findBetweenDates(Date dataInicio, Date dataFim) {
    return despesaRepository.findByPeriod(dataInicio, dataFim);
  }

  public List<DespesaModel> findDespesaType(String tipoDespesa) {
    tipoDespesa = tipoDespesa.toUpperCase();

    return despesaRepository.findByDespesaType(tipoDespesa);
  }

  public Boolean deleteDespesa(Long id) {
    despesaRepository.deleteById(id);
    return true;
  }
}
