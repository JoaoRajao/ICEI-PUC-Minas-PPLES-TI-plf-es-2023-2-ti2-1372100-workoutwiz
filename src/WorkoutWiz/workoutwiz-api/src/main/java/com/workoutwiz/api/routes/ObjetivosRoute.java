package com.workoutwiz.api.routes;

import com.workoutwiz.api.models.ObjetivosModel;
import com.workoutwiz.api.services.ObjetivosService;
import com.workoutwiz.api.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObjetivosRoute {

    private class ObjetivosResponse {
        private final Boolean error;
        private final String message;
        private final List<ObjetivosModel> objetivosList;

        // Constructor para POST
        public ObjetivosResponse(Boolean error, String message) {
            this.error = error;
            this.message = message;
            this.objetivosList = null;
        }

        // Constructor para GET
        public ObjetivosResponse(Boolean error, String message, List<ObjetivosModel> objetivosList) {
            this.error = error;
            this.message = message;
            this.objetivosList = objetivosList;
        }
    }

    @PostMapping("/objetivos")
    public String postObjetivos(@RequestBody ObjetivosModel objetivos) {
        final String[] response = new String[1];
        ObjetivosService.registerObjetivos(objetivos, success -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new ObjetivosResponse(false, "Objetivos registrados com sucesso"));
            } else {
                response[0] = HttpResponseUtil.toJson(new ObjetivosResponse(true, "Erro ao registrar os objetivos"));
            }
        });
        return response[0];
    }

    @GetMapping("/objetivos")
    public String getObjetivos() {
        final String[] response = new String[1];
        ObjetivosService.queryObjetivos((objetivosList, success) -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new ObjetivosResponse(false, "Objetivos recuperados com sucesso", objetivosList));
            } else {
                response[0] = HttpResponseUtil.toJson(new ObjetivosResponse(true, "Erro ao recuperar os objetivos", null));
            }
        });
        return response[0];
    }
}