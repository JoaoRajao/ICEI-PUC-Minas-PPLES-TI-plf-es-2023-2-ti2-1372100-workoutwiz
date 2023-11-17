package com.workoutwiz.api.services;

import com.workoutwiz.api.database.DatabaseManager;
import com.workoutwiz.api.models.FeedBackModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedBackService {
    @FunctionalInterface
    public interface RegisterFeedbackCallback {
        void onResult(boolean success);
    }
    @FunctionalInterface
    public interface QueryFeedbackCallback {
        void onResult(List<FeedBackModel> feedbackList, boolean success);
    }

    public static void registerFeedback(FeedBackModel feedback, RegisterFeedbackCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "INSERT INTO Feedback (ClienteID, Nome, Publico, Texto) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, feedback.getClientId());
                    stmt.setString(2, feedback.getName());
                    stmt.setString(3, feedback.getPublico());
                    stmt.setString(4, feedback.getText());
                    stmt.executeUpdate();
                    callback.onResult(true); // Callback com sucesso
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir feedback: " + e.getMessage());
                    callback.onResult(false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(false); // Callback com falha
            }
        });
    }
    public static void queryFeedback(QueryFeedbackCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "SELECT ClienteID, Nome, Publico, Texto FROM Feedback";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    ResultSet rs = stmt.executeQuery();
                    List<FeedBackModel> feedbackList = new ArrayList<>();

                    while (rs.next()) {
                        String clientId = rs.getString("ClienteID");
                        String name = rs.getString("Nome");
                        String publico = rs.getString("Publico");
                        String text = rs.getString("Texto");

                        FeedBackModel feedback = new FeedBackModel(clientId, name, publico, text);
                        feedbackList.add(feedback);
                    }

                    callback.onResult(feedbackList, true); // Callback com sucesso e lista de feedback
                } catch (SQLException e) {
                    System.out.println("Erro ao consultar feedback: " + e.getMessage());
                    callback.onResult(null, false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(null, false); // Callback com falha
            }
        });
    }

}
