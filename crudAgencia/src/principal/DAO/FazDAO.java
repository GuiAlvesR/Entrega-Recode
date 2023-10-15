package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import principal.Conexao;

public class FazDAO {
	private Connection conexao;
	private Connection connection; // Você precisa de uma conexão JDBC aqui

	public FazDAO(Connection connection) {
		this.connection = connection;
	}

	public FazDAO() {
		try {
			conexao = Conexao.conectar();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void adicionarRelacaoClienteCompra(int idCliente, int idCompraPassagem) {
		String sql = "INSERT INTO Faz (Id_Cliente, Id_Compra_Passagem) VALUES (?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, idCliente);
			preparedStatement.setInt(2, idCompraPassagem);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

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

	// Outros métodos para consultar, atualizar ou excluir relações, se necessário
}