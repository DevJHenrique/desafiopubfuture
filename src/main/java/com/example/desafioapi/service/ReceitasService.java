package com.example.desafioapi.service;

import java.sql.Date;
import java.util.List;

import com.example.desafioapi.dto.ReceitaDTO;
import com.example.desafioapi.model.ContaModel;
import com.example.desafioapi.model.ReceitaModel;
import com.example.desafioapi.repository.ContaRepository;
import com.example.desafioapi.repository.ReceitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReceitasService {

  @Autowired
  private ReceitaRepository receitaRepository;

  @Autowired
  private ContaRepository contaRepository;

  public List<ReceitaModel> getReceitas() {
    return receitaRepository.findAll();
  }

  public Float getTotalReceitas() {
    Float result = receitaRepository.sumReceita();
    if (result == null) {
      result = 0f;
    }
    return result;
  }

  public List<ReceitaModel> findBetweenDates(Date dataInicio, Date dataFim) {
    return receitaRepository.findByPeriod(dataInicio, dataFim);
  }

  public List<ReceitaModel> findReceitaType(String tipoReceita) {
    tipoReceita = tipoReceita.toUpperCase();

    return receitaRepository.findByReceitaType(tipoReceita);
  }

  public ReceitaModel addReceita(ReceitaDTO receitaDTO) {
    try {
      Long contaId = receitaDTO.getContaId();
      ContaModel conta = contaRepository
        .findById(contaId)
        .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

      ReceitaModel receita = new ReceitaModel();
      receita.setValor(receitaDTO.getValor());
      receita.setDataRecebimento(receitaDTO.getDataRecebimento());
      receita.setDataRecebimentoEsperado(
        receitaDTO.getDataRecebimentoEsperado()
      );
      receita.setDescricao(receitaDTO.getDescricao());
      receita.setTipoReceita(receitaDTO.getTipoReceita());
      receita.setConta(conta);

      return receitaRepository.save(receita);
    } catch (Exception e) {
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST,
        "Erro ao adicionar uma nova receita: " + e.getMessage()
      );
    }
  }

  public ReceitaModel updateReceitaById(Long id, ReceitaDTO receitaDTO) {
    try {
      Long contaId = receitaDTO.getContaId();
      ContaModel conta = contaRepository
        .findById(contaId)
        .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
      ReceitaModel receita = receitaRepository.findById(id).get();

      receita.setValor(receitaDTO.getValor());
      receita.setDataRecebimento(receitaDTO.getDataRecebimento());
      receita.setDataRecebimentoEsperado(
        receitaDTO.getDataRecebimentoEsperado()
      );
      receita.setDescricao(receitaDTO.getDescricao());
      receita.setTipoReceita(receitaDTO.getTipoReceita());
      receita.setConta(conta);
      return receitaRepository.save(receita);
    } catch (Exception e) {
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST,
        "Erro ao atualizar receita: " + e.getMessage()
      );
    }
  }

  public Boolean deleteReceita(Long id) {
    receitaRepository.deleteById(id);
    return true;
  }
}
