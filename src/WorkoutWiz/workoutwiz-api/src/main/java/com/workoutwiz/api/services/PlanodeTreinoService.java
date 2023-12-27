package com.workoutwiz.api.services;

import com.workoutwiz.api.database.DatabaseManager;
import com.workoutwiz.api.models.PlanodeTreinoModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanodeTreinoService {
    @FunctionalInterface
    public interface RegisterPlanodeTreinoCallback {
        void onResult(boolean success);
    }

    @FunctionalInterface
    public interface QueryPlanodeTreinoCallback {
        void onResult(List<PlanodeTreinoModel> planodeTreinoList, boolean success);
    }

    public static void registerPlanodeTreino(PlanodeTreinoModel planodeTreino, RegisterPlanodeTreinoCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "INSERT INTO PlanodeTreino (ClienteID, Data, Frequencia, Modalidade, GanhoDeMassaMuscular, ControleDePeso, AumentoDaResistencia, ProgressoesDeCarga, ProgressoesDeDificuldade, TreinadorID) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setInt(1, planodeTreino.getClienteId());
                    stmt.setString(2, planodeTreino.getData());
                    stmt.setInt(3, planodeTreino.getFrequencia());
                    stmt.setString(4, planodeTreino.getModalidade());
                    stmt.setString(5, planodeTreino.getGanhoDeMassaMuscular());
                    stmt.setString(6, planodeTreino.getControleDePeso());
                    stmt.setString(7, planodeTreino.getAumentoDaResistencia());
                    stmt.setString(8, planodeTreino.getProgressoesDeCarga());
                    stmt.setString(9, planodeTreino.getProgressoesDeDificuldade());
                    stmt.setInt(10, planodeTreino.getTreinadorId());
                    stmt.executeUpdate();
                    callback.onResult(true); // Callback com sucesso
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir plano de treino: " + e.getMessage());
                    callback.onResult(false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(false); // Callback com falha
            }
        });
    }

    public static void queryPlanodeTreino(QueryPlanodeTreinoCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "SELECT ClienteID, Data, Frequencia, Modalidade, GanhoDeMassaMuscular, ControleDePeso, " +
                        "AumentoDaResistencia, ProgressoesDeCarga, ProgressoesDeDificuldade, TreinadorID FROM PlanodeTreino";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    ResultSet rs = stmt.executeQuery();
                    List<PlanodeTreinoModel> planodeTreinoList = new ArrayList<>();

                    while (rs.next()) {
                        int clienteId = rs.getInt("ClienteID");
                        String data = rs.getString("Data");
                        int frequencia = rs.getInt("Frequencia");
                        String modalidade = rs.getString("Modalidade");
                        String ganhoDeMassaMuscular = rs.getString("GanhoDeMassaMuscular");
                        String controleDePeso = rs.getString("ControleDePeso");
                        String aumentoDaResistencia = rs.getString("AumentoDaResistencia");
                        String progressoesDeCarga = rs.getString("ProgressoesDeCarga");
                        String progressoesDeDificuldade = rs.getString("ProgressoesDeDificuldade");
                        int treinadorId = rs.getInt("TreinadorID");

                        PlanodeTreinoModel planodeTreino = new PlanodeTreinoModel(clienteId, data, frequencia, modalidade, ganhoDeMassaMuscular, controleDePeso, aumentoDaResistencia, progressoesDeCarga, progressoesDeDificuldade, treinadorId);

                        planodeTreinoList.add(planodeTreino);
                    }

                    callback.onResult(planodeTreinoList, true); // Callback com sucesso e lista de planos de treino
                } catch (SQLException e) {
                    System.out.println("Erro ao consultar planos de treino: " + e.getMessage());
                    callback.onResult(null, false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(null, false); // Callback com falha
            }
        });
    }
}
