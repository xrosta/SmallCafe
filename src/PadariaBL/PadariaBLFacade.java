package PadariaBL;

import PadariaBL.SubGestPedidos.IGestPedidos;
import PadariaBL.SubGestProdutos.IGestProdutos;
import PadariaBL.SubGestProdutos.Produto;
import PadariaBL.SubGestPedidos.Pedido;
import PadariaBL.SubGestProdutos.Ingrediente;

public class PadariaBLFacade implements IPadariaBL {
	public IGestPedidos _gestPedidos;
	public IGestProdutos _gestProdutos;

	public PadariaBLFacade() {
		throw new UnsupportedOperationException();
	}

	public int iniciarPedido() {
		throw new UnsupportedOperationException();
	}

	public Map<Integer, Produto> listarProdutos() {
		throw new UnsupportedOperationException();
	}

	public String adicionarItemPedido(int aIdPedido, Produto aItem, int aQtd) {
		throw new UnsupportedOperationException();
	}

	public String finalizarPedido(int aIdPedido) {
		throw new UnsupportedOperationException();
	}

	public String cancelarPedido(int aIdPedido) {
		throw new UnsupportedOperationException();
	}

	public List<Pedido> listarPedidos() {
		throw new UnsupportedOperationException();
	}

	public List<Pedido> listarPedidosPendentes() {
		throw new UnsupportedOperationException();
	}

	public List<String> avisosStock() {
		throw new UnsupportedOperationException();
	}

	public List<Ingrediente> listarStock() {
		throw new UnsupportedOperationException();
	}

	public String avancarEstadoPedido(int aIdPedido) {
		throw new UnsupportedOperationException();
	}

	public int getNumeroPedidos(LocalDate aIncicio, LocalDate aFim) {
		throw new UnsupportedOperationException();
	}

	public float getTotalVendido(LocalDate aInicio, LocalDate aFim) {
		throw new UnsupportedOperationException();
	}

	public Map<String, Integer> getProdutosMaisVendidos(LocalDate aInicio, LocalDate aFim) {
		throw new UnsupportedOperationException();
	}
}