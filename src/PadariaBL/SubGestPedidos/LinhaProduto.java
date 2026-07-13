package PadariaBL.SubGestPedidos;

import PadariaBL.SubGestProdutos.Produto;

public class LinhaProduto {
	private int _quantidade;
	public Produto _produto;

	public LinhaProduto() {
		throw new UnsupportedOperationException();
	}

	public LinhaProduto(LinhaProduto aL) {
		throw new UnsupportedOperationException();
	}

	public LinhaProduto(Produto aP, int aQtd) {
		throw new UnsupportedOperationException();
	}

	public void setProduto(Produto aP) {
		this._produto = aP;
	}

	public soid setQuantidade(int aQtd) {
		throw new UnsupportedOperationException();
	}

	public String getNomeProduto() {
		throw new UnsupportedOperationException();
	}

	public int getQuantidade() {
		return this._quantidade;
	}

	public float getTotalLinha() {
		throw new UnsupportedOperationException();
	}

	public Map<Integer, Integer> getConsumo() {
		throw new UnsupportedOperationException();
	}
}