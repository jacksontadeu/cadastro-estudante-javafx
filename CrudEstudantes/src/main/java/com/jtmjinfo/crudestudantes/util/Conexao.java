package com.jtmjinfo.crudestudantes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/crud_estudantes";

    private static String USER = "root";
    private static final String PASSWORD = "admin123";

    public static Connection obterConexao() throws SQLException{
        String driverName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driverName);
           // System.out.println("Conectado");
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Erro ao conectar " + e.getMessage());
        }
    }
    public static void fecharConexao(Connection connection) throws SQLException {
        if (!connection.isClosed()  && connection != null ){
            connection.close();
        }

    }

}
