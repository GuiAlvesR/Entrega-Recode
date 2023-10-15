package principal;

public class Usuario {

	private int idUsuario;
	private String nome;
	private String login;
	private int senha;
	private String permissaoDeAcesso;

	public Usuario(int idUsuario, String nome, String login, int senha, String permissaoDeAcesso) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.permissaoDeAcesso = permissaoDeAcesso;
	}

	public Usuario() {
		super();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getPermissaoDeAcesso() {
		return permissaoDeAcesso;
	}

	public void setPermissaoDeAcesso(String permissaoDeAcesso) {
		this.permissaoDeAcesso = permissaoDeAcesso;
	}

}
