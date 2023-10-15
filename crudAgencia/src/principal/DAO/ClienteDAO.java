package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Cliente;

public class ClienteDAO {
	private Connection conexao;
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	AgenciaDAO agenciaDAO = new AgenciaDAO();
	
	public ClienteDAO() {
		try {
			conexao = Conexao.conectar();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void criarCliente(Cliente cliente) {

		String sql = "INSERT INTO Cliente (Nome, Email, Telefone, Endereço, Id_Usuario, Id_Agencia) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setInt(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEndereco());
			
			if (cliente.getUsuario() != null) {
	            stmt.setInt(5, cliente.getUsuario().getIdUsuario());
	        } else {
	            stmt.setNull(5, Types.INTEGER); 
	        }

	        if (cliente.getAgencia() != null) {
	            stmt.setInt(6, cliente.getAgencia().getIdAgencia());
	        } else {
	            stmt.setNull(6, Types.INTEGER); 
	        }
			
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	  public void atualizarCliente(Cliente cliente) {

	        String sql = "UPDATE Cliente SET Nome = ?, Email = ?, Telefone = ?, Endereço = ? Id_Usuario = ? Id_Agencia = ? WHERE Id_Cliente = ?";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	        	stmt.setString(1, cliente.getNome());
				stmt.setString(2, cliente.getEmail());
				stmt.setInt(3, cliente.getTelefone());
				stmt.setString(4, cliente.getEndereco());
				stmt.setInt(5, cliente.getUsuario().getIdUsuario());
				stmt.setInt(6, cliente.getAgencia().getIdAgencia());			
	            stmt.setInt(7, cliente.getidCliente());

	            stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
	
	 public List<Cliente> listarClientes() {

	        List<Cliente> Clientes = new ArrayList<>();

	        String sql = "SELECT * FROM Cliente";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            ResultSet resultado = stmt.executeQuery();

	            while (resultado.next()) {
	            	Cliente cliente = new Cliente();
	            	cliente.setidCliente(resultado.getInt("Id_Cliente"));
	            	cliente.setNome(resultado.getString("Nome"));
	            	cliente.setEmail(resultado.getString("Email"));
	            	cliente.setTelefone(resultado.getInt("Telefone"));
	            	cliente.setEndereco(resultado.getString("Endereço"));
	            	cliente.setUsuario(usuarioDAO.buscarUsuario(resultado.getInt("Id_Usuario")));
	            	cliente.setAgencia(agenciaDAO.buscarAgencia(resultado.getInt("Id_Agencia")));
	                
	                Clientes.add(cliente);
	                
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Clientes;
	    } 
	 
	 public Cliente buscarCliente(int id) {

		 Cliente cliente = null;

	        String sql = "SELECT * FROM Cliente WHERE Id_Cliente = ?";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, id);

	            ResultSet resultado = stmt.executeQuery();

	            if (resultado.next()) {

	            	cliente = new Cliente();
	            	cliente.setidCliente(resultado.getInt("Id_Cliente"));
	            	cliente.setNome(resultado.getString("Nome"));
	            	cliente.setEmail(resultado.getString("Email"));
	            	cliente.setTelefone(resultado.getInt("Telefone"));
	            	cliente.setEndereco(resultado.getString("Endereço"));
	            	cliente.setUsuario(usuarioDAO.buscarUsuario(resultado.getInt("Id_Usuario")));
	            	cliente.setAgencia(agenciaDAO.buscarAgencia(resultado.getInt("Id_Agencia")));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return cliente;

	    }
	
	 public void excluirCliente(int id) {

	        String sql = "DELETE FROM Cliente WHERE Id_Cliente = ?";

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
