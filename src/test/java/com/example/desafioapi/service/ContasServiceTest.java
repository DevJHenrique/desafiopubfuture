package com.example.desafioapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.desafioapi.enumeration.ContaTypeEnum;
import com.example.desafioapi.model.ContaModel;
import com.example.desafioapi.repository.ContaRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;




@ExtendWith(MockitoExtension.class)
public class ContasServiceTest {


    @Mock
    private ContaRepository contaRepository;

    @InjectMocks
    private ContasService contasService;

    @Test
    @DisplayName("Deve retornar uma nova conta salva")
    public void saveConta(){
        ContaModel novaConta = new ContaModel();
        novaConta.setId(1L);
        novaConta.setInstituicaoFinanceira("Viacredi");
        novaConta.setSaldo(100.0f);
        novaConta.setTipoConta(ContaTypeEnum.CONTA_CORRENTE);

        when(contasService.addConta(any(ContaModel.class))).thenReturn(novaConta);

        ContaModel conta = contasService.addConta(new ContaModel());

        assertEquals(conta.getId(), 1);
        assertEquals(conta.getInstituicaoFinanceira(), "Viacredi");
        assertEquals(conta.getSaldo(), 100);
        assertEquals(conta.getTipoConta(), ContaTypeEnum.CONTA_CORRENTE);
        assertEquals(conta.getClass(), ContaModel.class);
    } 
}
