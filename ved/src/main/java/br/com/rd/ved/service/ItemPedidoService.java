package br.com.rd.ved.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.Produto;
import br.com.rd.ved.repository.ItemPedidoRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.ProdutoRepository;

@Service
public class ItemPedidoService {

	private final ItemPedidoRepository itemPedidoRepository;
	private final ProdutoRepository produtoRepository;
	private final PedidoRepository pedidoRepository;
	private Boolean sistema = true;

	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository, ProdutoRepository produtoRepository,
			PedidoRepository pedidoRepository) {
		super();
		this.itemPedidoRepository = itemPedidoRepository;
		this.produtoRepository = produtoRepository;
		this.pedidoRepository = pedidoRepository;
	}

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no Funcionario");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			acao = Integer.parseInt(sc.nextLine());

			switch (acao) {
			case 1:
				salvar(sc);
				break;
			case 2:
				atualizar(sc);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(sc);
				break;
			default:
				sistema = false;
				break;
			}
		}
	}

	private void salvar(Scanner sc) {

		System.out.println("Digite o ID do produto que deseja adicionar ");
		Integer qnt = Integer.parseInt(sc.nextLine());

		System.out.println("Informe uma porcentagem de valor para ICMS:");
		Double pIcms = Double.parseDouble(sc.nextLine());

		System.out.println("Informe um valor para ICMS:");
		Double vIcms = Double.parseDouble(sc.nextLine());

		System.out.println("Digite o ID do Produto para Item-pedido:");
		Integer produtoId = Integer.parseInt(sc.nextLine());

		Optional<Produto> produto = produtoRepository.findById(produtoId);

		System.out.println("Digite o ID do Pedido para Item-pedido:");
		Integer pedidoId = Integer.parseInt(sc.nextLine());
		Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);

		ItemPedido itemPedido = new ItemPedido(qnt, pIcms, vIcms, produto.get(), pedido.get());
		itemPedidoRepository.save(itemPedido);
		System.out.println("Item do pedido Salvo com Sucesso");

	}

	private void atualizar(Scanner sc) {

		System.out.println("Informe o ID do Item do pedido que deseja Atualizar:");
		Integer id = Integer.parseInt(sc.nextLine());

		System.out.println("Informe uma nova quantidade deste produto:");
		Integer qnt = Integer.parseInt(sc.nextLine());

		System.out.println("Informe uma porcentagem de valor para ICMS:");
		Double picms = Double.parseDouble(sc.nextLine());

		System.out.println("Informe um valor para ICMS:");
		Double vicms = Double.parseDouble(sc.nextLine());

		System.out.println("Digite o ID do Produto para Item-Pedido:");
		Integer produtoId = Integer.parseInt(sc.nextLine());

		System.out.println("Digite o ID do Pedido para Item-Pedido:");
		Integer pedidoId = Integer.parseInt(sc.nextLine());

		Optional<ItemPedido> itemPedido = itemPedidoRepository.findById(id);
		Optional<Produto> produto = produtoRepository.findById(produtoId);
		Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);
		itemPedido.get().setQuantidade(qnt);
		itemPedido.get().setPorcentagemIcms(picms);
		itemPedido.get().setValorIcms(vicms);
		itemPedido.get().setProduto(produto.get());
		itemPedido.get().setPedido(pedido.get());
		itemPedidoRepository.save(itemPedido.get());
		System.out.println("O Item foi Alterado com Sucesso");
	}

	private void visualizar() {
		Iterable<ItemPedido> itemPedido = itemPedidoRepository.findAll();
		itemPedido.forEach(uf -> System.out.println(uf));
	}


	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do Item do pedido que deseja deletar");
		Integer id = Integer.parseInt(sc.nextLine());
		itemPedidoRepository.deleteById(id);
		System.out.println("O Item foi deletado com sucesso");
	}

}
