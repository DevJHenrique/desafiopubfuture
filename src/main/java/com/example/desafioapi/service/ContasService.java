package com.example.desafioapi.service;

import com.example.desafioapi.model.ContaModel;
import com.example.desafioapi.repository.ContaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContasService {

  @Autowired
  private ContaRepository contaRepository;

  public List<ContaModel> getContas() {
    return contaRepository.findAll();
  }

  public ContaModel addConta(ContaModel conta) {
    return contaRepository.save(conta);
  }

  public ContaModel updateContaById(Long id, ContaModel conta) {
    try {
      ContaModel contaModel = contaRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
      contaModel.setSaldo(conta.getSaldo());
      contaModel.setTipoConta(conta.getTipoConta());
      contaModel.setInstituicaoFinanceira(conta.getInstituicaoFinanceira());
      return contaRepository.save(contaModel);
    } catch (Exception e) {
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST,
        "Erro ao atualizar conta: " + e.getMessage()
      );
    }
  }

  public Boolean deleteConta(Long id) {
    contaRepository.deleteById(id);
    return true;
  }

  public Float getSaldoContas() {
    Float result = contaRepository.sumSaldoContas();
    if (result == null) {
      result = 0f;
    }
    return result;
  }

  public ContaModel transferir(Long idOrigem, Long idDestino, float valor) {
    try {
      ContaModel contaOrigem = contaRepository
        .findById(idOrigem)
        .orElseThrow(
          () -> new RuntimeException("Conta de origem não encontrada")
        );
      ContaModel contaDestino = contaRepository
        .findById(idDestino)
        .orElseThrow(
          () -> new RuntimeException("Conta de destinho não encontrada")
        );
      contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
      contaDestino.setSaldo(contaDestino.getSaldo() + valor);
      contaRepository.save(contaOrigem);
      contaRepository.save(contaDestino);
      return contaOrigem;
    } catch (Exception e) {
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST,
        "Erro ao transferir valor: " + e.getMessage()
      );
    }
  }
}
