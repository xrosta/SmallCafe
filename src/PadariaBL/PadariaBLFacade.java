package PadariaBL;

import PadariaBL.SubGestPedidos.IGestPedidos;
import PadariaBL.SubGestProdutos.IGestProdutos;
import PadariaBL.SubGestProdutos.Produto;
import PadariaBL.SubGestPedidos.Pedido;
import PadariaBL.SubGestProdutos.Ingrediente;
import PadariaBL.SubGestPedidos.GestPedidosFacade;
import PadariaBL.SubGestProdutos.GestProdutosFacade;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class PadariaBLFacade implements IPadariaBL {
	public IGestPedidos gestPedidos;
	public IGestProdutos gestProdutos;

	public PadariaBLFacade() {
		this.gestProdutos = new GestProdutosFacade();
		this.gestPedidos = new GestPedidosFacade();
	}

	public int iniciarPedido() {
		return this.gestPedidos.iniciarPedido();
	}

	public Map<Integer, Produto> listarProdutos() {
		return this.gestProdutos.listarProdutos();
	}

	public String adicionarItemPedido(int idPedido, Produto item, int qtd) {
		return this.gestPedidos.adicionarItemPedido(idPedido, item, qtd);
	}

	public String finalizarPedido(int idPedido) {
		Map<Integer, Integer> cons = this.gestPedidos.calculaConsumo(idPedido);
		if (cons == null)
			return "Pedido nao existe";
		String res = this.gestProdutos.descontarStock(cons);
		if (res != null) {
			this.gestPedidos.cancelarPedido(idPedido);
			return "Sem stock suficiente. Pedido cancelado.";
		}
		return this.gestPedidos.finalizarPedido(idPedido);
	}

	public String cancelarPedido(int idPedido) {
		return this.gestPedidos.cancelarPedido(idPedido);
	}

	public List<Pedido> listarPedidos() {
		return this.gestPedidos.listarPedidos();
	}

	public List<Pedido> listarPedidosPendentes() {
		return this.gestPedidos.listarPedidosPendentes();
	}

	public List<String> avisosStock() {
		return this.gestProdutos.avisosStock();
	}

	public List<Ingrediente> listarStock() {
		return this.gestProdutos.listarStock();
	}

	public String avancarEstadoPedido(int idPedido) {
		return this.gestPedidos.avancarEstadoPedido(idPedido);
	}

	public int getNumeroPedidos(LocalDate incicio, LocalDate fim) {
		return this.gestPedidos.contarPedidos(incicio, fim);
	}

	public float getTotalVendido(LocalDate inicio, LocalDate fim) {
		return this.gestPedidos.calcularTotalVendido(inicio, fim);
	}

	public Map<String, Integer> getProdutosMaisVendidos(LocalDate inicio, LocalDate fim) {
		return this.gestPedidos.produtosMaisVendidos(inicio, fim);
	}
}