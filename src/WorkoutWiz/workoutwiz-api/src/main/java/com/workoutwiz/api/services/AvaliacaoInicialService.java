package com.workoutwiz.api.services;

import com.workoutwiz.api.database.DatabaseManager;
import com.workoutwiz.api.models.AvaliacaoInicialModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoInicialService {

    @FunctionalInterface
    public interface RegisterAvaliacaoInicialCallback {
        void onResult(boolean success);
    }

    @FunctionalInterface
    public interface QueryAvaliacaoInicialCallback {
        void onResult(List<AvaliacaoInicialModel> avaliacaoInicialList, boolean success);
    }

    public static void registerAvaliacaoInicial(AvaliacaoInicialModel avaliacaoInicial, RegisterAvaliacaoInicialCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                // Log de cada campo
                System.out.println("Registrando Avaliação Inicial: " + avaliacaoInicial);

                String sql = "INSERT INTO AvaliacaoInicial (ClienteID, TreinadorID, Objetivos, HistoricoDeTreinamento, RestricoesFisicas, NivelDeCondicionamento, PreferenciasDeTreino, DisponibilidadeDeTempo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setInt(1, avaliacaoInicial.getClienteId());
                    stmt.setInt(2, avaliacaoInicial.getTreinadorId());
                    stmt.setString(3, avaliacaoInicial.getObjetivos());
                    stmt.setString(4, avaliacaoInicial.getHistoricoTreinamento());
                    stmt.setString(5, avaliacaoInicial.getRestricoesFisicas());
                    stmt.setString(6, avaliacaoInicial.getNivelCondicionamento());
                    stmt.setString(7, avaliacaoInicial.getPreferenciaTreino());
                    stmt.setString(8, avaliacaoInicial.getDisponibilidadeTempo());
                    stmt.executeUpdate();
                    callback.onResult(true);
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir Avaliação Inicial: " + e.getMessage());
                    callback.onResult(false);
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(false);
            }
        });
    }


    public static void queryAvaliacaoInicial(QueryAvaliacaoInicialCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "SELECT ClienteID, TreinadorID, Objetivos, HistoricoDeTreinamento, RestricoesFisicas, NivelDeCondicionamento, PreferenciasDeTreino, DisponibilidadeDeTempo FROM AvaliacaoInicial";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    ResultSet rs = stmt.executeQuery();
                    List<AvaliacaoInicialModel> avaliacaoInicialList = new ArrayList<>();

                    while (rs.next()) {
                        int clienteId = rs.getInt("ClienteID");
                        int treinadorId = rs.getInt("TreinadorID");
                        String objetivos = rs.getString("Objetivos");
                        String historicoTreinamento = rs.getString("HistoricoDeTreinamento");
                        String restricoesFisicas = rs.getString("RestricoesFisicas");
                        String nivelCondicionamento = rs.getString("NivelDeCondicionamento");
                        String preferenciaTreino = rs.getString("PreferenciasDeTreino");
                        String disponibilidadeTempo = rs.getString("DisponibilidadeDeTempo");

                        AvaliacaoInicialModel avaliacaoInicial = new AvaliacaoInicialModel(clienteId, treinadorId, objetivos, historicoTreinamento, restricoesFisicas, nivelCondicionamento, preferenciaTreino, disponibilidadeTempo);
                        avaliacaoInicialList.add(avaliacaoInicial);
                    }

                    callback.onResult(avaliacaoInicialList, true); // Callback com sucesso e lista de Avaliação Inicial
                } catch (SQLException e) {
                    System.out.println("Erro ao consultar Avaliação Inicial: " + e.getMessage());
                    callback.onResult(null, false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(null, false); // Callback com falha
            }
        });
    }
}
