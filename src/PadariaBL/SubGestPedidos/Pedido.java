package PadariaBL.SubGestPedidos;

import java.util.Vector;
import PadariaBL.SubGestPedidos.LinhaProduto;
import PadariaBL.SubGestProdutos.Produto;

public class Pedido {
	private static int _proximoID = 1;
	private int _id;
	private LocalDate _data;
	private float _total = 0;
	public Vector<LinhaProduto> _itens = new Vector<LinhaProduto>();
	public Estado _estado;

	public Pedido() {
		throw new UnsupportedOperationException();
	}

	public Pedido(Pedido aP) {
		throw new UnsupportedOperationException();
	}

	public void setTotal(float aTotal) {
		this._total = aTotal;
	}

	public void adicionarItem(Produto aProd, int aQtd) {
		throw new UnsupportedOperationException();
	}

	public int getID() {
		throw new UnsupportedOperationException();
	}

	public LocalDate getData() {
		return this._data;
	}

	public float getTotal() {
		return this._total;
	}

	public Estado getEstado() {
		return this._estado;
	}

	public List<LinhaProduto> getItens() {
		throw new UnsupportedOperationException();
	}

	public boolean avancarEstado() {
		throw new UnsupportedOperationException();
	}

	public boolean cancelar() {
		throw new UnsupportedOperationException();
	}

	public Map<Integer, Integer> calculaConsumo() {
		throw new UnsupportedOperationException();
	}
}