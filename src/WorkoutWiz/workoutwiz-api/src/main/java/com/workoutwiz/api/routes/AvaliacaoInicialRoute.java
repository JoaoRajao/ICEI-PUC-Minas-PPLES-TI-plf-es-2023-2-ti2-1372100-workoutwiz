package com.workoutwiz.api.routes;

import com.workoutwiz.api.models.AvaliacaoInicialModel;
import com.workoutwiz.api.services.AvaliacaoInicialService;
import com.workoutwiz.api.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AvaliacaoInicialRoute {

    private class AvaliacaoInicialResponse {
        private final Boolean error;
        private final String message;
        private final List<AvaliacaoInicialModel> avaliacaoInicialList;

        // Construtor para POST
        public AvaliacaoInicialResponse(Boolean error, String message) {
            this.error = error;
            this.message = message;
            this.avaliacaoInicialList = null;
        }

        // Construtor para GET
        public AvaliacaoInicialResponse(Boolean error, String message, List<AvaliacaoInicialModel> avaliacaoInicialList) {
            this.error = error;
            this.message = message;
            this.avaliacaoInicialList = avaliacaoInicialList;
        }
    }

    @PostMapping("/avaliacaoInicial")
    public String postAvaliacaoInicial(@RequestBody AvaliacaoInicialModel avaliacaoInicial) {
        final String[] response = new String[1];
        AvaliacaoInicialService.registerAvaliacaoInicial(avaliacaoInicial, success -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new AvaliacaoInicialResponse(false, "Avaliacao Inicial registrada com sucesso"));
            } else {
                response[0] = HttpResponseUtil.toJson(new AvaliacaoInicialResponse(true, "Erro ao registrar a avaliacao inicial"));
            }
        });
        return response[0];
    }

    @GetMapping("/avaliacaoInicial")
    public String getAvaliacaoInicial() {
        final String[] response = new String[1];
        AvaliacaoInicialService.queryAvaliacaoInicial((avaliacaoInicialList, success) -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new AvaliacaoInicialResponse(false, "Avaliacao inicial recuperada com sucesso", avaliacaoInicialList));
            } else {
                response[0] = HttpResponseUtil.toJson(new AvaliacaoInicialResponse(true, "Erro ao recuperar a avaliacao inicial", null));
            }
        });
        return response[0];
    }
}
