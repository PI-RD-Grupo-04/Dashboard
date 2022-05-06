package br.com.rd.ved.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rd.ved.dto.PedidoDTO;
import br.com.rd.ved.formdto.PedidoForm;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.PedidoStatus;
import br.com.rd.ved.repository.ClienteRepository;
import br.com.rd.ved.repository.CupomDescontoRepository;
import br.com.rd.ved.repository.EnderecoRepository;
import br.com.rd.ved.repository.FreteRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.PedidoStatusRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CupomDescontoRepository cupomDescontoRepository;

	@Autowired
	private PedidoStatusRepository pedidoStatusRepository;

	@Autowired
	private FreteRepository freteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping
	public List<PedidoDTO> listar() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		return PedidoDTO.converter(pedidos);
	}

	@PostMapping("/cliente={id}/novo")
	@Transactional
	public ResponseEntity<PedidoDTO> cadastrar(@PathVariable("id") Integer id,
			@RequestBody @Valid PedidoForm pedidoForm, UriComponentsBuilder uriBuilder) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		Pedido pedido = pedidoForm.converter(pedidoRepository, clienteRepository, cupomDescontoRepository,
				pedidoStatusRepository, freteRepository, enderecoRepository);
		pedidoRepository.save(pedido);
		pedidoForm.cadastrarPedido(pedido, cliente.get(), pedidoRepository);
		URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
	}

	@GetMapping("/cliente={id}/detalhar/{pedido}")
	public ResponseEntity<PedidoDTO> detalhar(@PathVariable("id") Integer id,
			@PathVariable("pedido") Integer idPedido) {

		Optional<Cliente> cliente = clienteRepository.findById(id);
		Optional<Pedido> pedido = pedidoRepository.findById(idPedido);
		List<Pedido> pedidos = new ArrayList<>();
		pedidos = cliente.get().getPedidos();

		if (cliente.isPresent() && pedidos.contains(pedido.get())) {

			return ResponseEntity.ok().body(new PedidoDTO(pedido.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/cliente={id}/delete/{pedido}")
	@Transactional
	public ResponseEntity<?> cancelar(@PathVariable("id") Integer id, @PathVariable("pedido") Integer idPedido) {

		Optional<Cliente> cliente = clienteRepository.findById(id);
		Optional<Pedido> pedido = pedidoRepository.findById(idPedido);

		if (pedido.isPresent() && cliente.isPresent()) {
			List<Pedido> pedidos = new ArrayList<>();
			pedidos = cliente.get().getPedidos();
			pedido.get().setPedidoStatus(pedidoStatusRepository.findByDescricao("Cancelado"));
			pedidos.add(pedido.get());
			cliente.get().setPedidos(pedidos);
			clienteRepository.save(cliente.get());
			pedidoRepository.save(pedido.get());
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}