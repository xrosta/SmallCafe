package PadariaBL.SubGestProdutos;

public interface IGestProdutos {

	public Map<Integer, Produto> listarProdutos();

	public String descontarStock(Map<int, int> aConsumos);

	public List<Ingrediente> listarStock();

	public List<String> avisosStock();

	public void carregarDados();
}