package PadariaBL.SubGestProdutos;

import java.util.Vector;
import PadariaBL.SubGestProdutos.Produto;
import PadariaBL.SubGestProdutos.Ingrediente;

public class GestProdutosFacade implements IGestProdutos {
	public Vector<Produto> _produtos = new Vector<Produto>();
	public Vector<Ingrediente> _stock = new Vector<Ingrediente>();

	public GestProdutosFacade() {
		throw new UnsupportedOperationException();
	}

	private Produto getProduto(int aId) {
		throw new UnsupportedOperationException();
	}

	private Ingrediente getIngrediente(int aId) {
		throw new UnsupportedOperationException();
	}

	public Map<Integer, Produto> listarProdutos() {
		throw new UnsupportedOperationException();
	}

	public String descontarStock(Map<int, int> aConsumos) {
		throw new UnsupportedOperationException();
	}

	public List<Ingrediente> listarStock() {
		throw new UnsupportedOperationException();
	}

	public List<String> avisosStock() {
		throw new UnsupportedOperationException();
	}

	public void carregarDados() {
		throw new UnsupportedOperationException();
	}
}