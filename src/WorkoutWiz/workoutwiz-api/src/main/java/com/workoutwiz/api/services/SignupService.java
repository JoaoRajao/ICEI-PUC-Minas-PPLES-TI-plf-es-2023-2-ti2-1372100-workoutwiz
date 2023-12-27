package com.workoutwiz.api.services;

import com.workoutwiz.api.database.DatabaseManager;
import com.workoutwiz.api.models.SignupModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SignupService {
    @FunctionalInterface
    public interface RegisterUserCallback {
        void onResult(boolean success);
    }

    @FunctionalInterface
    public interface QuerySignUpCallback {
        void onResult(List<SignupModel> userList, boolean success);
    }

    public static void registerUser(SignupModel user, RegisterUserCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "INSERT INTO Cliente (nome, email, senha) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, user.getName());
                    stmt.setString(2, user.getEmail());
                    stmt.setString(3, user.getPassword());
                    stmt.executeUpdate();
                    callback.onResult(true); // Callback com sucesso
                } catch (SQLException e) {
                    System.out.println("Erro ao inserir usuário: " + e.getMessage());
                    callback.onResult(false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(false); // Callback com falha
            }
        });
    }

    public static void querySignUp(QuerySignUpCallback callback) {
        DatabaseManager.execute((success, connection) -> {
            if (success) {
                String sql = "SELECT nome, email, senha FROM Cliente";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    ResultSet rs = stmt.executeQuery();
                    List<SignupModel> userList = new ArrayList<>();

                    while (rs.next()) {
                        String nome = rs.getString("nome");
                        String email = rs.getString("email");
                        String senha = rs.getString("senha");
                        SignupModel user = new SignupModel(nome, email, senha);
                        userList.add(user);
                    }

                    callback.onResult(userList, true); // Callback com sucesso e lista de usuários
                } catch (SQLException e) {
                    System.out.println("Erro ao consultar usuários: " + e.getMessage());
                    callback.onResult(null, false); // Callback com falha
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
                callback.onResult(null, false); // Callback com falha
            }
        });
    }
}
