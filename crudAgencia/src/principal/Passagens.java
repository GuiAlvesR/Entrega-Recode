package principal;

import java.util.Date;

public class Passagens {

	private int idPassagem;
	private double precoPassagem;
	private int numeroDeVoo;
	private Date dataDePartida;
	private Date dataDeRetorno;

	public Passagens() {
		super();

	}

	public Passagens(int idPassagem, double precoPassagem, int numeroDeVoo, Date dataDePartida, Date dataDeRetorno) {
		super();
		this.idPassagem = idPassagem;
		this.precoPassagem = precoPassagem;
		this.numeroDeVoo = numeroDeVoo;
		this.dataDePartida = dataDePartida;
		this.dataDeRetorno = dataDeRetorno;
	}

	public int getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(int idPassagem) {
		this.idPassagem = idPassagem;
	}

	public double getPrecoPassagem() {
		return precoPassagem;
	}

	public void setPrecoPassagem(double precoPassagem) {
		this.precoPassagem = precoPassagem;
	}

	public int getNumeroDeVoo() {
		return numeroDeVoo;
	}

	public void setNumeroDeVoo(int numeroDeVoo) {
		this.numeroDeVoo = numeroDeVoo;
	}

	public Date getDataDePartida() {
		return dataDePartida;
	}

	public void setDataDePartida(Date dataDePartida) {
		this.dataDePartida = dataDePartida;
	}

	public Date getDataDeRetorno() {
		return dataDeRetorno;
	}

	public void setDataDeRetorno(Date dataDeRetorno) {
		this.dataDeRetorno = dataDeRetorno;
	}

}
