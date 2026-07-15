package PadariaBL.SubGestPedidos;

import PadariaBL.SubGestPedidos.LinhaProduto;
import PadariaBL.SubGestProdutos.Produto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {
	private static int proximoID = 1;
	private int id;
	private LocalDate data;
	private float total = 0;
	private List<LinhaProduto> itens = new ArrayList<LinhaProduto>();
	private Estado estado;

	public Pedido() {
		this.id = proximoID++;
		this.data = LocalDate.now();
		this.total = 0;
		this.estado = Estado.EM_REGISTO;
	}

	public Pedido(Pedido p) {
		this.id = p.getID();
		this.data = p.getData();
		this.total = p.getTotal();
		this.itens = new ArrayList<LinhaProduto>(p.getItens());
		this.estado = p.getEstado();
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public void adicionarItem(Produto prod, int qtd) {
		LinhaProduto l = new LinhaProduto(prod, qtd);
		this.itens.add(l);
		this.total += l.getTotalLinha();
	}

	public int getID() {
		return this.id;
	}

	public LocalDate getData() {
		return this.data;
	}

	public float getTotal() {
		return this.total;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public List<LinhaProduto> getItens() {
		return new ArrayList<LinhaProduto>(this.itens);
	}

	public boolean avancarEstado() {
		if (this.estado == Estado.EM_REGISTO) {
			this.estado = Estado.EM_PREPARACAO;
			if (this.itens.stream()
        		.noneMatch(lp -> lp.produto.getEstimativaPreparacao() > 0)) {
				this.estado = Estado.PRONTO;
			}
			return true;
		} else if (this.estado == Estado.EM_PREPARACAO) {
			this.estado = Estado.PRONTO;
			return true;
		} else if (this.estado == Estado.PRONTO) {
			this.estado = Estado.ENTREGUE;
			return true;
		} else if (this.estado == Estado.ENTREGUE || this.estado == Estado.CANCELADO) {
			throw new IllegalStateException("Estado inválido para avançar: " + this.estado);
		}
		throw new IllegalStateException("Estado desconhecido: " + this.estado);
	}

	public boolean cancelar() {
		if (this.estado == Estado.ENTREGUE || this.estado == Estado.CANCELADO)
			return false;
		this.estado = Estado.CANCELADO;
		return true;
	}

	public Map<Integer, Integer> calculaConsumo() {
		Map<Integer, Integer> consumo = new HashMap<>();
		for (LinhaProduto lp : this.itens) {
			Map<Integer, Integer> c = lp.getConsumo();
			for (Map.Entry<Integer, Integer> e : c.entrySet()) {
   				consumo.merge(e.getKey(), e.getValue(), Integer::sum);
			}
		}
		return consumo;
	}
}