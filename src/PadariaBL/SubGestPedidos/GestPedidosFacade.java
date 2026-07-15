package PadariaBL.SubGestPedidos;

import java.util.Vector;
import PadariaBL.SubGestPedidos.Pedido;
import PadariaBL.SubGestProdutos.Produto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestPedidosFacade implements IGestPedidos {
	public Vector<Pedido> pedidos = new Vector<Pedido>();

	public GestPedidosFacade() {
	}

	private Pedido getPedido(int id) {
		for (Pedido p : this.pedidos)
			if (p.getID() == id)
				return p;
		return null;
	}

	public int iniciarPedido() {
		Pedido p = new Pedido();
		this.pedidos.add(p);
		return p.getID();
	}

	public String adicionarItemPedido(int idPedido, Produto item, int qtd) {
		Pedido p = getPedido(idPedido);
		if (p == null)
			return "Pedido nao existe";
		p.adicionarItem(item, qtd);
		return null;
	}

	public Map<Integer, Integer> calculaConsumo(int idPedido) {
		Pedido p = getPedido(idPedido);
		if (p == null)
			return null;
		return p.calculaConsumo();
	}

	public String finalizarPedido(int idPedido) {
		Pedido p = getPedido(idPedido);
		if (p == null)
			return "Pedido nao existe";
		try {
			boolean ok = p.avancarEstado();
			return ok ? null : "Impossivel finalizar";
		} catch (IllegalStateException e) {
			return "Estado inválido";
		}
	}

	public String cancelarPedido(int idPedido) {
		Pedido p = getPedido(idPedido);
		if (p == null)
			return "Pedido nao existe";
		boolean ok = p.cancelar();
		return ok ? null : "Impossivel cancelar";
	}

	public List<Pedido> listarPedidos() {
		return new ArrayList<Pedido>(this.pedidos);
	}

	public List<Pedido> listarPedidosPendentes() {
		List<Pedido> res = new ArrayList<>();
		for (Pedido p : this.pedidos)
			if (p.getEstado() == Estado.EM_REGISTO || p.getEstado() == Estado.EM_PREPARACAO || p.getEstado() == Estado.PRONTO)
				res.add(p);
		return res;
	}

	public String avancarEstadoPedido(int idPedido) {
		Pedido p = getPedido(idPedido);
		if (p == null)
			return "Pedido nao existe";
		try {
			return p.avancarEstado() ? null : "Impossivel avancar";
		} catch (IllegalStateException e) {
			return "Estado inválido";
		}
	}

	public int contarPedidos(LocalDate inicio, LocalDate fim) {
		int c = 0;
		for (Pedido p : this.pedidos) {
			if ((p.getData().isEqual(inicio) || p.getData().isAfter(inicio)) && (p.getData().isEqual(fim) || p.getData().isBefore(fim)))
				c++;
		}
		return c;
	}

	public float calcularTotalVendido(LocalDate inicio, LocalDate fim) {
		float total = 0;
		for (Pedido p : this.pedidos) {
			if ((p.getData().isEqual(inicio) || p.getData().isAfter(inicio)) && (p.getData().isEqual(fim) || p.getData().isBefore(fim)))
				total += p.getTotal();
		}
		return total;
	}

	public Map<String, Integer> produtosMaisVendidos(LocalDate inicio, LocalDate fim) {
		Map<String, Integer> m = new HashMap<>();
		for (Pedido p : this.pedidos) {
			if ((p.getData().isEqual(inicio) || p.getData().isAfter(inicio)) && (p.getData().isEqual(fim) || p.getData().isBefore(fim))) {
				for (LinhaProduto lp : p.getItens()) {
					String nome = lp.getNomeProduto();
					m.put(nome, m.getOrDefault(nome, 0) + lp.getQuantidade());
				}
			}
		}
		return m;
	}
}