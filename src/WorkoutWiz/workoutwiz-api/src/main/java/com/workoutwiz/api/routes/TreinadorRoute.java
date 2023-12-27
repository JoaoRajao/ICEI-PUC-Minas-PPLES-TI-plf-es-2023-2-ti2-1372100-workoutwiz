package com.workoutwiz.api.routes;

import com.workoutwiz.api.models.TreinadorModel;
import com.workoutwiz.api.services.TreinadorService;
import com.workoutwiz.api.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TreinadorRoute {

    private class TreinadorResponse {
        private final Boolean error;
        private final String message;
        private final List<TreinadorModel> treinadorList;

        // Constructor para POST
        public TreinadorResponse(Boolean error, String message) {
            this.error = error;
            this.message = message;
            this.treinadorList = null;
        }

        // Constructor para GET
        public TreinadorResponse(Boolean error, String message, List<TreinadorModel> treinadorList) {
            this.error = error;
            this.message = message;
            this.treinadorList = treinadorList;
        }
    }

    @PostMapping("/treinador")
    public String postTreinador(@RequestBody TreinadorModel treinador) {
        final String[] response = new String[1];
        TreinadorService.registerTreinador(treinador, success -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new TreinadorResponse(false, "Treinador registrado com sucesso"));
            } else {
                response[0] = HttpResponseUtil.toJson(new TreinadorResponse(true, "Erro ao registrar o treinador"));
            }
        });
        return response[0];
    }

    @GetMapping("/treinador")
    public String getTreinador() {
        final String[] response = new String[1];
        TreinadorService.queryTreinador((treinadorList, success) -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new TreinadorResponse(false, "Treinador recuperado com sucesso", treinadorList));
            } else {
                response[0] = HttpResponseUtil.toJson(new TreinadorResponse(true, "Erro ao recuperar o treinador", null));
            }
        });
        return response[0];
    }
}