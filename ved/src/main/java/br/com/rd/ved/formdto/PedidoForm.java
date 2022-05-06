package br.com.rd.ved.formdto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.rd.ved.dto.ClienteDTO;
import br.com.rd.ved.dto.PedidoDTO;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.CupomDesconto;
import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.model.Frete;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.PedidoStatus;
import br.com.rd.ved.repository.ClienteRepository;
import br.com.rd.ved.repository.CupomDescontoRepository;
import br.com.rd.ved.repository.EnderecoRepository;
import br.com.rd.ved.repository.FreteRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.PedidoStatusRepository;

public class PedidoForm {
	
	
	private Date data;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private Integer cliente;
	private Integer cupomDesconto;
	private Integer pedidoStatus;
	private Integer frete;
	private Integer enderecos;



	public PedidoForm(String data, String cliente, String cupomDesconto,
			String pedidoStatus, String frete, String enderecos) throws ParseException {
		this.data = formato.parse(data);
		this.cliente = Integer.parseInt(cliente);
		this.cupomDesconto = Integer.parseInt(cupomDesconto);
		this.pedidoStatus = Integer.parseInt(pedidoStatus);
		this.frete = Integer.parseInt(frete);
		this.enderecos = Integer.parseInt(enderecos);
	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public SimpleDateFormat getFormato() {
		return formato;
	}

	public void setFormato(SimpleDateFormat formato) {
		this.formato = formato;
	}


	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Integer getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(Integer cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}

	public Integer getPedidoStatus() {
		return pedidoStatus;
	}

	public void setPedidoStatus(Integer pedidoStatus) {
		this.pedidoStatus = pedidoStatus;
	}

	public Integer getFrete() {
		return frete;
	}

	public void setFrete(Integer frete) {
		this.frete = frete;
	}

	public Integer getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(Integer enderecos) {
		this.enderecos = enderecos;
	}
	
	public Pedido converter(PedidoRepository pedidoRepository, 
							ClienteRepository clienteRepository,
							CupomDescontoRepository cupomDescontoRepository,
							PedidoStatusRepository pedidoStatusRepository,
							FreteRepository freteRepository,
							EnderecoRepository enderecoRepository) { 
		
		Optional<Cliente> cliente = clienteRepository.findById(this.cliente);		
		Optional<CupomDesconto> cupomDesconto = cupomDescontoRepository.findById(this.cupomDesconto);
		Optional<PedidoStatus> pedidoStatus = pedidoStatusRepository.findById(this.pedidoStatus);
		Optional<Frete> frete = freteRepository.findById(this.frete);
		Optional<Endereco> endereco = enderecoRepository.findById(this.enderecos);
		Pedido pedido = new Pedido(data, cliente.get(), cupomDesconto.get(), pedidoStatus.get(), frete.get(), endereco.get());
				
		return pedido;

	}
	
	public List<PedidoDTO> cadastrarPedido(Pedido pedido, Cliente cliente, PedidoRepository pedidoRepository) {
		List<Pedido> pedidos;
		pedidos = cliente.getPedidos();
		pedidos.add(pedido);
		cliente.setPedidos(pedidos);
		pedidoRepository.save(cliente);
		return PedidoDTO.converter(pedidos);

	} 
	
	public List<PedidoDTO> deletarEndereco(Pedido pedido, Cliente cliente, PedidoRepository pedidoRepository ) {
		List<Pedido> pedidos;
		pedidos = cliente.getPedidos();
		pedidos.add(pedido);
		cliente.setPedidos(pedidos);
		pedidoRepository.save(cliente);
		return PedidoDTO.converter(pedidos);

	} 
}
