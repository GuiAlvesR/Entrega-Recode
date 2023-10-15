package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Passagens;

public class PassagensDAO {
	private Connection conexao;

	public PassagensDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void criarPassagem(Passagens passagem) {
		String sql = "INSERT INTO Passagem (DatadaPartida, DatadeRetorno, Preço_Passagem, NumerodeVoo) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {	
			stmt.setTimestamp(1, new java.sql.Timestamp(passagem.getDataDePartida().getTime()));
			stmt.setTimestamp(2, new java.sql.Timestamp(passagem.getDataDeRetorno().getTime()));
			stmt.setDouble(3, passagem.getPrecoPassagem());
			stmt.setInt(4, passagem.getNumeroDeVoo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Passagens> listarPassagens() {
		List<Passagens> passagens = new ArrayList<>();
		String sql = "SELECT * FROM Passagem";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Passagens passagem = new Passagens();
				passagem.setIdPassagem(resultado.getInt("Id_Passagem"));
				passagem.setDataDePartida(resultado.getTimestamp("DatadaPartida"));
				passagem.setDataDeRetorno(resultado.getTimestamp("DatadeRetorno"));
				passagem.setPrecoPassagem(resultado.getDouble("Preço_Passagem"));
				passagem.setNumeroDeVoo(resultado.getInt("NumerodeVoo"));
				passagens.add(passagem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passagens;
	}

	public Passagens buscarPassagens(int id) {
		Passagens passagem = null;
		String sql = "SELECT * FROM Passagem WHERE Id_Passagem = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				passagem = new Passagens();
				passagem.setIdPassagem(resultado.getInt("Id_Passagem"));
				passagem.setDataDePartida(resultado.getTimestamp("DatadaPartida"));
				passagem.setDataDeRetorno(resultado.getTimestamp("DatadeRetorno"));
				passagem.setPrecoPassagem(resultado.getDouble("Preço_Passagem"));
				passagem.setNumeroDeVoo(resultado.getInt("NumerodeVoo"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passagem;
	}

	public void atualizarPassagem(Passagens passagem) {
		String sql = "UPDATE Passagem SET DatadaPartida = ? , DatadeRetorno = ?, Preço_Passagem = ?, NumerodeVoo = ? WHERE Id_Passagem = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			
			stmt.setTimestamp(1, new java.sql.Timestamp(passagem.getDataDePartida().getTime()));
			stmt.setTimestamp(2, new java.sql.Timestamp(passagem.getDataDeRetorno().getTime()));
			stmt.setDouble(3, passagem.getPrecoPassagem());
			stmt.setInt(4, passagem.getNumeroDeVoo());
			stmt.setInt(5, passagem.getIdPassagem());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirPassagem(int id) {
		String sql = "DELETE FROM Passagem WHERE Id_Passagem = ?";
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
