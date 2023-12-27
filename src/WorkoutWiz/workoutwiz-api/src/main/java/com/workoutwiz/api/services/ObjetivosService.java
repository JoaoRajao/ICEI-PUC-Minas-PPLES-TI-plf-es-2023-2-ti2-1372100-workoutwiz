package com.workoutwiz.api.services;

import com.workoutwiz.api.database.DatabaseManager;
import com.workoutwiz.api.models.ObjetivosModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjetivosService {
    @FunctionalInterface
    public interface RegisterObjetivosCallback {
        void onResult(boolean success);
    }

    @FunctionalInterface
    public interface QueryObjetivosCallback {
        void onResult(List<ObjetivosModel> objetivosList, boolean success);
    }

    public static void registerObjetivos(ObjetivosModel objetivos, RegisterObjetivosCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "INSERT INTO Objetivos (ClienteID, Descricao) VALUES (?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setInt(1, objetivos.getClienteId());
                    stmt.setString(2, objetivos.getDescricao());
                    stmt.executeUpdate();
                    callback.onResult(true); // Callback com sucesso
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir objetivos: " + e.getMessage());
                    callback.onResult(false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(false); // Callback com falha
            }
        });
    }

    public static void queryObjetivos(QueryObjetivosCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "SELECT ClienteID, Descricao FROM Objetivos";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    ResultSet rs = stmt.executeQuery();
                    List<ObjetivosModel> objetivosList = new ArrayList<>();

                    while (rs.next()) {
                        int clienteId = rs.getInt("ClienteID");
                        String descricao = rs.getString("Descricao");
                        ObjetivosModel objetivos = new ObjetivosModel(clienteId, descricao);
                        objetivosList.add(objetivos);
                    }

                    callback.onResult(objetivosList, true); // Callback com sucesso e lista de objetivos
                } catch (SQLException e) {
                    System.out.println("Erro ao consultar objetivos: " + e.getMessage());
                    callback.onResult(null, false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(null, false); // Callback com falha
            }
        });
    }
}
