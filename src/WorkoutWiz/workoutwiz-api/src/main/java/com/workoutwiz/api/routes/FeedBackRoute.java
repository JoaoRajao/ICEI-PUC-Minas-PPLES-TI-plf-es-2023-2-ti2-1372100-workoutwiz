package com.workoutwiz.api.routes;

import com.workoutwiz.api.models.FeedBackModel;
import com.workoutwiz.api.services.FeedBackService;
import com.workoutwiz.api.utils.HttpResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedBackRoute {

    private class FeedBackResponse {
        private final Boolean error;
        private final String message;
        private final List<FeedBackModel> feedbackList;

        // Construtor para POST
        public FeedBackResponse(Boolean error, String message) {
            this.error = error;
            this.message = message;
            this.feedbackList = null;
        }

        // Construtor para GET
        public FeedBackResponse(Boolean error, String message, List<FeedBackModel> feedbackList) {
            this.error = error;
            this.message = message;
            this.feedbackList = feedbackList;
        }
    }

    @PostMapping("/feedback")
    public String postFeedback(@RequestBody FeedBackModel feedback) {
        final String[] response = new String[1];
        FeedBackService.registerFeedback(feedback, success -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new FeedBackResponse(false, "Feedback registrado com sucesso"));
            } else {
                response[0] = HttpResponseUtil.toJson(new FeedBackResponse(true, "Erro ao registrar o feedback"));
            }
        });
        return response[0];
    }

    @GetMapping("/feedback")
    public String getFeedback() {
        final String[] response = new String[1];
        FeedBackService.queryFeedback((feedbackList, success) -> {
            if (success) {
                response[0] = HttpResponseUtil.toJson(new FeedBackResponse(false, "Feedback recuperado com sucesso", feedbackList));
            } else {
                response[0] = HttpResponseUtil.toJson(new FeedBackResponse(true, "Erro ao recuperar o feedback", null));
            }
        });
        return response[0];
    }
}
