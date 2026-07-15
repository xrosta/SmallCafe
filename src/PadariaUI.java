import PadariaBL.IPadariaBL;
import PadariaBL.PadariaBLFacade;
import PadariaBL.SubGestPedidos.LinhaProduto;
import PadariaBL.SubGestPedidos.Pedido;
import PadariaBL.SubGestProdutos.Ingrediente;
import PadariaBL.SubGestProdutos.Produto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PadariaUI {
    private Scanner in;
    private IPadariaBL padaria;

    public void run() {
        this.in = new Scanner(System.in);
        this.padaria = new PadariaBLFacade();

        System.out.println("=== Padaria ===");

        int opcao = -1;

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Listar produtos");
            System.out.println("2. Registar pedido");
            System.out.println("3. Listar pedidos");
            System.out.println("4. Listar pedidos pendentes");
            System.out.println("5. Avançar estado do pedido");
            System.out.println("6. Listar stock");
            System.out.println("7. Consultar estatísticas");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            try {
                opcao = in.nextInt();
                in.nextLine();
            } catch (Exception e) {
                opcao = -1;
                in.nextLine();
            }
            System.out.println();

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    registarPedido();
                    break;
                case 3:
                    listarPedidos();
                    break;
                case 4:
                    listarPedidosPendentes();
                    break;
                case 5:
                    avancarEstadoPedido();
                    break;
                case 6:
                    listarStock();
                    break;
                case 7:
                    listarEstatisticas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    private void listarProdutos() {
        Map<Integer, Produto> produtos = this.padaria.listarProdutos();
        if (produtos == null || produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
            return;
        }
        System.out.println("Produtos disponíveis:");
        for (Map.Entry<Integer, Produto> entry : produtos.entrySet()) {
            Produto p = entry.getValue();
            System.out.printf("%d -> %s | preço: %.2f | tempo: %d s\n", entry.getKey(), p.getNome(), p.getPreco(), p.getEstimativaPreparacao());
        }
    }

    private void registarPedido() {
        int idPedido = this.padaria.iniciarPedido();
        int opcao = -1;

        while (true) {
            System.out.println("\nEscolha:");
            System.out.println("1. Adicionar item");
            System.out.println("2. Finalizar pedido");
            System.out.println("3. Cancelar pedido");
            System.out.print("Opção: ");
            
            try {
                opcao = in.nextInt();
                in.nextLine();
            } catch (Exception e) {
                opcao = -1;
                in.nextLine();
            }
            System.out.println();

            if (opcao == 1) {
                listarProdutos();
                System.out.println("0. Cancelar ação");

                int idProduto = 0;
                try {
                    idProduto = in.nextInt();
                    in.nextLine();
                } catch (Exception e) {
                    in.nextLine();
                }
                System.out.println();

                if (idProduto <= 0) {
                    System.out.println("ID inválido.");
                    continue;
                }
                
                int qtd = 0;
                System.out.print("Quantidade: ");
                try {
                    qtd = in.nextInt();
                    in.nextLine();
                } catch (Exception e) {
                    in.nextLine();
                }
                System.out.println();
                
                Map<Integer, Produto> produtos = this.padaria.listarProdutos();
                Produto produto = produtos.get(idProduto);
                if (produto == null) {
                    System.out.println("Produto não encontrado.");
                    continue;
                }

                List<String> notas = produto.getNotas();
                List<Ingrediente> extras = produto.getExtras();
                Produto copiaProduto = new Produto(produto);


                if (!notas.isEmpty()) {
                    System.out.println("Notas disponíveis:");
                    for (int i = 0; i < notas.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, notas.get(i));
                    }
                    System.out.print("Escolha uma nota: ");
                    int notaIndex = -1;
                    try {
                        notaIndex = in.nextInt() - 1;
                        in.nextLine();
                    } catch (Exception e) {
                        in.nextLine();
                    }
                    System.out.println();
                    if (notaIndex >= 0 && notaIndex < notas.size()) {
                        List<String> notaSelecionada = List.of(notas.get(notaIndex));
                        copiaProduto.setNotas(notaSelecionada);
                    }
                }

                if (!extras.isEmpty()) {
                    System.out.println("Extras disponíveis:");
                    for (int i = 0; i < extras.size(); i++) {
                        Ingrediente ing = extras.get(i);
                        System.out.printf("%d. %s\n", i + 1, ing.getNome());
                    }
                    System.out.print("Escolha um extra (ou 0 para nenhum): ");
                    int extraIndex = -1;
                    try {
                        extraIndex = in.nextInt() - 1;
                        in.nextLine();
                    } catch (Exception e) {
                        in.nextLine();
                    }
                    System.out.println();
                    if (extraIndex >= 0 && extraIndex < extras.size()) {
                        List<Ingrediente> extrasSelecionados = List.of(extras.get(extraIndex));
                        copiaProduto.setExtras(extrasSelecionados);
                    }
                }

                String resultado = this.padaria.adicionarItemPedido(idPedido, copiaProduto, qtd);
                if (!(resultado == null)) {
                    System.out.println(resultado);
                }

            } else if (opcao == 2) {
                String resultado = this.padaria.finalizarPedido(idPedido);
                if (!(resultado == null)) {
                    System.out.println(resultado);
                }
                break;

            } else if (opcao == 3) {
                String resultado = this.padaria.cancelarPedido(idPedido);
                if (!(resultado == null)) {
                    System.out.println(resultado);
                }
                break;

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void listarPedidos() {
        List<Pedido> pedidos = this.padaria.listarPedidos();
        if (pedidos == null || pedidos.isEmpty()) {
            System.out.println("Não existem pedidos.");
            return;
        }
        System.out.println("Pedidos:");
        for (Pedido p : pedidos) {
            System.out.printf("ID: %d | Data: %s | Total: %.2f | Estado: %s\n", p.getID(), p.getData(), p.getTotal(), p.getEstado());
            for (LinhaProduto item : p.getItens()) {
                System.out.printf("- %s | quantidade: %d | preço unitário: %.2f\n", item.produto.getNome(), item.getQuantidade(), item.produto.getPreco());
            }
            System.out.println();
        }
    }

    private void listarPedidosPendentes() {
        List<Pedido> pedidos = this.padaria.listarPedidosPendentes();
        if (pedidos == null || pedidos.isEmpty()) {
            System.out.println("Não existem pedidos pendentes.");
            return;
        }
        System.out.println("Pedidos pendentes:");
        for (Pedido p : pedidos) {
            System.out.printf("ID: %d | Data: %s | Total: %.2f | Estado: %s\n", p.getID(), p.getData(), p.getTotal(), p.getEstado());
        }
    }

    private void listarStock() {
        List<Ingrediente> stock = this.padaria.listarStock();
        if (stock == null || stock.isEmpty()) {
            System.out.println("Stock vazio.");
            return;
        }
        System.out.println("Stock de ingredientes:");
        for (Ingrediente ing : stock) {
            System.out.printf("%d -> %s | quantidade: %d\n", ing.getID(), ing.getNome(), ing.getQuantidade());
        }
        List<String> avisos = this.padaria.avisosStock();
        if (!avisos.isEmpty()) {
            System.out.println("-----------------------------");
            System.out.println("Artigos com baixa quantidade:");
            for (String aviso : avisos) {
                System.out.println("- " + aviso);
            }
        }
    }

    private void avancarEstadoPedido() {
        List<Pedido> pedidos = this.padaria.listarPedidosPendentes();
        if (pedidos == null || pedidos.isEmpty()) {
            System.out.println("Não existem pedidos pendentes para avançar.");
            return;
        }
        
        listarPedidosPendentes();

        System.out.print("ID do pedido: ");
        int idPedido = 0;
        try {
            idPedido = in.nextInt();
            in.nextLine();
        } catch (Exception e) {
            in.nextLine();
        }
        System.out.println();

        String resultado = this.padaria.avancarEstadoPedido(idPedido);
        if (!(resultado == null)) {
            System.out.println(resultado);
        }
    }

    private void listarEstatisticas() {
        System.out.println("Introduza a data de início no formato YYYY-MM-DD (em branco para começar em 2000-01-01):");
        System.out.print("Início: ");
        String inputInicio = in.nextLine().trim();
        LocalDate inicio = inputInicio.isEmpty() ? LocalDate.of(2000, 1, 1) : LocalDate.parse(inputInicio);

        System.out.println("Introduza a data de fim no formato YYYY-MM-DD (em branco o dia atual):");
        System.out.print("Fim: ");
        System.out.println();
        String inputFim = in.nextLine().trim();
        LocalDate fim = inputFim.isEmpty() ? LocalDate.now() : LocalDate.parse(inputFim);

        int totalPedidos = this.padaria.getNumeroPedidos(inicio, fim);

        if (totalPedidos == 0) {
            System.out.println("Nenhum pedido registado neste período.");
            return;
        }

        float totalVendido = this.padaria.getTotalVendido(inicio, fim);

        System.out.printf("Pedidos entre %s e %s: %d\n", inicio, fim, totalPedidos);
        System.out.printf("Total vendido entre %s e %s: %.2f\n", inicio, fim, totalVendido);

        Map<String, Integer> maisVendidos = this.padaria.getProdutosMaisVendidos(inicio, fim);
        if (maisVendidos == null || maisVendidos.isEmpty()) {
            System.out.println("Nenhum produto vendido neste período.");
        } else {
            System.out.println("Produtos mais vendidos:");
            for (Map.Entry<String, Integer> entry : maisVendidos.entrySet()) {
                System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
            }
        }
    }
}