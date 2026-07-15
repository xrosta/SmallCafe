package PadariaBL.SubGestProdutos;

public class Ingrediente {
	private static int proximoID = 1;
	private int id;
	private int quantidade;
	private String nome;
	private int avisoNivel;

	public Ingrediente(Ingrediente i) {
		this.id = i.getID();
		this.quantidade = i.getQuantidade();
		this.nome = i.getNome();
		this.avisoNivel = i.avisoNivel;
	}

	public Ingrediente(int qtd, String nome, int minimo) {
		this.id = proximoID++;
		this.quantidade = qtd;
		this.nome = nome;
		this.avisoNivel = minimo;
	}

	public void setQuantidade(int qtd) {
		this.quantidade = qtd;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getID() {
		return this.id;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void consumir(int qtd) {
		if (qtd <= 0)
			return;
		this.quantidade -= qtd;
	}

	public boolean abaixoNivel() {
		return this.quantidade <= this.avisoNivel;
	}

	public boolean qtdSuficiente(int qtd) {
		return this.quantidade >= qtd;
	}
}