package PadariaBL.SubGestPedidos;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import PadariaBL.SubGestProdutos.Produto;

public interface IGestPedidos {

	public int iniciarPedido();

	public String adicionarItemPedido(int idPedido, Produto item, int qtd);

	public Map<Integer, Integer> calculaConsumo(int idPedido);

	public String finalizarPedido(int idPedido);

	public String cancelarPedido(int idPedido);

	public List<Pedido> listarPedidos();

	public List<Pedido> listarPedidosPendentes();

	public String avancarEstadoPedido(int idPedido);

	public int contarPedidos(LocalDate inicio, LocalDate fim);

	public float calcularTotalVendido(LocalDate inicio, LocalDate fim);

	public Map<String, Integer> produtosMaisVendidos(LocalDate inicio, LocalDate fim);
}