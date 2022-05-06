package br.com.rd.ved.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.TipoPagamento;
import br.com.rd.ved.repository.TipoPagamentoRepository;

@Service
public class TipoPagamentoService {
	private final TipoPagamentoRepository tipoPagamentoRepository;
	private Boolean sistema = true;
	
	public TipoPagamentoService(TipoPagamentoRepository tipoPagamentoRepository) {
		this.tipoPagamentoRepository = tipoPagamentoRepository;
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
		System.out.println("Digite a descrição do Tipo de Pagamento:");
		String descricao = sc.nextLine();
		TipoPagamento tipoPagamento = new TipoPagamento(descricao);
		tipoPagamentoRepository.save(tipoPagamento);
		System.out.println("Tipo de pagamento Salvo com Sucesso");

	}

	private void atualizar(Scanner sc) {
		System.out.println("Informe o ID do Usuario:");
		Integer id = Integer.parseInt(sc.nextLine());

		System.out.println("Digite a descrição do Tipo de Pagamento:");
		String descricao = sc.nextLine();
		TipoPagamento tipoPagamento = new TipoPagamento();
		tipoPagamento.setId(id);
		tipoPagamento.setDescricao(descricao);
		System.out.println("Tipo de Pagamento Alterado com Sucesso");
	}

	private void visualizar() {
		Iterable<TipoPagamento> tipoPagamento = tipoPagamentoRepository.findAll();
		tipoPagamento.forEach(tp -> System.out.println(tp));
	}

	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do Tipo de Pagamento");
		Integer id = Integer.parseInt(sc.nextLine());
		tipoPagamentoRepository.deleteById(id);
		System.out.println("Tipo de pagamento Deletado com Sucesso");
	}
}

