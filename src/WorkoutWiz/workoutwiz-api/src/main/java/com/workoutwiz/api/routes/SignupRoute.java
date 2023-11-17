package com.workoutwiz.api.routes;

import com.workoutwiz.api.services.SignupService;
import com.workoutwiz.api.models.SignupModel;
import com.workoutwiz.api.utils.HttpResponseUtil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SignupRoute {
    private class SignupResponse {
        private final Boolean error;
        private final String message;

        public SignupResponse(Boolean error, String message) {
            this.error = error;
            this.message = message;
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
}
