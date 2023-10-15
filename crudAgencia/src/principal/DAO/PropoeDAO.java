package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import principal.Conexao;

public class PropoeDAO {
	private Connection conexao;
	private Connection connection; // Você precisa de uma conexão JDBC aqui

	public PropoeDAO(Connection connection) {
		this.connection = connection;
	}

	public PropoeDAO() {
		try {
			conexao = Conexao.conectar();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void adicionarProposta(int idAgencia, int idDestino) {
		String sql = "INSERT INTO Propõe (Id_Agencia, Id_Destino) VALUES (?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, idAgencia);
			preparedStatement.setInt(2, idDestino);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Lide com a exceção apropriadamente
		}
	}

	public void fecharConexao() {
		try {
			if (conexao != null && !conexao.isClosed()) {
				conexao.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// Outros métodos para consultar, atualizar ou excluir propostas, se necessário
}
