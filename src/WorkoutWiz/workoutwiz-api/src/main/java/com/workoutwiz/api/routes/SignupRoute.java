package com.workoutwiz.api.routes;

import com.workoutwiz.api.models.SignupModel;
import com.workoutwiz.api.services.SignupService;
import com.workoutwiz.api.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class SignupRoute {
    private class SignupResponse {
        private final Boolean error;
        private final String message;
        private final List<SignupModel> userList;

        // Construtor para POST
        public SignupResponse(Boolean error, String message) {
            this.error = error;
            this.message = message;
            this.userList = null;
        }

        // Construtor para GET
        public SignupResponse(Boolean error, String message, List<SignupModel> userList) {
            this.error = error;
            this.message = message;
            this.userList = userList;
        }
    }

    @PostMapping("/signup")
    public String signup(@RequestBody SignupModel user) {
        final String[] response = new String[1];
        SignupService.registerUser(user, success -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new SignupResponse(false, "usuario registrado com sucesso"));
            } else {
                response[0] = HttpResponseUtil.toJson(new SignupResponse(true, "erro ao registrar o usuario"));
            }
        });
        return response[0];
    }

    @GetMapping("/signup")
    public String getSignup() {
        final String[] response = new String[1];
        SignupService.querySignUp((userList, success) -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new SignupRoute.SignupResponse(false, "Usuário recuperado com sucesso", userList));
            } else {
                response[0] = HttpResponseUtil.toJson(new SignupRoute.SignupResponse(true, "Erro ao recuperar o usuário", null));
            }
        });
        return response[0];
    }
}
