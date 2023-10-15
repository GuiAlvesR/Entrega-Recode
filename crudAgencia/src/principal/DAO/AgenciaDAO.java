package principal.DAO;

import principal.Conexao;
import principal.Agencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO {

	private Connection conexao;

	public AgenciaDAO() {

		try {
			conexao = Conexao.conectar();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void criarAgencia(Agencia agencia) {

		String sql = "INSERT INTO Agencia (Nome, Descrição) VALUES (?, ?)";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, agencia.getNome());
			stmt.setString(2, agencia.getDescricao());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualizarAgencia(Agencia agencia) {

		String sql = "UPDATE Agencia SET Nome = ?, Descrição = ? WHERE Id_Agencia = ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

			stmt.setString(1, agencia.getNome());
			stmt.setString(2, agencia.getDescricao());
			stmt.setInt(3, agencia.getIdAgencia());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Agencia> mostrarAgencia() {

		List<Agencia> Agencia = new ArrayList<>();

		String sql = "SELECT * FROM Agencia";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				Agencia agencia = new Agencia();
				agencia.setIdAgencia(resultado.getInt("Id_Agencia"));
				agencia.setNome(resultado.getString("Nome"));
				agencia.setDescricao(resultado.getString("Descrição"));

				Agencia.add(agencia);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Agencia;
	}

	public Agencia buscarAgencia(int id) {

		Agencia agencia = null;

		String sql = "SELECT * FROM Agencia WHERE Id_Agencia = ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);

			ResultSet resultado = stmt.executeQuery();

			if (resultado.next()) {

				agencia = new Agencia();
				agencia.setIdAgencia(resultado.getInt("Id_Agencia"));
				agencia.setNome(resultado.getString("Nome"));
				agencia.setDescricao(resultado.getString("Descrição"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return agencia;

	}

	public void excluirAgencia(int id) {

		String sql = "DELETE FROM Agencia WHERE Id_Agencia = ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();

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
