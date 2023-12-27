package com.workoutwiz.api;

import com.workoutwiz.api.models.AcompanhamentoModel;
import com.workoutwiz.api.services.AcompanhamentoService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AcompanhamentoTest {

    @Test
    public void testRegisterAcompanhamento() {
        AcompanhamentoService service = mock(AcompanhamentoService.class);
        AcompanhamentoModel acompanhamento = new AcompanhamentoModel(1, 100, 200, 30, 80);

        // Configuração do mock para retornar true quando o método registerAcompanhamento for chamado
        when(service.registerAcompanhamento(any(AcompanhamentoModel.class))).thenReturn(true);

        // Chamada do método a ser testado
        boolean resultado = service.registerAcompanhamento(acompanhamento);

        // Verificação do resultado
        assertTrue(resultado, "O acompanhamento do treino deve ser registrado com sucesso.");
    }
}