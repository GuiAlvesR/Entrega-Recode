package principal;

public class Faz {

	private Cliente cliente;
	private CompraPassagem pedidos;

	public Faz() {
		super();
	}

	public Faz(Cliente cliente, CompraPassagem pedidos) {
		super();
		this.cliente = cliente;
		this.pedidos = pedidos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public CompraPassagem getPedidos() {
		return pedidos;
	}

	public void setPedidos(CompraPassagem pedidos) {
		this.pedidos = pedidos;
	}
}
