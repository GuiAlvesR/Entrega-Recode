package principal;

public class Oferece {

	private Agencia agencia;
	private Promocoes promocao;

	public Oferece() {
		super();
		
	}

	public Oferece(Agencia agencia, Promocoes promocao) {
		super();
		this.agencia = agencia;
		this.promocao = promocao;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Promocoes getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocoes promocao) {
		this.promocao = promocao;
	}
}
