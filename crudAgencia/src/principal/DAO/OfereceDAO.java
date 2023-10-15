package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import principal.Conexao;

public class OfereceDAO {

	private Connection conexao;
	private Connection connection; // Você precisa de uma conexão JDBC aqui

	public OfereceDAO(Connection connection) {
		this.connection = connection;
	}
	
	public OfereceDAO() {
		try {
			conexao = Conexao.conectar();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void adicionarOferta(int idAgencia, int idPromocao) {
		String sql = "INSERT INTO Oferece (Id_Agencia, Id_Promoção) VALUES (?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, idAgencia);
			preparedStatement.setInt(2, idPromocao);

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
}