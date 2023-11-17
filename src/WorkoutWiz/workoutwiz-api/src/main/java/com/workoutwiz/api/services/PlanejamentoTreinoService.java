package com.workoutwiz.api.services;

import com.workoutwiz.api.database.DatabaseManager;
import com.workoutwiz.api.models.PlanejamentoTreinoModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PlanejamentoTreinoService {
    @FunctionalInterface
    public interface RegisterPlanejamentoCallback {
        void onResult(boolean success);
    }

    public static void registerPlanejamento(PlanejamentoTreinoModel planejamentoTreino, PlanejamentoTreinoService.RegisterPlanejamentoCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "INSERT INTO PlanejamentoDeTreinos (treinoID, Tempo, Data) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, planejamentoTreino.getTreinoId());
                    stmt.setString(2, planejamentoTreino.getData());
                    stmt.setString(3, planejamentoTreino.getTempo());
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
}
