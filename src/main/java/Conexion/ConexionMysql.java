package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql {

    private static final String URL = "jdbc:mysql://localhost:3306/mecanica"
            + "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    public static Connection conectar() {
        try {
            Connection con = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión exitosa");
            return con;
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }

    // Prueba rápida: clic derecho al archivo → Run File (Shift+F6)
    public static void main(String[] args) {
        Connection con = conectar();
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar: " + e.getMessage());
            }
        }
    }
}