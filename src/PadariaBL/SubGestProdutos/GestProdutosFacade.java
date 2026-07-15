package PadariaBL.SubGestProdutos;

import PadariaBL.SubGestProdutos.Produto;
import PadariaBL.SubGestProdutos.Ingrediente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestProdutosFacade implements IGestProdutos {
	public List<Produto> produtos = new ArrayList<Produto>();
	public List<Ingrediente> stock = new ArrayList<Ingrediente>();

	public GestProdutosFacade() {
		carregarDados();
	}

	private Produto getProduto(int id) {
		for (Produto p : this.produtos)
			if (p.getId() == id)
				return p;
		return null;
	}

	private Ingrediente getIngrediente(int id) {
		for (Ingrediente i : this.stock)
			if (i.getID() == id)
				return i;
		return null;
	}

	public Map<Integer, Produto> listarProdutos() {
		Map<Integer, Produto> m = new HashMap<>();
		for (Produto p : this.produtos)
			m.put(p.getId(), p);
		return m;
	}

	public String descontarStock(Map<Integer, Integer> consumos) {
		for (Integer id : consumos.keySet()) {
			Ingrediente ing = getIngrediente(id);
			if (ing == null)
				return "Ingrediente nao existe";
			int qtd = consumos.get(id);
			if (!ing.qtdSuficiente(qtd))
				return "Sem stock suficiente";
		}
		for (Integer id : consumos.keySet()) {
			Ingrediente ing = getIngrediente(id);
			ing.consumir(consumos.get(id));
		}
		return null;
	}

	public List<Ingrediente> listarStock() {
		return new ArrayList<Ingrediente>(this.stock);
	}

	public List<String> avisosStock() {
		List<String> res = new ArrayList<>();
		for (Ingrediente i : this.stock)
			if (i.abaixoNivel())
				res.add(i.getNome());
		return res;
	}

	public void carregarDados() {
		try (BufferedReader br = new BufferedReader(new FileReader("dados/ingredientes.csv"))) {
			String line;
			boolean first = true;
			while ((line = br.readLine()) != null) {
				if (first) {
					first = false;
					continue;
				}
				String[] parts = line.split(";");
				if (parts.length >= 3) {
					String nome = parts[0].trim();
					int qtd = Integer.parseInt(parts[1].trim());
					int minimo = Integer.parseInt(parts[2].trim());
					this.stock.add(new Ingrediente(qtd, nome, minimo));
				}
			}
		} catch (IOException e) {
		}

		try (BufferedReader br = new BufferedReader(new FileReader("dados/produtos.csv"))) {
			String line;
			boolean first = true;
			while ((line = br.readLine()) != null) {
				if (first) {
					first = false;
					continue;
				}
				String[] parts = line.split(";");
				if (parts.length >= 6) {
					String nome = parts[0].trim();
					float preco = Float.parseFloat(parts[1].trim());
					int estimativa = Integer.parseInt(parts[2].trim());
					String composicaoRaw = parts[3].trim();
					String extrasRaw = parts[4].trim();
					String notasRaw = parts[5].trim();

					List<Ingrediente> extrasList = new ArrayList<>();
					List<String> notasList = new ArrayList<>();

					composicaoRaw = composicaoRaw.replaceAll("\\[|\\]", "");
					extrasRaw = extrasRaw.replaceAll("\\[|\\]", "");
					notasRaw = notasRaw.replaceAll("\\[|\\]", "");

					if (!extrasRaw.isEmpty()) {
						String[] extrasNames = extrasRaw.split(",");
						for (String en : extrasNames) {
							String n = en.trim();
							if (n.isEmpty())
								continue;
							for (Ingrediente ing : this.stock) {
								if (ing.getNome().equalsIgnoreCase(n)) {
									extrasList.add(ing);
									break;
								}
							}
						}
					}

					if (!notasRaw.isEmpty()) {
						String[] notas = notasRaw.split(",");
						for (String nt : notas)
							if (!nt.trim().isEmpty())
								notasList.add(nt.trim());
					}

					Produto p = new Produto(nome, preco, estimativa, notasList, extrasList);

					if (!composicaoRaw.isEmpty()) {
						String[] compNames = composicaoRaw.split(",");
						for (String cn : compNames) {
							String n = cn.trim();
							if (n.isEmpty())
								continue;
							for (Ingrediente ing : this.stock) {
								if (ing.getNome().equalsIgnoreCase(n)) {
									p.composicao.add(ing);
									break;
								}
							}
						}
					}

					this.produtos.add(p);
				}
			}
		} catch (IOException e) {
		}
	}
}