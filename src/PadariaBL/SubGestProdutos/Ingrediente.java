package PadariaBL.SubGestProdutos;

public class Ingrediente {
	private int _id;
	private int _quantidade;
	private String _nome;
	private int _avisoNivel;

	public Ingrediente(Ingrediente aI) {
		throw new UnsupportedOperationException();
	}

	public Ingrediente(int aQtd, String aNome, int aMinimo) {
		throw new UnsupportedOperationException();
	}

	public void setQuantidade(int aQtd) {
		this._quantidade = aQtd;
	}

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public int getID() {
		throw new UnsupportedOperationException();
	}

	public int getQuantidade() {
		return this._quantidade;
	}

	public String getNome() {
		return this._nome;
	}

	public void consumir(int aQtd) {
		throw new UnsupportedOperationException();
	}

	public boolean abaixoNivel() {
		throw new UnsupportedOperationException();
	}

	public boolean qtdSuficiente(int aQtd) {
		throw new UnsupportedOperationException();
	}
}