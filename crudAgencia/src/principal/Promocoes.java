package principal;

import java.util.Date;

public class Promocoes {

	private int idPromocao;
	private String nome;
	private String descricao;
	private int precoPromocional;
	private Date dataDeInicio;
	private Date dataDeTermino;
	private Destinos destinos;

	public Promocoes(int idPromocao, String nome, String descricao, int precoPromocional, Date dataDeInicio,
			Date dataDeTermino, Destinos destinos) {
		super();
		this.idPromocao = idPromocao;
		this.nome = nome;
		this.descricao = descricao;
		this.precoPromocional = precoPromocional;
		this.dataDeInicio = dataDeInicio;
		this.dataDeTermino = dataDeTermino;
		this.destinos = destinos;
	}

	public Promocoes() {
		super();
	}

	public int getIdPromocao() {
		return idPromocao;
	}

	public void setIdPromocao(int idPromocao) {
		this.idPromocao = idPromocao;
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

	public int getPrecoPromocional() {
		return precoPromocional;
	}

	public void setPrecoPromocional(int precoPromocional) {
		this.precoPromocional = precoPromocional;
	}

	public Date getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public Date getDataDeTermino() {
		return dataDeTermino;
	}

	public void setDataDeTermino(Date dataDeTermino) {
		this.dataDeTermino = dataDeTermino;
	}

	public Destinos getDestinos() {
		return destinos;
	}

	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}
}
