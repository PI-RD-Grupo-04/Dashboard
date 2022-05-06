package br.com.rd.ved.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Produto;

public class ItemPedidoDTO {

	private Integer codigo_pedido;
	private Integer quantidade;	
	private BigDecimal preco;
	private String Produto;
	
	
		
	public ItemPedidoDTO(ItemPedido itemPedido) {
		this.codigo_pedido = itemPedido.getPedido().getId();
		this.preco = itemPedido.getProduto().getPreco();
		this.quantidade = itemPedido.getQuantidade();
		this.Produto = itemPedido.getProduto().getNomeProduto();		
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getProduto() {
		return Produto;
	}

	public void setProduto(String produto) {
		Produto = produto;
	}

	public Integer getCodigo_pedido() {
		return codigo_pedido;
	}

	public void setCodigo_pedido(Integer codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}
	
	
	public static List<ItemPedidoDTO> converter(List<ItemPedido> itemPedidos) {
		return itemPedidos.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
	}
	
}
