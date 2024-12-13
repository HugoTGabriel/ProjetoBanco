package apresentacao;

import java.sql.Connection;

public class testeconexao {
    public static void main(String[] args) {
        Connection conexao = ConexaoBanco.conectar();
        if (conexao != null) {
            System.out.println("Conexão bem-sucedida!");
        }
    }
}