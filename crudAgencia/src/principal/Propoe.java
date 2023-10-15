package principal;

public class Propoe {
	private Agencia agencia;
	private Destinos destino;

	public Propoe() {
		super();

	}

	public Propoe(Agencia agencia, Destinos destino) {
		super();
		this.agencia = agencia;
		this.destino = destino;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Destinos getDestino() {
		return destino;
	}

	public void setDestino(Destinos destino) {
		this.destino = destino;
	}

}
