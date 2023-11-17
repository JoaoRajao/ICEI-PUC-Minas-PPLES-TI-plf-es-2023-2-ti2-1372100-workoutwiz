package com.workoutwiz.api.routes;

import com.workoutwiz.api.models.AprimoramentoModel;
import com.workoutwiz.api.services.AprimoramentoService;
import com.workoutwiz.api.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AprimoramentoRoute {

    private class AprimoramentoResponse {
        private final Boolean error;
        private final String message;
        private final List<AprimoramentoModel> aprimoramentoList;

        // Construtor para POST
        public AprimoramentoResponse(Boolean error, String message) {
            this.error = error;
            this.message = message;
            this.aprimoramentoList = null;
        }

        // Construtor para GET
        public AprimoramentoResponse(Boolean error, String message, List<AprimoramentoModel> aprimoramentoList) {
            this.error = error;
            this.message = message;
            this.aprimoramentoList = aprimoramentoList;
        }
    }

    @PostMapping("/aprimoramento")
    public String postAprimoramento(@RequestBody AprimoramentoModel aprimoramento) {
        final String[] response = new String[1];
        AprimoramentoService.registerAprimoramento(aprimoramento, success -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new AprimoramentoResponse(false, "Aprimoramento registrado com sucesso"));
            } else {
                response[0] = HttpResponseUtil.toJson(new AprimoramentoResponse(true, "Erro ao registrar o aprimoramento"));
            }
        });
        return response[0];
    }

    @GetMapping("/aprimoramento")
    public String getAprimoramento() {
        final String[] response = new String[1];
        AprimoramentoService.queryAprimoramento((aprimoramentoList, success) -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new AprimoramentoResponse(false, "Aprimoramento recuperado com sucesso", aprimoramentoList));
            } else {
                response[0] = HttpResponseUtil.toJson(new AprimoramentoResponse(true, "Erro ao recuperar o aprimoramento", null));
            }
        });
        return response[0];
    }
}
