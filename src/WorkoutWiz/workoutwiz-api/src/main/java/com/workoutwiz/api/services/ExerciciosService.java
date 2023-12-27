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
    public interface RegisterExercicioCallback {
        void onResult(boolean success);
    }

    @FunctionalInterface
    public interface QueryExerciciosCallback {
        void onResult(List<ExerciciosModel> exerciciosList, boolean success);
    }

    public static void registerExercicio(ExerciciosModel exercicio, RegisterExercicioCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                // Log de cada campo
                System.out.println("Registrando Exercício: " + exercicio);

                String sql = "INSERT INTO Exercicios (NomeDoExercicio, NumeroDeRepeticoes, Peso) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, exercicio.getNomeDoExercicio());
                    stmt.setInt(2, exercicio.getNumeroDeRepeticoes());
                    stmt.setInt(3, exercicio.getPeso());
                    stmt.executeUpdate();
                    callback.onResult(true);
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir Exercício: " + e.getMessage());
                    callback.onResult(false);
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(false);
            }
        });
    }

    public static void queryExercicios(QueryExerciciosCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "SELECT NomeDoExercicio, NumeroDeRepeticoes, Peso FROM Exercicios";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    ResultSet rs = stmt.executeQuery();
                    List<ExerciciosModel> exerciciosList = new ArrayList<>();

                    while (rs.next()) {
                        String nomeDoExercicio = rs.getString("NomeDoExercicio");
                        int numeroDeRepeticoes = rs.getInt("NumeroDeRepeticoes");
                        int peso = rs.getInt("Peso");

                        ExerciciosModel exercicio = new ExerciciosModel(nomeDoExercicio, numeroDeRepeticoes, peso);
                        exerciciosList.add(exercicio);
                    }

                    callback.onResult(exerciciosList, true); // Callback com sucesso e lista de Exercícios
                } catch (SQLException e) {
                    System.out.println("Erro ao consultar Exercícios: " + e.getMessage());
                    callback.onResult(null, false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(null, false); // Callback com falha
            }
        });
    }
}
