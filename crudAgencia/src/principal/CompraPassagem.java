package principal;

import java.util.Date;

public class CompraPassagem {

	private int idCompraPassagem;
	private Date dataDaCompra;
	private double valorPago;
	private String status;
	private Passagens passagem;

	public CompraPassagem() {
		super();

	}

	public CompraPassagem(int idCompraPassagem, Date dataDaCompra, double valorPago, String status, Passagens passagem) {
		super();
		this.idCompraPassagem = idCompraPassagem;
		this.dataDaCompra = dataDaCompra;
		this.valorPago = valorPago;
		this.status = status;
		this.passagem = passagem;
	}

	public int getIdCompraPassagem() {
		return idCompraPassagem;
	}

	public void setIdCompraPassagem(int idCompraPassagem) {
		this.idCompraPassagem = idCompraPassagem;
	}

	public Date getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(Date dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Passagens getPassagem() {
		return passagem;
	}

	public void setPassagem(Passagens passagem) {
		this.passagem = passagem;
	}

}
