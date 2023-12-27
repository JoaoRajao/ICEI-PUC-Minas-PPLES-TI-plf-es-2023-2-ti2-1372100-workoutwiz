package com.workoutwiz.api.services;

import com.workoutwiz.api.database.DatabaseManager;
import com.workoutwiz.api.models.TreinadorModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreinadorService {
    @FunctionalInterface
    public interface RegisterTreinadorCallback {
        void onResult(boolean success);
    }

    @FunctionalInterface
    public interface QueryTreinadorCallback {
        void onResult(List<TreinadorModel> treinadorList, boolean success);
    }

    public static void registerTreinador(TreinadorModel treinador, RegisterTreinadorCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "INSERT INTO Treinador ( Nome, Especialidade,Usuario, Senha) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, treinador.getNome());
                    stmt.setString(2, treinador.getEspecialidade());
                    stmt.setString(3, treinador.getUsuario());
                    stmt.setString(4, treinador.getSenha());
                    stmt.executeUpdate();
                    callback.onResult(true); // Callback com sucesso
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir treinador: " + e.getMessage());
                    callback.onResult(false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(false); // Callback com falha
            }
        });
    }

    public static void queryTreinador(QueryTreinadorCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "SELECT TreinadorID, Nome, Especialidade,Usuario ,Senha FROM Treinador";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    ResultSet rs = stmt.executeQuery();
                    List<TreinadorModel> treinadorList = new ArrayList<>();

                    while (rs.next()) {
                        int treinadorID = rs.getInt("TreinadorID");
                        String nome = rs.getString("Nome");
                        String especialidade = rs.getString("Especialidade");
                        String senha = rs.getString("Senha");
                        String usuario = rs.getString("usuario");
                        TreinadorModel treinador = new TreinadorModel(treinadorID, nome, especialidade,usuario , senha);
                        treinadorList.add(treinador);
                    }

                    callback.onResult(treinadorList, true); // Callback com sucesso e lista de treinadores
                } catch (SQLException e) {
                    System.out.println("Erro ao consultar treinadores: " + e.getMessage());
                    callback.onResult(null, false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(null, false); // Callback com falha
            }
        });
    }
}