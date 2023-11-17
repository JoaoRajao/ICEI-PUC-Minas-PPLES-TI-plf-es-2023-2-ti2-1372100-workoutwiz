package com.workoutwiz.api.routes;

import com.workoutwiz.api.models.AcompanhamentoModel;
import com.workoutwiz.api.services.AcompanhamentoService;
import com.workoutwiz.api.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AcompanhamentoRoute {

    private class AcompanhamentoResponse {
        private final Boolean error;
        private final String message;
        private final List<AcompanhamentoModel> acompanhamentoList;

        // Construtor para respostas sem lista (usado no POST)
        public AcompanhamentoResponse(Boolean error, String message) {
            this.error = error;
            this.message = message;
            this.acompanhamentoList = null;
        }

        // Construtor para respostas com lista (usado no GET)
        public AcompanhamentoResponse(Boolean error, String message, List<AcompanhamentoModel> acompanhamentoList) {
            this.error = error;
            this.message = message;
            this.acompanhamentoList = acompanhamentoList;
        }
    }

    @PostMapping("/acompanhamento")
    public String acompanhamento(@RequestBody AcompanhamentoModel acompanhamento) {
        final String[] response = new String[1];
        AcompanhamentoService.registerAcompanhamento(acompanhamento, success -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new AcompanhamentoResponse(false, "acompanhamento registrado com sucesso"));
            } else {
                response[0] = HttpResponseUtil.toJson(new AcompanhamentoResponse(true, "erro ao registrar o acompanhamento"));
            }
        });
        return response[0];
    }

    @GetMapping("/acompanhamento")
    public String getAcompanhamento() {
        final String[] response = new String[1];
        AcompanhamentoService.queryAcompanhamento((acompanhamentoList, success) -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new AcompanhamentoResponse(false, "Dados de acompanhamento recuperados com sucesso", acompanhamentoList));
            } else {
                response[0] = HttpResponseUtil.toJson(new AcompanhamentoResponse(true, "Erro ao recuperar dados de acompanhamento", null));
            }
        });
        return response[0];
    }
}
