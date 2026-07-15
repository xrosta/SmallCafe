package PadariaBL.SubGestProdutos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Produto {
	private static int proximoID = 1;
	private int id;
	private String nome;
	private float preco;
	private int estimativaPreparacao;
	private List<String> notas;
	public List<Ingrediente> composicao = new ArrayList<Ingrediente>();
	public List<Ingrediente> extras = new ArrayList<Ingrediente>();

	public Produto(Produto original) {
		this.id = original.getId();
		this.nome = original.getNome();
		this.preco = original.getPreco();
		this.estimativaPreparacao = original.getEstimativaPreparacao();
		this.notas = new ArrayList<>(original.getNotas() == null ? new ArrayList<>() : original.getNotas());
		this.composicao = new ArrayList<>(original.getComposicao());
		this.extras = new ArrayList<>(original.getExtras());
	}

	public Produto(String nome, float preco, int estimativa, List<String> notas, List<Ingrediente> extras) {
		this.id = proximoID++;
		this.nome = nome;
		this.preco = preco;
		this.estimativaPreparacao = estimativa;
		this.notas = notas == null ? new ArrayList<>() : new ArrayList<>(notas);
		this.extras = extras == null ? new ArrayList<>() : new ArrayList<>(extras);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setEstimativaPreparacao(int estimativaPreparacao) {
		this.estimativaPreparacao = estimativaPreparacao;
	}

	public void setNotas(List<String> notas) {
		this.notas = notas == null ? new ArrayList<>() : new ArrayList<>(notas);
	}

	public void setExtras(List<Ingrediente> extras) {
		this.extras = extras == null ? new ArrayList<>() : new ArrayList<>(extras);
	}

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public float getPreco() {
		return this.preco;
	}

	public int getEstimativaPreparacao() {
		return this.estimativaPreparacao;
	}

	public List<String> getNotas() {
		return new ArrayList<>(this.notas);
	}

	public List<Ingrediente> getExtras() {
		return new ArrayList<>(this.extras);
	}

	public List<Ingrediente> getComposicao() {
		return new ArrayList<>(this.composicao);
	}

	public Map<Integer, Integer> getConsumo() {
		Map<Integer, Integer> consumo = new HashMap<>();
		for (Ingrediente ing : this.composicao) {
			consumo.put(ing.getID(), consumo.getOrDefault(ing.getID(), 0) + 1);
		}
		return consumo;
	}
}