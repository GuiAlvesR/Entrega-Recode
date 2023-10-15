package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Promocoes;

public class PromocoesDAO {
	private Connection conexao;

	DestinosDAO destinosDAO = new DestinosDAO();

	public PromocoesDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void criarPromocoes(Promocoes promocoes) {
		String sql = "INSERT INTO Promo�oes (Nome, Descri��o, Pre�o_Promocional, DatadeInicio, DatadeT�rmino, Id_Destino) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, promocoes.getNome());
			stmt.setString(2, promocoes.getDescricao());
			stmt.setInt(3, promocoes.getPrecoPromocional());
			stmt.setTimestamp(4, new java.sql.Timestamp(promocoes.getDataDeInicio().getTime()));
			stmt.setTimestamp(5, new java.sql.Timestamp(promocoes.getDataDeTermino().getTime()));
			stmt.setInt(6, promocoes.getDestinos().getIdDestino());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Promocoes> listarPromocoes() {
		List<Promocoes> promocoes = new ArrayList<>();
		String sql = "SELECT * FROM Promo�oes";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Promocoes promocao = new Promocoes();
				promocao.setIdPromocao(resultado.getInt("Id_Promo��o"));
				promocao.setNome(resultado.getString("Nome"));
				promocao.setDescricao(resultado.getString("Descri��o"));
				promocao.setPrecoPromocional(resultado.getInt("Pre�o_Promocional"));
				promocao.setDataDeInicio(resultado.getTimestamp("DatadeInicio"));
				promocao.setDataDeTermino(resultado.getTimestamp("DatadeT�rmino"));
				promocao.setDestinos(destinosDAO.buscarDestino(resultado.getInt("Id_Destino")));
				promocoes.add(promocao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return promocoes;
	}

	public Promocoes buscarPromocao(int id) {
		Promocoes promocao = null;
		String sql = "SELECT * FROM Promo�oes WHERE Id_Promo��o = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				promocao = new Promocoes();
				promocao.setIdPromocao(resultado.getInt("Id_Promo��o"));
				promocao.setNome(resultado.getString("Nome"));
				promocao.setDescricao(resultado.getString("Descri��o"));
				promocao.setPrecoPromocional(resultado.getInt("Pre�o_Promocional"));
				promocao.setDataDeInicio(resultado.getTimestamp("DatadeInicio"));
				promocao.setDataDeTermino(resultado.getTimestamp("DatadeT�rmino"));
				promocao.setDestinos(destinosDAO.buscarDestino(resultado.getInt("Id_Destino")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return promocao;
	}

	public void atualizarPromocao(Promocoes promocoes) {
		String sql = "UPDATE Promo�oes SET Nome = ?, Descri��o = ? , Pre�o_Promocional = ?, DatadeInicio = ?, DatadeT�rmino = ?, Id_Destino = ? WHERE Id_Promo��o = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, promocoes.getNome());
			stmt.setString(2, promocoes.getDescricao());
			stmt.setInt(3, promocoes.getPrecoPromocional());
			stmt.setTimestamp(4, new java.sql.Timestamp(promocoes.getDataDeInicio().getTime()));
			stmt.setTimestamp(5, new java.sql.Timestamp(promocoes.getDataDeTermino().getTime()));
			stmt.setInt(6, promocoes.getDestinos().getIdDestino());
			stmt.setInt(7, promocoes.getIdPromocao());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirPromocao(int id) {
		String sql = "DELETE FROM Promo�oes WHERE Id_Promo��o = ?";
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
