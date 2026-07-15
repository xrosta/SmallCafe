package PadariaBL;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import PadariaBL.SubGestProdutos.Produto;
import PadariaBL.SubGestPedidos.Pedido;
import PadariaBL.SubGestProdutos.Ingrediente;

public interface IPadariaBL {

	public int iniciarPedido();

	public Map<Integer, Produto> listarProdutos();

	public String adicionarItemPedido(int idPedido, Produto item, int qtd);

	public String finalizarPedido(int idPedido);

	public String cancelarPedido(int idPedido);

	public List<Pedido> listarPedidos();

	public List<Pedido> listarPedidosPendentes();

	public List<String> avisosStock();

	public List<Ingrediente> listarStock();

	public String avancarEstadoPedido(int idPedido);

	public int getNumeroPedidos(LocalDate inicio, LocalDate fim);

	public float getTotalVendido(LocalDate inicio, LocalDate fim);

	public Map<String, Integer> getProdutosMaisVendidos(LocalDate inicio, LocalDate fim);
}