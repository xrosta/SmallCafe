package PadariaBL.SubGestPedidos;

import PadariaBL.SubGestProdutos.Produto;
import java.util.HashMap;
import java.util.Map;

public class LinhaProduto {
	private int quantidade;
	public Produto produto;

	public LinhaProduto() {
		this.quantidade = 0;
		this.produto = null;
	}

	public LinhaProduto(LinhaProduto l) {
		this.quantidade = l.quantidade;
		this.produto = l.produto;
	}

	public LinhaProduto(Produto p, int qtd) {
		this.produto = p;
		this.quantidade = qtd;
	}

	public void setProduto(Produto p) {
		this.produto = p;
	}

	public void setQuantidade(int qtd) {
		this.quantidade = qtd;
	}

	public String getNomeProduto() {
		return this.produto == null ? null : this.produto.getNome();
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public float getTotalLinha() {
		return this.produto == null ? 0 : this.produto.getPreco() * this.quantidade;
	}

	public Map<Integer, Integer> getConsumo() {
		Map<Integer, Integer> consumo = new HashMap<>();
		if (this.produto != null) {
			Map<Integer, Integer> prodCons = this.produto.getConsumo();
			for (Integer k : prodCons.keySet()) {
				consumo.put(k, prodCons.get(k) * this.quantidade);
			}
		}
		return consumo;
	}
}