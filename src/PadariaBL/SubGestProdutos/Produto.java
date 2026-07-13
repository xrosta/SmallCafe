package PadariaBL.SubGestProdutos;

import java.util.Vector;
import PadariaBL.SubGestProdutos.Ingrediente;

public class Produto {
	private int _id;
	private String _nome;
	private float _preco;
	private int _estimativaPreparacao;
	private List<String> _notas;
	public Vector<Ingrediente> _composicao = new Vector<Ingrediente>();
	public Vector<Ingrediente> _extras = new Vector<Ingrediente>();

	public Produto(Produto aP) {
		throw new UnsupportedOperationException();
	}

	public Produto(String aNome, float aPreco, int aEstimativa, List<String> aNotas, List<Ingrediente> aExtras) {
		throw new UnsupportedOperationException();
	}

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public void setPreco(float aPreco) {
		this._preco = aPreco;
	}

	public void setEstimativaPreparacao(int aEstimativaPreparacao) {
		this._estimativaPreparacao = aEstimativaPreparacao;
	}

	public void setNotas(List<String> aNotas) {
		throw new UnsupportedOperationException();
	}

	public void setExtras(List<Ingrediente> aExtras) {
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return this._id;
	}

	public String getNome() {
		return this._nome;
	}

	public float getPreco() {
		return this._preco;
	}

	public int getEstimativaPreparacao() {
		return this._estimativaPreparacao;
	}

	public List<String> getNotas() {
		return this._notas;
	}

	public List<Ingrediente> getExtras() {
		throw new UnsupportedOperationException();
	}

	public List<Ingrediente> getComposicao() {
		throw new UnsupportedOperationException();
	}

	public Map<Integer, Integer> getConsumo() {
		throw new UnsupportedOperationException();
	}
}