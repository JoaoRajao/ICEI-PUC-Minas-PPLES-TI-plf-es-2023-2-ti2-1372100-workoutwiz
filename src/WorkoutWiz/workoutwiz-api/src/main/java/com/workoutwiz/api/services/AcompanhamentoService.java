package com.workoutwiz.api.services;

import com.workoutwiz.api.database.DatabaseManager;
import com.workoutwiz.api.models.AcompanhamentoModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AcompanhamentoService {

    @FunctionalInterface
    public interface QueryAcompanhamentoCallback {
        void onResult(List<AcompanhamentoModel> acompanhamentoList, boolean success);
    }
    @FunctionalInterface
    public interface RegisterAcompanhamentoCallback {
        void onResult(boolean success);
    }

    public static void registerAcompanhamento(AcompanhamentoModel acompanhamento, RegisterAcompanhamentoCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "INSERT INTO Progresso (TreinoID, PesosLevantados, DistanciasPercorridas, TemposAlcancados) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setInt(1, acompanhamento.getTreinoId());
                    stmt.setInt(2, acompanhamento.getPesosLevantados());
                    stmt.setInt(3, acompanhamento.getDistanciasPercorridas());
                    stmt.setInt(4, acompanhamento.getTemposAlcancados());
                    stmt.executeUpdate();
                    callback.onResult(true); // Callback com sucesso
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir acompanhamento: " + e.getMessage());
                    callback.onResult(false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(false); // Callback com falha
            }
        });
    }
    public static void queryAcompanhamento(QueryAcompanhamentoCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "SELECT TreinoID, PesosLevantados, DistanciasPercorridas, TemposAlcancados FROM Progresso";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    ResultSet rs = stmt.executeQuery();
                    List<AcompanhamentoModel> acompanhamentoList = new ArrayList<>();

                    while (rs.next()) {
                        int treinoId = rs.getInt("TreinoID");
                        int pesosLevantados = rs.getInt("PesosLevantados");
                        int distanciasPercorridas = rs.getInt("DistanciasPercorridas");
                        int temposAlcancados = rs.getInt("TemposAlcancados");

                        AcompanhamentoModel acompanhamento = new AcompanhamentoModel(treinoId, pesosLevantados, distanciasPercorridas, temposAlcancados);
                        acompanhamentoList.add(acompanhamento);
                    }

                    callback.onResult(acompanhamentoList, true); // Callback com sucesso
                } catch (SQLException e) {
                    System.out.println("Erro ao consultar acompanhamento: " + e.getMessage());
                    callback.onResult(null, false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(null, false); // Callback com falha
            }
        });
    }
}

