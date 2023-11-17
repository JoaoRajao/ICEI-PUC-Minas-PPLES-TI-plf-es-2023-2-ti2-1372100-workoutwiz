package com.workoutwiz.api.services;

import com.workoutwiz.api.database.DatabaseManager;
import com.workoutwiz.api.models.AprimoramentoModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AprimoramentoService {

    @FunctionalInterface
    public interface QueryAprimoramentoCallback {
        void onResult(List<AprimoramentoModel> aprimoramentoList, boolean success);
    }

    @FunctionalInterface
    public interface RegisterAprimoramentoCallback {
        void onResult(boolean success);
    }

    public static void registerAprimoramento(AprimoramentoModel aprimoramento, RegisterAprimoramentoCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "INSERT INTO Aprimoramento (TreinoID, ExecucoesDosMovimentos, DescricaoDaExecucao, DicasDeSeguranca, Feedback) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setInt(1, aprimoramento.getTreinoID());
                    stmt.setString(2, aprimoramento.getExecucoesDosMovimentos());
                    stmt.setString(3, aprimoramento.getDescricaoDaExecucao());
                    stmt.setString(4, aprimoramento.getDicasDeSeguranca());
                    stmt.setString(5, aprimoramento.getFeedback());
                    stmt.executeUpdate();
                    callback.onResult(true); // Callback com sucesso
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir aprimoramento: " + e.getMessage());
                    callback.onResult(false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(false); // Callback com falha
            }
        });
    }

    public static void queryAprimoramento(QueryAprimoramentoCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "SELECT TreinoID, ExecucoesDosMovimentos, DescricaoDaExecucao, DicasDeSeguranca, Feedback FROM Aprimoramento";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    ResultSet rs = stmt.executeQuery();
                    List<AprimoramentoModel> aprimoramentoList = new ArrayList<>();

                    while (rs.next()) {
                        int treinoID = rs.getInt("TreinoID");
                        String execucoesDosMovimentos = rs.getString("ExecucoesDosMovimentos");
                        String descricaoDaExecucao = rs.getString("DescricaoDaExecucao");
                        String dicasDeSeguranca = rs.getString("DicasDeSeguranca");
                        String feedback = rs.getString("Feedback");

                        AprimoramentoModel aprimoramentoModel = new AprimoramentoModel(treinoID, execucoesDosMovimentos, descricaoDaExecucao, dicasDeSeguranca, feedback);
                        aprimoramentoList.add(aprimoramentoModel);
                    }

                    callback.onResult(aprimoramentoList, true); // Callback com sucesso
                } catch (SQLException e) {
                    System.out.println("Erro ao consultar aprimoramento: " + e.getMessage());
                    callback.onResult(null, false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(null, false); // Callback com falha
            }
        });
    }
}
