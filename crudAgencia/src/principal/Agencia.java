package principal;

public class Agencia {
	
	private int Id_Agencia;
	private String nome;
	private String descricao;
	
	public Agencia(int idAgencia, String nome, String descricao) {
		super();
		this.Id_Agencia = idAgencia;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Agencia() {
		super();
	
	}

	public int getIdAgencia() {
		return Id_Agencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.Id_Agencia = idAgencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
