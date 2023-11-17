package com.workoutwiz.api.services;

import com.workoutwiz.api.database.DatabaseManager;
import com.workoutwiz.api.models.ExerciciosModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciciosService {

    @FunctionalInterface
    public interface QueryExerciciosCallback {
        void onResult(List<ExerciciosModel> exerciciosList, boolean success);
    }

    @FunctionalInterface
    public interface RegisterExerciciosCallback {
        void onResult(boolean success);
    }

    public static void registerExercicios(ExerciciosModel exercicios, RegisterExerciciosCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "INSERT INTO Exercicios (TreinoID, NomeDoExercicio, NumeroDeRepeticoes, Peso) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setInt(1, exercicios.getTreinoID());
                    stmt.setString(2, exercicios.getNomeDoExercicio());
                    stmt.setInt(3, exercicios.getNumeroDeRepeticoes());
                    stmt.setInt(4, exercicios.getPeso());
                    stmt.executeUpdate();
                    callback.onResult(true); // Callback com sucesso
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir exercícios: " + e.getMessage());
                    callback.onResult(false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(false); // Callback com falha
            }
        });
    }

    public static void queryExercicios(QueryExerciciosCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "SELECT TreinoID, NomeDoExercicio, NumeroDeRepeticoes, Peso FROM Exercicios";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    ResultSet rs = stmt.executeQuery();
                    List<ExerciciosModel> exerciciosList = new ArrayList<>();

                    while (rs.next()) {
                        int treinoID = rs.getInt("TreinoID");
                        String nomeDoExercicio = rs.getString("NomeDoExercicio");
                        int numeroDeRepeticoes = rs.getInt("NumeroDeRepeticoes");
                        int peso = rs.getInt("Peso");

                        ExerciciosModel exerciciosModel = new ExerciciosModel(treinoID, nomeDoExercicio, numeroDeRepeticoes, peso);
                        exerciciosList.add(exerciciosModel);
                    }

                    callback.onResult(exerciciosList, true); // Callback com sucesso e lista de exercícios
                } catch (SQLException e) {
                    System.out.println("Erro ao consultar exercícios: " + e.getMessage());
                    callback.onResult(null, false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(null, false); // Callback com falha
            }
        });
    }
}
