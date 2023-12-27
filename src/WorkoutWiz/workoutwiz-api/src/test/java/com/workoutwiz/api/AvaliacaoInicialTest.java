package com.workoutwiz.api;

import com.workoutwiz.api.models.AvaliacaoInicialModel;
import com.workoutwiz.api.services.AvaliacaoInicialService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AvaliacaoInicialTest {

    @Test
    public void testRegisterAvaliacaoInicial() {
        AvaliacaoInicialService service = mock(AvaliacaoInicialService.class);
        AvaliacaoInicialModel avaliacaoInicial = new AvaliacaoInicialModel(1, 1, "Objetivos", "Historico", "Restricoes", "Nivel", "Preferencias", "Disponibilidade");

        // Configuração do mock para retornar true quando o método registerAvaliacaoInicial for chamado
        when(service.registerAvaliacaoInicial(any(AvaliacaoInicialModel.class))).thenReturn(true);

        // Chamada do método a ser testado
        boolean resultado = service.registerAvaliacaoInicial(avaliacaoInicial);

        // Verificação do resultado
        assertTrue(resultado, "A avaliação inicial deve ser registrada com sucesso.");
    }
}

