package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.CompraPassagem;

public class CompraPassagemDAO {

	private Connection conexao;

	PassagensDAO passagensDAO = new PassagensDAO();

	public CompraPassagemDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void criarCompraPassagem(CompraPassagem compra) {
		String sql = "INSERT INTO Compra_de_Passagem (Data_da_Compra, Valor_Pago, Status, Id_Passagem) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setTimestamp(1, new java.sql.Timestamp(compra.getDataDaCompra().getTime()));
			stmt.setDouble(2, compra.getValorPago());
			stmt.setString(3, compra.getStatus());
			stmt.setInt(4, compra.getPassagem().getIdPassagem());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<CompraPassagem> listarCompras() {
		List<CompraPassagem> comprasDaPassagem = new ArrayList<>();
		String sql = "SELECT * FROM Compra_de_Passagem";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				CompraPassagem compras = new CompraPassagem();
				compras.setIdCompraPassagem(resultado.getInt("Id_Compra_Passagem"));
				compras.setDataDaCompra(resultado.getTimestamp("Data_da_Compra"));
				compras.setValorPago(resultado.getDouble("Valor_Pago"));
				compras.setStatus(resultado.getString("Status"));
				compras.setPassagem(passagensDAO.buscarPassagens(resultado.getInt("Id_Passagem")));
				comprasDaPassagem.add(compras);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comprasDaPassagem;
	}

	
	public CompraPassagem buscarCompra(int id) {
		CompraPassagem comprasDaPassagem = null;
		String sql = "SELECT * FROM Compra_de_Passagem WHERE Id_Compra_Passagem = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				comprasDaPassagem = new CompraPassagem();
				comprasDaPassagem.setIdCompraPassagem(resultado.getInt("Id_Compra_Passagem"));
				comprasDaPassagem.setDataDaCompra(resultado.getTimestamp("Data_da_Compra"));
				comprasDaPassagem.setValorPago(resultado.getInt("Valor_Pago"));
				comprasDaPassagem.setStatus(resultado.getString("Status"));
				comprasDaPassagem.setPassagem(passagensDAO.buscarPassagens(resultado.getInt("Id_Passagem")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comprasDaPassagem;
	}

	public void atualizarCompra(CompraPassagem compra) {
		String sql = "UPDATE Compra_de_Passagem SET Data_da_Compra = ?, Valor_Pago = ? , Status = ?, Id_Passagem = ? WHERE Id_Compra_Passagem = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setTimestamp(1, new java.sql.Timestamp(compra.getDataDaCompra().getTime()));
			stmt.setDouble(2, compra.getValorPago());
			stmt.setString(3, compra.getStatus());
			stmt.setInt(4, compra.getPassagem().getIdPassagem());
			stmt.setInt(5, compra.getIdCompraPassagem());
			stmt.setInt(6, compra.getPassagem().getIdPassagem());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirPromocao(int id) {
		String sql = "DELETE FROM Compra_de_Passagem WHERE Id_Compra_Passagem = ?";
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
