package PadariaBL;

import PadariaBL.SubGestProdutos.Produto;
import PadariaBL.SubGestPedidos.Pedido;
import PadariaBL.SubGestProdutos.Ingrediente;

public interface IPadariaBL {

	public int iniciarPedido();

	public Map<Integer, Produto> listarProdutos();

	public String adicionarItemPedido(int aIdPedido, Produto aItem, int aQtd);

	public String finalizarPedido(int aIdPedido);

	public String cancelarPedido(int aIdPedido);

	public List<Pedido> listarPedidos();

	public List<Pedido> listarPedidosPendentes();

	public List<String> avisosStock();

	public List<Ingrediente> listarStock();

	public String avancarEstadoPedido(int aIdPedido);

	public int getNumeroPedidos(LocalDate aIncicio, LocalDate aFim);

	public float getTotalVendido(LocalDate aInicio, LocalDate aFim);

	public Map<String, Integer> getProdutosMaisVendidos(LocalDate aInicio, LocalDate aFim);
}