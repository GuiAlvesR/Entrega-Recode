package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Destinos;

public class DestinosDAO {

	private Connection conexao;

	public DestinosDAO() {
		try {
			conexao = Conexao.conectar();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void criarDestinos(Destinos destinos) {

		String sql = "INSERT INTO Destinos (Nome, Descrição, Preço) VALUES (?, ?, ?)";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, destinos.getNome());
			stmt.setString(2, destinos.getDescricao());
			stmt.setDouble(3, destinos.getPreco());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualizarDestinos(Destinos destinos) {

		String sql = "UPDATE Destinos SET Nome = ?, Descrição = ?, Preço = ? WHERE Id_Destino = ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

			stmt.setString(1, destinos.getNome());
			stmt.setString(2, destinos.getDescricao());
			stmt.setDouble(3, destinos.getPreco());
			stmt.setInt(4, destinos.getIdDestino());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Destinos> listarDestinos() {

		List<Destinos> Destinos = new ArrayList<>();

		String sql = "SELECT * FROM Destinos";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				Destinos destino = new Destinos();
				destino.setIdDestino(resultado.getInt("Id_Destino"));
				destino.setNome(resultado.getString("Nome"));
				destino.setDescricao(resultado.getString("Descrição"));
				destino.setPreco(resultado.getDouble("Preço"));

				Destinos.add(destino);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Destinos;
	}

	public Destinos buscarDestino(int id) {

		Destinos destino = null;

		String sql = "SELECT * FROM Destinos WHERE Id_Destino = ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);

			ResultSet resultado = stmt.executeQuery();

			if (resultado.next()) {

				destino = new Destinos();
				destino.setIdDestino(resultado.getInt("Id_Destino"));
				destino.setNome(resultado.getString("Nome"));
				destino.setDescricao(resultado.getString("Descrição"));
				destino.setPreco(resultado.getDouble("Preço"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return destino;

	}

	public void excluirDestino(int id) {

		String sql = "DELETE FROM Destinos WHERE Id_Destino = ?";

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
