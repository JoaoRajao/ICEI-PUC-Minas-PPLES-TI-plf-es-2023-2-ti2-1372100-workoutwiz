package com.workoutwiz.api.routes;

import com.workoutwiz.api.models.PlanejamentoTreinoModel;
import com.workoutwiz.api.services.PlanejamentoTreinoService;
import com.workoutwiz.api.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlanejamentoTreinoRoute {

    private class PlanejamentoTreinoResponse {
        private final Boolean error;
        private final String message;

        public PlanejamentoTreinoResponse(Boolean error, String message) {
            this.error = error;
            this.message = message;
        }
    }

    @PostMapping("/planejamentotreino")
    public String planejamentoTreino(@RequestBody PlanejamentoTreinoModel planejamentoTreino) {
        final String[] response = new String[1];
        PlanejamentoTreinoService.registerPlanejamento(planejamentoTreino, success -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new PlanejamentoTreinoRoute.PlanejamentoTreinoResponse(false, "usuario registrado com sucesso"));
            } else {
                response[0] = HttpResponseUtil.toJson(new PlanejamentoTreinoRoute.PlanejamentoTreinoResponse(true, "erro ao registrar o usuario"));
            }
        });
        return response[0];
    }
}
