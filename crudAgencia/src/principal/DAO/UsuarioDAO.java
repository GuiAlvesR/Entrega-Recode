package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Usuario;

public class UsuarioDAO {

	private Connection conexao;

	public UsuarioDAO() {
		try {
			conexao = Conexao.conectar();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

	public void criarUsuario(Usuario usuario) {

		String sql = "INSERT INTO Usuario (Nome, Login, Senha, PermissõesdeAcesso) VALUES (?, ?, ?, ?)";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setInt(3, usuario.getSenha());
			stmt.setString(4, usuario.getPermissaoDeAcesso());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualizarUsuario(Usuario usuario) {

		String sql = "UPDATE Usuario SET Nome = ?, Login = ?, Senha = ?, PermissõesdeAcesso = ? WHERE Id_Usuario = ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setInt(3, usuario.getSenha());
			stmt.setString(4, usuario.getPermissaoDeAcesso());
			stmt.setInt(5, usuario.getIdUsuario());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Usuario> listarUsuarios() {

		List<Usuario> Usuarios = new ArrayList<>();

		String sql = "SELECT * FROM Usuario";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(resultado.getInt("Id_Usuario"));
				usuario.setNome(resultado.getString("Nome"));
				usuario.setLogin(resultado.getString("Login"));
				usuario.setSenha(resultado.getInt("Senha"));
				usuario.setPermissaoDeAcesso(resultado.getString("PermissõesdeAcesso"));

				Usuarios.add(usuario);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Usuarios;
	}

	public Usuario buscarUsuario(int id) {

		Usuario usuario = null;

		String sql = "SELECT * FROM Usuario WHERE Id_Usuario = ?";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);

			ResultSet resultado = stmt.executeQuery();

			if (resultado.next()) {

				usuario = new Usuario();
				usuario.setIdUsuario(resultado.getInt("Id_Usuario"));
				usuario.setNome(resultado.getString("Nome"));
				usuario.setLogin(resultado.getString("Login"));
				usuario.setSenha(resultado.getInt("Senha"));
				usuario.setPermissaoDeAcesso(resultado.getString("PermissõesdeAcesso"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;

	}

	public void excluirUsuario(int id) {

		String sql = "DELETE FROM Usuario WHERE Id_Usuario = ?";

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
