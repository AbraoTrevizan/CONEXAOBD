package llk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LerDados {
    public static void lerAlunos() {
        Connection conexao = ConexaoBD.conectar(); 
        if (conexao != null) {
            String sql = "SELECT * FROM alunos"; 
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(); 
                System.out.println("\n===== Lista de Alunos =====");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    System.out.println("ID: " + id + " | Nome: " + nome + " | Idade: " + idade);
                }
            } catch (SQLException e) {
                System.err.println("Erro ao ler dados: " + e.getMessage());
            } finally {
                try {
                    if (conexao != null) {
                        conexao.close(); // Fecha a conexão após o uso
                    }
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
}