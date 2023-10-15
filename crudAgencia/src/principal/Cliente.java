package principal;

public class Cliente extends Usuario {

	private int idCliente;
	private String nome;
	private String email;
	private int telefone;
	private String endereco;
	private Agencia agencia;
	private Usuario usuario;

	public Cliente(int idCliente, String nome, String email, int telefone, String endereco, Agencia agencia,
			Usuario usuario) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.agencia = agencia;
		this.usuario = usuario;
	}

	public Cliente() {
		super();

	}

	public int getidCliente() {
		return idCliente;
	}

	public void setidCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
