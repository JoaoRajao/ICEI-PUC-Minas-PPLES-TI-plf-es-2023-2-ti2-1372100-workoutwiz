package com.workoutwiz.api.routes;

import com.workoutwiz.api.models.PlanodeTreinoModel;
import com.workoutwiz.api.services.PlanodeTreinoService;
import com.workoutwiz.api.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlanodeTreinoRoute {

    private class PlanodeTreinoResponse {
        private final Boolean error;
        private final String message;
        private final List<PlanodeTreinoModel> planodeTreinoList;

        // Constructor para POST
        public PlanodeTreinoResponse(Boolean error, String message) {
            this.error = error;
            this.message = message;
            this.planodeTreinoList = null;
        }

        // Constructor para GET
        public PlanodeTreinoResponse(Boolean error, String message, List<PlanodeTreinoModel> planodeTreinoList) {
            this.error = error;
            this.message = message;
            this.planodeTreinoList = planodeTreinoList;
        }
    }

    @PostMapping("/planodetreino")
    public String postPlanodeTreino(@RequestBody PlanodeTreinoModel planodeTreino) {
        final String[] response = new String[1];
        PlanodeTreinoService.registerPlanodeTreino(planodeTreino, success -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new PlanodeTreinoResponse(false, "PlanodeTreino registrado com sucesso"));
            } else {
                response[0] = HttpResponseUtil.toJson(new PlanodeTreinoResponse(true, "Erro ao registrar o PlanodeTreino"));
            }
        });
        return response[0];
    }

    @GetMapping("/planodetreino")
    public String getPlanodeTreino() {
        final String[] response = new String[1];
        PlanodeTreinoService.queryPlanodeTreino((planodeTreinoList, success) -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new PlanodeTreinoResponse(false, "PlanodeTreino recuperado com sucesso", planodeTreinoList));
            } else {
                response[0] = HttpResponseUtil.toJson(new PlanodeTreinoResponse(true, "Erro ao recuperar o PlanodeTreino", null));
            }
        });
        return response[0];
    }
}
