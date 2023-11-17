package com.workoutwiz.api.routes;

import com.workoutwiz.api.models.ExerciciosModel;
import com.workoutwiz.api.services.ExerciciosService;
import com.workoutwiz.api.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciciosRoute {

    private class ExerciciosResponse {
        private final Boolean error;
        private final String message;
        private final List<ExerciciosModel> exerciciosList;

        // Construtor para POST
        public ExerciciosResponse(Boolean error, String message) {
            this.error = error;
            this.message = message;
            this.exerciciosList = null;
        }

        // Construtor para GET
        public ExerciciosResponse(Boolean error, String message, List<ExerciciosModel> exerciciosList) {
            this.error = error;
            this.message = message;
            this.exerciciosList = exerciciosList;
        }
    }

    @PostMapping("/exercicios")
    public String postExercicios(@RequestBody ExerciciosModel exercicios) {
        final String[] response = new String[1];
        ExerciciosService.registerExercicios(exercicios, success -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new ExerciciosResponse(false, "Exercícios registrados com sucesso"));
            } else {
                response[0] = HttpResponseUtil.toJson(new ExerciciosResponse(true, "Erro ao registrar os exercícios"));
            }
        });
        return response[0];
    }

    @GetMapping("/exercicios")
    public String getExercicios() {
        final String[] response = new String[1];
        ExerciciosService.queryExercicios((exerciciosList, success) -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new ExerciciosResponse(false, "Exercícios recuperados com sucesso", exerciciosList));
            } else {
                response[0] = HttpResponseUtil.toJson(new ExerciciosResponse(true, "Erro ao recuperar os exercícios", null));
            }
        });
        return response[0];
    }
}
