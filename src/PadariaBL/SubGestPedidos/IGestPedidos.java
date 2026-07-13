package PadariaBL.SubGestPedidos;

import PadariaBL.SubGestProdutos.Produto;

public interface IGestPedidos {

	public int iniciarPedido();

	public String adicionarItemPedido(int aIdPedido, Produto aItem, int aQtd);

	public Map<Integer, Integer> calculaConsumo(int aIdPedido);

	public String finalizarPedido(int aIdPedido);

	public String cancelarPedido(int aIdPedido);

	public List<Pedido> listarPedidos();

	public List<Pedido> listarPedidosPendentes();

	public String avancarEstadoPedido(int aIdPedido);

	public int contarPedidos(LocalDate aIncicio, LocalDate aFim);

	public float calcularTotalVendido(LocalDate aInicio, LocalDate aFim);

	public Map<String, Integer> produtosMaisVendidos(LocalDate aInicio, LocalDate aFim);
}