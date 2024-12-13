package apresentacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/projetousuario"; 
        String usuario = ""; 
        String senha = ""; 

        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }
}
