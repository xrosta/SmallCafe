package PadariaBL.SubGestProdutos;

import java.util.List;
import java.util.Map;

public interface IGestProdutos {

	public Map<Integer, Produto> listarProdutos();

	public String descontarStock(Map<Integer, Integer> consumos);

	public List<Ingrediente> listarStock();

	public List<String> avisosStock();

	public void carregarDados();
}