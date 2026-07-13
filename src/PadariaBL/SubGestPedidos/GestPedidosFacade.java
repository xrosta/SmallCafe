package PadariaBL.SubGestPedidos;

import java.util.Vector;
import PadariaBL.SubGestPedidos.Pedido;
import PadariaBL.SubGestProdutos.Produto;

public class GestPedidosFacade implements IGestPedidos {
	public Vector<Pedido> _pedidos = new Vector<Pedido>();

	public GestPedidosFacade() {
		throw new UnsupportedOperationException();
	}

	private Pedido getPedido(int aId) {
		throw new UnsupportedOperationException();
	}

	public int iniciarPedido() {
		throw new UnsupportedOperationException();
	}

	public String adicionarItemPedido(int aIdPedido, Produto aItem, int aQtd) {
		throw new UnsupportedOperationException();
	}

	public Map<Integer, Integer> calculaConsumo(int aIdPedido) {
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

	public String avancarEstadoPedido(int aIdPedido) {
		throw new UnsupportedOperationException();
	}

	public int contarPedidos(LocalDate aIncicio, LocalDate aFim) {
		throw new UnsupportedOperationException();
	}

	public float calcularTotalVendido(LocalDate aInicio, LocalDate aFim) {
		throw new UnsupportedOperationException();
	}

	public Map<String, Integer> produtosMaisVendidos(LocalDate aInicio, LocalDate aFim) {
		throw new UnsupportedOperationException();
	}
}